package com.ixuea.courses.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class qizhongkaoshi2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qizhongkaoshi2);
        TextView tv_sex = findViewById(R.id.tv_sex);
        TextView tv_height = findViewById(R.id.tv_height);
        TextView tv_weight = findViewById(R.id.tv_weight);
        Bundle bundle = getIntent().getExtras();
        tv_sex.setText(bundle.getString("sex"));
        tv_height.setText(String.valueOf(bundle.getDouble("height")));
        tv_weight.setText(String.valueOf(bundle.getDouble("weight")));
    }
}
