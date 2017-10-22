package com.zyq.springtest.exception;

/**
 * Created by williamjing on 2017/2/23.
 */
public class InfoErrorException extends RuntimeException {
    public InfoErrorException(String message) {
        super(message);
    }

    public InfoErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
