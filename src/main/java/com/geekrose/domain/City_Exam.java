package com.geekrose.domain;

/**
 * @author Joker_Dong
 * @date 2021-11-10 14:54
 */

public class City_Exam {
    private Integer cid;
    private String cname;
    private Integer pid;

    public City_Exam(Integer cid, String cname, Integer pid) {
        this.cid = cid;
        this.cname = cname;
        this.pid = pid;
    }

    public City_Exam() {
    }

    @Override
    public String toString() {
        return "City_Exam{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", pid=" + pid +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
