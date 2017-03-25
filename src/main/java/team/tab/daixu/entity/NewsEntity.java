package team.tab.daixu.entity;

import javax.persistence.*;

/**
 * Created by CLY on 2017/3/25.
 */
@Entity
@Table(name = "news", schema = "daixu", catalog = "")
public class NewsEntity {
    private int id;
    private int send;
    private int receive;
    private String content;
    private String get;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "send")
    public int getSend() {
        return send;
    }

    public void setSend(int send) {
        this.send = send;
    }

    @Basic
    @Column(name = "receive")
    public int getReceive() {
        return receive;
    }

    public void setReceive(int receive) {
        this.receive = receive;
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
    @Column(name = "get")
    public String getGet() {
        return get;
    }

    public void setGet(String get) {
        this.get = get;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsEntity that = (NewsEntity) o;

        if (id != that.id) return false;
        if (send != that.send) return false;
        if (receive != that.receive) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (get != null ? !get.equals(that.get) : that.get != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + send;
        result = 31 * result + receive;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (get != null ? get.hashCode() : 0);
        return result;
    }
}
