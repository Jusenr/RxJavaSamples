// (c)2016 Flipboard Inc, All Rights Reserved.

package com.myself.rxjavasamsples.TestCase.rxjava.module.map_2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.myself.rxjavasamsples.TestCase.rxjava.fragment.BaseFragment;
import com.myself.rxjavasamsples.R;
import com.myself.rxjavasamsples.TestCase.mvptest.test.api.NetworkApi;
import com.myself.rxjavasamsples.TestCase.rxjava.DividerItemDecoration;
import com.myself.rxjavasamsples.TestCase.rxjava.adapter.ItemListAdapter;
import com.myself.rxjavasamsples.TestCase.rxjava.model.Item;
import com.myself.rxjavasamsples.TestCase.rxjava.util.GankBeautyResultToItemsMapper;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MapFragment extends BaseFragment {
    private int page = 0;

    @Bind(R.id.pageTv)
    TextView pageTv;
    @Bind(R.id.previousPageBt)
    Button previousPageBt;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.gridRv)
    RecyclerView gridRv;

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
        public void onNext(List<Item> images) {
            swipeRefreshLayout.setRefreshing(false);
            pageTv.setText(getString(R.string.page_with_number, page));
            adapter.setItemsData(images);
        }
    };

    @OnClick(R.id.previousPageBt)
    void previousPage() {
        loadPage(--page);
        if (page == 1) {
            previousPageBt.setEnabled(false);
        }
    }

    @OnClick(R.id.nextPageBt)
    void nextPage() {
        loadPage(++page);
        if (page == 2) {
            previousPageBt.setEnabled(true);
        }
    }

    public ItemListAdapter getAdapter() {
        return new ItemListAdapter(getActivity());
    }

    private void loadPage(int page) {
        swipeRefreshLayout.setRefreshing(true);
        unsubscribe();
//        subscription = Network.getGankApi()
//                .getBeauties(10, page)
//                .map(GankBeautyResultToItemsMapper.getInstance())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);

        subscription = NetworkApi.getGank2Api()
                .getBeauties(10, page)
                .map(GankBeautyResultToItemsMapper.getInstance())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        ButterKnife.bind(this, view);

        adapter = getAdapter();

        gridRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        gridRv.setAdapter(adapter);
        //设置分隔线
        gridRv.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        //设置增加或删除条目的动画
        gridRv.setItemAnimator(new DefaultItemAnimator());

        adapter.setOnItemClickLitener(new ItemListAdapter.OnItemClickLitener() {

            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), position + "Click", Toast.LENGTH_SHORT).show();
                adapter.insert(new Item(), 0);
            }

            @Override
            public void onLongItemClick(View view, int position) {
                Toast.makeText(getActivity(), position + "LongClick", Toast.LENGTH_SHORT).show();
                adapter.remove(position);
            }
        });

        swipeRefreshLayout.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW);
        swipeRefreshLayout.setEnabled(false);
        return view;
    }

    @Override
    protected int getDialogRes() {
        return R.layout.dialog_map;
    }

    @Override
    protected int getTitleRes() {
        return R.string.title_map;
    }
}
