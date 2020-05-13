package com.ixuea.courses.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.DialerKeyListener;
import android.text.method.DigitsKeyListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class qizhongkaoshi1Activity extends AppCompatActivity {
    private Button button;
    private RadioGroup radioGroup;
    private EditText editText;
    String sex;//性别
    double height;//身高
    double weight;//体重

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qizhongkaoshi1);
        button = findViewById(R.id.btn_jisuan);
        radioGroup = findViewById(R.id.rg);
        editText = findViewById(R.id.et_height);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = group.findViewById(checkedId);
                if (radioButton.getText().toString().equals("男")) {
                    sex = "男";
                } else {
                    sex = "女";
                }
            }
        });
        char a = '1';
//        editText.setKeyListener(DigitsKeyListener.getInstance("0123456789."));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                for(int i=0;i<str.length();i++){
                    char s = str.charAt(i);
                    if(!((s>'0'&&s<'9')||s=='.')){
                        Toast.makeText(qizhongkaoshi1Activity.this, "请输入数字！", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                height = Double.parseDouble(editText.getText().toString());
                if (sex.equals("男")) {
                    weight = (height - 80) * 0.7;
                } else {
                    weight = (height - 70) * 0.6;
                }
                Intent intent = new Intent(qizhongkaoshi1Activity.this, qizhongkaoshi2Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("sex", sex);
                bundle.putDouble("height", height);
                bundle.putDouble("weight", Double.parseDouble(new DecimalFormat(".##").format(weight)));//weight保留两位小数
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }
}
