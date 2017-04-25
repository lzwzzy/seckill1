package com.seckill.exception;

/**
 * 重复秒杀异常(运行时异常)
 * Created by lzw on 2017/4/18.
 */
public class RepeatKillException extends SeckillException {
    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}