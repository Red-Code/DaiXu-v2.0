package team.tab.daixu.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by CLY on 2017/3/25.
 */
@Entity
@Table(name = "storyline_comment", schema = "daixu", catalog = "")
public class StorylineCommentEntity {
    private int id;
    private Integer commentUserId;
    private Integer storylineId;
    private Timestamp publishTime;
    private String commentContent;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "comment_user_id")
    public Integer getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(Integer commentUserId) {
        this.commentUserId = commentUserId;
    }

    @Basic
    @Column(name = "storyline_id")
    public Integer getStorylineId() {
        return storylineId;
    }

    public void setStorylineId(Integer storylineId) {
        this.storylineId = storylineId;
    }

    @Basic
    @Column(name = "publish_time")
    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    @Basic
    @Column(name = "comment_content")
    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StorylineCommentEntity that = (StorylineCommentEntity) o;

        if (id != that.id) return false;
        if (commentUserId != null ? !commentUserId.equals(that.commentUserId) : that.commentUserId != null)
            return false;
        if (storylineId != null ? !storylineId.equals(that.storylineId) : that.storylineId != null) return false;
        if (publishTime != null ? !publishTime.equals(that.publishTime) : that.publishTime != null) return false;
        if (commentContent != null ? !commentContent.equals(that.commentContent) : that.commentContent != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (commentUserId != null ? commentUserId.hashCode() : 0);
        result = 31 * result + (storylineId != null ? storylineId.hashCode() : 0);
        result = 31 * result + (publishTime != null ? publishTime.hashCode() : 0);
        result = 31 * result + (commentContent != null ? commentContent.hashCode() : 0);
        return result;
    }
}
