package com.woosung.quick.delivery.entity;

import com.woosung.quick.delivery.entity.base.JpaBaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "Store")
@Getter
@SuperBuilder
public class StoreEntity extends JpaBaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String storeName;
    private String storeAddress;
    private String storePhoneNumber;
    private String storeDescription;
    private Long deliveryFee;

    @OneToMany(mappedBy = "store")
    private List<StoreMenuEntity> storyMenuList = new ArrayList<>();
}
