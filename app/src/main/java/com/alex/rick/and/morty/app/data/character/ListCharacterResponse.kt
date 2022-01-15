package com.alex.rick.and.morty.app.data.character

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListCharacterResponse(
    @SerializedName("results")
    val character: List<SingleCharacter>
) : Parcelable