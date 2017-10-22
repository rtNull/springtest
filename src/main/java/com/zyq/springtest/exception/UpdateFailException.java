package com.zyq.springtest.exception;

/**
 * Created by williamjing on 2017/2/23.
 */
public class UpdateFailException extends InfoErrorException {
    public UpdateFailException(String message) {
        super(message);
    }

    public UpdateFailException(String message, Throwable cause) {
        super(message, cause);
    }
}
