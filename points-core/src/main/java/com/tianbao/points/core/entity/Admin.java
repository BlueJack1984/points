package com.tianbao.points.core.entity;

public class Admin {
    private Short id;

    private String username;

    private String password;

    private String superpw;

    private String nickname;

    private Boolean question;

    private String answer;

    private Boolean levelname;

    private String checkadmin;

    private String loginip;

    private Integer logintime;

    private String phone;

    private String email;

    private String zw;

    private Integer orderid;

    private String userid;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSuperpw() {
        return superpw;
    }

    public void setSuperpw(String superpw) {
        this.superpw = superpw == null ? null : superpw.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Boolean getQuestion() {
        return question;
    }

    public void setQuestion(Boolean question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Boolean getLevelname() {
        return levelname;
    }

    public void setLevelname(Boolean levelname) {
        this.levelname = levelname;
    }

    public String getCheckadmin() {
        return checkadmin;
    }

    public void setCheckadmin(String checkadmin) {
        this.checkadmin = checkadmin == null ? null : checkadmin.trim();
    }

    public String getLoginip() {
        return loginip;
    }

    public void setLoginip(String loginip) {
        this.loginip = loginip == null ? null : loginip.trim();
    }

    public Integer getLogintime() {
        return logintime;
    }

    public void setLogintime(Integer logintime) {
        this.logintime = logintime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getZw() {
        return zw;
    }

    public void setZw(String zw) {
        this.zw = zw == null ? null : zw.trim();
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }
}