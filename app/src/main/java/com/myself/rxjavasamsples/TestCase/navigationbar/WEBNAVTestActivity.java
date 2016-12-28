package com.myself.rxjavasamsples.TestCase.navigationbar;

import android.os.Bundle;
import android.widget.PopupWindow;

import com.myself.rxjavasamsples.R;
import com.myself.rxjavasamsples.TestCase.navigationbar.adapter.ChildrenAdapter;
import com.myself.rxjavasamsples.TestCase.navigationbar.model.BindChild;
import com.myself.rxjavasamsples.library.base.WDActivity;

import java.util.List;


public class WEBNAVTestActivity extends WDActivity /*implements View.OnClickListener*/ {
    public static final String KEY_GROWN_SEL_CHILD_ID = "key_grown_sel_child_id";


//    @Bind(R.id.rl_navigation)
//    RelativeLayout rl_navigation;
//
//    /****************************************/
//
//    @Bind(R.id.main_title)
//    TextView main_title;
//    @Bind(R.id.iv_main_icon)
//    ImageView iv_main_icon;
//
//    /****************************************/
//
//    @Bind(R.id.left_title)
//    TextView left_title;
//
//    @Bind(R.id.rl_left_icon)
//    RelativeLayout rl_left_icon;
//    @Bind(R.id.iv_left_icon)
//    ImageView iv_left_icon;
//    @Bind(R.id.iv_left_close)
//    ImageView iv_left_close;
//
//    /****************************************/
//
//    @Bind(R.id.right_title)
//    TextView right_title;
//
//    @Bind(R.id.ll_right_icon)
//    RelativeLayout ll_right_icon;
//    @Bind(R.id.iv_right_icon_0)
//    ImageDraweeView iv_right_icon_0;
//    @Bind(R.id.rl_right_icon)
//    RelativeLayout rl_right_icon;
//    @Bind(R.id.iv_right_icon)
//    ImageDraweeView iv_right_icon;
//    @Bind(R.id.iv_more_icon)
//    ImageView iv_more_icon;
//
//    @Bind(R.id.divider)
//    View divider;
//
//    @Bind(R.id.popup_mask)
//    View popup_mask;


    private List<BindChild> mChildList;
    private PopupWindow childrenWindow;
    private ChildrenAdapter adapter;
    private int selectedPosition = 0;


    @Override
    protected int getLayoutId() {
//        ButterKnife.bind(this);
        return R.layout.activity_webnavtest;
    }

    @Override
    protected void onViewCreatedFinish(Bundle saveInstanceState) {
        addNavigation();
        addListener();
//        initData();
//        initView();

    }

    private void addListener() {

//        setMainTitle("我们都是小小鸟啊啊啊啊啊");
    }

//    private void initData() {
//        Bundle bundle = getIntent().getExtras();
//        if (bundle != null) {
//            ChildListBean mChildListBean = (ChildListBean) bundle.getSerializable(BUNDLE_CHILD_LIST_BEAN);
//            mChildList = mChildListBean.getList();
//        }
//
////        String childId = PreferenceUtils.getValue(KEY_GROWN_SEL_CHILD_ID, null);
//        String childId = "6012731";
//        if (!TextUtils.isEmpty(childId)) {
//            for (int i = 0; i < mChildList.size(); i++) {
//                BindChild child = mChildList.get(i);
//                if (child != null && childId.equals(child.getChildid())) {
//                    selectedPosition = i;
//                }
//            }
//        }
//
//    }
//
//    private void initView() {
//
////        main_title.setText("浏览器");
//
//        Log.e("#####", "initView: mChildList=" + mChildList.toString());
//
//        initCurrentChild(getSelChildIcon());
//
//        showMoreChildIcon(hasMoreChild());
//    }
//
//    //获取孩子id
//    public String getSelChildId() {
//        BindChild child = mChildList.get(selectedPosition);
//        if (child != null) {
//            return child.getChildid();
//        }
//        return "";
//    }
//
//    //根据下标，获取孩子头像
//    public String getSelChildIcon() {
//        BindChild child = mChildList.get(selectedPosition);
//        if (child != null) {
//            BindChild.ChildInfoBean info = child.getChild_info();
//            if (info != null) {
//                return info.getAvatar();
//            }
//        }
//        return null;
//    }
//
//    //加载当前孩子头像
//    public void initCurrentChild(String url) {
//        iv_right_icon.setImageURL(BaseApi.PT_CLOUD_FILE + url);
//    }
//
//    //是否还有更多孩子
//    public boolean hasMoreChild() {
//        return mChildList.size() > 1;
//    }
//
//    //显示更多孩子
//    public void showMoreChildIcon(boolean hasNewChildAbilityLog) {
//        iv_more_icon.setVisibility(View.VISIBLE);
//        ObjectAnimator alpha = AnimatorUtil.alphaAnimator(iv_more_icon, 300, null, 0.0f, 1.0f);
//        if (hasNewChildAbilityLog)
//            alpha.addListener(new AnimatorUtil.SimpleAnimationListener() {
//                @Override
//                public void onAnimationEnd(Animator animation) {
////                    ivIndicator.setVisibility(View.VISIBLE);
//                }
//            });
//        alpha.start();
//    }
//
//    //显示更多孩子弹窗
//    public void initChildrenPopupWindow(List<BindChild> list, int selectedPosition) {
//        View contentView = LayoutInflater.from(this).inflate(R.layout.popup_childrens_window, null);
//        childrenWindow = PopupWindowUtil.getPopupWindow(this, contentView);
//        childrenWindow.setBackgroundDrawable(new ColorDrawable(0x0000));
//        childrenWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
//            @Override
//            public void onDismiss() {
//                popup_mask.setVisibility(View.GONE);
//            }
//        });
//        contentView.setPivotX(DensityUtil.getScreenW(this) / 2);
//        contentView.setPivotY(0);
//        contentView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                zoomOutDropDownWindow(childrenWindow);
//            }
//        });
//        BasicRecyclerView recyclerView = (BasicRecyclerView) contentView.findViewById(R.id.rv_children);
//        adapter = new ChildrenAdapter(this, list);
//        recyclerView.setAdapter(adapter);
//        adapter.setSelectedPosition(selectedPosition);
//        adapter.notifyDataSetChanged();
//        onItemClickListener();
//        recyclerView.setOnItemClickListener(new OnItemClickListener<BindChild>() {
//            @Override
//            public void onItemClick(BindChild bindChild, int position) {
//                YouMengHelper.onEvent(WEBNAVTestActivity.this, "切换孩子", "切换孩子");
//                zoomOutDropDownWindow(childrenWindow);
//                onChildReselected(bindChild, position);
//            }
//        });
//        zoomInAsDropDown(childrenWindow, iv_more_icon);
//    }
//
//    public void onChildReselected(final BindChild bindChild, final int position) {
//        loadSuccess(null, position, bindChild.getChildid());
//        initCurrentChild(getSelChildIcon());
//    }
//
//    public void loadSuccess(ChildAbilities childAbilities, int position, String childId) {
//        adapter.setSelectedPosition(position);
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("data", childAbilities.getAbility_list());
//        bundle.putString("childId", childId);
//        bundle.putString("url", childAbilities.getAbility_pic());
//        EventBusHelper.post(bundle, EVENT_CHILD_RESELECTED);
//    }
//
//    private void moreChildClicked() {
//        if (iv_more_icon.getVisibility() == View.GONE)
//            return;
//        if (childrenWindow == null) {
//            initChildrenPopupWindow(mChildList, selectedPosition);
//        } else {
//            zoomInAsDropDown(childrenWindow, iv_more_icon);
//        }
//    }
//
//    private void zoomInAsDropDown(final PopupWindow window, View anchor) {
//        final PopupWindow mPopupWindow = window;
//        View view = mPopupWindow.getContentView();
//        ObjectAnimator scaleX = AnimatorUtil.scaleXAnimator(view, 0.0f, 1.2f, 1.0f);
//        ObjectAnimator scaleY = AnimatorUtil.scaleYAnimator(view, 0.0f, 1.2f, 1.0f);
//        popup_mask.setVisibility(View.VISIBLE);
//        adapter.notifyDataSetChanged();
//        ObjectAnimator alpha = AnimatorUtil.alphaAnimator(popup_mask, 0.0f, 0.5f);
//        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
//        animatorSet.setDuration(500);
//        animatorSet.playTogether(scaleX, scaleY, alpha);
//        mPopupWindow.showAsDropDown(anchor);
//        animatorSet.start();
//    }
//
//    private void zoomOutDropDownWindow(PopupWindow window) {
//        final PopupWindow mPopupWindow = window;
//        if (mPopupWindow != null) {
//            View view = mPopupWindow.getContentView();
//            ObjectAnimator scaleX = AnimatorUtil.scaleXAnimator(view, 1.0f, 0.0f);
//            ObjectAnimator scaleY = AnimatorUtil.scaleYAnimator(view, 1.0f, 0.0f);
//            ObjectAnimator alphaPopup = AnimatorUtil.scaleYAnimator(view, 1.0f, 0.0f);
//            ObjectAnimator alpha = AnimatorUtil.alphaAnimator(popup_mask, 0.5f, 0.0f);
//            AnimatorSet animatorSet = new AnimatorSet();
//            animatorSet.setDuration(250);
//            animatorSet.playTogether(scaleX, scaleY, alphaPopup, alpha);
//            animatorSet.addListener(new AnimatorUtil.SimpleAnimationListener() {
//                @Override
//                public void onAnimationEnd(Animator animation) {
//                    popup_mask.setVisibility(View.GONE);
//                    mPopupWindow.dismiss();
//                }
//            });
//            animatorSet.start();
//        }
//    }
//
//    public void onItemClickListener() {
//        adapter.setOnItemClickLitener(new ChildrenAdapter.OnItemClickLitener() {
//            @Override
//            public void onItemClick(View view, BindChild child, int position) {
//
//                Log.e("#####", "onItemClick: " + child.toString());
//            }
//
//            @Override
//            public void onLongItemClick(View view, BindChild child, int position) {
//
//            }
//        });
//    }
//
//
//    @OnClick({R.id.iv_left_icon, R.id.iv_left_close, R.id.iv_right_icon, R.id.iv_more_icon})
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.iv_left_icon:
//                finish();
//                break;
//            case R.id.iv_left_close:
//                rl_right_icon.setVisibility(View.GONE);
//                break;
//            case R.id.iv_right_icon:
//                initChildrenPopupWindow(mChildList, 0);
//                break;
//            case R.id.iv_more_icon:
//                moreChildClicked();
//                break;
//        }
//    }


    @Override
    public void onLeft2Action() {
        super.onLeft2Action();

    }

    @Override
    public void onMain2Action() {
        super.onMain2Action();

    }

    @Override
    public void onRightAction() {
        super.onRightAction();

    }

    @Override
    public void onRight2Action() {
        super.onRight2Action();

    }


    @Override
    protected String[] getRequestUrls() {
        return new String[0];
    }
}
