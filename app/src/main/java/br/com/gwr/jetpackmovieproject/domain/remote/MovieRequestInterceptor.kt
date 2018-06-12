package br.com.gwr.jetpackmovieproject.domain.remote

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by WCisang on 12/06/2018.
 */
class MovieRequestInterceptor: Interceptor{

    override fun intercept(chain: Interceptor.Chain?): Response {
        val originalRequest = chain.request()
        val originalHttpUrl = originalRequest.url()

        val url = originalHttpUrl.newBuilder()
                .addQueryParameter("api_key", ApiConstants.API_KEY)
                .build()

        val request = originalRequest.newBuilder().url(url).build()
        return chain.proceed(request)
    }

}