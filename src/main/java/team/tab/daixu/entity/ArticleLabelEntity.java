package team.tab.daixu.entity;

import javax.persistence.*;

/**
 * Created by CLY on 2017/1/6.
 */
@Entity
@Table(name = "article_label", schema = "daixu", catalog = "")
public class ArticleLabelEntity {
    private int articleId;
    private String label;
    private int id;

    @Basic
    @Column(name = "article_id")
    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    @Basic
    @Column(name = "label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleLabelEntity that = (ArticleLabelEntity) o;

        if (articleId != that.articleId) return false;
        if (label != null ? !label.equals(that.label) : that.label != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = articleId;
        result = 31 * result + (label != null ? label.hashCode() : 0);
        return result;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
