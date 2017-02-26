package team.tab.daixu.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by CLY on 2017/1/3.
 */
@Entity
@Table(name = "uweek", schema = "daixu", catalog = "")
public class UweekEntity {
    private int uweekId;
    private Date uweekDate;
    private String uweekInfo;

    @Id
    @Column(name = "uweek_id")
    public int getUweekId() {
        return uweekId;
    }

    public void setUweekId(int uweekId) {
        this.uweekId = uweekId;
    }

    @Basic
    @Column(name = "uweek_date")
    public Date getUweekDate() {
        return uweekDate;
    }

    public void setUweekDate(Date uweekDate) {
        this.uweekDate = uweekDate;
    }

    @Basic
    @Column(name = "uweek_info")
    public String getUweekInfo() {
        return uweekInfo;
    }

    public void setUweekInfo(String uweekInfo) {
        this.uweekInfo = uweekInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UweekEntity that = (UweekEntity) o;

        if (uweekId != that.uweekId) return false;
        if (uweekDate != null ? !uweekDate.equals(that.uweekDate) : that.uweekDate != null) return false;
        if (uweekInfo != null ? !uweekInfo.equals(that.uweekInfo) : that.uweekInfo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uweekId;
        result = 31 * result + (uweekDate != null ? uweekDate.hashCode() : 0);
        result = 31 * result + (uweekInfo != null ? uweekInfo.hashCode() : 0);
        return result;
    }
}
