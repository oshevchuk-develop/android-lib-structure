package com.gb.lib.view.holders;

import android.content.Context;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.gb.lib.R;
import com.gb.lib.adapters.rv.BaseAdapter;
import com.gb.lib.app.utils.Utils;
import com.google.android.material.snackbar.Snackbar;

public class VHBase {

    private View
            v;

    public VHBase(
            View v) {
        this.v = v;
    }

    public VHBase click(
            View.OnClickListener l) {
        if (this.v != null) {
            this.v.setOnClickListener(l);
        }
        return this;
    }

    public VHBase click(
            @IdRes int id, View.OnClickListener l) {
        View v = this.v(id);
        if (
                v != null) {
            v.setOnClickListener(l);
        }
        return this;
    }

    public VHBase clickLong(
            View.OnLongClickListener l) {
        if (this.v != null) {
            this.v.setOnLongClickListener(l);
        }
        return this;
    }

    public VHBase clickLong(
            @IdRes int id, View.OnLongClickListener l) {
        View v = this.v(id);
        if (
                v != null) {
            v.setOnLongClickListener(l);
        }
        return this;
    }

    public VHBase clickable(
            boolean state) {
        if (
                this.v != null) {
            this.v.setClickable(state);
        }
        return this;
    }

    public VHBase clickable(
            @IdRes int id, boolean state) {
        View v = this.v(id);
        if (
                v != null) {
            v.setClickable(state);
        }
        return this;
    }

    public VHBase touch(
            @IdRes int id, View.OnTouchListener l) {
        View v = this.v(id);
        if (
                v != null) {
            v.setOnTouchListener(l);
        }
        return this;
    }

    public boolean checked(
            @IdRes int id) {
        CheckBox v = this.v(id, CheckBox.class);
        if (
                v != null) {
            return v.isChecked();
        }
        return false;
    }

    public VHBase checked(
            @IdRes int id, boolean state) {
        CheckBox v = this.v(id, CheckBox.class);
        if (
                v != null) {
            v.setChecked(state);
        }
        return this;
    }

    public VHBase checked(
            @IdRes int id, CompoundButton.OnCheckedChangeListener listener) {
        CheckBox v = this.v(id, CheckBox.class);
        if (
                v != null) {
            v.setOnCheckedChangeListener(listener);
        }
        return this;
    }

    public String text(
            @IdRes int id) {
        TextView v = this.v(id, TextView.class);
        if (
                v != null) {
            return v.getText().toString();
        } else {
            return Utils.Strings.EMPTY;
        }
    }

    public VHBase text(
            @IdRes int id, String text) {
        TextView v = this.v(id, TextView.class);
        if (
                v != null) {
            v.setText(Utils.Strings.val(text));
        }
        return this;
    }

    public VHBase text(
            @IdRes int id, @StringRes int res) {
        TextView v = this.v(id, TextView.class);
        if (
                v != null) {
            v.setText(res);
        }
        return this;
    }

    public VHBase text(
            @IdRes int id, Spanned spanned) {
        TextView v = this.v(id, TextView.class);
        if (
                v != null) {
            v.setText(spanned);
        }
        return this;
    }

    public VHBase textColor(
            @IdRes int id, @ColorInt int color) {
        TextView v = this.v(id, TextView.class);
        if (
                v != null) {
            v.setTextColor(color);
        }
        return this;
    }

    public VHBase caps(
            @IdRes int id, boolean caps) {
        TextView v = this.v(id, TextView.class);
        if (
                v != null) {
            v.setAllCaps(caps);
        }
        return this;
    }

    public VHBase visible(
            int value) {
        if (
                this.v != null) {
            this.v.setVisibility(value);
        }
        return this;
    }

    public VHBase visible(
            @IdRes int id, int value) {
        View v = this.v(id);
        if (
                v != null) {
            v.setVisibility(value);
        }
        return this;
    }

    public VHBase enable(
            boolean value) {
        if (
                this.v != null) {
            this.v.setEnabled(value);
        }
        return this;
    }

    public VHBase enable(
            @IdRes int id, boolean value) {
        View v = this.v(id);
        if (
                v != null) {
            v.setEnabled(value);
        }
        return this;
    }

    public VHBase backgroundResource(
            int res) {
        if (
                this.v != null) {
            this.v.setBackgroundResource(res);
        }
        return this;
    }

    public VHBase backgroundResource(
            @IdRes int id, int res) {
        View v = this.v(id);
        if (
                v != null) {
            v.setBackgroundResource(res);
        }
        return this;
    }

    public VHBase src(
            @IdRes int id, @DrawableRes int res) {
        ImageView v = this.v(id, ImageView.class);
        if (
                v != null) {
            v.setImageResource(res);
        }
        return this;
    }

    public <ADAPTER extends BaseAdapter> List.RV rv(
            @IdRes int id, boolean fixed, boolean nested, RecyclerView.LayoutManager manager, ADAPTER adapter) {
        List.RV v = v(
                id,
                List.RV.class
        );
        if (v != null) {
            return v.adapter(adapter).fixed(fixed).nestedScrollEnabled(nested).manager(manager);
        }
        return null;
    }

    public VHBase refresh(
            @IdRes int id, List.Refresh.Listener.Action action, @NonNull @ColorInt int... colors) {
        List.Refresh v = this.v(id, List.Refresh.class);
        if (
                v != null) {
            v.listener(new List.Refresh.Listener(action).refresh(v)).colors(colors);
        }
        return this;
    }

    public VHBase refresh(
            @IdRes int id, boolean refreshing, boolean enabled) {
        List.Refresh v = this.v(id, List.Refresh.class);
        if (
                v != null) {
            v.refreshing(refreshing).enabled(enabled);
        }
        return this;
    }

    public View v(
    ) {
        return
                this.v;
    }

    public View v(
            @IdRes int id) {
        if (this.v != null) {
            return this.v.findViewById(id);
        }
        return null;
    }

    public <T extends View> T v(
            @IdRes int id, Class<T> cls) {
        View v = this.v(id);
        if (
                v != null && cls != null && cls.isInstance(v)) {
            return cls.cast(v);
        }
        return null;
    }

    public <T> T and(T o) {
        return
                o;
    }

    /*----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     *
     *
     * messages
     *
     *
     * ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

    public VHBase snack(Messages.Snack.Type type, @StringRes int id) {
        return this.snack(
                type, this.v.getResources().getString(id));
    }

    public VHBase snack(Messages.Snack.Type type, String message) {
        return this.snack(
                type, message, Messages.Snack.Duration.SHORT);
    }

    public VHBase snack(Messages.Snack.Type type, @StringRes int id, Messages.Snack.Duration duration) {
        return this.snack(type, this.v.getResources().getString(id), duration);
    }

    public VHBase snack(Messages.Snack.Type type, String message, Messages.Snack.Duration duration) {
        Messages.Snack.snack(
                this.v,
                type,
                Utils.Strings.val(message),
                duration);

        return
                this;
    }

    /*----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     *
     *
     * extensions
     *
     *
     * ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    public static class List {

        public static class RV extends RecyclerView {

            public RV(@NonNull Context context) {
                super(context);
            }

            public RV(@NonNull Context context, @Nullable AttributeSet attrs) {
                super(context, attrs);
            }

            public RV(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
                super(context, attrs, defStyle);
            }

            public <ADAPTER extends BaseAdapter> RV adapter(
                    ADAPTER adapter) {
                this.setAdapter(adapter);
                return this;
            }

            public RV manager(
                    RecyclerView.LayoutManager manager) {
                this.setLayoutManager(manager);
                return this;
            }

            public RV nestedScrollEnabled(
                    boolean state) {
                this.setNestedScrollingEnabled(
                        state
                );
                return this;
            }

            public RV fixed(
                    boolean state) {
                this.setHasFixedSize(state);
                return this;
            }
        }

        public static class Refresh extends SwipeRefreshLayout {

            public Refresh(@NonNull Context context) {
                super(context);
            }

            public Refresh(@NonNull Context context, @Nullable AttributeSet attrs) {
                super(context, attrs);
            }

            public Refresh listener(Listener listener) {
                this.setOnRefreshListener(
                        listener
                );
                return this;
            }

            public Refresh colors(@NonNull @ColorInt int... colors) {
                this.setColorSchemeColors(
                        colors
                );
                return this;
            }

            public Refresh enabled(boolean state) {
                this.setEnabled(state);
                return this;
            }

            public Refresh refreshing(boolean state) {
                this.post(() -> this.setRefreshing(
                        state
                ));
                return this;
            }

            public static class Listener implements SwipeRefreshLayout.OnRefreshListener {

                private Refresh
                        refresh;

                private final Action
                        action;

                public Listener(
                        Action action
                ) {
                    this.action = action;
                }

                public Listener refresh(
                        Refresh refresh) {
                    this.refresh = refresh;
                    return this;
                }

                @Override
                public void onRefresh() {
                    if (this.action != null) {
                        this.action.action(this.refresh);
                    }
                }

                public interface Action {
                    void action(Refresh refresh);
                }
            }

        }
    }

    public static class Messages {

        public static class Snack {

            public enum Type {
                S(R.color.lib_g_70),
                E(R.color.lib_r_70),
                W(R.color.lib_o_70);
                @ColorRes
                int
                        color;

                Type(int color) {
                    this.color = color;
                }
            }

            public enum Duration {

                SHORT(Snackbar.LENGTH_SHORT), LONG(Snackbar.LENGTH_LONG), INDEFINITE(Snackbar.LENGTH_INDEFINITE);
                int id;

                Duration(int id) {
                    this.id = id;
                }

                public int getId() {
                    return id;
                }
            }

            public static void snack(View view, Type type, String message, Duration duration) {
                Snackbar snackbar = Snackbar.make(
                        view,
                        message,
                        duration.getId()
                );
                snackbar.getView().setBackgroundResource(
                        type.color
                );
                snackbar.show(

                );
            }

        }

    }


}
