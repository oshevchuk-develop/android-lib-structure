package com.gb.lib.adapters.rv.i;

import com.gb.lib.adapters.rv.BaseAdapter;
import com.gb.lib.view.holders.VHBase;

public interface IBaseAdapter<T extends BaseAdapter.IItem, H extends VHBase> {

    void bind(H holder, T item, int i);

    void bind(H holder, BaseAdapter.Injection item, int i);
}
