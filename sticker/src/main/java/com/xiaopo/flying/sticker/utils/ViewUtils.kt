package com.xiaopo.flying.sticker.utils

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.ImageView


/**
 * @param @param  context
 * @param @return
 * @return int
 * @throws @history 1.YYYY-MM-DD author: description:
 * @Title: getHeight
 * @Description: 屏幕高度
 */
fun getHeight(context: Context): Int {
    return context.resources.displayMetrics.heightPixels
}


/**
 * @param @param  context
 * @param @return
 * @return int
 * @throws @history 1.YYYY-MM-DD author: description:
 * @Title: getWidth
 * @Description: 屏幕宽度
 */
fun getWidth(context: Context): Int {
    return context.resources.displayMetrics.widthPixels
}

/**
 * @param @param  context
 * @param @return
 * @return float
 * @throws @history 1.YYYY-MM-DD author: description:
 * @Title: getDensity
 * @Description: 屏幕密度
 */
fun getDensity(context: Context): Float {
    return context.resources.displayMetrics.density
}

/**
 * 获取View宽度
 *
 * @param view
 * @return
 */
fun getViewWidth(view: View): Float {
    val w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
    val h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
    view.measure(w, h)
    return view.measuredWidth.toFloat()
}

/**
 * 获取view高度
 *
 * @param view
 * @return
 */
fun getViewHeight(view: View): Float {
    val w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
    val h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
    view.measure(w, h)
    return view.measuredHeight.toFloat()
}

/**
 * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
 */
fun dip2px(context: Context, dpValue: Float): Int {
    val scale = context.resources.displayMetrics.density
    return (dpValue * scale + 0.5f).toInt()
}

fun dp2px(dp: Float):Float{
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().displayMetrics)
}

fun sp2px(dp: Float):Float{
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, dp, Resources.getSystem().displayMetrics)
}


/**
 * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
 */
fun px2dip(context: Context, pxValue: Float): Int {
    val scale = context.resources.displayMetrics.density
    return (pxValue / scale + 0.5f).toInt()
}

// 将px值转换为sp值
fun px2sp(context: Context, pxValue: Float): Int {
    val fontScale = context.resources.displayMetrics.scaledDensity
    return (pxValue / fontScale + 0.5f).toInt()
}

// 将sp值转换为px值
fun sp2px(context: Context, spValue: Float): Int {
    val fontScale = context.resources.displayMetrics.scaledDensity
    return (spValue * fontScale + 0.5f).toInt()
}

fun startImageViewAnimation(imageView: ImageView?) {
    if (imageView != null) {
        val rotateAnimation = RotateAnimation(
            0f, 360f, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF,
            0.5f
        )
        rotateAnimation.interpolator = LinearInterpolator()
        rotateAnimation.duration = 720
        rotateAnimation.fillAfter = true
        rotateAnimation.repeatCount = Animation.INFINITE

        imageView.visibility = View.VISIBLE
        imageView.startAnimation(rotateAnimation)
    }
}

/**
 * @param @param imageView
 * @return void
 * @throws @history 1.YYYY-MM-DD author: description:
 * @Title: stopLodingImageViewAnimation
 * @Description: 停止loading
 */
fun stopLoadingImageViewAnimation(imageView: ImageView?) {
    if (imageView != null) {
        val anim = imageView.animation
        anim?.cancel()
        imageView.clearAnimation()
        imageView.visibility = View.INVISIBLE
    }
}

