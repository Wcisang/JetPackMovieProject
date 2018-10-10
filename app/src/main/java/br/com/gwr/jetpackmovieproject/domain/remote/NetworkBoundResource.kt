package br.com.gwr.jetpackmovieproject.domain.remote

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.support.annotation.MainThread
import android.support.annotation.WorkerThread
import br.com.gwr.jetpackmovieproject.domain.Resource
import br.com.gwr.jetpackmovieproject.util.AppExecutors

/**
 * Created by WCisang on 12/06/2018.
 */
abstract class NetworkBoundResource<ResultType, RequestType> @MainThread constructor(
        private val appExecutors: AppExecutors
) {

    /**
     * The final result LiveData
     */
    private val result = MediatorLiveData<Resource<ResultType?>>()

    init {

        result.value = Resource.loading()
        val dbSource = this.loadFromDb()
        result.addSource(dbSource) { data ->
            result.removeSource(dbSource)
            if (shouldFetch(data)) {
                fetchFromNetwork(dbSource)
            } else {
                result.addSource(dbSource) { newData -> setValue(Resource.success(newData)) }
            }
        }
    }

    /**
     * Fetch the data from network and persist into DB and then
     * send it back to UI.
     */
    private fun fetchFromNetwork(dbSource: LiveData<ResultType>) {
        val apiResponse = createCall()
        // we re-attach dbSource as a new source, it will dispatch its latest value quickly
        result.addSource(dbSource) { result.setValue(Resource.loading()) }
        result.addSource(apiResponse) { response ->
            result.removeSource(apiResponse)
            result.removeSource(dbSource)

            response?.apply {
                if (status.isSuccessful()) {
                    appExecutors.diskIO().execute {
                        processResponse(this)?.let { requestType -> saveCallResult(requestType) }
                        appExecutors.mainThread().execute {
                            // we specially request a new live data,
                            // otherwise we will get immediately last cached value,
                            // which may not be updated with latest results received from network.
                            result.addSource(loadFromDb()) { newData -> setValue(Resource.success(newData)) }
                        }
                    }
                } else {
                    onFetchFailed()
                    result.addSource(dbSource) { result.setValue(Resource.error(errorMessage)) }
                }
            }
        }
    }

    @MainThread
    private fun setValue(newValue: Resource<ResultType?>) {
        if (result.value != newValue){
            result.value = newValue
        }
    }

    protected fun onFetchFailed() {result.value = Resource.error("")}

    fun asLiveData(): LiveData<Resource<ResultType?>> {
        return result
    }

    @WorkerThread
    private fun processResponse(response: Resource<RequestType>): RequestType? {
        return response.data
    }

    @WorkerThread
    protected abstract fun saveCallResult(item: RequestType)

    @MainThread
    protected abstract fun shouldFetch(data: ResultType?): Boolean

    @MainThread
    protected abstract fun loadFromDb(): LiveData<ResultType>

    @MainThread
    protected abstract fun createCall(): LiveData<Resource<RequestType>>
}