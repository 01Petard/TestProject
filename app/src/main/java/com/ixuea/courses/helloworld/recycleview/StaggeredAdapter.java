package com.ixuea.courses.helloworld.recycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ixuea.courses.helloworld.R;

import java.util.List;

public class StaggeredAdapter extends RecyclerView.Adapter<StaggeredAdapter.ViewHolder> {
    static  class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ItemImage;
        TextView ItemText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ItemImage = itemView.findViewById(R.id.staggered_iv);
            ItemText = itemView.findViewById(R.id.staggered_tv);
        }
    }
    private List<Item> mItemList;
    public StaggeredAdapter(List<Item> ItemList){
        mItemList = ItemList;
    }
    /*
    创建ViewHold
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_staggered_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    /*
    赋值
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = mItemList.get(position);
        holder.ItemImage.setImageResource(item.getImageId());
        holder.ItemText.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
}
