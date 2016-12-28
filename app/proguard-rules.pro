# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/rengwuxian/.android-sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
#保持自定义控件类不被混淆
-keepclasseswithmembernames class * {
    native <methods>;
}
-keepclasseswithmembernames class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}
-keepclasseswithmembernames class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

#保持注解类不被混淆
-keepattributes *Annotation*

# facebook fresco
-keep,allowobfuscation @interface com.facebook.common.internal.DoNotStrip
# Do not strip any method/class that is annotated with @DoNotStrip
-keep @com.facebook.common.internal.DoNotStrip class *
-keepclassmembers class * {
    @com.facebook.common.internal.DoNotStrip *;
}
-dontwarn javax.annotation.**

# OkHttp配置
-dontwarn com.squareup.okhttp.**
-dontwarn okio.**

# fastjson配置
-keep class com.alibaba.fastjson.** { *; }

# 友盟
-keepclassmembers class * {
    public <init> (org.json.JSONObject);
}
-keep public class [您的应用包名].R$*{
    public static final int *;
}

# Gson配置
-keep class com.google.gson.stream.** { *; }
-keep class com.google.gson.** { *; }
-keep class com.antew.redditinpictures.library.imgur.** { *; }
-keep class com.antew.redditinpictures.library.reddit.** { *; }

#butterknife
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }

-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}
-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}

#mob
-keep class com.mob.** {*;}
-dontwarn com.mob.**

# umeng
-dontwarn com.umeng.**
-dontwarn org.android.agoo.**
-keep class com.umeng.** { *; }
-keep class org.android.agoo.** { *; }
-keep class org.android.spdy.** { *; }

#photoview-library
#-dontwarn uk.co.senab.photoview.**
#-keep class uk.co.senab.photoview.** {*;}

-dontwarn com.viewpagerindicator.**

#retrofit
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions

#JPush
-dontoptimize -dontpreverify
-dontwarn cn.jpush.** -keep class cn.jpush.** { *; }


