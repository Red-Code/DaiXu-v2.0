package team.tab.daixu.entity;

import javax.persistence.*;

/**
 * Created by CLY on 2017/1/3.
 */
@Entity
@Table(name = "reply", schema = "daixu", catalog = "")
public class ReplyEntity {
    private int replyId;
    private int replyLayer;
    private String replyContent;
    private int replyAuthorId;

    @Id
    @Column(name = "reply_id")
    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    @Basic
    @Column(name = "reply_layer")
    public int getReplyLayer() {
        return replyLayer;
    }

    public void setReplyLayer(int replyLayer) {
        this.replyLayer = replyLayer;
    }

    @Basic
    @Column(name = "reply_content")
    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    @Basic
    @Column(name = "reply_author_id")
    public int getReplyAuthorId() {
        return replyAuthorId;
    }

    public void setReplyAuthorId(int replyAuthorId) {
        this.replyAuthorId = replyAuthorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReplyEntity that = (ReplyEntity) o;

        if (replyId != that.replyId) return false;
        if (replyLayer != that.replyLayer) return false;
        if (replyAuthorId != that.replyAuthorId) return false;
        if (replyContent != null ? !replyContent.equals(that.replyContent) : that.replyContent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = replyId;
        result = 31 * result + replyLayer;
        result = 31 * result + (replyContent != null ? replyContent.hashCode() : 0);
        result = 31 * result + replyAuthorId;
        return result;
    }
}
