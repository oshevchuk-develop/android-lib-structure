package com.gb.lib.api.connection;

import android.os.AsyncTask;

import com.gb.lib.exceptions.CException;

public class Post<D> extends AsyncTask<Void, Void, Post.Response<D>> {

    private IDo<D>
            f;

    private IBefore
            before;

    private ISuccess<D>
            success;

    private IError
            error;

    private IAlways<D>
            always;

    public Post(IDo f) {
        this.f = f;
    }

    public Post<D> before(IBefore l) {
        this.before = l;
        return
                this;
    }

    public Post<D> success(ISuccess<D> l) {
        this.success = l;
        return
                this;
    }

    public Post<D> error(IError l) {
        this.error = l;
        return
                this;
    }

    public Post<D> always(IAlways<D> l) {
        this.always = l;
        return
                this;
    }

    @Override
    protected void onPreExecute(

    ) {
        if (this.before != null) {
            this.before.result();
        }
    }

    @Override
    protected Response<D> doInBackground(Void... voids) {
        return
                this.f.get();
    }

    @Override
    protected void onPostExecute(Post.Response<D> response) {
        switch (
                response.status) {
            case S:
                if (this.success != null) {
                    this.success.result(response.data);
                }
            case E:
                if (this.error != null) {
                    this.error.result(response.error);
                }
        }
        if (this.always != null) {
            this
                    .always.result(response);
        }
    }

    public interface IDo<D> {
        Response<D> get(

        );
    }

    public interface IBefore {
        void result(

        );
    }

    public interface ISuccess<D> {
        void result(
                D data);
    }

    public interface IError {
        void result(
                CException.Error error);
    }

    public interface IAlways<D> {
        void result(
                Post.Response<D> response);
    }

    public static class Response<D> {

        public enum Status {
            S,
            E
        }

        public Status status;

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

        @Override
        public String toString() {
            return "Response{" +
                    "status=" + status +
                    ", data=" + data +
                    ", error=" + error +
                    '}';
        }
    }
}
