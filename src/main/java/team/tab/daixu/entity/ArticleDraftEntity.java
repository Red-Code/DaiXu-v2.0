package team.tab.daixu.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by CLY on 2017/2/28.
 */
@Entity
@Table(name = "article_draft", schema = "daixu", catalog = "")
public class ArticleDraftEntity {
    private int draftId;
    private String draftContent;
    private Timestamp draftTime;
    private int draftAuthor;

    @Id
    @Column(name = "draft_id")
    public int getDraftId() {
        return draftId;
    }

    public void setDraftId(int draftId) {
        this.draftId = draftId;
    }

    @Basic
    @Column(name = "draft_content")
    public String getDraftContent() {
        return draftContent;
    }

    public void setDraftContent(String draftContent) {
        this.draftContent = draftContent;
    }

    @Basic
    @Column(name = "draft_time")
    public Timestamp getDraftTime() {
        return draftTime;
    }

    public void setDraftTime(Timestamp draftTime) {
        this.draftTime = draftTime;
    }

    @Basic
    @Column(name = "draft_author")
    public int getDraftAuthor() {
        return draftAuthor;
    }

    public void setDraftAuthor(int draftAuthor) {
        this.draftAuthor = draftAuthor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleDraftEntity that = (ArticleDraftEntity) o;

        if (draftId != that.draftId) return false;
        if (draftAuthor != that.draftAuthor) return false;
        if (draftContent != null ? !draftContent.equals(that.draftContent) : that.draftContent != null) return false;
        if (draftTime != null ? !draftTime.equals(that.draftTime) : that.draftTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = draftId;
        result = 31 * result + (draftContent != null ? draftContent.hashCode() : 0);
        result = 31 * result + (draftTime != null ? draftTime.hashCode() : 0);
        result = 31 * result + draftAuthor;
        return result;
    }
}
