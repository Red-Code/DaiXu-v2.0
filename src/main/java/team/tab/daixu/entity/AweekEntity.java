package team.tab.daixu.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by CLY on 2017/1/3.
 */
@Entity
@Table(name = "aweek", schema = "daixu", catalog = "")
public class AweekEntity {
    private int aweekId;
    private Date aweekDate;
    private String aweekInfo;

    @Id
    @Column(name = "aweek_id")
    public int getAweekId() {
        return aweekId;
    }

    public void setAweekId(int aweekId) {
        this.aweekId = aweekId;
    }

    @Basic
    @Column(name = "aweek_date")
    public Date getAweekDate() {
        return aweekDate;
    }

    public void setAweekDate(Date aweekDate) {
        this.aweekDate = aweekDate;
    }

    @Basic
    @Column(name = "aweek_info")
    public String getAweekInfo() {
        return aweekInfo;
    }

    public void setAweekInfo(String aweekInfo) {
        this.aweekInfo = aweekInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AweekEntity that = (AweekEntity) o;

        if (aweekId != that.aweekId) return false;
        if (aweekDate != null ? !aweekDate.equals(that.aweekDate) : that.aweekDate != null) return false;
        if (aweekInfo != null ? !aweekInfo.equals(that.aweekInfo) : that.aweekInfo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aweekId;
        result = 31 * result + (aweekDate != null ? aweekDate.hashCode() : 0);
        result = 31 * result + (aweekInfo != null ? aweekInfo.hashCode() : 0);
        return result;
    }
}
