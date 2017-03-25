package team.tab.daixu.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by CLY on 2017/3/25.
 */
@Entity
@Table(name = "notice_storyline", schema = "daixu", catalog = "")
public class NoticeStorylineEntity {
    private int id;
    private int receiveId;
    private String content;
    private int originId;
    private Integer continueId;
    private Timestamp time;
    private String read;
    private String type;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "receive_id")
    public int getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(int receiveId) {
        this.receiveId = receiveId;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "origin_id")
    public int getOriginId() {
        return originId;
    }

    public void setOriginId(int originId) {
        this.originId = originId;
    }

    @Basic
    @Column(name = "continue_id")
    public Integer getContinueId() {
        return continueId;
    }

    public void setContinueId(Integer continueId) {
        this.continueId = continueId;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "read")
    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoticeStorylineEntity that = (NoticeStorylineEntity) o;

        if (id != that.id) return false;
        if (receiveId != that.receiveId) return false;
        if (originId != that.originId) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (continueId != null ? !continueId.equals(that.continueId) : that.continueId != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (read != null ? !read.equals(that.read) : that.read != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + receiveId;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + originId;
        result = 31 * result + (continueId != null ? continueId.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (read != null ? read.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
