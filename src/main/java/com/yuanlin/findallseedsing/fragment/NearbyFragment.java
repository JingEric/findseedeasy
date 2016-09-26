package com.yuanlin.findallseedsing.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.yuanlin.findallseedsing.R;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
public class NearbyFragment extends Fragment {

    private FrameLayout flcontent;
    private View view;


    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        view = super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.mapfragment_extra_layout, null);

        flcontent = (FrameLayout) inflate.findViewById(R.id.fl_content);

        return inflate;
    }


    @Override
    public void onResume() {
        super.onResume();
//        flcontent.addView(view);
        System.out.println("we can go!");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("onActivityCreated"+"被调用了！！！！附近！！！！！");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("onCreate"+"被调用了！！！！附近！！！！！");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        System.out.println("onAttach"+"被调用了！！！！！附近！！！！");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        System.out.println("onAttachFragment"+"被调用了！！！附近！！！！！！");
    }


    @Override
    public void onStart() {
        super.onStart();
        System.out.println("onStart"+"被调用了！！！！附近！！！！！");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("onStop"+"被调用了！！！！附近！！！！！");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy"+"被调用了！！！！附近！！！！！");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("onDetach"+"被调用了！！！附近！！！！！！");
    }
}
