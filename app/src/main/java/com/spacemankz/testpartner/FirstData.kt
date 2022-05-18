package com.spacemankz.testpartner

import com.google.gson.annotations.SerializedName

data class FirstData(

    @field:SerializedName("payload")
    val payload: Payload? = null,

    @field:SerializedName("type")
    val type: String? = null
)
