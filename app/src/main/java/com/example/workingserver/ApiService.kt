package com.example.workingserver.network

import com.example.workingserver.model.Object
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("objects")
    fun getObjects(): Call<List<Object>>
}
