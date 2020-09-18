package com.gb.lib.view.holders;

import android.view.View;

import androidx.annotation.IdRes;

public class VHBase {

    private View
            v;

    public VHBase(
            View v) {
        this.v = v;
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

    public VHBase click(
            View.OnClickListener l) {
        if (this.v != null) {
            this.v.setOnClickListener(l);
        }
        return this;
    }

    private View v(
            @IdRes int id) {
        if (this.v != null) {
            return this.v.findViewById(id);
        }
        return null;
    }
}
