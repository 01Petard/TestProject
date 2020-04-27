package com.ixuea.courses.helloworld.IntentStudy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ixuea.courses.helloworld.R;

public class FirstIntent extends AppCompatActivity {
    Button mBtn1;
    TextView mTv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_intent);
        mBtn1 = findViewById(R.id.btn1);
        mTv1 = findViewById(R.id.tv1);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //确定起始活动
                Intent intent = new Intent(FirstIntent.this,SecondIntent.class);
                //①：用intent传递数据
                intent.putExtra("back","我是数据back");
                //②：用Bundle传递数据
                Bundle bundle = new Bundle();
                bundle.putString("name","黄泽校");
                bundle.putString("sex","男");
                bundle.putString("phone","13248684099");
                intent.putExtras(bundle);
                //让intent传递数据
//                startActivity(intent);
                startActivityForResult(intent,1);
            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String resultDate = data.getStringExtra("data_return");
                    mTv1.setText(resultDate);
                }
                break;
        }
    }
}
