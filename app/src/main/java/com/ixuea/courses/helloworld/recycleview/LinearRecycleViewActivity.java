package com.ixuea.courses.helloworld.recycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ixuea.courses.helloworld.R;

public class LinearRecycleViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycle_view);
        RecyclerView mRvmain = findViewById(R.id.rv_main);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRvmain.setLayoutManager(layoutManager);
        mRvmain.addItemDecoration(new MyDecroation());
        mRvmain.setAdapter(new LinearAdapter(LinearRecycleViewActivity.this,
                new LinearAdapter.LinearViewHolder.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(LinearRecycleViewActivity.this, "click..."+pos, Toast.LENGTH_SHORT).show();
            }
        },
                new LinearAdapter.LinearViewHolder.OnItemLongClickListener() {
            @Override
            public void onLongClick(int pos) {
                Toast.makeText(LinearRecycleViewActivity.this, "longclick..."+pos, Toast.LENGTH_SHORT).show();
            }
        }
        ));

    }

    class MyDecroation extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.deviderHeight));
        }
    }
}
