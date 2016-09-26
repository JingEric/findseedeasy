package com.yuanlin.findallseedsing.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 圈子
 * Created by Administrator on 2016/7/14 0014.
 */
public class UserFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView tv = new TextView(getActivity());
        tv.setText("用户文化");
        tv.setTextColor(Color.RED);
        tv.setGravity(Gravity.CENTER);
//        tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getActivity(), CityPickerActivity.class));
//            }
//        });
        System.out.println("onCreateView"+"被调用了！！！！！！！！！");
        return tv;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("onActivityCreated"+"被调用了！！！！！！！！！");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("onCreate"+"被调用了！！！！！！！！！");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        System.out.println("onAttach"+"被调用了！！！！！！！！！");
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        System.out.println("onAttachFragment"+"被调用了！！！！！！！！！");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("onResume"+"被调用了！！！！！！！！！");
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("onStart"+"被调用了！！！！！！！！！");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("onStop"+"被调用了！！！！！！！！！");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy"+"被调用了！！！！！！！！！");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("onDetach"+"被调用了！！！！！！！！！");
    }
}
