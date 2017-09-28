package com.navinfo.android.qcniscan.scan;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.navinfo.android.qcniscan.R;
import com.navinfo.android.qcniscan.scan.view.MyHelpDialog;
import com.navinfo.android.qcniscan.zxing.activity.CaptureActivity;
import com.navinfo.android.qcniscan.zxing.camera.CameraManager;


public class HomeCaptureActivity extends CaptureActivity implements View.OnClickListener,
        OnFailInterface.Capture {

    private static final String TAG = HomeCaptureActivity.class.getSimpleName();
    private int ifOpenLight = 0; //判断是否开启闪光灯
    private ImageView ivLight;
    private TextView tvLight;
    private LinearLayout llInput;
    private LinearLayout llLight;
    private MyHelpDialog myDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 向 ScanBaseActivity 传递数据
        captureFail = this;
    }

    public void initView() {
        setContentView(R.layout.activity_page_capture);
        llLight = (LinearLayout) findViewById(R.id.ll_light);
        llInput = (LinearLayout) findViewById(R.id.ll_input);
        ivLight = (ImageView) findViewById(R.id.iv_light);
        tvLight = (TextView) findViewById(R.id.tv_light);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        ImageView iv_arrow = (ImageView) findViewById(R.id.iv_arrow);
        ImageView iv_help = (ImageView) findViewById(R.id.iv_help);
        llInput.setOnClickListener(this);
        llLight.setOnClickListener(this);
        iv_arrow.setOnClickListener(this);
        iv_help.setOnClickListener(this);
        myDialog = new MyHelpDialog(this, R.style.dialogStyle, MyHelpDialog.HELP_TYPE_HOME);
        myDialog.setTip("扫码目标为驾驶室挡风玻璃左上角二维码", "扫码目标为车辆前面罩右上角的二维码");
        myDialog.setCancelable(false);
        myDialog.setCanceledOnTouchOutside(false);
        myDialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                myDialog.dismiss();
            }
        }, 3000);
    }

    // 是否开启闪光灯
    public void IfOpenLight(View v) {
        ifOpenLight++;
        switch (ifOpenLight % 2) {
            case 0:
                //关闪光灯
                if (CameraManager.get().closeLight()) {
                    ivLight.setImageResource(R.drawable.icon_light_close);
                    tvLight.setText("打开手电筒");
                }
                break;
            case 1:
                //开闪光灯
                if (CameraManager.get().openLight()) {
                    ivLight.setImageResource(R.drawable.icon_light_open);
                    tvLight.setText("关闭手电筒");
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_input:
//                Intent intent = new Intent(this, VINInputActivity.class);
//                intent.putExtra("workOrderFlag", workOrderFlag);
//                startActivity(intent);
                finish();
                break;
            case R.id.ll_light:
                IfOpenLight(v);
                break;
            case R.id.iv_arrow:
                finish();
                break;
            case R.id.iv_help:
                myDialog.show();
                break;
        }
    }

    // 处理扫码数据
    public void dealData(String data, String format) {
//        scanData = data;
//        double lon = myApplication.getdLon();
//        double lat = myApplication.getdLat();
//        boolean gps = GPSUtils.isSetGps(getApplicationContext());
//        if (!gps) {
//            ToastUtils.getToast(getApplicationContext(), "请开启位置定位");
//            return;
//        }
//        if (lon != 0.0 && lat != 0.0) {
//            progressBar.setVisibility(View.VISIBLE);
//            requestData(lon, lat);
//        } else {
//            initCapture();
//            ToastUtils.getToast(getApplicationContext(), "正在定位，请稍候再试");
//        }
    }

    @Override
    public void onFail(int resultCode, String message) {
//        progressBar.setVisibility(View.INVISIBLE);
//        LogUtils.logd(TAG, LogUtils.getThreadName() + ">>>> resultCode:" + resultCode + ",message:" + message);
//        ToastUtils.getToast(getApplicationContext(), message);
//        initCapture();
    }


    public void setStatus() {
        initCapture();
    }
}