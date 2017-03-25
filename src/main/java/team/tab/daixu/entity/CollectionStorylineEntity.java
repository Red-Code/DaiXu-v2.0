package team.tab.daixu.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by CLY on 2017/3/25.
 */
@Entity
@Table(name = "collection_storyline", schema = "daixu", catalog = "")
public class CollectionStorylineEntity {
    private int id;
    private int userId;
    private int storylineId;
    private Integer marker;
    private Timestamp time;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "storyline_id")
    public int getStorylineId() {
        return storylineId;
    }

    public void setStorylineId(int storylineId) {
        this.storylineId = storylineId;
    }

    @Basic
    @Column(name = "marker")
    public Integer getMarker() {
        return marker;
    }

    public void setMarker(Integer marker) {
        this.marker = marker;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollectionStorylineEntity that = (CollectionStorylineEntity) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (storylineId != that.storylineId) return false;
        if (marker != null ? !marker.equals(that.marker) : that.marker != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + storylineId;
        result = 31 * result + (marker != null ? marker.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
