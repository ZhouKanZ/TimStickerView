package com.zkqueen.timstickerview.popupWindow

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.zkqueen.timstickerview.R
import com.zkqueen.timstickerview.data.CropSpec
import com.zkqueen.timstickerview.data.getCropDatas
import com.xiaopo.flying.sticker.utils.WindowBackgroundDrawable
import com.xiaopo.flying.sticker.utils.dip2px
import com.zkqueen.timstickerview.widget.itemdecorator.CropItemDecoration
import kotlinx.android.synthetic.main.picture_edit_crop_dialog.view.*

class CropPicDialog(context: Context, var cropClickListener: OnCropClickListener) :
    BaseTimingDialog(context) {

    override fun preSetting() {
        backgroundDrawable = WindowBackgroundDrawable.WHITE
    }

    private val cropAdapter by lazy {
        object : BaseQuickAdapter<CropSpec, BaseViewHolder>(R.layout.item_crop) {
            override fun convert(helper: BaseViewHolder?, item: CropSpec?) {
                helper?.apply {
                    item?.resId?.let { setImageResource(R.id.iv_crop_icon, it) }
                    setText(R.id.tv_crop_type, item?.cropName)
                }
            }
        }
    }

    override fun getLayoutResId() = R.layout.picture_edit_crop_dialog

    override fun getWidth() = ViewGroup.LayoutParams.MATCH_PARENT

    override fun getHeight() = dip2px(context, 150f)

    override fun onCreateDialog(mRootView: View) {
        mRootView.rv_crop.adapter = cropAdapter
        mRootView.rv_crop.addItemDecoration(CropItemDecoration())
        cropAdapter.setNewData(getCropDatas())
        cropAdapter.onItemClickListener =
            BaseQuickAdapter.OnItemClickListener { adapter, _, position ->
                val cropSpec = adapter.data[position] as CropSpec
                cropClickListener.onCropClick(adapter.data.lastIndex == position, cropSpec.ration)
            }
    }

    interface OnCropClickListener {
        fun onCropClick(isLast: Boolean, ration: Float)
    }

}