package team.tab.daixu.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by CLY on 2017/2/28.
 */
@Entity
@Table(name = "article", schema = "daixu", catalog = "")
public class ArticleEntity {
    private int articleId;
    private String articleName;
    private int articleAuthor;
    private String articleRule;
    private Integer articleJurisdiction;
    private String articleContent;
    private Timestamp articleUpdate;
    private Timestamp articlePublish;
    private int articlePraise;
    private int articleTotal;
    private String articleSurface;
    private String articleFine;
    private String articleEnd;
    private String articleEndName;
    private String articleEndBrief;
    private String articleEndSurface;

    @Id
    @Column(name = "article_id")
    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    @Basic
    @Column(name = "article_name")
    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    @Basic
    @Column(name = "article_author")
    public int getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(int articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    @Basic
    @Column(name = "article_rule")
    public String getArticleRule() {
        return articleRule;
    }

    public void setArticleRule(String articleRule) {
        this.articleRule = articleRule;
    }

    @Basic
    @Column(name = "article_jurisdiction")
    public Integer getArticleJurisdiction() {
        return articleJurisdiction;
    }

    public void setArticleJurisdiction(Integer articleJurisdiction) {
        this.articleJurisdiction = articleJurisdiction;
    }

    @Basic
    @Column(name = "article_content")
    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    @Basic
    @Column(name = "article_update")
    public Timestamp getArticleUpdate() {
        return articleUpdate;
    }

    public void setArticleUpdate(Timestamp articleUpdate) {
        this.articleUpdate = articleUpdate;
    }

    @Basic
    @Column(name = "article_publish")
    public Timestamp getArticlePublish() {
        return articlePublish;
    }

    public void setArticlePublish(Timestamp articlePublish) {
        this.articlePublish = articlePublish;
    }

    @Basic
    @Column(name = "article_praise")
    public int getArticlePraise() {
        return articlePraise;
    }

    public void setArticlePraise(int articlePraise) {
        this.articlePraise = articlePraise;
    }

    @Basic
    @Column(name = "article_total")
    public int getArticleTotal() {
        return articleTotal;
    }

    public void setArticleTotal(int articleTotal) {
        this.articleTotal = articleTotal;
    }

    @Basic
    @Column(name = "article_surface")
    public String getArticleSurface() {
        return articleSurface;
    }

    public void setArticleSurface(String articleSurface) {
        this.articleSurface = articleSurface;
    }

    @Basic
    @Column(name = "article_fine")
    public String getArticleFine() {
        return articleFine;
    }

    public void setArticleFine(String articleFine) {
        this.articleFine = articleFine;
    }

    @Basic
    @Column(name = "article_end")
    public String getArticleEnd() {
        return articleEnd;
    }

    public void setArticleEnd(String articleEnd) {
        this.articleEnd = articleEnd;
    }

    @Basic
    @Column(name = "article_end_name")
    public String getArticleEndName() {
        return articleEndName;
    }

    public void setArticleEndName(String articleEndName) {
        this.articleEndName = articleEndName;
    }

    @Basic
    @Column(name = "article_end_brief")
    public String getArticleEndBrief() {
        return articleEndBrief;
    }

    public void setArticleEndBrief(String articleEndBrief) {
        this.articleEndBrief = articleEndBrief;
    }

    @Basic
    @Column(name = "article_end_surface")
    public String getArticleEndSurface() {
        return articleEndSurface;
    }

    public void setArticleEndSurface(String articleEndSurface) {
        this.articleEndSurface = articleEndSurface;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleEntity that = (ArticleEntity) o;

        if (articleId != that.articleId) return false;
        if (articleAuthor != that.articleAuthor) return false;
        if (articlePraise != that.articlePraise) return false;
        if (articleTotal != that.articleTotal) return false;
        if (articleName != null ? !articleName.equals(that.articleName) : that.articleName != null) return false;
        if (articleRule != null ? !articleRule.equals(that.articleRule) : that.articleRule != null) return false;
        if (articleJurisdiction != null ? !articleJurisdiction.equals(that.articleJurisdiction) : that.articleJurisdiction != null)
            return false;
        if (articleContent != null ? !articleContent.equals(that.articleContent) : that.articleContent != null)
            return false;
        if (articleUpdate != null ? !articleUpdate.equals(that.articleUpdate) : that.articleUpdate != null)
            return false;
        if (articlePublish != null ? !articlePublish.equals(that.articlePublish) : that.articlePublish != null)
            return false;
        if (articleSurface != null ? !articleSurface.equals(that.articleSurface) : that.articleSurface != null)
            return false;
        if (articleFine != null ? !articleFine.equals(that.articleFine) : that.articleFine != null) return false;
        if (articleEnd != null ? !articleEnd.equals(that.articleEnd) : that.articleEnd != null) return false;
        if (articleEndName != null ? !articleEndName.equals(that.articleEndName) : that.articleEndName != null)
            return false;
        if (articleEndBrief != null ? !articleEndBrief.equals(that.articleEndBrief) : that.articleEndBrief != null)
            return false;
        if (articleEndSurface != null ? !articleEndSurface.equals(that.articleEndSurface) : that.articleEndSurface != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = articleId;
        result = 31 * result + (articleName != null ? articleName.hashCode() : 0);
        result = 31 * result + articleAuthor;
        result = 31 * result + (articleRule != null ? articleRule.hashCode() : 0);
        result = 31 * result + (articleJurisdiction != null ? articleJurisdiction.hashCode() : 0);
        result = 31 * result + (articleContent != null ? articleContent.hashCode() : 0);
        result = 31 * result + (articleUpdate != null ? articleUpdate.hashCode() : 0);
        result = 31 * result + (articlePublish != null ? articlePublish.hashCode() : 0);
        result = 31 * result + articlePraise;
        result = 31 * result + articleTotal;
        result = 31 * result + (articleSurface != null ? articleSurface.hashCode() : 0);
        result = 31 * result + (articleFine != null ? articleFine.hashCode() : 0);
        result = 31 * result + (articleEnd != null ? articleEnd.hashCode() : 0);
        result = 31 * result + (articleEndName != null ? articleEndName.hashCode() : 0);
        result = 31 * result + (articleEndBrief != null ? articleEndBrief.hashCode() : 0);
        result = 31 * result + (articleEndSurface != null ? articleEndSurface.hashCode() : 0);
        return result;
    }
}
