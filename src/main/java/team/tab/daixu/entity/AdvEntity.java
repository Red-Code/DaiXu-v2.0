package team.tab.daixu.entity;

import javax.persistence.*;

/**
 * Created by CLY on 2017/3/25.
 */
@Entity
@Table(name = "adv", schema = "daixu", catalog = "")
public class AdvEntity {
    private int id;
    private String img;
    private String url;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdvEntity advEntity = (AdvEntity) o;

        if (id != advEntity.id) return false;
        if (img != null ? !img.equals(advEntity.img) : advEntity.img != null) return false;
        if (url != null ? !url.equals(advEntity.url) : advEntity.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (img != null ? img.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
