package br.com.gwr.jetpackmovieproject.domain

/**
 * Created by WCisang on 12/06/2018.
 */
data class Resource<ResultType>(var status: Status, var data: ResultType? = null, var errorMessage: String? = null) {

    companion object {

        fun <ResultType> success(data: ResultType): Resource<ResultType> = Resource(Status.SUCCESS, data)

        fun <ResultType> loading(): Resource<ResultType> = Resource(Status.LOADING)

        fun <ResultType> error(message: String?): Resource<ResultType> = Resource(Status.ERROR, errorMessage = message)
    }
}