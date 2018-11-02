package id.kotlin.multiplatform

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.MemoryCategory
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.module.AppGlideModule

@GlideModule
class GlideModule : AppGlideModule()

internal fun ImageView.load(url: String) {
    val context: Context = this.context
    Glide.get(context).setMemoryCategory(MemoryCategory.NORMAL)
    GlideApp.with(context).load(url).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(this)
}

internal fun ViewGroup?.inflate(context: Context, layoutRes: Int, attachToRoot: Boolean): View =
        LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)