package com.myself.rxjavasamsples.TestCase.mvptest.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.myself.rxjavasamsples.EventBusConstants;
import com.myself.rxjavasamsples.R;
import com.myself.rxjavasamsples.TestCase.mvptest.model.bean.FindResource;
import com.myself.rxjavasamsples.library.controller.eventbus.EventBusHelper;
import com.myself.rxjavasamsples.library.view.image.ImageDraweeView;
import com.myself.rxjavasamsples.library.view.recycler.BasicViewHolder;
import com.myself.rxjavasamsples.library.view.recycler.adapter.LoadMoreAdapter;

import java.util.List;

import butterknife.Bind;

/**
 * 精彩订阅适配器
 * Created by Jusenr on 2016/8/4.
 */
public class WonderfulAdapter extends LoadMoreAdapter<FindResource, BasicViewHolder> {
    private static final int KEY_STICK = 0XFD;// 置顶文章
    private static final int KEY_RESOURCE = 0XFC;//文章条目

    private boolean isRefresh;
    private boolean showTop = false;

    private FindResource mTop;

    public WonderfulAdapter(Context context, List<FindResource> resous) {
        super(context, resous);
    }

    @Override
    public int getMultiItemViewType(int position) {
        if (showTop) {
            if (position == 0) {
                return KEY_STICK;
            } else if (mItems.get(position).is_recommend()) {
                return KEY_STICK;
            } else {
                return KEY_RESOURCE;
            }
        } else {
            if (mItems.get(position).is_recommend()) {
                return KEY_STICK;
            } else {
                return KEY_RESOURCE;
            }
        }
    }

    @Override
    public int getLayoutId(int viewType) {
        if (KEY_STICK == viewType)
            return R.layout.discovery_stick;
        else
            return R.layout.discovery_resource;
    }

    @Override
    public BasicViewHolder getViewHolder(View itemView, int viewType) {
        return new WonderfulAdapter.ResourceHolder(itemView);
    }

    @Override
    public void onBindItem(BasicViewHolder holder, FindResource resou, int position) {
        if (showTop) {
            if (position == 0)
                setitemData(holder, mTop); //top展示
            else
                setitemData(holder, resou);//item展示
        } else {
            setitemData(holder, resou);//item展示
        }
    }

    /**
     * 设置top和item数据展示
     *
     * @param holder
     * @param resource
     */
    private void setitemData(final BasicViewHolder holder, final FindResource resource) {
        ResourceHolder resHolder = (ResourceHolder) holder;
        if (resource == null)
            return;
        if (resource.is_recommend())
            resHolder.iv_discovery_pic.resize(600, 300);
        else
            resHolder.iv_discovery_pic.resize(240, 240);
        resHolder.iv_discovery_pic.setImageURL(resource.getIcon());
        resHolder.tv_discovery_title.setText(resource.getTitle());
        resHolder.tv_show_top.setVisibility(resource.is_top() ? View.VISIBLE : View.GONE);
        resHolder.view_gray.setVisibility(resource.is_show_view() ? View.VISIBLE : View.GONE);
        resHolder.view_gray_head.setVisibility(resource.is_show_view() ? View.VISIBLE : View.GONE);
        String[] tags = new String[]{};
        if (resource.getTag() != null) {
            tags = resource.getTag().split("#");
        }
        switch (tags.length) {
            case 0:
            case 1:
                resHolder.tv_tag1.setVisibility(View.GONE);
                resHolder.tv_tag2.setVisibility(View.GONE);
                resHolder.tv_tag3.setVisibility(View.GONE);
                break;
            case 2:
                resHolder.tv_tag1.setVisibility(View.VISIBLE);
                resHolder.tv_tag2.setVisibility(View.GONE);
                resHolder.tv_tag3.setVisibility(View.GONE);
                resHolder.tv_tag1.setText(tags[1]);
                break;
            case 3:
                resHolder.tv_tag1.setVisibility(View.VISIBLE);
                resHolder.tv_tag2.setVisibility(View.VISIBLE);
                resHolder.tv_tag3.setVisibility(View.GONE);
                resHolder.tv_tag1.setText(tags[1]);
                resHolder.tv_tag2.setText(tags[2]);
                break;
            case 4:
                resHolder.tv_tag1.setVisibility(View.VISIBLE);
                resHolder.tv_tag2.setVisibility(View.VISIBLE);
                resHolder.tv_tag3.setVisibility(View.VISIBLE);
                resHolder.tv_tag1.setText(tags[1]);
                resHolder.tv_tag2.setText(tags[2]);
                resHolder.tv_tag3.setText(tags[3]);
                break;
        }

        resHolder.ll_resource.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EventBusHelper.post(resource, EventBusConstants.EVENT_CHILD_UID);
            }
        });
    }


    public static class ResourceHolder extends BasicViewHolder {
        @Bind(R.id.ll_resource)
        LinearLayout ll_resource;
        @Bind(R.id.iv_discovery_pic)
        ImageDraweeView iv_discovery_pic;
        @Bind(R.id.tv_discovery_title)
        TextView tv_discovery_title;
        @Bind(R.id.tv_show_top)
        TextView tv_show_top;
        @Bind(R.id.tv_tag1)
        TextView tv_tag1;
        @Bind(R.id.tv_tag2)
        TextView tv_tag2;
        @Bind(R.id.tv_tag3)
        TextView tv_tag3;
        @Bind(R.id.view_gray)
        View view_gray;
        @Bind(R.id.view_gray_head)
        View view_gray_head;

        public ResourceHolder(View itemView) {
            super(itemView);
        }
    }

    /**
     * TOP
     *
     * @param top
     */
    public void setTop(FindResource top) {
        this.mTop = top;
        isRefresh = true;
        notifyDataSetChanged();
    }

    /**
     * showTop
     *
     * @param have_top
     */
    public void showTop(boolean have_top) {
        Log.e("showTop=: ", "" + have_top);
        this.showTop = have_top;
    }
}
