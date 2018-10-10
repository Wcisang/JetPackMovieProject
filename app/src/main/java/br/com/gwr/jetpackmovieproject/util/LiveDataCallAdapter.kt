package br.com.gwr.jetpackmovieproject.util


import android.arch.lifecycle.LiveData
import br.com.gwr.jetpackmovieproject.domain.Resource
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type
import java.util.concurrent.atomic.AtomicBoolean

class LiveDataCallAdapter<R>(private val responseType: Type) :
        CallAdapter<R, LiveData<Resource<R>>> {

    override fun responseType() = responseType

    override fun adapt(call: Call<R>): LiveData<Resource<R>> {
        return object : LiveData<Resource<R>>() {
            private var started = AtomicBoolean(false)
            override fun onActive() {
                super.onActive()
                if (started.compareAndSet(false, true)) {
                    call.enqueue(object : Callback<R> {
                        override fun onResponse(call: Call<R>, response: Response<R>) {
                            val body = response.body()
                            if (body == null)
                                postValue(Resource.error("Retorno nulo"))
                            else
                                postValue(Resource.success(response.body()!!))
                        }

                        override fun onFailure(call: Call<R>, throwable: Throwable) {
                            postValue(Resource.error(throwable.message))
                        }
                    })
                }
            }
        }
    }
}