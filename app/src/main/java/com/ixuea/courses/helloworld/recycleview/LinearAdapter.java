package com.ixuea.courses.helloworld.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ixuea.courses.helloworld.R;

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder> {

    private Context mContext;
    private LinearViewHolder.OnItemClickListener mListener;
    private LinearViewHolder.OnItemLongClickListener mLongListener;


    LinearAdapter(Context context, LinearViewHolder.OnItemClickListener listener, LinearViewHolder.OnItemLongClickListener longlistener){
        this.mContext = context;
        this.mListener = listener;
        this.mLongListener = longlistener;
    }

    @NonNull
    @Override
    public LinearAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LinearAdapter.LinearViewHolder holder, final int position) {
        holder.textView.setText("Hello World!");
        //为linear_item添加点击时间
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(position);
            }
        });
        //添加长按事件
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mLongListener.onLongClick(position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    static class LinearViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;

        LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
        }
        //实现短按的接口
        public interface OnItemClickListener{
            void onClick(int pos);
        }
        //实现长按的接口
        public interface OnItemLongClickListener{
            void onLongClick(int pos);
        }

    }
}
