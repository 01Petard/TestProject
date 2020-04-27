package com.ixuea.courses.helloworld.IntentStudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ixuea.courses.helloworld.R;

public class SecondIntent extends AppCompatActivity {
    Button mBtn2;
    TextView mTv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_intent);
        mBtn2 = findViewById(R.id.btn2);
        mTv2 = findViewById(R.id.tv2);
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String sex = bundle.getString("sex");
        String phone = bundle.getString("phone");
        Toast.makeText(SecondIntent.this, getIntent().getExtras().getString("back"), Toast.LENGTH_SHORT).show();
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent();
                intent.putExtra("data_return","我是从SecondIntent返回的数据");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
        mTv2.setText("name:"+name+"\n"+"sex:"+sex+"\n"+"phone:"+phone+"\n");

    }

    @Override
    public void onBackPressed() {
        Intent intent  = new Intent();
        intent.putExtra("data_return","我是从SecondIntent返回的数据");
        setResult(RESULT_OK,intent);
        finish();
        super.onBackPressed();
    }
}
