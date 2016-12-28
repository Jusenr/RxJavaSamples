package com.myself.rxjavasamsples.TestCase.navigationbar.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.generic.RoundingParams;
import com.myself.rxjavasamsples.R;
import com.myself.rxjavasamsples.TestCase.navigationbar.model.BindChild;
import com.myself.rxjavasamsples.TestCase.navigationbar.util.PreferencesHelper;
import com.myself.rxjavasamsples.library.view.image.ImageDraweeView;
import com.myself.rxjavasamsples.library.view.recycler.BasicViewHolder;
import com.myself.rxjavasamsples.library.view.recycler.adapter.BasicAdapter;
import com.myself.rxjavasamsples.library.view.select.IndicatorDrawable;
import com.myself.rxjavasamsples.retrofit.api.BaseApi;

import java.text.ParseException;
import java.util.List;

import butterknife.Bind;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Email      : jusenr@163.com
 * Company    : 葡萄科技
 * Author     : Jusenr
 * Date       : 2016/10/21 16:28.
 */

public class ChildrenAdapter extends BasicAdapter<BindChild, ChildrenAdapter.ChildViewHolder> {

    private int selectedPosition = 0;
    private final Context mContext;

    public ChildrenAdapter(Context context, List<BindChild> children) {
        super(context, children);
        mContext = this.context;
    }

    public void setSelectedPosition(int position) {
        selectedPosition = position;
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.layout_children_item;
    }

    @Override
    public ChildViewHolder getViewHolder(View itemView, int viewType) {
        //将创建的View注册点击事件
        itemView.setOnClickListener((View.OnClickListener) mContext);
        itemView.setOnLongClickListener((View.OnLongClickListener) mContext);
        return new ChildViewHolder(itemView);
    }

    @Override
    public void onBindItem(final ChildViewHolder holder, final BindChild child, final int position) throws ParseException {
        BindChild.ChildInfoBean bean = child.getChild_info();
        if (bean != null) {
            if (position == selectedPosition) {
                RoundingParams roundingParams = holder.ivChild.getHierarchy().getRoundingParams();
                if (roundingParams == null)
                    roundingParams = new RoundingParams();
                roundingParams.setBorder(Color.parseColor("#8B4CF2"), 4);
                roundingParams.setRoundAsCircle(true);
                holder.ivChild.getHierarchy().setRoundingParams(roundingParams);
                holder.ivSelected.setVisibility(View.VISIBLE);
            } else {
                RoundingParams roundingParams = holder.ivChild.getHierarchy().getRoundingParams();
                if (roundingParams == null)
                    roundingParams = new RoundingParams();
                roundingParams.setBorder(Color.parseColor("#FFFFFF"), 4);
                roundingParams.setRoundAsCircle(true);
                holder.ivChild.getHierarchy().setRoundingParams(roundingParams);
                holder.ivSelected.setVisibility(View.GONE);
            }

            if (TextUtils.isEmpty(bean.getAvatar())) {
                holder.ivChild.setImageURL("res://putao/" + R.drawable.img_head_default_kid);
            } else {
                holder.ivChild.setImageURL(BaseApi.PT_CLOUD_FILE + bean.getAvatar());
            }

            if (PreferencesHelper.childHasNewLog(child.getChildid())) {
                holder.ivIndicator.setVisibility(View.VISIBLE);
            } else {
                holder.ivIndicator.setVisibility(View.GONE);
            }

            String name = TextUtils.isEmpty(bean.getNickname()) ? child.getNick_name() : bean.getNickname();
            holder.tvNickName.setText(name);
        }

        // 如果设置了回调，则设置点击事件
        if (mOnItemClickLitener != null) {
            final int pos = holder.getLayoutPosition();
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickLitener.onItemClick(holder.itemView, child, pos);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    mOnItemClickLitener.onLongItemClick(holder.itemView, child, pos);
                    return false;
                }
            });
        }
    }

    //点击监听方法
    private OnItemClickLitener mOnItemClickLitener;

    public interface OnItemClickLitener {
        void onItemClick(View view, BindChild child, int position);

        void onLongItemClick(View view, BindChild child, int position);
    }

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public static class ChildViewHolder extends BasicViewHolder {
        @Bind(R.id.iv_child)
        ImageDraweeView ivChild;
        @Bind(R.id.iv_selected)
        ImageView ivSelected;
        @Bind(R.id.tv_nickname)
        TextView tvNickName;
        @Bind(R.id.iv_indicator)
        ImageView ivIndicator;

        public ChildViewHolder(View itemView) {
            super(itemView);
            ivIndicator.setImageDrawable(new IndicatorDrawable(itemView.getContext(), true, 10));
        }
    }
}
