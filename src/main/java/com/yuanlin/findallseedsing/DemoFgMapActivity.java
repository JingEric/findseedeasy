package com.yuanlin.findallseedsing;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.yuanlin.findallseedsing.fragment.FragmentFactory;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class DemoFgMapActivity extends AppCompatActivity implements View.OnClickListener{

    @InjectView(R.id.fl_content)
    FrameLayout flContent;
    @InjectView(R.id.ll_home)
    LinearLayout llHome;
    @InjectView(R.id.ll_nearby)
    LinearLayout llNearby;
    @InjectView(R.id.ll_circle)
    LinearLayout llCircle;
    @InjectView(R.id.ll_user)
    LinearLayout llUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_fg_map);
        ButterKnife.inject(this);
        llHome.setOnClickListener(this);
        llNearby.setOnClickListener(this);
        llCircle.setOnClickListener(this);
        llUser.setOnClickListener(this);

        llHome.setTag(0);
        llNearby.setTag(1);
        llCircle.setTag(2);
        llUser.setTag(3);

        updateBottomIcon(0);
        setCurrentFragment(0);
    }

    @Override
    public void onClick(View view) {
        int position = (int) view.getTag();
        updateBottomIcon(position);
        setCurrentFragment(position);
    }

    private void updateBottomIcon(int position) {
        llHome.setSelected(position == 0 ? true : false);
        llNearby.setSelected(position == 1 ? true : false);
        llCircle.setSelected(position == 2 ? true : false);
        llUser.setSelected(position == 3 ? true : false);
    }

    private void setCurrentFragment(int position) {
        Fragment fragment = FragmentFactory.getFragment(position);
       // SupportMapFragment supportMapFragment = SupportMapFragment.newInstance();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
       /* if (position==1){
            transaction.replace(R.id.fl_content,supportMapFragment);
        }else {
            transaction.replace(R.id.fl_content,fragment);
        }*/
        transaction.replace(R.id.fl_content,fragment);
        transaction.commit();
    }
}
