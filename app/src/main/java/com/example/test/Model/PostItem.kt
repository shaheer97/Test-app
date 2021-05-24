package com.example.test.Model

import com.google.gson.annotations.SerializedName

data class PostsItem(
    @SerializedName("code") val code : Int,
    @SerializedName("status") val status : String,
    val data :List<Data>
)

data class Data(

    @SerializedName("name") val name : String,
    @SerializedName("transliteration") val transliteration : String,
    @SerializedName("number") val number : Int,
    @SerializedName("en") val en : En
)
