package com.tec.anji.exception;

/**
 * @author Administrator
 */
public class UserNotExistException extends RuntimeException {

    public UserNotExistException() {
        super("用户不存在");
    }
}
