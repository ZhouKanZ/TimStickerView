package com.zkqueen.timstickerview.data

import android.graphics.ColorMatrix

class FilterStickerSpec( resId: Int, hintName: String,val colorMatrix:ColorMatrix,type: StickerType = StickerType.Filter) :
    StickerSpec(type, resId, hintName) {
}