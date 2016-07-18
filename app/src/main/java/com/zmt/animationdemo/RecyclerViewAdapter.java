package com.zmt.animationdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Dangelo on 2016/7/15.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private OnItemClickListener clickListener;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.position.setText(position + "");
        holder.title.setText("点击这一项");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n = holder.getLayoutPosition();
                clickListener.OnItemClick(v, n);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView position;
        public TextView title;
        public MyViewHolder(View itemView) {
            super(itemView);
            position = (TextView) itemView.findViewById(R.id.position);
            title = (TextView) itemView.findViewById(R.id.content);
        }
    }

    public interface OnItemClickListener{
        void OnItemClick(View view, int position);
    }

    public void addOnItemClickListener(OnItemClickListener listener){
        clickListener = listener;
    }

}
