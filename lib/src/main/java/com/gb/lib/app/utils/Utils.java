package com.gb.lib.app.utils;

import java.util.ArrayList;

public class Utils {

    public static class Strings {

        public static final String EMPTY = "";

        public static String val(
                String str) {
            return val(str, EMPTY);
        }

        public static String val(
                String str, String def) {
            return
                    str == null ? (def == null ? EMPTY : def) : str;
        }

        public static boolean empty(
                String string) {
            return (string == null || string.length() == 0);
        }

        public static boolean notEmpty(
                String string) {
            return (string != null && string.length() > 0);
        }
    }

    public static class Lists {
        public static <T> java.util.List<T> safe(java.util.List<T> other) {
            return
                    other == null ? new ArrayList<>() : other;
        }
    }

}
