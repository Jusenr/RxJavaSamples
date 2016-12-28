package com.myself.rxjavasamsples.TestCase.navigationbar;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.myself.rxjavasamsples.R;


/**
 * WEBView special title bar.
 * Created by Jusenr on 2016/8/31.
 */
public class WEBNavigationBar extends RelativeLayout {
    private String mMainTitle;
    private String mLeftTitle;
    private String mLeftTitle2;
    private String mRightTitle;
    private String mRightTitle2;

    private int mMainTitleColor;
    private int mLeftTitleColor;
    private int mLeftTitle2Color;
    private int mRightTitleColor;
    private int mRightTitle2Color;

    private int mDisMainTitleColor;
    private int mDisLeftTitleColor;
    private int mDisLeftTitle2Color;
    private int mDisRightTitleColor;
    private int mDisRightTitle2Color;

    private int mMainTitleSize;
    private int mLeftTitleSize;
    private int mLeftTitle2Size;
    private int mRightTitleSize;
    private int mRightTitle2Size;

    private boolean isMainAction = true;
    private boolean isMain2Action = true;
    private boolean isLeftAction = true;
    private boolean isLeft2Action = true;
    private boolean isRightAction = true;
    private boolean isRight2Action = true;

    private Drawable mLeftDrawable;
    private Drawable mLeftDrawable2;
    private Drawable mRightDrawable;
    private Drawable mRightDrawable2;
    private Drawable mMainDrawable;
    private Drawable mMainDrawable2;

    private View mLeftView;
    private TextView mLeft2View;
    private View mRightView;
    private View mRight2View;
    private TextView mMainView;//TODO: make it support custom main view
    private TextView mMainIconView;//TODO: make it support custom main view
    private TextView mRightIconView;
    private WEBActionsListener mListener;

    private boolean mHasDivider = true;
    private int mDividerColor = -1;

    private boolean mHasRightIcon = false;//top right icon for shopping car
    private Drawable mRightIconIndicatorDrawable;
    private int mRightIconTextColor;


    public WEBNavigationBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initNavigationBar(context, attrs);
    }

    public WEBNavigationBar(Context context) {
        this(context, null);
    }

    /**
     * Initialization.
     *
     * @param context
     * @param attrs
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void initNavigationBar(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.WEBNavigationBar);

        /*标题文字*/
        mMainTitle = array.getString(R.styleable.WEBNavigationBar_nav_main_title);
        mLeftTitle = array.getString(R.styleable.WEBNavigationBar_nav_left_title);
        mLeftTitle2 = array.getString(R.styleable.WEBNavigationBar_nav_left_title2);
        mRightTitle = array.getString(R.styleable.WEBNavigationBar_nav_right_title);
        mRightTitle2 = array.getString(R.styleable.WEBNavigationBar_nav_right_title2);

        /*标题文字颜色*/
        mMainTitleColor = array.getColor(R.styleable.WEBNavigationBar_nav_main_title_color, -1);
        mLeftTitleColor = array.getColor(R.styleable.WEBNavigationBar_nav_left_title_color, -1);
        mLeftTitle2Color = array.getColor(R.styleable.WEBNavigationBar_nav_left_title2_color, -1);
        mRightTitleColor = array.getColor(R.styleable.WEBNavigationBar_nav_right_title_color, -1);
        mRightTitle2Color = array.getColor(R.styleable.WEBNavigationBar_nav_right_title2_color, -1);

        mDisMainTitleColor = array.getColor(R.styleable.WEBNavigationBar_nav_dis_main_title_color, -1);
        mDisLeftTitleColor = array.getColor(R.styleable.WEBNavigationBar_nav_dis_left_title_color, -1);
        mDisLeftTitle2Color = array.getColor(R.styleable.WEBNavigationBar_nav_dis_left_title2_color, -1);
        mDisRightTitleColor = array.getColor(R.styleable.WEBNavigationBar_nav_dis_right_title_color, -1);
        mDisRightTitle2Color = array.getColor(R.styleable.WEBNavigationBar_nav_dis_right_title2_color, -1);

        mDividerColor = array.getColor(R.styleable.WEBNavigationBar_nav_divider_color, -1);

        /*标题文字大小*/
        mMainTitleSize = array.getDimensionPixelSize(R.styleable.WEBNavigationBar_nav_main_title_size, -1);
        mLeftTitleSize = array.getDimensionPixelSize(R.styleable.WEBNavigationBar_nav_left_title_size, -1);
        mLeftTitle2Size = array.getDimensionPixelSize(R.styleable.WEBNavigationBar_nav_left_title2_size, -1);
        mRightTitleSize = array.getDimensionPixelSize(R.styleable.WEBNavigationBar_nav_right_title_size, -1);
        mRightTitle2Size = array.getDimensionPixelSize(R.styleable.WEBNavigationBar_nav_right_title2_size, -1);

        /*标题处显示图片*/
        mMainDrawable2 = array.getDrawable(R.styleable.WEBNavigationBar_nav_main_icon);
        mLeftDrawable = array.getDrawable(R.styleable.WEBNavigationBar_nav_left_icon);
        mLeftDrawable2 = array.getDrawable(R.styleable.WEBNavigationBar_nav_left_icon2);
        mRightDrawable = array.getDrawable(R.styleable.WEBNavigationBar_nav_right_icon);
        mRightDrawable2 = array.getDrawable(R.styleable.WEBNavigationBar_nav_right_icon2);

        /*不确定判断*/
        mHasDivider = array.getBoolean(R.styleable.WEBNavigationBar_nav_has_divider, true);
        mHasRightIcon = array.getBoolean(R.styleable.WEBNavigationBar_nav_has_right_title_icon, false);

        /*指示器(购物车左上方数字)*/
        mRightIconIndicatorDrawable = array.getDrawable(R.styleable.WEBNavigationBar_nav_right_title_indicator_background);
        mRightIconTextColor = array.getColor(R.styleable.WEBNavigationBar_nav_right_title_icon_text_color, -1);

        array.recycle();

        //TODO://use custom view to do this to improve performance
        //initializtion
        View v = LayoutInflater.from(getContext()).inflate(R.layout.widget_web_navigation_bar, this);
        mMainView = (TextView) v.findViewById(R.id.main_title);
        mMainIconView = (TextView) v.findViewById(R.id.main_icon);
        TextView leftTitle = (TextView) v.findViewById(R.id.left_title);
        mLeft2View = (TextView) v.findViewById(R.id.left_title2);
        TextView rightTitle = (TextView) v.findViewById(R.id.right_title);
        TextView rightTitle2 = (TextView) v.findViewById(R.id.right_title2);
        mRightIconView = (TextView) v.findViewById(R.id.right_title_icon);
        View right_title_down_icon = v.findViewById(R.id.right_title_down_icon);

        mLeftView = leftTitle;
        mRightView = rightTitle;
        mRight2View = rightTitle2;

        //setTitle
        setMainTitle(mMainTitle);
        setLeftTitle(mLeftTitle);
        setLeftTitle2(mLeftTitle2);
        setRightTitle(mRightTitle);
        setRightTitle2(mRightTitle2);

        //setDrawable
        setDrawableLeft(mMainIconView, mMainDrawable2);
        setDrawableLeft(leftTitle, mLeftDrawable);
        setDrawableLeft(mLeft2View, mLeftDrawable2);
        setDrawableLeft(rightTitle, mRightDrawable);
        setDrawableLeft(rightTitle2, mRightDrawable2);

        //setDivider
        if (mDividerColor != -1)
            findViewById(R.id.divider).setBackgroundColor(mDividerColor);
        findViewById(R.id.divider).setVisibility(mHasDivider ? VISIBLE : GONE);
        //setId
        if (getId() == View.NO_ID)
            setId(R.id.webNavigation_bar);
        //setMainIcon
        if (mMainDrawable2 != null)
            mMainIconView.setVisibility(VISIBLE);

        //setLeftTitleIcon2
        if (mLeftTitle2 != null || mLeftDrawable2 != null)
            mLeft2View.setVisibility(VISIBLE);

        //setRightTitleIcon
        if (mHasRightIcon) {
            mRightIconView.setBackground(mRightIconIndicatorDrawable);
            mRightIconView.setTextColor(mRightIconTextColor);
        }
        //setRightTitleIcon2
        if (mRightTitle2 != null ||  mRightDrawable2 != null)
            mRight2View.setVisibility(VISIBLE);

        //setRightDownIconView
//        if (mHasRightIconDown && mRightDrawabledown != null) {
//            mRightDownIconView.setVisibility(VISIBLE);
//        }
    }

    /**
     * Set the main title.
     *
     * @param title
     */
    public void setMainTitle(String title) {
        mMainTitle = title;
        mMainView.setText(mMainTitle);
        if (mMainTitleColor != -1)
            mMainView.setTextColor(mMainTitleColor);
        if (mMainTitleSize != -1)
            mMainView.setTextSize(mMainTitleSize);
    }

    /**
     * Set the main title color.
     *
     * @param colorId
     */
    public void setMainTitleColor(int colorId) {
        mMainView.setTextColor(colorId);
    }

    /**
     * Set the left title.
     *
     * @param title
     */
    public void setLeftTitle(String title) {
        mLeftTitle = title;
        if (mLeftView instanceof TextView) {
            ((TextView) mLeftView).setText(mLeftTitle);
            if (mLeftTitleColor != -1)
                ((TextView) mLeftView).setTextColor(mLeftTitleColor);
            if (mLeftTitleSize != -1)
                ((TextView) mLeftView).setTextSize(mLeftTitleSize);
        }
    }

    /**
     * Set the left title color.
     *
     * @param colorId
     */
    public void setLeftTitleColor(int colorId) {
        ((TextView) mLeftView).setTextColor(colorId);
    }

    /**
     * Set the left title can be clicked.
     *
     * @param isClick
     */
    public void setLeftClickable(boolean isClick) {
        mLeftView.setEnabled(isClick);
    }

    /**
     * Set the left title2.
     *
     * @param title
     */
    public void setLeftTitle2(String title) {
        mLeftTitle2 = title;
        mLeft2View.setText(mLeftTitle2);
        if (mLeftTitle2Color != -1)
            mLeft2View.setTextColor(mLeftTitle2Color);
        if (mLeftTitle2Size != -1)
            mLeft2View.setTextSize(mLeftTitle2Size);
    }

    /**
     * Set the left title2 color.
     *
     * @param colorId
     */
    public void setLeftTitle2Color(int colorId) {
        mLeft2View.setTextColor(colorId);
    }

    /**
     * Set the left title2 can be clicked.
     *
     * @param isClick
     */
    public void setLeft2Clickable(boolean isClick) {
        mLeft2View.setEnabled(isClick);
    }

    /**
     * Set the right title.
     *
     * @param title
     */
    public void setRightTitle(String title) {
        mRightTitle = title;
        if (mRightView instanceof TextView) {
            ((TextView) mRightView).setText(mRightTitle);
            if (mRightTitleColor != -1)
                ((TextView) mRightView).setTextColor(mRightTitleColor);
            if (mRightTitleSize != -1)
                ((TextView) mRightView).setTextSize(mRightTitleSize);
        }
    }

    /**
     * Set the right title color.
     *
     * @param colorId
     */
    public void setRightTitleColor(int colorId) {
        ((TextView) mRightView).setTextColor(colorId);
    }

    /**
     * Set the right title can be clicked.
     *
     * @param isClick
     */
    public void setRightClickable(boolean isClick) {
        mRightView.setEnabled(isClick);
    }

    /**
     * Set the right title2.
     *
     * @param title
     */
    public void setRightTitle2(String title) {
        mRightTitle2 = title;
        if (mRight2View instanceof TextView) {
            ((TextView) mRight2View).setText(mRightTitle2);
            if (mRightTitle2Color != -1)
                ((TextView) mRight2View).setTextColor(mRightTitle2Color);
            if (mRightTitle2Size != -1)
                ((TextView) mRight2View).setTextSize(mRightTitle2Size);
        }
    }

    /**
     * Set the right title2 color.
     *
     * @param colorId
     */
    public void setRightTitle2Color(int colorId) {
        ((TextView) mRight2View).setTextColor(colorId);
    }

    /**
     * Set the right title2 can be clicked.
     *
     * @param isClick
     */
    public void setRight2Clickable(boolean isClick) {
        mRight2View.setEnabled(isClick);
    }

    /**
     * Set left view.
     *
     * @param view
     */
    public void setLeftView(View view) {
        ViewGroup.LayoutParams params = mLeftView.getLayoutParams();
        view.setLayoutParams(params);
        removeView(mLeftView);
        addView(view);
        mLeftView = view;
    }

    /**
     * Set right view.
     *
     * @param view
     */
    public void setRightView(View view) {
        ViewGroup.LayoutParams params = mRightView.getLayoutParams();
        view.setLayoutParams(params);
        removeView(mRightView);
        addView(view);
        mRightView = view;
    }

    /**
     * Set main action.
     *
     * @param mainAction
     */
    public void setMainAction(boolean mainAction) {
        isMainAction = mainAction;
        setMainTitleColor(isMainAction ? mMainTitleColor : mDisMainTitleColor);
    }

    /**
     * Set left action.
     *
     * @param leftAction
     */
    public void setLeftAction(boolean leftAction) {
        isLeftAction = leftAction;
        setLeftTitleColor(isLeftAction ? mLeftTitleColor : mDisLeftTitleColor);
    }

    /**
     * Set left2 action.
     *
     * @param left2Action
     */
    public void setLeft2Action(boolean left2Action) {
        isLeft2Action = left2Action;
        setLeftTitle2Color(isLeft2Action ? mLeftTitle2Color : mDisLeftTitle2Color);
    }

    /**
     * Set right action.
     *
     * @param rightAction
     */
    public void setRightAction(boolean rightAction) {
        isRightAction = rightAction;
        setRightTitleColor(isRightAction ? mRightTitleColor : mDisRightTitleColor);
    }

    /**
     * Set right2 action.
     *
     * @param right2Action
     */
    public void setRight2Action(boolean right2Action) {
        isRight2Action = right2Action;
        setRightTitle2Color(isRight2Action ? mRightTitle2Color : mDisRightTitle2Color);
    }

    /**
     * Set left visibility.
     *
     * @param visibility
     */
    public void setLeftVisibility(boolean visibility) {
        mLeftView.setVisibility(visibility ? View.VISIBLE : View.GONE);
    }

    /**
     * Set left2 visibility.
     *
     * @param visibility
     */
    public void setLeft2Visibility(boolean visibility) {
        mLeft2View.setVisibility(visibility ? View.VISIBLE : View.GONE);
    }

    /**
     * Set right visibility.
     *
     * @param visibility
     */
    public void setRightVisibility(boolean visibility) {
        mRightView.setVisibility(visibility ? View.VISIBLE : View.GONE);
    }

    /**
     * Set right2 visibility.
     *
     * @param visibility
     */
    public void setRight2Visibility(boolean visibility) {
        mRight2View.setVisibility(visibility ? View.VISIBLE : View.GONE);
    }

    /**
     * Set drawableLeft.
     *
     * @param textView
     * @param drawable
     */
    private void setDrawableLeft(TextView textView, Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(drawable, null, null, null);
    }

    /**
     * Set drawableRight.
     *
     * @param textView
     * @param drawable
     */
    private void setDrawableRight(TextView textView, Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, null, drawable, null);
    }

    /**
     * Set drawableBottom.
     *
     * @param textView
     * @param drawable
     */
    private void setDrawableBottom(TextView textView, Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, null, null, drawable);
    }

    /**
     * Set right title icon.
     */
    public void setRightTitleIcon(String icon) {
        mRightIconView.setText(icon);
    }

    /**
     * Hide right title icon.
     */
    public void hideRightTitleIcon(boolean isHide) {
        mRightIconView.setVisibility(isHide ? View.GONE : View.VISIBLE);
    }

    /**
     * Get left view.
     */
    public View getLeftView() {
        return mLeftView;
    }

    /**
     * Get left2 view.
     */
    public View getLeft2View() {
        return mLeft2View;
    }

    /**
     * Get right view.
     */
    public View getRightView() {
        return mRightView;
    }

    /**
     * Get right2 view.
     */
    public View getRight2View() {
        return mRight2View;
    }

    /**
     * Get main view.
     */
    public View getMainView() {
        return mMainView;
    }

    /**
     * Set action listener.
     * TODO:is it necessary to give three methods for each?
     */
    public void setWEBActionListener(WEBActionsListener listener) {
        mListener = listener;
        for (View v : new View[]{mMainView, mMainIconView, mLeftView, mLeft2View, mRightView, mRight2View}) {
            v.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == mMainView && isMainAction) {
                        mListener.onMainAction();
                    } else if (v == mMainIconView && isMain2Action) {
                        mListener.onMain2Action();
                    } else if (v == mLeftView && isLeftAction) {
                        mListener.onLeftAction();
                    } else if (v == mLeft2View && isLeft2Action) {
                        mListener.onLeft2Action();
                    } else if (v == mRightView && isRightAction) {
                        mListener.onRightAction();
                    } else if (v == mRight2View && isRight2Action) {
                        mListener.onRight2Action();
                    }
                }
            });
        }
    }

    /**
     * Set background.
     */
    @Override
    protected void onFinishInflate() {
        View background = findViewById(R.id.nav_background);
        if (background != null) {
            removeView(background);
            addView(background, 0);
        }
        super.onFinishInflate();
    }

    /**
     * Listener for click event on WEBNavigationBar.
     */
    public interface WEBActionsListener {
        void onLeftAction();

        void onLeft2Action();

        void onMainAction();

        void onMain2Action();

        void onRightAction();

        void onRight2Action();
    }

    public static class SimpleWEBNavigationListener implements WEBActionsListener {
        @Override
        public void onLeftAction() {

        }

        @Override
        public void onLeft2Action() {

        }

        @Override
        public void onMainAction() {

        }

        @Override
        public void onMain2Action() {

        }

        @Override
        public void onRightAction() {

        }

        @Override
        public void onRight2Action() {

        }
    }
}
