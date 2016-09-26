package com.yuanlin.findallseedsing.fragment;

import android.support.v4.app.Fragment;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/7/14 0014.
 */
public class FragmentFactory {
private static HashMap<Integer,Fragment> saveFragment = new HashMap<>();
    public static Fragment getFragment(int position){
        Fragment fragment = saveFragment.get(position);
        if (fragment==null){
            switch (position){
                case 0:
                    fragment = new HomeFragment();
                    break;
                case 1:
                    fragment = new NearbyFragment();
                    break;
                case 2:
                    fragment = new CircleFragment();
                    break;
                case 3:
                    fragment = new UserFragment();
                    break;
            }
            saveFragment.put(position,fragment);

        }
        return fragment;
    }
}
