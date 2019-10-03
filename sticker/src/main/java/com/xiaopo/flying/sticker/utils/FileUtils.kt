package com.xiaopo.flying.sticker.utils

import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


/**
 *  保存bitmap到 internal storage 应该使用内部存储 牢记 [单一职责]
 *  // todo 修改存储方式
 */
fun saveBitmap(bitmap: Bitmap,context: Context): String {

    val cw = ContextWrapper(context)
    // path to /data/data/yourapp/app_data/imageDir
    val directory = cw.getDir("imageDir", Context.MODE_PRIVATE)
    // Create imageDir
    val mypath = File(directory, "${System.currentTimeMillis()}crop.jpg")

    var fos: FileOutputStream? = null
    try {
        fos = FileOutputStream(mypath)
        // Use the compress method on the BitMap object to write image to the OutputStream
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos)
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        try {
            fos!!.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }
    return mypath.absolutePath
}