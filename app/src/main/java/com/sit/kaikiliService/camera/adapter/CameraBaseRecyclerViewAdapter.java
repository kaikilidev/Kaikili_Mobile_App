package com.sit.kaikiliService.camera.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ketan patel on 26/1/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 *
 */

public abstract class CameraBaseRecyclerViewAdapter<T, H extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected List<T> arrayList;
    OnItemClickListener onItemClickListener;
    OnItemLongClickListener onItemLongClickListener;
    private Context context;

    public CameraBaseRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public CameraBaseRecyclerViewAdapter(Context context, List<T> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

    }

    public Context getContext() {
        return context;
    }

    abstract public void onBindView(H holder, int position);

    @Override
    public int getItemCount() {
        if (arrayList == null)
            return 0;


        return arrayList.size();
    }

    public T getItem(int position) {
        if (arrayList == null)
            return null;


        return arrayList.get(position);
    }


    public void updateItems(ArrayList<T> items) {

        this.arrayList = items;

        notifyDataSetChanged();
    }

    public void addItems(ArrayList<T> items) {

        if (this.arrayList == null) {
            this.arrayList = items;
        } else {
            this.arrayList.addAll(items);
        }

        notifyDataSetChanged();


    }


    public void addItem(T item) {
        if (arrayList == null) {
            arrayList = new ArrayList<T>();
        }

        arrayList.add(item);
        notifyDataSetChanged();

    }

    public void removeItem(T item) {
        arrayList.remove(item);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(holder.itemView, position);
                }


            });
        }


        if (onItemLongClickListener != null) {
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {

                    onItemLongClickListener.onItemLongClick(holder.itemView, position);


                    return false;
                }
            });
        }


        onBindView((H) holder, position);


    }

    public void setOnItemClickListener(
            OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(
            OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public interface OnItemClickListener {

        public void onItemClick(View view, int position);
    }


    public interface OnItemLongClickListener {

        public void onItemLongClick(View view, int position);
    }


}
