package team.tab.daixu.entity;

import javax.persistence.*;

/**
 * Created by CLY on 2017/3/25.
 */
@Entity
@Table(name = "rmedal", schema = "daixu", catalog = "")
public class RmedalEntity {
    private int id;
    private int medal;
    private int userId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "medal")
    public int getMedal() {
        return medal;
    }

    public void setMedal(int medal) {
        this.medal = medal;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RmedalEntity that = (RmedalEntity) o;

        if (id != that.id) return false;
        if (medal != that.medal) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + medal;
        result = 31 * result + userId;
        return result;
    }
}
