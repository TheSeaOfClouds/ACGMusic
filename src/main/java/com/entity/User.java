package com.entity;

import java.sql.Timestamp;
import java.util.List;

public class User {

    private Integer uid;//用户id
    private String email;//邮箱
    private String nickname;//昵称
    private String password;//密码
    private Timestamp registerTime;//注册时间
    private String describe;//个人简介
    private String headImage;//头像

    private List<BombRecord> bombRecords;

    public User() {
    }

    public User(Integer uid) {
        this.uid = uid;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(Integer uid, String password) {
        this.uid = uid;
        this.password = password;
    }

    public User(String email, String nickname, String password) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }

    public User(Integer uid, String nickname, String describe) {
        this.uid = uid;
        this.nickname = nickname;
        this.describe = describe;
    }

    public User(Integer uid, String email, String nickname, String password, Timestamp registerTime, String describe, String headImage) {
        this.uid = uid;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.registerTime = registerTime;
        this.describe = describe;
        this.headImage = headImage;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public List<BombRecord> getBombRecords() {
        return bombRecords;
    }

    public void setBombRecords(List<BombRecord> bombRecords) {
        this.bombRecords = bombRecords;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", registerTime=" + registerTime +
                ", describe='" + describe + '\'' +
                ", headImage='" + headImage + '\'' +
                ", bombRecords=" + bombRecords +
                '}';
    }
}
