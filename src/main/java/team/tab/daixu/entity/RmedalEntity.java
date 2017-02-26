package team.tab.daixu.entity;

import javax.persistence.*;

/**
 * Created by CLY on 2017/1/3.
 */
@Entity
@Table(name = "rmedal", schema = "daixu", catalog = "")
public class RmedalEntity {
    private int rmedalId;
    private int rmedalMedal;
    private int rmedalUser;

    @Id
    @Column(name = "rmedal_id")
    public int getRmedalId() {
        return rmedalId;
    }

    public void setRmedalId(int rmedalId) {
        this.rmedalId = rmedalId;
    }

    @Basic
    @Column(name = "rmedal_medal")
    public int getRmedalMedal() {
        return rmedalMedal;
    }

    public void setRmedalMedal(int rmedalMedal) {
        this.rmedalMedal = rmedalMedal;
    }

    @Basic
    @Column(name = "rmedal_user")
    public int getRmedalUser() {
        return rmedalUser;
    }

    public void setRmedalUser(int rmedalUser) {
        this.rmedalUser = rmedalUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RmedalEntity that = (RmedalEntity) o;

        if (rmedalId != that.rmedalId) return false;
        if (rmedalMedal != that.rmedalMedal) return false;
        if (rmedalUser != that.rmedalUser) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rmedalId;
        result = 31 * result + rmedalMedal;
        result = 31 * result + rmedalUser;
        return result;
    }
}
