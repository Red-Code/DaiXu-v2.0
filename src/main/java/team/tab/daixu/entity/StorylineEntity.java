package team.tab.daixu.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by CLY on 2017/3/25.
 */
@Entity
@Table(name = "storyline", schema = "daixu", catalog = "")
public class StorylineEntity {
    private int id;
    private int authorId;
    private String name;
    private String surface;
    private Timestamp publishTime;
    private Timestamp updateTime;
    private String background;
    private String wordNum;
    private Integer lookNum;
    private String whetherEnd;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "author_id")
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surface")
    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    @Basic
    @Column(name = "publish_time")
    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "background")
    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    @Basic
    @Column(name = "word_num")
    public String getWordNum() {
        return wordNum;
    }

    public void setWordNum(String wordNum) {
        this.wordNum = wordNum;
    }

    @Basic
    @Column(name = "look_num")
    public Integer getLookNum() {
        return lookNum;
    }

    public void setLookNum(Integer lookNum) {
        this.lookNum = lookNum;
    }

    @Basic
    @Column(name = "whether_end")
    public String getWhetherEnd() {
        return whetherEnd;
    }

    public void setWhetherEnd(String whetherEnd) {
        this.whetherEnd = whetherEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StorylineEntity that = (StorylineEntity) o;

        if (id != that.id) return false;
        if (authorId != that.authorId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surface != null ? !surface.equals(that.surface) : that.surface != null) return false;
        if (publishTime != null ? !publishTime.equals(that.publishTime) : that.publishTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (background != null ? !background.equals(that.background) : that.background != null) return false;
        if (wordNum != null ? !wordNum.equals(that.wordNum) : that.wordNum != null) return false;
        if (lookNum != null ? !lookNum.equals(that.lookNum) : that.lookNum != null) return false;
        if (whetherEnd != null ? !whetherEnd.equals(that.whetherEnd) : that.whetherEnd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + authorId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surface != null ? surface.hashCode() : 0);
        result = 31 * result + (publishTime != null ? publishTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (background != null ? background.hashCode() : 0);
        result = 31 * result + (wordNum != null ? wordNum.hashCode() : 0);
        result = 31 * result + (lookNum != null ? lookNum.hashCode() : 0);
        result = 31 * result + (whetherEnd != null ? whetherEnd.hashCode() : 0);
        return result;
    }
}
