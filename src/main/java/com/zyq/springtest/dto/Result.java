package com.zyq.springtest.dto;

/**
 * Created by zhanyq on 2017/3/30.
 */
public class Result<T> {
    private boolean success;

    private T data;

    private Integer resultCode;

    public Result(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public Result(boolean success, Integer resultCode) {
        this.success = success;
        this.resultCode = resultCode;
    }

    public Result(boolean success, T data, Integer resultCode) {
        this.success = success;
        this.data = data;
        this.resultCode = resultCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", data=" + data +
                ", resultCode=" + resultCode +
                '}';
    }
}
