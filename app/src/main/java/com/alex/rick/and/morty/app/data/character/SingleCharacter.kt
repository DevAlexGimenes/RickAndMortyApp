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

    @SerializedName("image")
    val image: String? = "",

    @SerializedName("species")
    val species: String? = "",

    @SerializedName("gender")
    val gender: String? = "",

    @SerializedName("location")
    val location: CharacterLocation?,

    @SerializedName("origin")
    val origin: CharacterOrigin?

) : Parcelable