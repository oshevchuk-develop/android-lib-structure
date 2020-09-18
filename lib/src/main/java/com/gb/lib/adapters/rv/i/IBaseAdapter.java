package com.gb.lib.adapters.rv.i;

import com.gb.lib.adapters.rv.BaseAdapter;
import com.gb.lib.view.holders.VHBase;

public interface IBaseAdapter<T extends BaseAdapter.IItem> {

    int getL(BaseAdapter.IItem item);

    void bind(VHBase holder, T item, int i);

    void bind(VHBase holder, BaseAdapter.Injection item, int i);
}
