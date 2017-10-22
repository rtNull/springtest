package com.zyq.springtest.exception;

/**
 * Created by williamjing on 2017/2/23.
 */
public class UserRegistedException extends InfoErrorException {
    public UserRegistedException(String message) {
        super(message);
    }

    public UserRegistedException(String message, Throwable cause) {
        super(message, cause);
    }
}
