package com.yuanlin.findallseedsing;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.yuanlin.findallseedsing.fragment.FragmentFactory;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * mainifest文件配置这个activity
 * Created by Administrator on 2016/9/23 0023.
 */
public class FragmentMapDemo extends FragmentActivity {
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
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_fragment_map_demo);
        ButterKnife.inject(this);
        updateBottomIcon(0);
        setCurrentFragment(0);
    }

    private void updateBottomIcon(int position) {
        llHome.setSelected(position == 0 ? true : false);
        llNearby.setSelected(position == 1 ? true : false);
        llCircle.setSelected(position == 2 ? true : false);
        llUser.setSelected(position == 3 ? true : false);
    }

    private void setCurrentFragment(int position) {
        Fragment fragment = FragmentFactory.getFragment(position);
//        Fragment Nfragment = FragmentFactory.getFragment(1);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        transaction.replace(R.id.fl_content, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @OnClick({R.id.ll_home, R.id.ll_nearby, R.id.ll_circle, R.id.ll_user})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_home:
                updateBottomIcon(0);
                setCurrentFragment(0);
                break;
            case R.id.ll_nearby:
                updateBottomIcon(1);
                setCurrentFragment(1);
                break;
            case R.id.ll_circle:
                updateBottomIcon(2);
                setCurrentFragment(2);
                break;
            case R.id.ll_user:
                updateBottomIcon(3);
                setCurrentFragment(3);
                break;
        }
    }
}
