package com.xiaopo.flying.sticker

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import com.xiaopo.flying.sticker.utils.dp2px
import com.xiaopo.flying.sticker.utils.sp2px

/**
 *  单行文字贴纸
 */
class SingleBorderTextSticker(drawable: Drawable?, var text: String) : DrawableSticker(drawable) {

    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var textSize = sp2px(20f)
    var textColor = Color.RED
    var textBorderColor = Color.parseColor("#fddf3f")
    var textBorderWidth = dp2px(5f)
    var fontMetrics: Paint.FontMetrics

    init {
        println("SingleBorderTextSticker")
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        canvas.save()
        canvas.concat(matrix)
        drawText(canvas)
        canvas.restore()
    }

    init {
        paint.textSize = textSize
        fontMetrics = paint.fontMetrics
    }

    /**
     *  绘制文字
     */
    private fun drawText(canvas: Canvas) {

        val measureText = paint.measureText(text)
        val startX = (width - measureText) / 2
        val startY = height / 2 + (fontMetrics.descent - fontMetrics.ascent) / 2

        paint.color = textBorderColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = textBorderWidth
        // 1.绘制外边框
        canvas.save()
        canvas.drawText(text, startX, startY, paint)
        canvas.restore()
        // 2.绘制内部
        canvas.save()
        paint.strokeWidth = 0f
        paint.style = Paint.Style.FILL
        paint.color = textColor
        canvas.drawText(text, startX, startY, paint)
        canvas.restore()
    }


}