package com.bears.webPage.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "games_impotant_info")
public class Games_impotant_info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    private int gameid;
    private String lang;
    private String namegame;
    private Boolean useinapple;
    private Boolean useinandroid;
    private Boolean useinwindows;
    private Boolean useinwebgl;
    private String genre;
    private String moreinfo;
    private String img;
    private String imgbg;
}
