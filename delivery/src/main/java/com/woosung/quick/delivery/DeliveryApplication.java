package com.woosung.quick.delivery;

import com.woosung.quick.delivery.entity.StoreEntity;
import com.woosung.quick.delivery.entity.StoreMenuEntity;
import com.woosung.quick.delivery.repository.jpa.StoreMenuJpaRepository;
import com.woosung.quick.delivery.repository.jpa.StoreJpaRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.TimeZone;

@SpringBootApplication
public class DeliveryApplication {
    @Bean
    ApplicationRunner onStart(StoreJpaRepository storeJpaRepository, StoreMenuJpaRepository storeJpaMenuRepository) {
        return args -> {
            TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

            StoreEntity chicken = StoreEntity.of("치킨집", "서울시 중구 신당동", "02-2265-1124", "치킨 맛있게 파는 곳입니다", 3000L);
            StoreEntity jokbal = StoreEntity.of("족발집", "서울시 종로구 창신동", "02-2215-1355", "족발 맛있게 파는 곳입니다", 2000L);

            storeJpaRepository.save(chicken);
            storeJpaRepository.save(jokbal);

            storeJpaMenuRepository.save(StoreMenuEntity.of(chicken, "후라이드 치킨", 15000L));
            storeJpaMenuRepository.save(StoreMenuEntity.of(chicken, "양념 치킨", 16000L));
            storeJpaMenuRepository.save(StoreMenuEntity.of(chicken, "간장 치킨", 17000L));

            storeJpaMenuRepository.save(StoreMenuEntity.of(jokbal, "족발(소)", 30000L));
            storeJpaMenuRepository.save(StoreMenuEntity.of(jokbal, "족발(중)", 35000L));
            storeJpaMenuRepository.save(StoreMenuEntity.of(jokbal, "족발(대)", 40000L));
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(DeliveryApplication.class, args);
    }
}
