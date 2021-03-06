package team.tab.daixu.entity;

import javax.persistence.*;

/**
 * Created by CLY on 2017/4/5.
 */
@Entity
@Table(name = "storyline_continue", schema = "daixu", catalog = "")
public class StorylineContinueEntity {
    private long id;
    private String item;
    private String continueContent;
    private long storylineId;
    private String whetherBegin;
    private String whetherEnd;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "item")
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
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
    @Column(name = "storyline_id")
    public long getStorylineId() {
        return storylineId;
    }

    public void setStorylineId(long storylineId) {
        this.storylineId = storylineId;
    }

    @Basic
    @Column(name = "whether_begin")
    public String getWhetherBegin() {
        return whetherBegin;
    }

    public void setWhetherBegin(String whetherBegin) {
        this.whetherBegin = whetherBegin;
    }

    @Basic
    @Column(name = "whether_end")
    public String getWhetherEnd() {
        return whetherEnd;
    }

    public void setWhetherEnd(String whetherEnd) {
        this.whetherEnd = whetherEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StorylineContinueEntity that = (StorylineContinueEntity) o;

        if (id != that.id) return false;
        if (item != null ? !item.equals(that.item) : that.item != null) return false;
        if (continueContent != null ? !continueContent.equals(that.continueContent) : that.continueContent != null)
            return false;
        if (whetherBegin != null ? !whetherBegin.equals(that.whetherBegin) : that.whetherBegin != null) return false;
        if (whetherEnd != null ? !whetherEnd.equals(that.whetherEnd) : that.whetherEnd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (item != null ? item.hashCode() : 0);
        result = 31 * result + (continueContent != null ? continueContent.hashCode() : 0);
        result = 31 * result + (whetherBegin != null ? whetherBegin.hashCode() : 0);
        result = 31 * result + (whetherEnd != null ? whetherEnd.hashCode() : 0);
        return result;
    }
}
