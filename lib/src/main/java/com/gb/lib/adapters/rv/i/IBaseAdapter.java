package com.gb.lib.adapters.rv.i;

import com.gb.lib.adapters.rv.BaseAdapter;
import com.gb.lib.adapters.rv.holder.Holder;
import com.gb.lib.view.holders.VHBase;

public interface IBaseAdapter<T extends BaseAdapter.Item, H extends VHBase> {

    void init(

    );

    void bind(Holder<H> holder, T item, int i);

    void bind(Holder<H> holder, BaseAdapter.Injection item, int i);

    <D> D get001(Object... objects);

    <D> D get002(Object... objects);

    <D> D get003(Object... objects);

}
