package com.zkqueen.timstickerview.popupWindow

import android.content.Context
import android.graphics.ColorMatrixColorFilter
import android.graphics.Rect
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.zkqueen.timstickerview.R
import com.zkqueen.timstickerview.data.FilterStickerSpec
import com.zkqueen.timstickerview.data.getFilterData
import com.xiaopo.flying.sticker.utils.WindowBackgroundDrawable
import com.xiaopo.flying.sticker.utils.dip2px
import kotlinx.android.synthetic.main.picture_edit_filter_dialog.view.*

class FilterDialog(
    context: Context,var onFilterSelectedListener: OnFilterSelectedListener
) : BaseTimingDialog(context), BaseQuickAdapter.OnItemClickListener {

    override fun getOffsetY() = dip2px(context, 50f)

    override fun preSetting() {
        backgroundDrawable = WindowBackgroundDrawable.WHITE
    }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
        // 选在不同的位置
        if (lastSelectedPosition != position) {
            val filterStickerSpec = adapter?.data?.get(position) as FilterStickerSpec
            val colorMatrixColorFilter = ColorMatrixColorFilter(filterStickerSpec.colorMatrix)
            onFilterSelectedListener.onFilterSelected(colorMatrixColorFilter)
            adapter?.notifyItemChanged(position)
            if (lastSelectedPosition != -1) {
                adapter?.notifyItemChanged(lastSelectedPosition)
            }
        }
        lastSelectedPosition = position
    }

    // 上次选中的位置
    private var lastSelectedPosition = -1

    private val filterAdapter by lazy {
        object : BaseQuickAdapter<FilterStickerSpec, BaseViewHolder>(R.layout.item_filter) {
            override fun convert(helper: BaseViewHolder?, item: FilterStickerSpec?) {
                helper?.apply {
                    item?.resId?.let { setImageResource(R.id.ivFilterIcon, it) }
                    setVisible(R.id.ivMask, lastSelectedPosition == adapterPosition)
                    setText(R.id.tvFilterName, item?.hintName)
                }
            }
        }
    }

    override fun getLayoutResId() = R.layout.picture_edit_filter_dialog

    override fun getWidth() = ViewGroup.LayoutParams.MATCH_PARENT

    override fun getHeight() = dip2px(context, 100f)


    override fun onCreateDialog(mRootView: View) {
        mRootView.rvFilter.adapter = filterAdapter
        mRootView.rvFilter.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                outRect.left = dip2px(context, 15f)
                outRect.top = dip2px(context, 15f)
                outRect.bottom = 0
                outRect.right = 0
            }
        })
        filterAdapter.onItemClickListener = this
        filterAdapter.setNewData(getFilterData())
    }

    interface OnFilterSelectedListener {
        fun onFilterSelected(colorFilter: ColorMatrixColorFilter)
    }
}