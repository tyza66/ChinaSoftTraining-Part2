package com.icss.test.exception;

/**
 * 自定义异常 继承Exception
 */
public class MyException extends Exception{

    public MyException(String message) {
        super(message);
    }
}
