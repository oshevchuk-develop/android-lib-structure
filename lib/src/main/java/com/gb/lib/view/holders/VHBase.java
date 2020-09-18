package com.gb.lib.view.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.StringRes;

import com.gb.lib.app.utils.Utils;

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
            @IdRes int id, int value) {
        View v = this.v(id);
        if (
                v != null) {
            v.setVisibility(value);
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
}
