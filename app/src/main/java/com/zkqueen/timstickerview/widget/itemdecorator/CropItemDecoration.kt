package com.zkqueen.timstickerview.widget.itemdecorator

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.xiaopo.flying.sticker.utils.dp2px


class CropItemDecoration : RecyclerView.ItemDecoration() {

    val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        paint.color = Color.parseColor("#eaeaea")
        paint.strokeWidth = dp2px(1f)
        paint.style = Paint.Style.FILL
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val childCount = parent.childCount
        for (index in 0 until childCount) {
            if (index == childCount - 1) {
                val view = parent.getChildAt(index)
                c.drawLine(view.left + 2f, view.top.toFloat()+2f,view.left + 2f,view.bottom.toFloat()-2f,paint)
            }
        }
    }
}