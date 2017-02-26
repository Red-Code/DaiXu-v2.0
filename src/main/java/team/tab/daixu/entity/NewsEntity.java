package team.tab.daixu.entity;

import javax.persistence.*;

/**
 * Created by CLY on 2017/1/3.
 */
@Entity
@Table(name = "news", schema = "daixu", catalog = "")
public class NewsEntity {
    private int newsId;
    private int newsSend;
    private int newsReceive;
    private String newsContent;
    private String newsGet;

    @Id
    @Column(name = "news_id")
    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    @Basic
    @Column(name = "news_send")
    public int getNewsSend() {
        return newsSend;
    }

    public void setNewsSend(int newsSend) {
        this.newsSend = newsSend;
    }

    @Basic
    @Column(name = "news_receive")
    public int getNewsReceive() {
        return newsReceive;
    }

    public void setNewsReceive(int newsReceive) {
        this.newsReceive = newsReceive;
    }

    @Basic
    @Column(name = "news_content")
    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    @Basic
    @Column(name = "news_get")
    public String getNewsGet() {
        return newsGet;
    }

    public void setNewsGet(String newsGet) {
        this.newsGet = newsGet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsEntity that = (NewsEntity) o;

        if (newsId != that.newsId) return false;
        if (newsSend != that.newsSend) return false;
        if (newsReceive != that.newsReceive) return false;
        if (newsContent != null ? !newsContent.equals(that.newsContent) : that.newsContent != null) return false;
        if (newsGet != null ? !newsGet.equals(that.newsGet) : that.newsGet != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = newsId;
        result = 31 * result + newsSend;
        result = 31 * result + newsReceive;
        result = 31 * result + (newsContent != null ? newsContent.hashCode() : 0);
        result = 31 * result + (newsGet != null ? newsGet.hashCode() : 0);
        return result;
    }
}
