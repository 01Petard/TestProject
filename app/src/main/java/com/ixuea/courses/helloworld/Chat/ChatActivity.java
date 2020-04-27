package com.ixuea.courses.helloworld.Chat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ixuea.courses.helloworld.R;

import java.util.ArrayList;
import java.util.List;

    public class ChatActivity extends Activity {

    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        initMsgs();
        inputText = findViewById(R.id.input_text);
        send = findViewById(R.id.send);
        msgRecyclerView = findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if(!"".equals(content)){
                    Msg msg = new Msg(R.drawable.doctor,"博士",content, Msg.TYPE_SEND);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size()-1);//当有新消息时，刷新RecyclerView中的显示
                    msgRecyclerView.scrollToPosition(msgList.size()-1);//将RecyclerView定位到最后一行
                    inputText.setText("");//清空输入框中的内容
                }
            }
        });
    }

    private void initMsgs() {
        msgList.add(new Msg(R.drawable.amiya,"阿米娅","（咚，咚，咚……）",Msg.TYPE_RECEIVED));
        msgList.add(new Msg(R.drawable.doctor,"博士","（刚醒来……）",Msg.TYPE_SEND));
        msgList.add(new Msg(R.drawable.amiya,"阿米娅","Doctor，还有很多事要做哦，现在还不能休息！",Msg.TYPE_RECEIVED));

    }
}
