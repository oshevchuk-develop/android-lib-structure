package com.gb.lib.app;

import android.app.Application;
import android.content.SharedPreferences;

import com.gb.lib.app.i.IACallBack;

public class App extends Application implements IACallBack {

    public static final String TAG = "tAg1715";

    protected transient SharedPreferences
            preferences;

    @Override
    public void onCreate() {
        super
                .onCreate();
        this.preferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(this);

        this.created();
    }

    @Override
    public void created() {

    }

    /*-------------------------------------------------------------------------------*/

    public App put(
            String key, String value) {
        this.preferences.edit()
                .putString(key, value)
                .apply();
        return this;
    }

    public App put(
            String key, Integer value) {
        this.preferences.edit()
                .putInt(key, value)
                .apply();
        return this;
    }

    public App put(
            String key, Long value) {
        this.preferences.edit()
                .putLong(key, value)
                .apply();
        return this;
    }
}
