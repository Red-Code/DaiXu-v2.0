package team.tab.daixu.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by CLY on 2017/1/3.
 */
@Entity
@Table(name = "tarticle", schema = "daixu", catalog = "")
public class TarticleEntity {
    private int tarticleArticle;
    private int tarticleContinue;
    private String tarticleName;
    private Date tarticleDate;

    @Id
    @Column(name = "tarticle_article")
    public int getTarticleArticle() {
        return tarticleArticle;
    }

    public void setTarticleArticle(int tarticleArticle) {
        this.tarticleArticle = tarticleArticle;
    }

    @Basic
    @Column(name = "tarticle_continue")
    public int getTarticleContinue() {
        return tarticleContinue;
    }

    public void setTarticleContinue(int tarticleContinue) {
        this.tarticleContinue = tarticleContinue;
    }

    @Basic
    @Column(name = "tarticle_name")
    public String getTarticleName() {
        return tarticleName;
    }

    public void setTarticleName(String tarticleName) {
        this.tarticleName = tarticleName;
    }

    @Basic
    @Column(name = "tarticle_date")
    public Date getTarticleDate() {
        return tarticleDate;
    }

    public void setTarticleDate(Date tarticleDate) {
        this.tarticleDate = tarticleDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TarticleEntity that = (TarticleEntity) o;

        if (tarticleArticle != that.tarticleArticle) return false;
        if (tarticleContinue != that.tarticleContinue) return false;
        if (tarticleName != null ? !tarticleName.equals(that.tarticleName) : that.tarticleName != null) return false;
        if (tarticleDate != null ? !tarticleDate.equals(that.tarticleDate) : that.tarticleDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tarticleArticle;
        result = 31 * result + tarticleContinue;
        result = 31 * result + (tarticleName != null ? tarticleName.hashCode() : 0);
        result = 31 * result + (tarticleDate != null ? tarticleDate.hashCode() : 0);
        return result;
    }
}
