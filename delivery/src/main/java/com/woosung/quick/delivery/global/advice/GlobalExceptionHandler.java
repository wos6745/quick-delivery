package com.woosung.quick.delivery.global.advice;

import com.woosung.quick.delivery.global.QuickDeliveryResponse;
import com.woosung.quick.delivery.common.Supports;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.woosung.quick.delivery.common.Supports.*;

@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(EntityNotFoundException.class)
    protected QuickDeliveryResponse handleEntityNotFoundException(EntityNotFoundException e) {
        return QuickDeliveryResponse.builder()
                .code(ResultCode.ENTITY_NOT_FOUND.getCode())
                .message(ResultCode.ENTITY_NOT_FOUND.getInfoMessage())
                .build();
    }

    @ExceptionHandler(Exception.class)
    protected QuickDeliveryResponse handleException(Exception e) {

        return QuickDeliveryResponse.builder()
                .code(ResultCode.INTERNAL_SERVER_ERROR.getCode())
                .message(ResultCode.INTERNAL_SERVER_ERROR.getInfoMessage())
                .build();
    }
}
