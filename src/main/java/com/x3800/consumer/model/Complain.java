package com.x3800.consumer.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 *  소비자 불만 접수 내역
 */
@Entity
@Table(name = "complain")
public class Complain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    // 등록일시
    @Column
    private Date regist_datetime;

    // 타이틀
    @Column(length = 200, nullable = false)
    private String title;

    // 내용
    @Column(length = 8000)
    private String description;


    @Transient
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");


}
