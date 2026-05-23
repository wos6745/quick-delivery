package com.woosung.quick.delivery.global;

import lombok.Getter;

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

    enum OrderStatus {
        PENDING(100),
        CANCELED(101),
        ACCEPTED(102),
        DELIVERING(200),
        DELIVERED(201);

        @Getter
        private final int status;

        OrderStatus(int status) {
            this.status = status;
        }
    }
}
