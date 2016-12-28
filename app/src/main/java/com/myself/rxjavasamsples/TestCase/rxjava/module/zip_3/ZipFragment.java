// (c)2016 Flipboard Inc, All Rights Reserved.

package com.myself.rxjavasamsples.TestCase.rxjava.module.zip_3;

import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.myself.rxjavasamsples.TestCase.rxjava.fragment.BaseFragment;
import com.myself.rxjavasamsples.R;
import com.myself.rxjavasamsples.TestCase.rxjava.adapter.ItemListAdapter;
import com.myself.rxjavasamsples.TestCase.rxjava.model.Item;
import com.myself.rxjavasamsples.TestCase.rxjava.model.ZhuangbiImage;
import com.myself.rxjavasamsples.TestCase.rxjava.DividerGridItemDecoration;
import com.myself.rxjavasamsples.TestCase.rxjava.network.Network;
import com.myself.rxjavasamsples.TestCase.rxjava.util.GankBeautyResultToItemsMapper;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

public class ZipFragment extends BaseFragment {
    @Bind(R.id.gridRv)
    RecyclerView gridRv;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    ItemListAdapter adapter;

    Observer<List<Item>> observer = new Observer<List<Item>>() {

        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            swipeRefreshLayout.setRefreshing(false);
            Toast.makeText(getActivity(), R.string.loading_failed, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNext(List<Item> items) {
            swipeRefreshLayout.setRefreshing(false);
            //设置适配器数据
            adapter.setItemsData(items);
        }
    };

    public ItemListAdapter getAdapter() {
        return new ItemListAdapter(getActivity());
    }

    @OnClick(R.id.zipLoadBt)
    void load() {
        swipeRefreshLayout.setRefreshing(true);
        unsubscribe();
        subscription = Observable.zip(Network.getGankApi().getBeauties(200, 1).map(GankBeautyResultToItemsMapper.getInstance()),
                Network.getZhuangbiApi().search("装逼"),
                new Func2<List<Item>, List<ZhuangbiImage>, List<Item>>() {
                    @Override
                    public List<Item> call(List<Item> gankItems, List<ZhuangbiImage> zhuangbiImages) {
                        List<Item> items = new ArrayList<Item>();
                        for (int i = 0; i < gankItems.size() / 2 && i < zhuangbiImages.size(); i++) {
                            items.add(gankItems.get(i * 2));
                            items.add(gankItems.get(i * 2 + 1));
                            Item zhuangbiItem = new Item();
                            ZhuangbiImage zhuangbiImage = zhuangbiImages.get(i);
                            zhuangbiItem.description = zhuangbiImage.description;
                            zhuangbiItem.imageUrl = zhuangbiImage.image_url;
                            items.add(zhuangbiItem);
                        }
                        return items;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

        private int space;

        public SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect.top = space;
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zip, container, false);
        ButterKnife.bind(this, view);
        adapter = getAdapter();

        gridRv.setLayoutManager(new GridLayoutManager(getActivity(), 2));
//        gridRv.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL));
        gridRv.setAdapter(adapter);

        //设置item之间的间隔
//        gridRv.addItemDecoration(new SpacesItemDecoration(16));
        //设置分隔线
        gridRv.addItemDecoration(new DividerGridItemDecoration(getActivity()));

        adapter.setOnItemClickListener(new ItemListAdapter.OnRecyclerViewItemClickListener() {

            @Override
            public void onItemClick(View view, Item data) {
                Toast.makeText(getActivity(), data.imageUrl, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClick(View view, Item data) {
                Toast.makeText(getActivity(), data.description, Toast.LENGTH_SHORT).show();
            }
        });

        swipeRefreshLayout.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW);
        swipeRefreshLayout.setEnabled(false);
        return view;
    }


    @Override
    protected int getDialogRes() {
        return R.layout.dialog_zip;
    }

    @Override
    protected int getTitleRes() {
        return R.string.title_zip;
    }
}
