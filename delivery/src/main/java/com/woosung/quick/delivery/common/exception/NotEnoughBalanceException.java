package com.woosung.quick.delivery.common.exception;

import com.woosung.quick.delivery.common.Supports;
import com.woosung.quick.delivery.common.Supports.ErrorCode;
import lombok.Getter;

@Getter
public class NotEnoughBalanceException extends RuntimeException {
    private final String message;
    private final int code;

    public NotEnoughBalanceException(ErrorCode errorCode) {
        this.message = errorCode.getInfoMessage();
        this.code = errorCode.getCode();
    }
}
