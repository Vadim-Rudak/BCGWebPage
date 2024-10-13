package com.bears.webPage.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "game_page_info")
public class Game_page_info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    private String lang;
    private int gameid;
    private String genre;
    private String namegame;
    private String moreinfo1;
    private String imgbg;
    private String hrefapple;
    private String hrefandroid;
    private String hrefsteam;
    private String hrefvk;
    private String hrefyn;
    private String hrefok;
    private String hrefvideo;
    private String moreinfo2;

}
