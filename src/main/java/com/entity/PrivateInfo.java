package com.entity;

import java.sql.Timestamp;

public class PrivateInfo {

    private Integer privateId;//私信id
    private Integer uid;//发送者id
    private Integer anotherUid;//接收者id
    private String letterContent;//私信内容
    private Integer state;//查看状态
    private Timestamp msgTime;//发送时间

    public PrivateInfo() {
    }

    public PrivateInfo(Integer uid, Integer anotherUid, String letterContent) {
        this.uid = uid;
        this.anotherUid = anotherUid;
        this.letterContent = letterContent;
    }

    public PrivateInfo(Integer privateId, Integer uid, Integer anotherUid, String letterContent,Integer state,Timestamp msgTime) {
        this.privateId = privateId;
        this.uid = uid;
        this.anotherUid = anotherUid;
        this.letterContent = letterContent;
        this.state=state;
        this.msgTime=msgTime;
    }

    public Integer getPrivateId() {
        return privateId;
    }

    public void setPrivateId(Integer privateId) {
        this.privateId = privateId;
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

    public String getLetterContent() {
        return letterContent;
    }

    public void setLetterContent(String letterContent) {
        this.letterContent = letterContent;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Timestamp getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(Timestamp msgTime) {
        this.msgTime = msgTime;
    }

    @Override
    public String toString() {
        return "PrivateInfo{" +
                "privateId=" + privateId +
                ", uid=" + uid +
                ", anotherUid=" + anotherUid +
                ", letterContent='" + letterContent + '\'' +
                ", state=" + state +
                ", msgTime=" + msgTime +
                '}';
    }
}
