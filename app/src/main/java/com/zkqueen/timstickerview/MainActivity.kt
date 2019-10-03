package com.zkqueen.timstickerview

import android.graphics.Color
import android.graphics.ColorMatrixColorFilter
import android.graphics.PointF
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.xiaopo.flying.sticker.*
import com.zkqueen.timstickerview.databinding.ActivityMainBinding
import com.zkqueen.timstickerview.popupWindow.CropPicDialog
import com.zkqueen.timstickerview.popupWindow.FilterDialog
import com.zkqueen.timstickerview.popupWindow.StickerDialog
import com.xiaopo.flying.sticker.utils.saveBitmap
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.floor
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity(), BaseQuickAdapter.OnItemClickListener,
    CropPicDialog.OnCropClickListener, FilterDialog.OnFilterSelectedListener {

    /**
     *  选择滤镜
     */
    override fun onFilterSelected(colorFilter: ColorMatrixColorFilter) {
        image_crop_viewer.colorFilter = colorFilter
    }

    /**
     *  裁剪
     */
    override fun onCropClick(isLast: Boolean, ration: Float) {
        if (isLast) {
            rotateImage()
        } else {
            image_crop_area.setAspect(ration)
            image_crop_area.update(true)
        }
    }

    /**
     *  向右旋转imageView
     */
    private fun rotateImage() {
        val controller = image_crop_viewer.controller

        if (controller.isAnimating) {
            return  // Waiting for animation end
        }

        val state = controller.state.copy()
        val pivot = getPivot()

        // Rotating to closest next 90 degree ccw
        val rotation = if (state.rotation.roundToInt() % 90f == 0f)
            state.rotation + 90f
        else
            floor((state.rotation / 90f).toDouble()).toFloat() * 90f
        state.rotateTo(rotation, pivot.x, pivot.y)

        // Animating state changes. Do not forget to make a state's copy prior to any changes.
        controller.setPivot(pivot.x, pivot.y)
        controller.animateStateTo(state)
    }

    private fun getPivot(): PointF {
        // Default pivot point is a view center
        val pivot = PointF()
        pivot.x = 0.5f * image_crop_viewer.controller.settings.viewportW
        pivot.y = 0.5f * image_crop_viewer.controller.settings.viewportH
        return pivot
    }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
        val sticker = adapter?.data?.get(position) as Sticker
        sticker_view.addSticker(sticker)
    }

    private val stickerDialog by lazy {
        StickerDialog(this, this)
    }

    private val filterDialog by lazy {
        FilterDialog(this, this)
    }

    private val cropPicDialog by lazy {
        CropPicDialog(this, this)
    }

    private val itemClickListener by lazy {
        BaseQuickAdapter.OnItemClickListener { _, _, position ->
            triggerClick(position)
        }
    }

    private val adapter by lazy {
        object : BaseQuickAdapter<TextSpec, BaseViewHolder>(R.layout.sticker_bottom_item) {
            override fun convert(helper: BaseViewHolder?, item: TextSpec?) {
                helper?.setText(R.id.tv_icon, item?.name)
                item?.resId?.let { helper?.setImageResource(R.id.iv_icon, it) }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        val model = ViewModelProviders.of(this)[MainViewModel::class.java]

        rv_bottom.adapter = adapter
        adapter.onItemClickListener = itemClickListener
        model.stickerList.observe(this, Observer<List<TextSpec>> {
            adapter.setNewData(it)
        })

        initStickerOptions()
        initCropOptions()
    }

    private fun initStickerOptions() {
        //currently you can config your own icons and icon event
        //the event you can custom
        val deleteIcon = BitmapStickerIcon(
            ContextCompat.getDrawable(
                this,
                R.mipmap.ic_sticker_widget_delete
            ),
            BitmapStickerIcon.LEFT_TOP
        )
        deleteIcon.iconEvent = DeleteIconEvent()

        val zoomIcon = BitmapStickerIcon(
            ContextCompat.getDrawable(
                this,
                R.mipmap.ic_sticker_widget_scale
            ),
            BitmapStickerIcon.RIGHT_BOTOM
        )
        zoomIcon.iconEvent = ZoomIconEvent()



        sticker_view.icons = listOf(deleteIcon, zoomIcon)

        //default icon layout
        //stickerView.configDefaultIcons();

        sticker_view.setBackgroundColor(Color.WHITE)
        sticker_view.isLocked = false
        sticker_view.isConstrained = true
        sticker_view.onStickerOperationListener = object :StickerView.OnStickerOperationListener{

            override fun onStickerAdded(sticker: Sticker) {
            }

            override fun onStickerClicked(sticker: Sticker) {
            }

            override fun onStickerDeleted(sticker: Sticker) {
            }

            override fun onStickerDragFinished(sticker: Sticker) {
            }

            override fun onStickerTouchedDown(sticker: Sticker) {
            }

            override fun onStickerZoomFinished(sticker: Sticker) {
            }

            override fun onStickerFlipped(sticker: Sticker) {
            }

            override fun onStickerDoubleTapped(sticker: Sticker) {
            }

        }
    }

    private fun initCropOptions() {
        image_crop_area.setImageView(image_crop_viewer)
        cropPicDialog.setOnShowListener { image_crop_area.visibility = View.VISIBLE }
        cropPicDialog.setOnDismissListener { image_crop_area.visibility = View.GONE }
    }


    private fun triggerClick(position: Int) {
        when (position) {
            0 -> {
                stickerDialog.show()
            }
            1 -> {
                filterDialog.show()
            }
            2 -> {
                cropPicDialog.show()
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_right, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            R.id.save -> {
                // 截图
                val crop = image_crop_viewer.crop()
                crop?.let {
                    val savePath = saveBitmap(it,this)
                    Glide.with(this).load(crop).into(image_crop_viewer)
                }

            }
        }

        return super.onOptionsItemSelected(item)
    }


}
