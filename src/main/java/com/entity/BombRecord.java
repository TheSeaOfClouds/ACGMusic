package com.entity;

import java.sql.Timestamp;

public class BombRecord {

    private Integer recordId;//积分记录id
    private Integer uid;//用户id
    private Integer anotherUid;//打赏者id
    private Integer bombNum;//积分数
    private String bombHistory;//积分记录
    private Timestamp bombTime;//记录时间

    public BombRecord() {
    }

    public BombRecord(Integer uid, String bombHistory) {
        this.uid = uid;
        this.bombHistory = bombHistory;
    }

    public BombRecord(Integer uid, Integer anotherUid, String bombHistory) {
        this.uid = uid;
        this.anotherUid = anotherUid;
        this.bombHistory = bombHistory;
    }

    public BombRecord(Integer uid, Integer anotherUid, Integer bombNum, String bombHistory) {
        this.uid = uid;
        this.anotherUid=anotherUid;
        this.bombNum = bombNum;
        this.bombHistory = bombHistory;
    }

    public BombRecord(Integer recordId, Integer uid, Integer anotherUid, Integer bombNum, String bombHistory, Timestamp bombTime) {
        this.recordId = recordId;
        this.uid = uid;
        this.anotherUid=anotherUid;
        this.bombNum = bombNum;
        this.bombHistory = bombHistory;
        this.bombTime=bombTime;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getAnotherUid() {
        return anotherUid;
    }

    public void setAnotherUid(Integer anotherUid) {
        this.anotherUid = anotherUid;
    }

    public Integer getBombNum() {
        return bombNum;
    }

    public void setBombNum(Integer bombNum) {
        this.bombNum = bombNum;
    }

    public String getBombHistory() {
        return bombHistory;
    }

    public void setBombHistory(String bombHistory) {
        this.bombHistory = bombHistory;
    }

    public Timestamp getBombTime() {
        return bombTime;
    }

    public void setBombTime(Timestamp bombTime) {
        this.bombTime = bombTime;
    }

    @Override
    public String toString() {
        return "BombRecord{" +
                "recordId=" + recordId +
                ", uid=" + uid +
                ", anotherUid=" + anotherUid +
                ", bombNum=" + bombNum +
                ", bombHistory='" + bombHistory + '\'' +
                ", bombTime=" + bombTime +
                '}';
    }
}
