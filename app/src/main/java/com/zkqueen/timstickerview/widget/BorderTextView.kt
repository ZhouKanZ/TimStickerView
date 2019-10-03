package com.zkqueen.timstickerview.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.TextView
import com.xiaopo.flying.sticker.utils.dp2px

/**
 *  绘制带border的文字
 */
class BorderTextView : TextView {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onDraw(canvas: Canvas?) {
        val defaultColor = textColors.defaultColor
        setTextColor(Color.BLACK)
        paint.strokeWidth = dp2px(5f)
        paint.style = Paint.Style.STROKE
        paint.strokeCap = Paint.Cap.ROUND
        super.onDraw(canvas)
        setTextColor(defaultColor)
        paint.strokeWidth = 0f
        paint.style = Paint.Style.FILL
        paint.strokeCap = Paint.Cap.SQUARE
        super.onDraw(canvas)
    }

}