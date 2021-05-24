package com.example.test.Interface

import com.example.test.Model.Data
import com.example.test.Model.PostsItem
import retrofit2.Call
import retrofit2.http.GET

interface NetworkApi {


        @GET("/asmaAlHusna")
        fun getAllPosts(): Call<PostsItem>


}