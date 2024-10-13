package com.bears.webPage.repos;

import com.bears.webPage.domain.shop.ShopEnt;
import com.bears.webPage.domain.shop.UserBuyEnt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBuyEntRepo extends JpaRepository<UserBuyEnt,Integer> {

}
