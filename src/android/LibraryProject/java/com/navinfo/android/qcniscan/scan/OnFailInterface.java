package com.navinfo.android.qcniscan.scan;

/**
 * Created by Administrator on 2017/9/22.
 */

public interface OnFailInterface {

    interface VinInput {
        void onFail(int resultCode, String message);
    }

    interface Capture {
        void onFail(int resultCode, String message);
    }
}
