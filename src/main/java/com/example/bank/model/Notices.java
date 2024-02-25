package com.example.bank.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "notice_details")
public class Notices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id")
    private long noticeId;
    private String noticeSummary;
    private String noticeDetails;
    private Date notic_beg_dt;
    private Date notic_end_dt;
    private Date create_dt;
    private Date update_dt;

    public Notices() {

    }

    public Notices(String noticeSummary, String noticeDetails, Date notic_beg_dt, Date notic_end_dt, Date create_dt, Date update_dt) {
        this.noticeSummary = noticeSummary;
        this.noticeDetails = noticeDetails;
        this.notic_beg_dt = notic_beg_dt;
        this.notic_end_dt = notic_end_dt;
        this.create_dt = create_dt;
        this.update_dt = update_dt;
    }

    public long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(long noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeSummary() {
        return noticeSummary;
    }

    public void setNoticeSummary(String noticeSummary) {
        this.noticeSummary = noticeSummary;
    }

    public String getNoticeDetails() {
        return noticeDetails;
    }

    public void setNoticeDetails(String noticeDetails) {
        this.noticeDetails = noticeDetails;
    }

    public Date getNotic_beg_dt() {
        return notic_beg_dt;
    }

    public void setNotic_beg_dt(Date notic_beg_dt) {
        this.notic_beg_dt = notic_beg_dt;
    }

    public Date getNotic_end_dt() {
        return notic_end_dt;
    }

    public void setNotic_end_dt(Date notic_end_dt) {
        this.notic_end_dt = notic_end_dt;
    }

    public Date getCreate_dt() {
        return create_dt;
    }

    public void setCreate_dt(Date create_dt) {
        this.create_dt = create_dt;
    }

    public Date getUpdate_dt() {
        return update_dt;
    }

    public void setUpdate_dt(Date update_dt) {
        this.update_dt = update_dt;
    }
}
