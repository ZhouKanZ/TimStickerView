package com.zkqueen.timstickerview.popupWindow

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import com.zkqueen.timstickerview.R
import com.xiaopo.flying.sticker.utils.WindowBackgroundDrawable

/**
 *  @author zk
 *  @feature 1.触摸不消失
 *           2.焦点可以向外传递
 */
abstract class BaseTimingDialog(context: Context, var cancelTouchOutside: Boolean = false) :
    Dialog(context, R.style.BaseDialog),
    TimingDialogHelper {

    var backgroundDrawable: WindowBackgroundDrawable = WindowBackgroundDrawable.BLACK

    private var mRootView: View = View.inflate(context, getLayoutResId(), null)


    // 设置布局id
    abstract fun getLayoutResId(): Int

    abstract fun getWidth(): Int

    abstract fun getHeight(): Int

    abstract fun onCreateDialog(mRootView: View)

    open fun getOffsetY(): Int {
        return 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateDialog(mRootView)
    }

    init {
        preSetting()
        setContentView(mRootView)
        initSetting()
    }

    /**
     *  设置
     */
    open fun preSetting() {}

    private fun initSetting() {

        setCanceledOnTouchOutside(cancelTouchOutside)

        window.setGravity(Gravity.BOTTOM)
        window.attributes = window.attributes.apply {
            dimAmount = 0.0f
            width = getWidth()
            height = getHeight()
            y = getOffsetY()
        }

        window.setWindowAnimations(R.style.anim_bottom_in_out)
        window.addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL)
        window.setBackgroundDrawable(backgroundDrawable.drawable)
    }


}