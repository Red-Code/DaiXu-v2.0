package team.tab.daixu.entity;

import javax.persistence.*;

/**
 * Created by CLY on 2017/1/3.
 */
@Entity
@Table(name = "rtask", schema = "daixu", catalog = "")
public class RtaskEntity {
    private int rtaskId;
    private int rtaskTask;
    private int rtaskUser;

    @Id
    @Column(name = "rtask_id")
    public int getRtaskId() {
        return rtaskId;
    }

    public void setRtaskId(int rtaskId) {
        this.rtaskId = rtaskId;
    }

    @Basic
    @Column(name = "rtask_task")
    public int getRtaskTask() {
        return rtaskTask;
    }

    public void setRtaskTask(int rtaskTask) {
        this.rtaskTask = rtaskTask;
    }

    @Basic
    @Column(name = "rtask_user")
    public int getRtaskUser() {
        return rtaskUser;
    }

    public void setRtaskUser(int rtaskUser) {
        this.rtaskUser = rtaskUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RtaskEntity that = (RtaskEntity) o;

        if (rtaskId != that.rtaskId) return false;
        if (rtaskTask != that.rtaskTask) return false;
        if (rtaskUser != that.rtaskUser) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rtaskId;
        result = 31 * result + rtaskTask;
        result = 31 * result + rtaskUser;
        return result;
    }
}
