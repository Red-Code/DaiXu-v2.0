package team.tab.daixu.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by CLY on 2017/1/3.
 */
@Entity
@Table(name = "tuser", schema = "daixu", catalog = "")
public class TuserEntity {
    private int tuserUser;
    private int tuserPublish;
    private Date tuserDate;

    @Id
    @Column(name = "tuser_user")
    public int getTuserUser() {
        return tuserUser;
    }

    public void setTuserUser(int tuserUser) {
        this.tuserUser = tuserUser;
    }

    @Basic
    @Column(name = "tuser_publish")
    public int getTuserPublish() {
        return tuserPublish;
    }

    public void setTuserPublish(int tuserPublish) {
        this.tuserPublish = tuserPublish;
    }

    @Basic
    @Column(name = "tuser_date")
    public Date getTuserDate() {
        return tuserDate;
    }

    public void setTuserDate(Date tuserDate) {
        this.tuserDate = tuserDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TuserEntity that = (TuserEntity) o;

        if (tuserUser != that.tuserUser) return false;
        if (tuserPublish != that.tuserPublish) return false;
        if (tuserDate != null ? !tuserDate.equals(that.tuserDate) : that.tuserDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tuserUser;
        result = 31 * result + tuserPublish;
        result = 31 * result + (tuserDate != null ? tuserDate.hashCode() : 0);
        return result;
    }
}
