package com.example.tuosha.Utils;

import android.graphics.Bitmap;
import android.util.LruCache;

public class CacheUtil {
    /**
     * 缓存json数据
     */
    private LruCache<Integer, String> mJsonCache;
    private LruCache<String, String> sJsonCache;
    /**
     * 缓存图片信息
     */
    private LruCache<Integer, Bitmap> mBitmapCache;

    private static CacheUtil instance;
    public static CacheUtil getInstance() {
        if (instance == null) {
            instance = new CacheUtil();
        }
        return instance;
    }



    public CacheUtil() {
        mJsonCache = new LruCache<Integer, String>(1 * 1024 * 1024);
        mBitmapCache = new LruCache<Integer, Bitmap>(2 * 1024 * 1024);
        sJsonCache =  new LruCache<String, String>(1 * 1024 * 1024);
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
    }

    /**
     * 添加进入缓存列表
     *
     * @param key
     * @param value
     */
    public void addJsonLruCache(Integer key, String value) {
        mJsonCache.put(key, value);
    }
    public void addJsonLruCache(String key, String value) {
        sJsonCache.put(key, value);
    }
    public void addBitmapLruCache(Integer key, Bitmap value) {
        mBitmapCache.put(key, value);
    }

    /**
     * 从缓存列表中拿出来
     *
     * @param key
     * @return
     */
    public String getJsonLruCache(Integer key) {
        return mJsonCache.get(key);
    }
    public String getJsonLruCache(String key) {
        return sJsonCache.get(key);
    }
    public Bitmap getBitmapLruCache(Integer key) {
        return mBitmapCache.get(key);
    }


    // 从缓存中删除指定的Bitmap
    public void removeBitmapFromMemory(String key) {
        sJsonCache.remove(key);
    }


}