package com.geekrose.vo;

/**
 * @author Joker_Dong
 * @date 2021-11-11 21:49
 */

public class StudentAndCity {
    private Integer sid;
    private String sname;
    private String semail;
    private Integer sage;
    private Integer cid;
    private String cname;
    private Integer pid;

    public StudentAndCity(Integer sid, String sname, String semail, Integer sage, Integer cid, String cname, Integer pid) {
        this.sid = sid;
        this.sname = sname;
        this.semail = semail;
        this.sage = sage;
        this.cid = cid;
        this.cname = cname;
        this.pid = pid;
    }

    public StudentAndCity() {
    }

    @Override
    public String toString() {
        return "StudentAndCity{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", semail='" + semail + '\'' +
                ", sage=" + sage +
                ", cid=" + cid +
                ", cname='" + cname + '\'' +
                ", pid=" + pid +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
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
