package com.power.test01;

/**
 * @author 崔帅
 * @version 1.0
 */
public class OutOfTheRangeException extends RuntimeException {
    public OutOfTheRangeException() {
    }

    public OutOfTheRangeException(String message) {
        super(message);
    }

    public OutOfTheRangeException(String message, Throwable cause) {
        super(message, cause);
    }
}
