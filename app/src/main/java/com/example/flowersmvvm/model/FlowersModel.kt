package com.example.flowersmvvm.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FlowersModel (
    @SerializedName("productId")
    var productId: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("photo")
    var image: String? = null,

    @SerializedName("instructions")
    var instructions: String? = null,

    @SerializedName("price")
    var price: String? = null
): Parcelable {

}