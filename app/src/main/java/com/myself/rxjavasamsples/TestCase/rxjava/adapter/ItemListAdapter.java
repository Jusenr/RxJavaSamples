// (c)2016 Flipboard Inc, All Rights Reserved.

package com.myself.rxjavasamsples.TestCase.rxjava.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.myself.rxjavasamsples.R;
import com.myself.rxjavasamsples.TestCase.rxjava.model.Item;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ItemListAdapter extends RecyclerView.Adapter implements View.OnClickListener, View.OnLongClickListener {
    private List<Item> mDataList = new ArrayList<>();
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public ItemListAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.grid_item;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(viewType, parent, false);
        //将创建的View注册点击事件
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        return new DebounceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        Context mContext = holder.itemView.getContext();
        if (holder instanceof DebounceViewHolder)
            ((DebounceViewHolder) holder).bind(mContext, mDataList, position);


//        DebounceViewHolder debounceViewHolder = (DebounceViewHolder) holder;
//        final Item image = mDataList.get(position);
//        //将数据保存在itemView的Tag中，以便点击时进行获取
//        debounceViewHolder.itemView.setTag(image);
//
//        Glide.with(holder.itemView.getContext())
//                .load(image.imageUrl)
//                .into(debounceViewHolder.imageIv);
//
//        debounceViewHolder.descriptionTv.setText(image.description);

        // 如果设置了回调，则设置点击事件
        if (mOnItemClickLitener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {

                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onLongItemClick(holder.itemView, pos);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    //设置数据,添加数据后通知 adpter 更新
    public void setItemsData(List<Item> list) {
        mDataList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(v, (Item) v.getTag());
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onLongItemClick(v, (Item) v.getTag());
        }
        return false;
    }

    //普通item的viewholder
    static class DebounceViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.imageIv)
        ImageView imageIv;
        @Bind(R.id.descriptionTv)
        TextView descriptionTv;

        public DebounceViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }

        public void bind(Context context, List<Item> mDataList, int position) {
            Glide.with(context)
                    .load(mDataList.get(position).imageUrl)
                    .into(imageIv);

            descriptionTv.setText(mDataList.get(position).description);

            //将数据保存在itemView的Tag中，以便点击时进行获取
            final Item image = mDataList.get(position);
            itemView.setTag(image);
        }
    }

    //添加数据
    public void insert(Item data, int position) {
        mDataList.add(position, data);
        notifyItemInserted(position);
    }

    //移除数据
    public void remove(int position) {
        mDataList.remove(position);
        notifyItemRemoved(position);
    }

    //点击监听方法1(实现onclick...)
    private OnRecyclerViewItemClickListener mOnItemClickListener;

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, Item data);

        void onLongItemClick(View view, Item data);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }


    //点击监听方法2
    private OnItemClickLitener mOnItemClickLitener;

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);

        void onLongItemClick(View view, int position);
    }

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }
}
