package com.yuanlin.findallseedsing;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.yuanlin.findallseedsing.fragment.FragmentAAA;
import com.yuanlin.findallseedsing.fragment.FragmentBB;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class TransferActivity extends FragmentActivity {

    @InjectView(R.id.btn_a)
    Button btnA;
    @InjectView(R.id.btn_b)
    Button btnB;
    @InjectView(R.id.fl_content)
    FrameLayout flContent;
    private FragmentTransaction transaction;
    private FragmentTransaction transaction1;
    private FragmentAAA fragmentAAA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        ButterKnife.inject(this);

        fragmentAAA = new FragmentAAA();
    }

    private void getFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.fl_content, fragment);
        transaction.commit();
    }

    @OnClick({R.id.btn_a, R.id.btn_b})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_a:
                getFragment(fragmentAAA);

                break;
            case R.id.btn_b:
                getFragment(new FragmentBB());
                break;
        }
    }
}
