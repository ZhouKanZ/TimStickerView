package com.zkqueen.timstickerview.data

import androidx.annotation.DrawableRes

open class StickerSpec(val type: StickerType, @DrawableRes val resId: Int, val hintName: String)

enum  class StickerType {
    TITLE,
    COMPOUNDCAPTION,
    STICKER,
    Filter
}