package com.yuanlin.findallseedsing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements BDLocationListener {

    @InjectView(R.id.bmapView)
    MapView bmapView;
    @InjectView(R.id.btn_next)
    Button btnNext;
    private BaiduMap baiduMap;
    private LocationClient client;
    private boolean isFirstLoc = true;//是否首次定位

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initMap();

        initLocation();
    }

    private void initLocation() {
        client = new LocationClient(getApplicationContext());
        LocationClientOption clientOption = new LocationClientOption();
        clientOption.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);// 设置定位模式
        clientOption.setCoorType("bd09ll");// 返回的定位结果是百度经纬度,默认值gcj02
        clientOption.setScanSpan(5000);// 设置发起定位请求的间隔时间为5000ms
        clientOption.setIsNeedAddress(true);// 返回的定位结果包含地址信息
        clientOption.setNeedDeviceDirect(true);// 返回的定位结果包含手机机头的方向

        client.setLocOption(clientOption);

        baiduMap.setMyLocationEnabled(true);
        client.start();//开启定位
        client.registerLocationListener(this);
    }

    private void initMap() {
        baiduMap = bmapView.getMap();
        baiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        bmapView.showZoomControls(false);//mapview隐藏缩放按钮

    }

    @Override
    protected void onDestroy() {
        client.stop();
        baiduMap.setMyLocationEnabled(false);//关闭定位图层
        bmapView.onDestroy();
        bmapView = null;
        super.onDestroy();

    }

    @Override
    protected void onResume() {
        super.onResume();
        bmapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        bmapView.onPause();
    }

    @Override
    public void onReceiveLocation(BDLocation bdLocation) {

        if (bdLocation == null || bmapView == null) {
            return;
        }
        MyLocationData locData = new MyLocationData.Builder().accuracy(bdLocation.getRadius()).direction(100).latitude(bdLocation.getLatitude()).longitude(bdLocation.getLongitude()).build();
        baiduMap.setMyLocationData(locData);

        if (isFirstLoc) {
            isFirstLoc = false;
            LatLng latLng = new LatLng(bdLocation.getLatitude(), bdLocation.getLongitude());
            MapStatus.Builder builder = new MapStatus.Builder();
            builder.target(latLng).zoom(18.0f);//设置地图中心点和缩放比例
            baiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
        }
    }

    @OnClick(R.id.btn_next)
    public void onClick() {
        startActivity(new Intent(this,Main2Activity.class));
    }
}
