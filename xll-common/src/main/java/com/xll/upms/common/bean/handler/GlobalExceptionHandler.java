package com.xll.upms.common.bean.handler;

/**
 * @author lengleng
 * @date 2018/5/24
 */

import com.xll.upms.common.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author 徐亮亮
 * @Description： 全局的的异常拦截器
 * @Date 2019/1/18 20:37
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 全局异常.
     *
     * @param e the e
     * @return R
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public R exception(Exception e) {
        log.info("保存全局异常信息 ex={}", e.getMessage(), e);
        return new R<>(e);
    }
}
