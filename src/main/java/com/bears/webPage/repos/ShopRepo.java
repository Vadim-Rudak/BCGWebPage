package com.bears.webPage.repos;

import com.bears.webPage.domain.shop.ShopEnt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepo extends JpaRepository<ShopEnt,Integer> {
    ShopEnt findByItemid(String item_id);
}
