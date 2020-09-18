package com.gb.lib.adapters.rv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gb.lib.adapters.list.Selector;
import com.gb.lib.adapters.rv.holder.H;
import com.gb.lib.adapters.rv.i.IBaseAdapter;
import com.gb.lib.app.utils.Utils;
import com.gb.lib.view.holders.VHBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T extends BaseAdapter.IItem> extends RecyclerView.Adapter<H<VHBase>> implements IBaseAdapter<T> {

    @LayoutRes
    private int
            l;

    protected List<IItem>
            items = new ArrayList<>();

    protected Context
            c;

    public BaseAdapter(
            Context c, int l) {
        this.c = c;
        this.l = l;
    }

    public BaseAdapter(
            Context c, int l, List<T> arg1) {
        this(c, l);
        this
                .oAdd(arg1)
                .oAdd(arg1);
    }

    public BaseAdapter(
            Context c, int l, Injection arg1, List<T> arg2) {
        this(c, l);

        this
                .oAdd(arg1)
                .oAdd(arg2);

    }

    /*clean and set*/
    public boolean data(
            List<T> arg1) {

        return this.oClear()
                .oAdd(arg1)
                .uiNotifAll().getItemCount() == 0;
    }

    public boolean data(
            List<T> arg1, Injection arg2) {

        return this.oClear()
                .oAdd(arg1)
                .oAdd(arg2)
                .uiNotifAll().getItemCount() == 0;
    }

    public boolean data(
            Injection arg1, List<T> arg2) {

        return this.oClear()
                .oAdd(arg1)
                .oAdd(arg2)
                .uiNotifAll().getItemCount() == 0;
    }

    public boolean data(
            Injection arg1, List<T> arg2, Injection arg3) {

        return this.oClear()
                .oAdd(arg1)
                .oAdd(arg2)
                .oAdd(arg3)
                .uiNotifAll().getItemCount() == 0;
    }

    public boolean data(
            Injection arg1, List<T> arg2, Injection arg3, List<T> arg4, Injection arg5, List<T> arg6) {

        return this.oClear()
                .oAdd(arg1)
                .oAdd(arg2)
                .oAdd(arg3)
                .oAdd(arg4)
                .oAdd(arg5)
                .oAdd(arg6)
                .uiNotifAll().getItemCount() == 0;
    }

    public boolean data(
            List<T> arg1, Injection arg2, List<T> arg3) {

        return this.oClear()
                .oAdd(arg1)
                .oAdd(arg2)
                .oAdd(arg3)
                .uiNotifAll().getItemCount() == 0;
    }

    /*add*/
    public boolean add(
            List<T> arg1) {
        return this.add(arg1, this.items.size());
    }

    public boolean add(
            List<T> arg1, int position) {
        if (this.items.size() > 0) {
            int p1 = this.items.size() - 1;
            if (this.items.get(p1) instanceof InjectionPagination) {
                this.notifyItemChanged(p1);
            }
        }
        return this.oAdd(arg1, position).uiNotifInsertRange(position, Utils.Lists.safe(arg1).size()).getItemCount() == 0;
    }

    public BaseAdapter<T> update(
            int i, T t) {
        this.items.set(i, t);
        return this;
    }

    public BaseAdapter<T> remove(
            int i) {
        this.items.remove(i);
        return this;
    }

    @NonNull
    @Override
    public H<VHBase> onCreateViewHolder(@NonNull ViewGroup view, int i) {
        return
                new H<>(new VHBase(LayoutInflater.from(this.c).inflate(i, view, false)));
    }

    @Override
    public void onBindViewHolder(@NonNull H view, int position) {
        if (this.items.get(view.getAdapterPosition()) instanceof Injection) {
            this.bind(
                    view.item, (Injection) this.items.get(view.getAdapterPosition()), view.getAdapterPosition());
        } else {
            this.bind(
                    view.item, (T) this.items.get(view.getAdapterPosition()), view.getAdapterPosition());
        }
    }

    @Override
    public void bind(VHBase holder, BaseAdapter.Injection item, int i) {

    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return this.getL(this.items.get(position));
    }

    @Override
    public int getL(IItem item) {
        return item.inst(Injection.class) ? item.cast(Injection.class).getL() : this.l;
    }

    public IItem first() {
        if (this.items.size() > 0) {
            return this.items.get(0);
        }
        return null;
    }

    public IItem selected() {
        for (IItem item : this.items) {
            if (item instanceof Selector && ((Selector) item).isSelected()) {
                return item;
            }
        }
        return null;
    }

    public IItem get(int i) {
        return this.items.get(i);
    }

    public BaseAdapter<T> select(int index) {
        return select(index, true);
    }

    public BaseAdapter<T> select(int index, boolean notif) {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i) instanceof Selector) {
                ((Selector) this.items.get(i)).setSelected(i == index);
            }
        }
        if (notif) {
            this.notifyDataSetChanged();
        }
        return this;
    }

    public int selectedIndex() {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i) instanceof Selector && ((Selector) this.items.get(i)).isSelected()) {
                return i;
            }
        }
        return -1;
    }

    public interface IItem extends Serializable {

        default boolean inst(Class<?> cls) {
            return
                    cls != null && cls.isInstance(this);
        }

        default <T extends IItem> T cast(Class<T> cls) {
            return this.inst(cls) ? cls.cast(this) : null;
        }
    }

    public static class Injection extends Selector implements IItem {

        private @LayoutRes
        int l;

        private int key = -1;

        public Injection(@LayoutRes int l) {
            this.l = l;
        }

        public Injection(@LayoutRes int l, int key) {
            this(l);
            this.key = key;
        }

        public int getL() {
            return l;
        }

        public int getKey() {
            return key;
        }
    }

    public static class InjectionPagination extends Injection {

        public InjectionPagination(int l) {
            super(l);
        }
    }

    public static class IASub<T extends IItem> extends Selector {

        private int index;

        private transient BaseAdapter<T> sub;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public BaseAdapter<T> getSub() {
            return sub;
        }

        public BaseAdapter<T> setSub(BaseAdapter<T> sub) {
            this.sub = sub;
            return sub;
        }
    }


    /*actions*/
    private BaseAdapter<T> oClear() {
        if (this.items != null) {
            this.items.clear();
        }
        return this;
    }

    private BaseAdapter<T> oAdd(List<T> items) {
        return this.oAdd(items, this.items.size());
    }

    private BaseAdapter<T> oAdd(List<T> items, int position) {
        if (items != null) {
            this.items.addAll(position, items);
        }
        return this;
    }

    private BaseAdapter<T> oAdd(Injection injection) {
        if (injection != null) {
            this.items.add(injection);
        }
        return this;
    }

    private BaseAdapter<T> uiNotifAll() {
        this.notifyDataSetChanged();
        return this;
    }

    private BaseAdapter<T> uiNotifInsertRange(int start, int count) {
        this.notifyItemRangeInserted(start, count);
        return this;
    }
}
