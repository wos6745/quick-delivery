package com.woosung.quick.delivery.common;

import lombok.Getter;

public interface Supports {
    enum ResultCode {

        SUCCESS(20000, "성공"),
        INTERNAL_SERVER_ERROR(50000, "알 수 없는 서버 에러"),
        ENTITY_NOT_FOUND(50001, "요청 하신 엔티티가 존재 하지 않습니다.");

        @Getter
        private final int code;
        @Getter
        private final String infoMessage;

        ResultCode(int code, String infoMessage) {
            this.code = code;
            this.infoMessage = infoMessage;
        }
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
