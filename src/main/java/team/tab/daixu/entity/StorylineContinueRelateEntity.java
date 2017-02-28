package team.tab.daixu.entity;

import javax.persistence.*;

/**
 * Created by CLY on 2017/2/28.
 */
@Entity
@Table(name = "storyline_continue_relate", schema = "daixu", catalog = "")
public class StorylineContinueRelateEntity {
    private int id;
    private Integer storylineContinueFrontId;
    private Integer storylineContinueBackId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "storyline_continue_front_id")
    public Integer getStorylineContinueFrontId() {
        return storylineContinueFrontId;
    }

    public void setStorylineContinueFrontId(Integer storylineContinueFrontId) {
        this.storylineContinueFrontId = storylineContinueFrontId;
    }

    @Basic
    @Column(name = "storyline_continue_back_id")
    public Integer getStorylineContinueBackId() {
        return storylineContinueBackId;
    }

    public void setStorylineContinueBackId(Integer storylineContinueBackId) {
        this.storylineContinueBackId = storylineContinueBackId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StorylineContinueRelateEntity that = (StorylineContinueRelateEntity) o;

        if (id != that.id) return false;
        if (storylineContinueFrontId != null ? !storylineContinueFrontId.equals(that.storylineContinueFrontId) : that.storylineContinueFrontId != null)
            return false;
        if (storylineContinueBackId != null ? !storylineContinueBackId.equals(that.storylineContinueBackId) : that.storylineContinueBackId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (storylineContinueFrontId != null ? storylineContinueFrontId.hashCode() : 0);
        result = 31 * result + (storylineContinueBackId != null ? storylineContinueBackId.hashCode() : 0);
        return result;
    }
}
