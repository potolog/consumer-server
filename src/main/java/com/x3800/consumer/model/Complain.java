package com.x3800.consumer.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.x3800.consumer.serializer.JsonDateTimeSerializer;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonSerialize(using = JsonDateTimeSerializer.class)
    public Date getRegist_datetime() {
        return regist_datetime;
    }

    public void setRegist_datetime(Date regist_datetime) {
        this.regist_datetime = regist_datetime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Complain{" +
                "id=" + id +
                ", regist_datetime=" + regist_datetime +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
