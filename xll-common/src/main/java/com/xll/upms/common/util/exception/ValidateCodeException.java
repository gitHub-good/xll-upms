package com.xll.upms.common.util.exception;

/**
 * @Author 徐亮亮
 * @Description：验证码异常
 * @Date 2019/1/18 20:54
 */
public class ValidateCodeException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = -7285211528095468156L;

    public ValidateCodeException(String msg) {
        super(msg);
    }

}
