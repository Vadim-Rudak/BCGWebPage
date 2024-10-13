package com.bears.webPage.domain.shop;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "shop")
public class ShopEnt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    private String itemid;
    private String photourl;
    private String title;
    private int price;
    private int discount;
    private int expiration;

}
