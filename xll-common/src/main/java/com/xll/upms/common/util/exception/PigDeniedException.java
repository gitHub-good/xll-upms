package com.xll.upms.common.util.exception;

/**
 * @Author 徐亮亮
 * @Description： 403 授权拒绝
 * @Date 2019/1/18 20:53
 */
public class PigDeniedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PigDeniedException() {
    }

    public PigDeniedException(String message) {
        super(message);
    }

    public PigDeniedException(Throwable cause) {
        super(cause);
    }

    public PigDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public PigDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
