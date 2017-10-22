package com.zyq.springtest.exception;

/**
 * Created by williamjing on 2017/2/23.
 */
public class LoginFailException extends InfoErrorException {
    public LoginFailException(String message) {
        super(message);
    }

    public LoginFailException(String message, Throwable cause) {
        super(message, cause);
    }
}
