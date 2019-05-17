package com.sss.model;

public class UserDetail {
    private Integer id;

    private Integer userId;

    private String realname;

    private String sex;

    private String school;

    private String grade;

    private Float gpa;

    private String dreamregion;

    private String dreamschool;

    private String phone;

    private Integer qq;

    private Integer gre;

    private Integer tofel;

    private Float ielts;

    private Integer act;

    private Integer gmat;

    private String degree;

    private String profession;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public Float getGpa() {
        return gpa;
    }

    public void setGpa(Float gpa) {
        this.gpa = gpa;
    }

    public String getDreamregion() {
        return dreamregion;
    }

    public void setDreamregion(String dreamregion) {
        this.dreamregion = dreamregion == null ? null : dreamregion.trim();
    }

    public String getDreamschool() {
        return dreamschool;
    }

    public void setDreamschool(String dreamschool) {
        this.dreamschool = dreamschool == null ? null : dreamschool.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getQq() {
        return qq;
    }

    public void setQq(Integer qq) {
        this.qq = qq;
    }

    public Integer getGre() {
        return gre;
    }

    public void setGre(Integer gre) {
        this.gre = gre;
    }

    public Integer getTofel() {
        return tofel;
    }

    public void setTofel(Integer tofel) {
        this.tofel = tofel;
    }

    public Float getIelts() {
        return ielts;
    }

    public void setIelts(Float ielts) {
        this.ielts = ielts;
    }

    public Integer getAct() {
        return act;
    }

    public void setAct(Integer act) {
        this.act = act;
    }

    public Integer getGmat() {
        return gmat;
    }

    public void setGmat(Integer gmat) {
        this.gmat = gmat;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree == null ? null : degree.trim();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }
}