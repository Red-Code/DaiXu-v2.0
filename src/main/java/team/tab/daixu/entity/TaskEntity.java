package team.tab.daixu.entity;

import javax.persistence.*;

/**
 * Created by CLY on 2017/2/28.
 */
@Entity
@Table(name = "task", schema = "daixu", catalog = "")
public class TaskEntity {
    private int taskId;
    private String taskContent;
    private String taskReward;

    @Id
    @Column(name = "task_id")
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Basic
    @Column(name = "task_content")
    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    @Basic
    @Column(name = "task_reward")
    public String getTaskReward() {
        return taskReward;
    }

    public void setTaskReward(String taskReward) {
        this.taskReward = taskReward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskEntity that = (TaskEntity) o;

        if (taskId != that.taskId) return false;
        if (taskContent != null ? !taskContent.equals(that.taskContent) : that.taskContent != null) return false;
        if (taskReward != null ? !taskReward.equals(that.taskReward) : that.taskReward != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = taskId;
        result = 31 * result + (taskContent != null ? taskContent.hashCode() : 0);
        result = 31 * result + (taskReward != null ? taskReward.hashCode() : 0);
        return result;
    }
}
