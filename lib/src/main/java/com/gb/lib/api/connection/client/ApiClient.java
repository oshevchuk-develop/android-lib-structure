package com.gb.lib.api.connection.client;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.gb.lib.app.App;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

public class ApiClient {

    private static int
            cTTL = 15,
            rTTL = 15,
            wTTL = 15;

    private static volatile OkHttpClient
            instance;

    public static void cTTL(
            int cTTL) {
        ApiClient.cTTL = cTTL;
    }

    public static void trTTL(
            int rTTL) {
        ApiClient.rTTL = rTTL;
    }

    public static void wTTL(
            int wTTL) {
        ApiClient.wTTL = wTTL;
    }

    public static <APP extends App> OkHttpClient getInstance(APP application) {

        if (instance == null)
            synchronized (OkHttpClient.class) {
                if (instance == null) {
                    instance = new OkHttpClient.Builder().connectTimeout(ApiClient.cTTL, TimeUnit.SECONDS).readTimeout(ApiClient.rTTL, TimeUnit.SECONDS).writeTimeout(ApiClient.wTTL, TimeUnit.SECONDS).cookieJar(new CookieStore(application)).build();
                }
            }
        return instance;
    }

    public static class CookieStore implements CookieJar {

        private final SharedPreferences store;

        private final Gson gson;

        public CookieStore(Context context) {
            this
                    .store = context.getSharedPreferences(context.getPackageName() + ".cookies.store", Context.MODE_PRIVATE);
            this
                    .gson = new Gson();
        }

        @Override
        synchronized public void saveFromResponse(@NonNull HttpUrl url, @NonNull List<Cookie> cookies) {
            boolean clear = this
                    .store.edit().clear().commit();

            for (Cookie cookie : cookies) {
                boolean res = this
                        .store.edit().putString(this.key(cookie), this.gson.toJson(cookie)).commit();
            }
        }

        @Override
        synchronized public List<Cookie> loadForRequest(@NonNull HttpUrl url) {
            List<Cookie> cookies = new ArrayList<>();
            for (Map.Entry<String, ?> item : this.store.getAll().entrySet()) {
                cookies
                        .add(this.gson.fromJson((String) item.getValue(), Cookie.class));
            }
            return cookies;
        }

        private String key(Cookie cookie) {
            return (cookie.secure() ? "https" : "http") + "://" + cookie.domain() + "|" + cookie.name();
        }
    }

}
