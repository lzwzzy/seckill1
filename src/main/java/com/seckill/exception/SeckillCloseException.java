package com.seckill.exception;

/**
 * 秒杀关闭异常
 * Created by lzw on 2017/4/18.
 */
public class SeckillCloseException extends SeckillException {
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
