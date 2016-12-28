package com.myself.rxjavasamsples.TestCase.navigationbar.util;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.Interpolator;

/**
 * Created by riven_chris on 16/8/11.
 */
public class AnimatorUtil {

    public static abstract class SimpleAnimationListener implements Animator.AnimatorListener {
        @Override
        public void onAnimationStart(Animator animation) {

        }

        @Override
        public void onAnimationEnd(Animator animation) {

        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
    }

    public static ObjectAnimator scaleXAnimator(View targetView, float... values) {
        return scaleXAnimator(targetView, 0, null, values);
    }

    public static ObjectAnimator scaleXAnimator(View targetView, long duration, Interpolator interpolator, float... values) {
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(targetView, "scaleX", values);
        if (duration > 0)
            scaleXAnimator.setDuration(duration);
        if (interpolator != null)
            scaleXAnimator.setInterpolator(interpolator);
        return scaleXAnimator;
    }


    public static ObjectAnimator scaleYAnimator(View targetView, float... values) {
        return scaleYAnimator(targetView, 0, null, values);
    }

    public static ObjectAnimator scaleYAnimator(View targetView, long duration, Interpolator interpolator, float... values) {
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(targetView, "scaleY", values);
        if (duration > 0)
            scaleYAnimator.setDuration(duration);
        if (interpolator != null)
            scaleYAnimator.setInterpolator(interpolator);
        return scaleYAnimator;
    }

    public static AnimatorSet zoomAnimator(View targetView, float... values) {
        return zoomAnimator(targetView, 0, null, values);
    }

    public static AnimatorSet zoomAnimator(View targetView, long duration, Interpolator interpolator, float... values) {
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(targetView, "scaleX", values);
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(targetView, "scaleY", values);
        AnimatorSet set = new AnimatorSet();
        if (duration > 0)
            set.setDuration(duration);
        if (interpolator != null)
            set.setInterpolator(interpolator);
        set.playTogether(scaleXAnimator, scaleYAnimator);
        return set;
    }

    public static ObjectAnimator rotationAnimator(View targetView, float... values) {
        return rotationAnimator(targetView, 0, null, values);
    }

    public static ObjectAnimator rotationAnimator(View targetView, long duration, Interpolator interpolator, float... values) {
        ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(targetView, "rotation", values);
        if (duration > 0)
            rotationAnimator.setDuration(duration);
        if (interpolator != null)
            rotationAnimator.setInterpolator(interpolator);
        return rotationAnimator;
    }

    public static ObjectAnimator alphaAnimator(View targetView, float... values) {
        return alphaAnimator(targetView, 0, null, values);
    }

    public static ObjectAnimator alphaAnimator(View targetView, long duration, Interpolator interpolator, float... values) {
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(targetView, "alpha", values);
        if (duration > 0)
            alphaAnimator.setDuration(duration);
        if (interpolator != null)
            alphaAnimator.setInterpolator(interpolator);
        return alphaAnimator;
    }

    public static ObjectAnimator translationXAnimator(View targetView, float... values) {
        return translationXAnimator(targetView, 0, null, values);
    }

    public static ObjectAnimator translationXAnimator(View targetView, long duration, Interpolator interpolator, float... values) {
        ObjectAnimator translationXAnimator = ObjectAnimator.ofFloat(targetView, "translationX", values);
        if (duration > 0)
            translationXAnimator.setDuration(duration);
        if (interpolator != null)
            translationXAnimator.setInterpolator(interpolator);
        return translationXAnimator;
    }


    public static ObjectAnimator translationYAnimator(View targetView, float... values) {
        return translationYAnimator(targetView, 0, null, values);
    }

    public static ObjectAnimator translationYAnimator(View targetView, long duration, Interpolator interpolator, float... values) {
        ObjectAnimator translationYAnimator = ObjectAnimator.ofFloat(targetView, "translationY", values);
        if (duration > 0)
            translationYAnimator.setDuration(duration);
        if (interpolator != null)
            translationYAnimator.setInterpolator(interpolator);
        return translationYAnimator;
    }
}
