package com.bears.webPage.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Blocks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    private int idgame;
    private String lang;
    private Boolean useblock1;
    private Boolean useblock2;
    private Boolean useblock3;

    private String img1;
    private String img2;
    private String img3;
    private String titel1;
    private String titel2;
    private String titel3;
    private String moreinfo1;
    private String moreinfo2;
    private String moreinfo3;
}
