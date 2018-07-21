package com.x3800.consumer.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.x3800.consumer.serializer.JsonDateTimeSerializer;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "consumer")
public class Consumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    // 소비자명(아이디)
    @Column(length = 50, unique = true, nullable = false)
    private String consumer_name;

    // 소비자명
    @Column(length = 100, nullable = false)
    private String name;

    // 이메일
    @Column(length = 255)
    private String email;

    // 전화번호
    @Column(length = 255)
    private String telephone;

    // 등록일시
    @Column
    private Date regist_datetime;

    @Transient
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConsumer_name() {
        return consumer_name;
    }

    public void setConsumer_name(String consumer_name) {
        this.consumer_name = consumer_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @JsonSerialize(using = JsonDateTimeSerializer.class)
    public Date getRegist_datetime() {
        return regist_datetime;
    }

    public void setRegist_datetime(Date regist_datetime) {
        this.regist_datetime = regist_datetime;
    }


    @PrePersist // Auto created date when it's created
    public void prePersist() {
        regist_datetime = new Date();
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "id=" + id +
                ", consumer_name='" + consumer_name + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", regist_datetime=" + regist_datetime +
                '}';
    }
}
