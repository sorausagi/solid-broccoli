package com.example.hiroki_tsukazawa.lifee_2018;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<String> ilist;

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        ViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.text_view);
        }
    }

    MyAdapter(List<String> ilist){
        this.ilist = ilist;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cell_view, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(ilist.get(position));
    }

    @Override
    public int getItemCount() {
        return ilist.size();
    }

}