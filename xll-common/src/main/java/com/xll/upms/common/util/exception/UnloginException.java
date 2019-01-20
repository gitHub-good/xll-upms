package com.xll.upms.common.util.exception;

/**
 * @Author 徐亮亮
 * @Description：  登录失败异常
 * @Date 2019/1/18 20:53
 */
public class UnloginException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnloginException() {
    }

    public UnloginException(String message) {
        super(message);
    }

    public UnloginException(Throwable cause) {
        super(cause);
    }

    public UnloginException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnloginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
