package com.ruoyi.common.exception.ding;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.controller.ding.exception
 * @ClassName: IllegalOperationException
 * @Author: guohailong
 * @Description: 浙政钉 - 非法操作异常
 * @Date: 2021/3/14 15:38
 * @Version: 1.0
 */
public class IllegalOperationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    protected final String message;

    public IllegalOperationException(String message) {
        this.message = message;
    }

    public IllegalOperationException(String message, Throwable e) {
        super(message, e);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
