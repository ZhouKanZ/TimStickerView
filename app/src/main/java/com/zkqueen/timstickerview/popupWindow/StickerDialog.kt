package com.zkqueen.timstickerview.popupWindow

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.xiaopo.flying.sticker.Sticker
import com.zkqueen.timstickerview.R
import com.zkqueen.timstickerview.data.getStickerData
import com.xiaopo.flying.sticker.utils.dip2px
import kotlinx.android.synthetic.main.picture_edit_sticker_dialog.view.*


class StickerDialog(
    context: Context,
    var onStickerClickListener: BaseQuickAdapter.OnItemClickListener
) : BaseTimingDialog(context) {

    private val adapter =
        object :
            BaseQuickAdapter<Sticker, BaseViewHolder>(R.layout.item_sticker, getStickerData()) {
            override fun convert(helper: BaseViewHolder?, item: Sticker?) {
                item?.let {
                    helper?.setImageDrawable(R.id.iv_sticker, it.drawable)
                }
            }
        }


    override fun getLayoutResId() = R.layout.picture_edit_sticker_dialog

    override fun getWidth() = ViewGroup.LayoutParams.MATCH_PARENT

    override fun getHeight() = dip2px(context, 260f)

    override fun onCreateDialog(mRootView: View) {
        mRootView.rv_sticker.adapter = adapter
        adapter.onItemClickListener = onStickerClickListener

    }
}