package com.spacemankz.testpartner

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("https://demo7877231.mockable.io/api/v1/post/271")
    fun getData(): Call<List<Payload>>
}