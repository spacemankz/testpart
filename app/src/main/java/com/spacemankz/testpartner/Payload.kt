package com.spacemankz.testpartner
import com.google.gson.annotations.SerializedName

data class Payload(

    @field:SerializedName("text")
    val text: String? = null
)
