package team.tab.daixu.entity;

import javax.persistence.*;

/**
 * Created by CLY on 2017/4/5.
 */
@Entity
@Table(name = "storyline_continue_relate", schema = "daixu", catalog = "")
public class StorylineContinueRelateEntity {
    private long id;
    private Integer frontId;
    private Integer backId;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "front_id")
    public Integer getFrontId() {
        return frontId;
    }

    public void setFrontId(Integer frontId) {
        this.frontId = frontId;
    }

    @Basic
    @Column(name = "back_id")
    public Integer getBackId() {
        return backId;
    }

    public void setBackId(Integer backId) {
        this.backId = backId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StorylineContinueRelateEntity that = (StorylineContinueRelateEntity) o;

        if (id != that.id) return false;
        if (frontId != null ? !frontId.equals(that.frontId) : that.frontId != null) return false;
        if (backId != null ? !backId.equals(that.backId) : that.backId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (frontId != null ? frontId.hashCode() : 0);
        result = 31 * result + (backId != null ? backId.hashCode() : 0);
        return result;
    }
}
