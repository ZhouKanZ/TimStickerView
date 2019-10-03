package com.zkqueen.timstickerview

import androidx.annotation.DrawableRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val stickerList: LiveData<List<TextSpec>> = MutableLiveData(arrayListOf(
        TextSpec("贴纸",R.drawable.ic_mood_black_24dp),
        TextSpec("滤镜",R.drawable.ic_copyright_black_24dp),
        TextSpec("裁剪",R.drawable.ic_crop_black_24dp)
    ))

}

data class TextSpec(val name: String, @DrawableRes val resId: Int)