package com.ixuea.courses.helloworld.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.ixuea.courses.helloworld.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StaggeredActivity extends AppCompatActivity {

    private List<Item> ItemList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered);
        init();
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        RecyclerView recyclerView = findViewById(R.id.staggeredview);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        StaggeredAdapter adapter = new StaggeredAdapter(ItemList);
        recyclerView.setAdapter(adapter);
    }

    private void init() {
        for(int i=0;i<10;i++){
            ItemList.add(new Item(getRandomLengthName("1111111"),R.drawable.amiya));
            ItemList.add(new Item(getRandomLengthName("2222"),R.drawable.amiya));
            ItemList.add(new Item(getRandomLengthName("333"),R.drawable.amiya));
            ItemList.add(new Item(getRandomLengthName("44"),R.drawable.amiya));
            ItemList.add(new Item(getRandomLengthName("555555"),R.drawable.amiya));
        }
    }
    private String getRandomLengthName(String str){
        Random random=new Random();
        int length=random.nextInt(20)+1;
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<length;i++){
            builder.append(str);
        }
        return builder.toString();
    }
}
