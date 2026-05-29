package com.woosung.quick.delivery.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public interface Supports {
    enum ResultCode {

        SUCCESS(20000, "성공"),
        INTERNAL_SERVER_ERROR(50000, "알 수 없는 서버 에러");

        @Getter
        private final int code;
        @Getter
        private final String infoMessage;

        ResultCode(int code, String infoMessage) {
            this.code = code;
            this.infoMessage = infoMessage;
        }
    }


    @RequiredArgsConstructor
    enum ErrorCode {

        ENTITY_NOT_FOUND(10000, "요청 하신 엔티티가 존재 하지 않습니다."),
        NOT_ENOUGH_BALANCE(10100, "잔액이 충분하지 않습니다."),
        INVALID_TOTAL_POINTS(10200, "총 금액이 메뉴 금액의 합과 일치 하지 않습니다.");


        @Getter
        private final int code;
        @Getter
        private final String infoMessage;
    }

    enum OrderStatus {
        PENDING(100),
        CANCELED_STORE(200),
        CANCELED_CUSTOMER(201),
        ACCEPTED(300),
        DELIVERING(400),
        DELIVERED(500);

        @Getter
        private final int status;

        OrderStatus(int status) {
            this.status = status;
        }
    }
}
