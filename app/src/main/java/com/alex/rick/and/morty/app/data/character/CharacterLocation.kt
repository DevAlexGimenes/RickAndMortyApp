package com.alex.rick.and.morty.app.data.character

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterLocation(
    @SerializedName("name")
    val name: String? = ""
) : Parcelable
