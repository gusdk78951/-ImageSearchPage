package com.hyuna.imagesearchpage.Data

import com.google.gson.annotations.SerializedName

data class ImageSearch(
    @SerializedName("meta")
    val imageSearchMeta: ImageSearchMeta,
    @SerializedName("documents")
    val imageSearchDocuments: ArrayList<ImageSearchDocuments>
)

data class ImageSearchMeta(
    val totalCount: Int,
    val pageableCount: Int,
    val isEnd: Boolean
)

data class ImageSearchDocuments(
    val collection: String,
    val thumbnailUrl: String,
    val imageUrl: String,
    val width: Int,
    val height: Int,
    val displaySitename: String,
    val docUrl: String,
    val datetime: String
)