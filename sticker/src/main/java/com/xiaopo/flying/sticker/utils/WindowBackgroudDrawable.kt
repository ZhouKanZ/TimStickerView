package com.xiaopo.flying.sticker.utils

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable

enum class WindowBackgroundDrawable(var drawable: Drawable) {
    BLACK(ColorDrawable(Color.BLACK)),
    TRANSPARENT(ColorDrawable(Color.TRANSPARENT)),
    WHITE(ColorDrawable(Color.WHITE))
}