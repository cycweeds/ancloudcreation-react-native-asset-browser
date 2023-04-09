package com.ancloudcreation.reactnativeassetbrowser;

import android.content.Context;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;

import java.io.InputStream;

import cc.shinichi.library.glide.progress.ProgressManager;

public class ReactNativeAssetBrowserModule extends com.ancloudcreation.reactnativeassetbrowser.ReactNativeAssetBrowserSpec  {
  public static final String NAME = "ReactNativeAssetBrowser";

  ReactNativeAssetBrowserModule(ReactApplicationContext context) {
    super(context);
  }



  @Override
  @NonNull
  public String getName() {
    return NAME;
  }


  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  @ReactMethod
  public void multiply(double a, double b, Promise promise) {
    promise.resolve(a * b);
  }
}
