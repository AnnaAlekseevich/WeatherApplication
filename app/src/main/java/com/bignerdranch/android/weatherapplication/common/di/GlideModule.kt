package com.bignerdranch.android.weatherapplication.common.di

import android.content.Context
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.module.AppGlideModule

@GlideModule
class GlideModule : AppGlideModule() {

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        builder.setMemoryCache(LruResourceCache((1024 * 1024 * 20).toLong())) // 20mb
        builder.setDiskCache(InternalCacheDiskCacheFactory(context, 104857600.toLong())) //100 MB
    }
}
