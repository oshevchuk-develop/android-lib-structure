package com.gb.lib.api.connection.manager;

import com.gb.lib.api.connection.Post;
import com.gb.lib.api.connection.client.ApiClient;
import com.gb.lib.app.App;
import com.gb.lib.exceptions.CException;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;

import io.resourcepool.jarpic.client.HttpJsonRpcClient;
import io.resourcepool.jarpic.model.JsonRpcRequest;
import io.resourcepool.jarpic.model.JsonRpcResponse;

public class ApiManager {

    public static class JSONRPC2<D extends JSONRPC2.Result> {

        private String
                url;

        private JsonRpcRequest.Builder
                builder;

        public JSONRPC2() {
            this.builder = JsonRpcRequest.builder();
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
                JsonRpcResponse<D> response = new HttpJsonRpcClient(this.url, ApiClient.getInstance(application)).send(builder.build(), (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
                if (
                        response.getError() != null) {
                    return new Post.Response<>(new CException.Error(response.getError().getCode(), response.getError().getMessage(), CException.Error.Type.E));
                }
                return new Post.Response<>(response.getResult());
            } catch (IOException e) {
                return new Post.Response<>(new CException.Error(1, e.getMessage(), CException.Error.Type.E));
            }
        }

        public static class Result {

        }

    }

    public static class JSONREST {

    }


}
