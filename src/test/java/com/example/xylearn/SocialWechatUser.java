package com.example.xylearn;

import java.util.Objects;

public class SocialWechatUser {
    private Long id;
    private Long qwxid;
    private String nickName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocialWechatUser that = (SocialWechatUser) o;
        return  Objects.equals(qwxid, that.qwxid) && Objects.equals(nickName, that.nickName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, qwxid, nickName);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQwxid() {
        return qwxid;
    }

    public void setQwxid(Long qwxid) {
        this.qwxid = qwxid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
