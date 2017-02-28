package team.tab.daixu.entity;

import javax.persistence.*;

/**
 * Created by CLY on 2017/2/28.
 */
@Entity
@Table(name = "adv", schema = "daixu", catalog = "")
public class AdvEntity {
    private int advId;
    private String advImg;
    private String advUrl;

    @Id
    @Column(name = "adv_id")
    public int getAdvId() {
        return advId;
    }

    public void setAdvId(int advId) {
        this.advId = advId;
    }

    @Basic
    @Column(name = "adv_img")
    public String getAdvImg() {
        return advImg;
    }

    public void setAdvImg(String advImg) {
        this.advImg = advImg;
    }

    @Basic
    @Column(name = "adv_url")
    public String getAdvUrl() {
        return advUrl;
    }

    public void setAdvUrl(String advUrl) {
        this.advUrl = advUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdvEntity advEntity = (AdvEntity) o;

        if (advId != advEntity.advId) return false;
        if (advImg != null ? !advImg.equals(advEntity.advImg) : advEntity.advImg != null) return false;
        if (advUrl != null ? !advUrl.equals(advEntity.advUrl) : advEntity.advUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = advId;
        result = 31 * result + (advImg != null ? advImg.hashCode() : 0);
        result = 31 * result + (advUrl != null ? advUrl.hashCode() : 0);
        return result;
    }
}
