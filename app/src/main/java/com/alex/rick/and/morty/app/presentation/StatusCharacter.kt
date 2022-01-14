package com.alex.rick.and.morty.app.presentation

import android.graphics.Color
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.alex.rick.and.morty.app.R

enum class StatusCharacter(
    @StringRes val status: Int,
    @ColorRes val textColor: Int,
    @DrawableRes val iconImg: Int,
) {
    STATUS_ALIVE(
        status = R.string.txt_status_alive,
        textColor = Color.GREEN,
        iconImg = R.drawable.alive_status
    ),

    STATUS_DEAD(
        status = R.string.txt_status_dead,
        textColor = Color.RED,
        iconImg = R.drawable.dead_status
    ),

    STATUS_UNKNOWN(
        status = R.string.txt_status_unknown,
        textColor = Color.GRAY,
        iconImg = R.drawable.unknow_status
    )
}