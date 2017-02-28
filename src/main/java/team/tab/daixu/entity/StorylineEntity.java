package team.tab.daixu.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by CLY on 2017/2/28.
 */
@Entity
@Table(name = "storyline", schema = "daixu", catalog = "")
public class StorylineEntity {
    private int id;
    private int authorId;
    private String storylineName;
    private String storylineSurface;
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
    @Column(name = "storyline_name")
    public String getStorylineName() {
        return storylineName;
    }

    public void setStorylineName(String storylineName) {
        this.storylineName = storylineName;
    }

    @Basic
    @Column(name = "storyline_surface")
    public String getStorylineSurface() {
        return storylineSurface;
    }

    public void setStorylineSurface(String storylineSurface) {
        this.storylineSurface = storylineSurface;
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
        if (storylineName != null ? !storylineName.equals(that.storylineName) : that.storylineName != null)
            return false;
        if (storylineSurface != null ? !storylineSurface.equals(that.storylineSurface) : that.storylineSurface != null)
            return false;
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
        result = 31 * result + (storylineName != null ? storylineName.hashCode() : 0);
        result = 31 * result + (storylineSurface != null ? storylineSurface.hashCode() : 0);
        result = 31 * result + (publishTime != null ? publishTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (background != null ? background.hashCode() : 0);
        result = 31 * result + (wordNum != null ? wordNum.hashCode() : 0);
        result = 31 * result + (lookNum != null ? lookNum.hashCode() : 0);
        result = 31 * result + (whetherEnd != null ? whetherEnd.hashCode() : 0);
        return result;
    }
}
