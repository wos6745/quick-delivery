package com.woosung.quick.delivery.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseInitConfig {
    private final JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        jdbcTemplate.execute("CREATE SEQUENCE IF NOT EXISTS SEQ_ORDER_BUSINESS_ID START WITH 1000000000000 INCREMENT BY 1");
        jdbcTemplate.execute("CREATE SEQUENCE IF NOT EXISTS SEQ_ORDER_STORE_BUSINESS_ID START WITH 2000000000000 INCREMENT BY 1");
        jdbcTemplate.execute("CREATE SEQUENCE IF NOT EXISTS SEQ_ORDER_ITEM_BUSINESS_ID START WITH 3000000000000 INCREMENT BY 1");
    }
}
