package com.weiwei.tinker.test.tinkerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * @creater weiwei
 * @date 2018/11/14
 */
public class MainActivity extends AppCompatActivity {
    private String file_end = ".apk";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnLoad = findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //    /storage/emulated/0/patch.apk
                String flie_path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/patch"+file_end;
                Log.d("patch location===",flie_path);
                TinkerManager.loadPatch(flie_path);
            }
        });
        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });
    }
}
