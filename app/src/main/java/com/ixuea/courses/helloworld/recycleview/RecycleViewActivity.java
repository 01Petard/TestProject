package com.ixuea.courses.helloworld.recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ixuea.courses.helloworld.R;

public class RecycleViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        Button mBtnLinear = findViewById(R.id.btn_linear);
        Button mBtnStaggered = findViewById(R.id.btn_staggered);
        mBtnLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecycleViewActivity.this,LinearRecycleViewActivity.class);
                startActivity(intent);
            }
        });
        mBtnStaggered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecycleViewActivity.this,StaggeredActivity.class);
                startActivity(intent);
            }
        });
    }
}
