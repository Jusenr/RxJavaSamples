package com.myself.rxjavasamsples.library.utils;

import android.content.Context;
import android.graphics.Bitmap;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

public class ImageLoaderUtil {
	private static ImageLoader imageLoader;

	/**
	 * 获取ImageLoader的实例
	 * 
	 * @param context
	 * @return
	 */
	public static ImageLoader getInstance(Context context) {
		if (imageLoader == null) {
			initImageLoader(context);
			return imageLoader;
		}
		return imageLoader;
	}

	/**
	 * 初始化
	 * 
	 * @param context
	 */
	public static void initImageLoader(Context context) {

		// 初始化图片加载库

		DisplayImageOptions options;
		options = new DisplayImageOptions.Builder()
				//.showImageOnLoading(R.drawable.default_dish_image_loading) // 设置图片在下载期间显示的图片
				//.showImageForEmptyUri(R.drawable.default_image_no_image)// 设置图片Uri为空或是错误的时候显示的图片
				//.showImageOnFail(R.drawable.default_image_no_image) // 设置图片加载/解码过程中错误时候显示的图片
				.cacheInMemory(true)// 设置下载的图片是否缓存在内存中
				.cacheOnDisc(true)// 设置下载的图片是否缓存在SD卡中
				//.considerExifParams(true) // 是否考虑JPEG图像EXIF参数（旋转，翻转）
				.imageScaleType(ImageScaleType.EXACTLY)// 设置图片以如何的编码方式显示
				.bitmapConfig(Bitmap.Config.RGB_565)// 设置图片的解码类型
				// .decodingOptions(android.graphics.BitmapFactory.Options decodingOptions)//设置图片的解码配置
				.delayBeforeLoading(0)// delayInMillis为你设置的下载前的延迟时间
				// .preProcessor(BitmapProcessor preProcessor)// 设置图片加入缓存前，对bitmap进行设置
				.resetViewBeforeLoading(true)// 设置图片在下载前是否重置，复位
				//.displayer(new RoundedBitmapDisplayer(20))// 是否设置为圆角，弧度为多少
				.displayer(new FadeInBitmapDisplayer(0))// 是否图片加载好后渐入的动画时间
				.build();// 构建完成

		ImageLoaderConfiguration config = new ImageLoaderConfiguration  
			    .Builder(context)  
			    .memoryCacheExtraOptions(480, 480) // max width, max height，即保存的每个缓存文件的最大长宽  
			    //.discCacheExtraOptions(480, 800, CompressFormat.JPEG, 75, null) //设置缓存的详细信息，最好不要设置这个  
			    .threadPoolSize(4)//线程池内加载的数量  
			    .threadPriority(Thread.NORM_PRIORITY - 2)  
			    .denyCacheImageMultipleSizesInMemory()  
			    //.memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024)) //你可以通过自己的内存缓存实现  
			    .memoryCacheSize(16 * 1024 * 1024)    
			    .discCacheSize(50 * 1024 * 1024)    
			    //.discCacheFileNameGenerator(new Md5FileNameGenerator())//将保存的时候的URI名称用MD5 加密  
			    .tasksProcessingOrder(QueueProcessingType.FIFO)//设置缓存清除算法
			    .discCacheFileCount(100) //缓存的文件数量  
			    //.discCache(new FileCountLimitedDiscCache(AppCommon.CacheDirPath))//自定义缓存路径 
			    .defaultDisplayImageOptions(options)  
			    .imageDownloader(new BaseImageDownloader(context, 5 * 1000, 30 * 1000)) // 链接超时时间 (5 s),读写超时时间 (30 s) 
			    .build();//开始构建  
		
		imageLoader = ImageLoader.getInstance();

		imageLoader.init(config);
	}
	
}
