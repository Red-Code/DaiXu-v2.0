package team.tab.daixu.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by CLY on 2017/1/3.
 */
@Entity
@Table(name = "notice", schema = "daixu", catalog = "")
public class NoticeEntity {
    private int noticeId;
    private int noticeReceive;
    private String noticeContent;
    private int noticeOriginId;
    private Integer noticeContinueId;
    private Timestamp noticeTime;
    private String noticeRead;
    private Integer noticeUserId;
    private String noticeType;
    private String noticeUrl;

    @Id
    @Column(name = "notice_id")
    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    @Basic
    @Column(name = "notice_receive")
    public int getNoticeReceive() {
        return noticeReceive;
    }

    public void setNoticeReceive(int noticeReceive) {
        this.noticeReceive = noticeReceive;
    }

    @Basic
    @Column(name = "notice_content")
    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    @Basic
    @Column(name = "notice_origin_id")
    public int getNoticeOriginId() {
        return noticeOriginId;
    }

    public void setNoticeOriginId(int noticeOriginId) {
        this.noticeOriginId = noticeOriginId;
    }

    @Basic
    @Column(name = "notice_continue_id")
    public Integer getNoticeContinueId() {
        return noticeContinueId;
    }

    public void setNoticeContinueId(Integer noticeContinueId) {
        this.noticeContinueId = noticeContinueId;
    }

    @Basic
    @Column(name = "notice_time")
    public Timestamp getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(Timestamp noticeTime) {
        this.noticeTime = noticeTime;
    }

    @Basic
    @Column(name = "notice_read")
    public String getNoticeRead() {
        return noticeRead;
    }

    public void setNoticeRead(String noticeRead) {
        this.noticeRead = noticeRead;
    }

    @Basic
    @Column(name = "notice_user_id")
    public Integer getNoticeUserId() {
        return noticeUserId;
    }

    public void setNoticeUserId(Integer noticeUserId) {
        this.noticeUserId = noticeUserId;
    }

    @Basic
    @Column(name = "notice_type")
    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    @Basic
    @Column(name = "notice_url")
    public String getNoticeUrl() {
        return noticeUrl;
    }

    public void setNoticeUrl(String noticeUrl) {
        this.noticeUrl = noticeUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoticeEntity that = (NoticeEntity) o;

        if (noticeId != that.noticeId) return false;
        if (noticeReceive != that.noticeReceive) return false;
        if (noticeOriginId != that.noticeOriginId) return false;
        if (noticeContent != null ? !noticeContent.equals(that.noticeContent) : that.noticeContent != null)
            return false;
        if (noticeContinueId != null ? !noticeContinueId.equals(that.noticeContinueId) : that.noticeContinueId != null)
            return false;
        if (noticeTime != null ? !noticeTime.equals(that.noticeTime) : that.noticeTime != null) return false;
        if (noticeRead != null ? !noticeRead.equals(that.noticeRead) : that.noticeRead != null) return false;
        if (noticeUserId != null ? !noticeUserId.equals(that.noticeUserId) : that.noticeUserId != null) return false;
        if (noticeType != null ? !noticeType.equals(that.noticeType) : that.noticeType != null) return false;
        if (noticeUrl != null ? !noticeUrl.equals(that.noticeUrl) : that.noticeUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = noticeId;
        result = 31 * result + noticeReceive;
        result = 31 * result + (noticeContent != null ? noticeContent.hashCode() : 0);
        result = 31 * result + noticeOriginId;
        result = 31 * result + (noticeContinueId != null ? noticeContinueId.hashCode() : 0);
        result = 31 * result + (noticeTime != null ? noticeTime.hashCode() : 0);
        result = 31 * result + (noticeRead != null ? noticeRead.hashCode() : 0);
        result = 31 * result + (noticeUserId != null ? noticeUserId.hashCode() : 0);
        result = 31 * result + (noticeType != null ? noticeType.hashCode() : 0);
        result = 31 * result + (noticeUrl != null ? noticeUrl.hashCode() : 0);
        return result;
    }
}
