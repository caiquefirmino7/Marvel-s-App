package com.caique.appmarvel.data.model.comic

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ComicModelResponse(
    @SerializedName("data")
    val data: ComicModelData
) : Serializable
