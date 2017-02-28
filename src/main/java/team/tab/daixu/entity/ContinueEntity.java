package team.tab.daixu.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by CLY on 2017/2/28.
 */
@Entity
@Table(name = "continue", schema = "daixu", catalog = "")
public class ContinueEntity {
    private int continueId;
    private int continueHead;
    private String continueContent;
    private String continueImg;
    private Timestamp continueTime;
    private int continueAuthor;
    private int continuePraise;
    private int continueComment;

    @Id
    @Column(name = "continue_id")
    public int getContinueId() {
        return continueId;
    }

    public void setContinueId(int continueId) {
        this.continueId = continueId;
    }

    @Basic
    @Column(name = "continue_head")
    public int getContinueHead() {
        return continueHead;
    }

    public void setContinueHead(int continueHead) {
        this.continueHead = continueHead;
    }

    @Basic
    @Column(name = "continue_content")
    public String getContinueContent() {
        return continueContent;
    }

    public void setContinueContent(String continueContent) {
        this.continueContent = continueContent;
    }

    @Basic
    @Column(name = "continue_img")
    public String getContinueImg() {
        return continueImg;
    }

    public void setContinueImg(String continueImg) {
        this.continueImg = continueImg;
    }

    @Basic
    @Column(name = "continue_time")
    public Timestamp getContinueTime() {
        return continueTime;
    }

    public void setContinueTime(Timestamp continueTime) {
        this.continueTime = continueTime;
    }

    @Basic
    @Column(name = "continue_author")
    public int getContinueAuthor() {
        return continueAuthor;
    }

    public void setContinueAuthor(int continueAuthor) {
        this.continueAuthor = continueAuthor;
    }

    @Basic
    @Column(name = "continue_praise")
    public int getContinuePraise() {
        return continuePraise;
    }

    public void setContinuePraise(int continuePraise) {
        this.continuePraise = continuePraise;
    }

    @Basic
    @Column(name = "continue_comment")
    public int getContinueComment() {
        return continueComment;
    }

    public void setContinueComment(int continueComment) {
        this.continueComment = continueComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContinueEntity that = (ContinueEntity) o;

        if (continueId != that.continueId) return false;
        if (continueHead != that.continueHead) return false;
        if (continueAuthor != that.continueAuthor) return false;
        if (continuePraise != that.continuePraise) return false;
        if (continueComment != that.continueComment) return false;
        if (continueContent != null ? !continueContent.equals(that.continueContent) : that.continueContent != null)
            return false;
        if (continueImg != null ? !continueImg.equals(that.continueImg) : that.continueImg != null) return false;
        if (continueTime != null ? !continueTime.equals(that.continueTime) : that.continueTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = continueId;
        result = 31 * result + continueHead;
        result = 31 * result + (continueContent != null ? continueContent.hashCode() : 0);
        result = 31 * result + (continueImg != null ? continueImg.hashCode() : 0);
        result = 31 * result + (continueTime != null ? continueTime.hashCode() : 0);
        result = 31 * result + continueAuthor;
        result = 31 * result + continuePraise;
        result = 31 * result + continueComment;
        return result;
    }
}
