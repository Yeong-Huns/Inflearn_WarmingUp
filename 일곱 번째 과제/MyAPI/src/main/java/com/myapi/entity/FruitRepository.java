package com.myapi.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FruitRepository extends JpaRepository<FruitInfoEntity, Long> {

    Optional<FruitInfoEntity> findByIdAndSoldOutFalse(long id);
    List<FruitInfoEntity> findAllByName(String name);
    long countBySoldOutTrueAndName(String name);
    List<FruitInfoEntity> findAllByPriceGreaterThanEqual(long price);
    List<FruitInfoEntity> findAllByPriceLessThanEqual(long price);
}
