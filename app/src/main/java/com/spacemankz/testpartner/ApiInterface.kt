package com.spacemankz.testpartner

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("/271")
    fun getData(): Call<List<FirstData>>
}