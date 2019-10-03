package com.zkqueen.timstickerview.data

import android.graphics.ColorMatrix
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.alexvasilkov.gestures.commons.CropAreaView
import com.xiaopo.flying.sticker.DrawableSticker
import com.xiaopo.flying.sticker.SingleBorderTextSticker
import com.xiaopo.flying.sticker.Sticker
import com.zkqueen.timstickerview.MainApplication
import com.zkqueen.timstickerview.R


/**
 *  获取滤镜数据
 */
fun getFilterData(): ArrayList<FilterStickerSpec> {

    val colorMatrix = getColorFilters()
    var stickerSpecs = ArrayList<FilterStickerSpec>()
    stickerSpecs.add(FilterStickerSpec(R.mipmap.filter01, "原图", colorMatrix[0]))
    stickerSpecs.add(FilterStickerSpec(R.mipmap.filter02, "黑白", colorMatrix[1]))
    stickerSpecs.add(FilterStickerSpec(R.mipmap.filter03, "怀旧", colorMatrix[2]))
    stickerSpecs.add(FilterStickerSpec(R.mipmap.filter04, "哥特", colorMatrix[3]))
    stickerSpecs.add(FilterStickerSpec(R.mipmap.filter05, "淡雅", colorMatrix[4]))
    stickerSpecs.add(FilterStickerSpec(R.mipmap.filter06, "蓝调", colorMatrix[5]))
    stickerSpecs.add(FilterStickerSpec(R.mipmap.filter07, "光晕", colorMatrix[6]))
    stickerSpecs.add(FilterStickerSpec(R.mipmap.filter08, "梦幻", colorMatrix[7]))
    stickerSpecs.add(FilterStickerSpec(R.mipmap.filter09, "酒红", colorMatrix[8]))
    stickerSpecs.add(FilterStickerSpec(R.mipmap.filter10, "胶片", colorMatrix[9]))
    stickerSpecs.add(FilterStickerSpec(R.mipmap.filter11, "湖光掠影", colorMatrix[10]))
    stickerSpecs.add(FilterStickerSpec(R.mipmap.filter12, "褐片", colorMatrix[11]))
    stickerSpecs.add(FilterStickerSpec(R.mipmap.filter13, "复古", colorMatrix[12]))
    stickerSpecs.add(FilterStickerSpec(R.mipmap.filter14, "泛黄", colorMatrix[13]))
    stickerSpecs.add(FilterStickerSpec(R.mipmap.filter15, "传统", colorMatrix[14]))
    stickerSpecs.add(FilterStickerSpec(R.mipmap.filter16, "胶片", colorMatrix[15]))
    stickerSpecs.add(FilterStickerSpec(R.mipmap.filter17, "锐色", colorMatrix[16]))
    stickerSpecs.add(FilterStickerSpec(R.mipmap.filter18, "清宁", colorMatrix[17]))
    stickerSpecs.add(FilterStickerSpec(R.mipmap.filter19, "浪漫", colorMatrix[18]))
    stickerSpecs.add(FilterStickerSpec(R.mipmap.filter20, "夜色", colorMatrix[19]))

    return stickerSpecs;

}

/**
 *  获取裁剪数据
 */
fun getCropDatas(): ArrayList<CropSpec> {

    val cropSpecs = ArrayList<CropSpec>()
    cropSpecs.add(
        CropSpec(
            CropAreaView.ORIGINAL_ASPECT,
            R.drawable.ic_crop_original_black_24dp,
            "原图"
        )
    )
    cropSpecs.add(CropSpec(3 / 2f, R.drawable.ic_crop_3_2_black_24dp, "3:2"))
    cropSpecs.add(CropSpec(16 / 9f, R.drawable.ic_crop_16_9_black_24dp, "16:9"))
    cropSpecs.add(CropSpec(1f, R.drawable.ic_crop_square_black_24dp, "1:1"))
    cropSpecs.add(CropSpec(1f, R.drawable.ic_rotate_right_black_24dp, "旋转"))

    return cropSpecs
}

/**
 *  获取颜色矩阵
 */
fun getColorFilters(): ArrayList<ColorMatrix> {

    val colorMatrixs = ArrayList<ColorMatrix>()

    colorMatrixs.add(
        ColorMatrix(
            floatArrayOf(
                1f, 0f, 0f, 0f, 0f,
                0f, 1f, 0f, 0f, 0f,
                0f, 0f, 1f, 0f, 0f,
                0f, 0f, 0f, 1f, 0f
            )
        )
    )

        // 黑白
    colorMatrixs.add(
        ColorMatrix(
            floatArrayOf(
                0.8f, 1.6f, 0.2f, 0f, -163.9f,
                0.8f, 1.6f, 0.2f, 0f, -163.9f,
                0.8f, 1.6f, 0.2f, 0f, -163.9f,
                0f, 0f, 0f, 1.0f, 0f
            )
        )
    )

        // 怀旧
    colorMatrixs.add(
        ColorMatrix(
            floatArrayOf(
                0.2f, 0.5f, 0.1f, 0f, 40.8f,
                0.2f, 0.5f, 0.1f, 0f, 40.8f,
                0.2f, 0.5f, 0.1f, 0f, 40.8f,
                0f, 0f, 0f, 1f, 0f
            )
        )
    )
    // 哥特
    colorMatrixs.add(
        ColorMatrix(
            floatArrayOf(
                1.9f, -0.3f, -0.2f, 0f, -87.0f,
                -0.2f, 1.7f, -0.1f, 0f, -87.0f,
                -0.1f, -0.6f, 2.0f, 0f, -87.0f,
                0f, 0f, 0f, 1.0f, 0f
            )
        )
    )
    // 淡雅
    colorMatrixs.add(
        ColorMatrix(
            floatArrayOf(
                0.6f, 0.3f, 0.1f, 0f, 73.3f,
                0.2f, 0.7f, 0.1f, 0f, 73.3f,
                0.2f, 0.3f, 0.4f, 0f, 73.3f,
                0f, 0f, 0f, 1.0f, 0f
            )
        )
    )
    // 蓝调
    colorMatrixs.add(
        ColorMatrix(
            floatArrayOf(
                2.1f, -1.4f, 0.6f, 0.0f, -71.0f,
                -0.3f, 2.0f, -0.3f, 0.0f, -71.0f,
                -1.1f, -0.2f, 2.6f, 0.0f, -71.0f,
                0.0f, 0.0f, 0.0f, 1.0f, 0.0f
            )
        )
    )
    // 光晕
    colorMatrixs.add(
        ColorMatrix(
            floatArrayOf(
                0.9f, 0f, 0f, 0f, 64.9f,
                0f, 0.9f, 0f, 0f, 64.9f,
                0f, 0f, 0.9f, 0f, 64.9f,
                0f, 0f, 0f, 1.0f, 0f
            )
        )
    )
    // 梦幻
    colorMatrixs.add(
        ColorMatrix(
            floatArrayOf(
                0.8f, 0.3f, 0.1f, 0.0f, 46.5f,
                0.1f, 0.9f, 0.0f, 0.0f, 46.5f,
                0.1f, 0.3f, 0.7f, 0.0f, 46.5f,
                0.0f, 0.0f, 0.0f, 1.0f, 0.0f
            )
        )
    )
    // 酒红
    colorMatrixs.add(
        ColorMatrix(
            floatArrayOf(
                1.2f, 0.0f, 0.0f, 0.0f, 0.0f,
                0.0f, 0.9f, 0.0f, 0.0f, 0.0f,
                0.0f, 0.0f, 0.8f, 0.0f, 0.0f,
                0f, 0f, 0f, 1.0f, 0f
            )
        )
    )
    // 胶片
    colorMatrixs.add(
        ColorMatrix(
            floatArrayOf(
                -1.0f, 0.0f, 0.0f, 0.0f, 255.0f,
                0.0f, -1.0f, 0.0f, 0.0f, 255.0f,
                0.0f, 0.0f, -1.0f, 0.0f, 255.0f,
                0.0f, 0.0f, 0.0f, 1.0f, 0.0f
            )
        )
    )
    // 湖光掠影
    colorMatrixs.add(
        ColorMatrix(
            floatArrayOf(
                0.8f, 0.0f, 0.0f, 0.0f, 0.0f,
                0.0f, 1.0f, 0.0f, 0.0f, 0.0f,
                0.0f, 0.0f, 0.9f, 0.0f, 0.0f,
                0f, 0f, 0f, 1.0f, 0f
            )
        )
    )
    // 褐片
    colorMatrixs.add(
        ColorMatrix(
            floatArrayOf(
                1.0f, 0.0f, 0.0f, 0.0f, 0.0f,
                0.0f, 0.8f, 0.0f, 0.0f, 0.0f,
                0.0f, 0.0f, 0.8f, 0.0f, 0.0f,
                0f, 0f, 0f, 1.0f, 0f
            )
        )
    )
    // 复古
    colorMatrixs.add(
        ColorMatrix(
            floatArrayOf(
                0.9f, 0.0f, 0.0f, 0.0f, 0.0f,
                0.0f, 0.8f, 0.0f, 0.0f, 0.0f,
                0.0f, 0.0f, 0.5f, 0.0f, 0.0f,
                0f, 0f, 0f, 1.0f, 0f
            )
        )
    )
    // 泛黄
    colorMatrixs.add(
        ColorMatrix(
            floatArrayOf(
                1.0f, 0.0f, 0.0f, 0.0f, 0.0f,
                0.0f, 1.0f, 0.0f, 0.0f, 0.0f,
                0.0f, 0.0f, 0.5f, 0.0f, 0.0f,
                0f, 0f, 0f, 1.0f, 0f
            )
        )
    )
    // 传统
    colorMatrixs.add(
        ColorMatrix(
            floatArrayOf(
                1.0f, 0.0f, 0.0f, 0f, -10f,
                0.0f, 1.0f, 0.0f, 0f, -10f,
                0.0f, 0.0f, 1.0f, 0f, -10f,
                0f, 0f, 0f, 1f, 0f
            )
        )
    )

    // 胶片2
    colorMatrixs.add(
        ColorMatrix(
            floatArrayOf(
                0.71f, 0.2f, 0.0f, 0.0f, 60.0f,
                0.0f, 0.94f, 0.0f, 0.0f, 60.0f,
                0.0f, 0.0f, 0.62f, 0.0f, 60.0f,
                0f, 0f, 0f, 1.0f, 0f
            )
        )
    )
    // 锐色
    colorMatrixs.add(
        ColorMatrix(
            floatArrayOf(
                4.8f, -1.0f, -0.1f, 0f, -388.4f,
                -0.5f, 4.4f, -0.1f, 0f, -388.4f,
                -0.5f, -1.0f, 5.2f, 0f, -388.4f,
                0f, 0f, 0f, 1.0f, 0f
            )
        )
    )
    // 清宁
    colorMatrixs.add(
        ColorMatrix(
            floatArrayOf(
                0.9f, 0f, 0f, 0f, 0f,
                0f, 1.1f, 0f, 0f, 0f,
                0f, 0f, 0.9f, 0f, 0f,
                0f, 0f, 0f, 1.0f, 0f
            )
        )
    )
    // 浪漫
    colorMatrixs.add(
        ColorMatrix(
            floatArrayOf(
                0.9f, 0f, 0f, 0f, 63.0f,
                0f, 0.9f, 0f, 0f, 63.0f,
                0f, 0f, 0.9f, 0f, 63.0f,
                0f, 0f, 0f, 1.0f, 0f
            )
        )
    )
    // 夜色
    colorMatrixs.add(
        ColorMatrix(
            floatArrayOf(
                1.0f, 0.0f, 0.0f, 0.0f, -66.6f,
                0.0f, 1.1f, 0.0f, 0.0f, -66.6f,
                0.0f, 0.0f, 1.0f, 0.0f, -66.6f,
                0.0f, 0.0f, 0.0f, 1.0f, 0.0f
            )
        )
    )




    return colorMatrixs
}


/**
 *  构造贴纸数据
 */
fun getStickerData(): ArrayList<Sticker> {

    fun getDrawable(@DrawableRes resId: Int): Drawable? =
        ContextCompat.getDrawable(MainApplication.context, resId)

    val stickers = ArrayList<Sticker>()
    stickers.add(SingleBorderTextSticker(getDrawable(R.mipmap.learn_life01),"【示例】编辑封面标题"))
    stickers.add(DrawableSticker(getDrawable(R.mipmap.learn_life02)))
    stickers.add(DrawableSticker(getDrawable(R.mipmap.sticker01)))
    stickers.add(DrawableSticker(getDrawable(R.mipmap.sticker02)))
    stickers.add(DrawableSticker(getDrawable(R.mipmap.sticker03)))
    stickers.add(DrawableSticker(getDrawable(R.mipmap.sticker04)))
    return stickers
}


