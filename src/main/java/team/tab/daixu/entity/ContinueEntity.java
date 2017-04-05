package team.tab.daixu.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by CLY on 2017/4/5.
 */
@Entity
@Table(name = "continue", schema = "daixu", catalog = "")
public class ContinueEntity {
    private long id;
    private int head;
    private String content;
    private String img;
    private Timestamp time;
    private int author;
    private int praise;
    private int comment;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "head")
    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "img")
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "author")
    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    @Basic
    @Column(name = "praise")
    public int getPraise() {
        return praise;
    }

    public void setPraise(int praise) {
        this.praise = praise;
    }

    @Basic
    @Column(name = "comment")
    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContinueEntity that = (ContinueEntity) o;

        if (id != that.id) return false;
        if (head != that.head) return false;
        if (author != that.author) return false;
        if (praise != that.praise) return false;
        if (comment != that.comment) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (img != null ? !img.equals(that.img) : that.img != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + head;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (img != null ? img.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + author;
        result = 31 * result + praise;
        result = 31 * result + comment;
        return result;
    }
}
