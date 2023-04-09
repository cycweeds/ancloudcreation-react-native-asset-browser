package com.ancloudcreation.reactnativeassetbrowser;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;


import java.util.ArrayList;
import java.util.List;

import cc.shinichi.library.ImagePreview;
import cc.shinichi.library.bean.ImageInfo;

public class AssetBrowserManager extends ReactContextBaseJavaModule {
  public static final String TAG = "AssetBrowserManager";

  public static final String NAME = "AssetBrowserManager";
  AssetBrowserManager(ReactApplicationContext context) {
    super(context);
  }


  @NonNull
  @Override
  public String getName() {
    return "AssetBrowserManager";
  }



  @ReactMethod
  public void show(ReadableMap props) {


    ReadableArray pics = props.getArray("urls");
    int defaultIndex = props.getInt("index");
    Log.d(TAG, "show: " + defaultIndex);

    ImageInfo imageInfo;
    final List<ImageInfo> imageInfoList = new ArrayList<>();
    for(int i=0 ; i<pics.size(); i++){
      imageInfo = new ImageInfo();
      imageInfo.setOriginUrl(pics.getString(i));// 原图url
      imageInfoList.add(imageInfo);
    }

    ImagePreview
      .getInstance()
      // 上下文，必须是activity，不需要担心内存泄漏，本框架已经处理好；
      .setContext(getCurrentActivity())

      // 设置从第几张开始看（索引从0开始）
      .setIndex(defaultIndex)

      //=================================================================================================
      // 有三种设置数据集合的方式，根据自己的需求进行三选一：
      // 1：第一步生成的imageInfo List
      .setImageInfoList(imageInfoList)
      .setShowDownButton(false)
      // 开启预览
      .start();
  }
}
