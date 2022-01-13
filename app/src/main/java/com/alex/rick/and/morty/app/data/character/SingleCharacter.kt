package com.alex.rick.and.morty.app.data.character

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SingleCharacter(

    @SerializedName("id")
    val id: Int? = 0,

    @SerializedName("name")
    val name: String? = "",

    @SerializedName("status")
    val status: String? = "",

) : Parcelable