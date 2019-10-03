package com.zkqueen.timstickerview.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.view.GestureDetectorCompat

/**
 *  支持手势的ImageView
 */
class GestureImageView : ImageView, GestureDetector.OnGestureListener,
    GestureDetector.OnDoubleTapListener, View.OnTouchListener {


    private var mDetector: GestureDetectorCompat

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        mDetector = GestureDetectorCompat(context, this)
        mDetector.setOnDoubleTapListener(this)
        setOnTouchListener(this)
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        return if (mDetector.onTouchEvent(event)) {
            true
        } else {
            super.onTouchEvent(event)
        }
    }


    override fun setImageResource(@DrawableRes resId: Int) {
        setImageDrawable(getDrawable(context, resId))
    }

    private fun getDrawable(context: Context, @DrawableRes id: Int): Drawable? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            context.getDrawable(id)
        } else {
            context.resources.getDrawable(id)
        }
    }

    override fun setImageDrawable(drawable: Drawable?) {
        super.setImageDrawable(drawable)

        drawable?.let {
            it.intrinsicHeight
            it.intrinsicWidth
        }

    }


    override fun onShowPress(e: MotionEvent?) {
        println("GestureImageView.onShowPress")
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        println("GestureImageView.onSingleTapUp")
        return true
    }

    override fun onDown(e: MotionEvent?): Boolean {
        println("GestureImageView.onDown")
        return true
    }


    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        println("GestureImageView.onFling")
        return true
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        println("GestureImageView.onScroll")
        return true
    }

    override fun onLongPress(e: MotionEvent?) {
        println("GestureImageView.onLongPress")
    }

    override fun onDoubleTap(e: MotionEvent?): Boolean {
        println("GestureImageView.onDoubleTap")
        return true
    }

    override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
        println("GestureImageView.onDoubleTapEvent")
        return true
    }

    override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
        println("GestureImageView.onSingleTapConfirmed")
        return true
    }


}