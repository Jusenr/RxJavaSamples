package com.myself.rxjavasamsples.TestCase.buglytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.myself.rxjavasamsples.R;
import com.tencent.bugly.crashreport.CrashReport;

public class BuglyTActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnTestJavaCrash;
    private Button btnTestANRCrash;
    private Button btnTestNativeCrash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bugly_t);

        btnTestJavaCrash = (Button) findViewById(R.id.btnTestJavaCrash);
        btnTestANRCrash = (Button) findViewById(R.id.btnTestANRCrash);
        btnTestNativeCrash = (Button) findViewById(R.id.btnTestNativeCrash);
        btnTestJavaCrash.setOnClickListener(this);
        btnTestANRCrash.setOnClickListener(this);
        btnTestNativeCrash.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnTestJavaCrash: // 点击测试Java Crash
                CrashReport.testJavaCrash();
                break;
            case R.id.btnTestANRCrash: // 点击测试ANR Crash
                CrashReport.testANRCrash();
                break;
            case R.id.btnTestNativeCrash: // 点击测试Native Crash
                CrashReport.testNativeCrash();
                break;
        }
    }
}
