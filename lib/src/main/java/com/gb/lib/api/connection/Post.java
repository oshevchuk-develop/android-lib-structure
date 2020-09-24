package com.gb.lib.api.connection;

import android.os.AsyncTask;

import com.gb.lib.exceptions.CException;

public class Post<D> extends AsyncTask<Void, Void, Post.Response<D>> {

    private IDo f;

    public Post(IDo f) {
        this.f = f;
    }

    @Override
    protected Response<D> doInBackground(Void... voids) {
        return
                this.f.get();
    }

    public interface IDo<D> {
        Response<D> get(

        );
    }

    public interface ISuccess<D> {
        void result(
                D data);
    }

    public interface IError {
        void result(
                CException e);
    }

    public static class Response<D> {

        public enum Status {
            S,
            E
        }

        public Status status = Status.E;

        public D data;

        public CException.Error error;

        private Response(
                Status status) {
            this.status = status;
        }

        public Response(D data) {
            this(Status.S);
            this
                    .data = data;
        }

        public Response(CException.Error error) {
            this(Status.E);
            this
                    .error = error;
        }
    }
}
