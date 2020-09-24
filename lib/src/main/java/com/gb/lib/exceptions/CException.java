package com.gb.lib.exceptions;

public class CException extends Exception {

    public static class Error {

        private int
                code;
        private String
                message;
        private Type
                type;

        public Error(
                int code, String message, Type type) {
            this.code = code;
            this.message = message;
            this.type = type;
        }

        public enum Type {
            E, W
        }

        public int getCode() {
            return this.code;
        }

        public String getMessage() {
            return
                    this.message;
        }

        public Type getType() {
            return this.type;
        }
    }

    public CException(Error error) {
        super(
                error.message);
    }
}