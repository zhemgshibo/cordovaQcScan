package com.navinfo.android.qcniscan.scan.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.navinfo.android.qcniscan.R;


/**
 * Created by Administrator on 2016/12/12.
 */
public class MyHelpDialog extends Dialog {

    public static final int HELP_TYPE_HOME = 1;//首页扫码
    public static final int HELP_TYPE_VIN_INPUT = 2;
    private int helpType = 0;
    private String tip,tip2;

    public MyHelpDialog(Context context) {
        super(context);
    }

    public MyHelpDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public MyHelpDialog(Context context, int themeResId, int type) {
        super(context, themeResId);
        this.helpType = type;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_dialog);
        Button btnConfirm = (Button) findViewById(R.id.btn_confirm);
        ImageView ivClose = (ImageView) findViewById(R.id.iv_close);
        ImageView iv = (ImageView) findViewById(R.id.iv);
        ImageView iv2 = (ImageView) findViewById(R.id.iv2);
        TextView tv_content = (TextView) findViewById(R.id.tv_content);
        TextView tv_content2 = (TextView) findViewById(R.id.tv_content2);
        if (!TextUtils.isEmpty(tip)&&!TextUtils.isEmpty(tip2)) {
            tv_content.setText(tip);
            tv_content2.setText(tip);
        }
        switch (helpType) {
            case HELP_TYPE_HOME:
                iv.setImageResource(R.drawable.help_type_home);
                iv2.setImageResource(R.drawable.help_type_home2);
                break;
            case HELP_TYPE_VIN_INPUT:
                iv.setImageResource(R.drawable.help_type_vin2);
                iv2.setImageResource(R.drawable.help_type_vin);
                break;
            default:
                iv.setImageResource(R.drawable.ic_launcher_round);
                break;
        }

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyHelpDialog.this.dismiss();
            }
        });
        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyHelpDialog.this.dismiss();
            }
        });
    }

    public void setTip(String tip,String tip2) {
        this.tip = tip;
        this.tip2 = tip2;
    }
}
