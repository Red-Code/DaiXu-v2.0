package team.tab.daixu.entity;

import javax.persistence.*;

/**
 * Created by CLY on 2017/3/25.
 */
@Entity
@Table(name = "rtask", schema = "daixu", catalog = "")
public class RtaskEntity {
    private int id;
    private int task;
    private int user;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "task")
    public int getTask() {
        return task;
    }

    public void setTask(int task) {
        this.task = task;
    }

    @Basic
    @Column(name = "user")
    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RtaskEntity that = (RtaskEntity) o;

        if (id != that.id) return false;
        if (task != that.task) return false;
        if (user != that.user) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + task;
        result = 31 * result + user;
        return result;
    }
}
