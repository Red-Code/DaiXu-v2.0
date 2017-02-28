package team.tab.daixu.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by CLY on 2017/2/28.
 */
@Entity
@Table(name = "topic", schema = "daixu", catalog = "")
public class TopicEntity {
    private int topicId;
    private String topicName;
    private Date topicData;
    private String topicUrl;

    @Id
    @Column(name = "topic_id")
    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    @Basic
    @Column(name = "topic_name")
    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    @Basic
    @Column(name = "topic_data")
    public Date getTopicData() {
        return topicData;
    }

    public void setTopicData(Date topicData) {
        this.topicData = topicData;
    }

    @Basic
    @Column(name = "topic_url")
    public String getTopicUrl() {
        return topicUrl;
    }

    public void setTopicUrl(String topicUrl) {
        this.topicUrl = topicUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TopicEntity that = (TopicEntity) o;

        if (topicId != that.topicId) return false;
        if (topicName != null ? !topicName.equals(that.topicName) : that.topicName != null) return false;
        if (topicData != null ? !topicData.equals(that.topicData) : that.topicData != null) return false;
        if (topicUrl != null ? !topicUrl.equals(that.topicUrl) : that.topicUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = topicId;
        result = 31 * result + (topicName != null ? topicName.hashCode() : 0);
        result = 31 * result + (topicData != null ? topicData.hashCode() : 0);
        result = 31 * result + (topicUrl != null ? topicUrl.hashCode() : 0);
        return result;
    }
}
