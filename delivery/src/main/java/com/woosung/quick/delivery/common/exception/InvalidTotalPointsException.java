package com.woosung.quick.delivery.common.exception;

import com.woosung.quick.delivery.common.Supports;
import com.woosung.quick.delivery.common.Supports.ErrorCode;
import lombok.Getter;

@Getter
public class InvalidTotalPointsException extends RuntimeException {
    private final String message;
    private final int code;

    public InvalidTotalPointsException(ErrorCode errorCode) {
        this.message = errorCode.getInfoMessage();
        this.code = errorCode.getCode();
    }
}
