package com.myfittinglife.app.wanandroid.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.myfittinglife.app.wanandroid.R;

import static com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions.withCrossFade;

/**
 * @Author      LD
 * @Time        2019/1/23 18:11
 * @Describe    图片处理类
 * @Modify
 */
public class ImageUtil {


    /**
     * 加载图片，自定将动态图片转为静态图
     * @param context
     * @param url
     * @param id
     */
    public static void loadStaticImage(Context context,String url, ImageView id){

        RequestOptions requestOptions= new RequestOptions()
                .placeholder(R.drawable.item_pic)                                  //加载过程占位符
                .error(R.drawable.item_pic);                                       //加载失败图片
//                .skipMemoryCache(true);                                           //不在内存中缓存但还是会在本地缓存 ，会导致闪烁

        Glide.with(context)
                .asBitmap()                       //只加载静态图片
                .load(url)
                .apply(requestOptions)
//                .transition(withCrossFade())    //过渡选项淡入淡出(使用了导致图片显示不清晰)
                .into(id);


    }

}
