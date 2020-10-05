package com.gb.lib.api.connection.manager;

import androidx.annotation.NonNull;

import com.gb.lib.api.connection.Post;
import com.gb.lib.api.connection.client.ApiClient;
import com.gb.lib.app.App;
import com.gb.lib.app.utils.Utils;
import com.gb.lib.exceptions.CException;

import java.io.IOException;

import io.resourcepool.jarpic.client.HttpJsonRpcClient;
import io.resourcepool.jarpic.model.JsonRpcRequest;
import io.resourcepool.jarpic.model.JsonRpcResponse;
import okhttp3.Request;
import okhttp3.Response;

public class ApiManager {

    public static class JSONRPC2<D extends JSONRPC2.Result> {

        private final Class<D>
                type;

        private String
                url;

        private JsonRpcRequest.Builder
                builder;

        public JSONRPC2(
                Class<D> type) {
            this.type = type;
            this
                    .builder = JsonRpcRequest.builder();
        }

        public JSONRPC2 url(String url) {
            this.url = url;
            return
                    this;
        }

        public JSONRPC2 function(String function) {
            this
                    .builder.method(function);
            return this;
        }

        public JSONRPC2 param(String key, String value) {
            this
                    .builder.param(key, value);
            return this;
        }

        public <APP extends App> Post.Response<D> run(APP application) {

            try {
                JsonRpcResponse<D> response = new HttpJsonRpcClient(this.url, ApiClient.getInstance(application)).send(this.builder.build(), this.type);
                if (
                        response.getError() != null) {
                    return new Post.Response<>(
                            new CException.Error(response.getError().getCode(), response.getError().getMessage(), CException.Error.Type.E)
                    );
                } else {
                    return new Post.Response<>(
                            response
                                    .getResult()
                    );
                }

            } catch (IOException e) {
                return new Post.Response<>(
                        new CException.Error(1, e.getMessage(), CException.Error.Type.E)
                );
            }
        }

        public static class Result {

        }

    }

    public static abstract class JSONREST<D> {

        private Class<D>
                data;

        private JSONREST(

        ) {

        }

        public JSONREST(
                Class<D> data) {
            this();
            this.data = data;
        }

        public <APP extends App> Post.Response<D> run(APP application, @NonNull Request request) {
            try {
                Response response = ApiClient.getInstance(
                        application
                ).newCall(request).execute(

                );
                return this.response(
                        response.isSuccessful(),
                        response.code(),
                        response.body() != null ? response.body().string() : Utils.Strings.EMPTY);
            } catch (IOException e) {
                return new Post.Response<>(
                        new CException.Error(-1, e.getMessage(), CException.Error.Type.E)
                );
            }
        }

        public abstract Post.Response<D> response(boolean success, int code, @NonNull String data);
    }
}
