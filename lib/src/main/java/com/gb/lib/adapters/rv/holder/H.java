package com.gb.lib.adapters.rv.holder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gb.lib.view.holders.VHBase;

public class H<H extends VHBase> extends RecyclerView.ViewHolder {

    public H
            item;

    public H(@NonNull H holder) {
        super(
                holder.v());

        this.item = holder;
    }
}