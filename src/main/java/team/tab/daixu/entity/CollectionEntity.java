package team.tab.daixu.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by CLY on 2017/1/3.
 */
@Entity
@Table(name = "collection", schema = "daixu", catalog = "")
public class CollectionEntity {
    private int collectionId;
    private int collectionUserId;
    private int collectionArticleId;
    private int collectionArticleClassify;
    private Integer collectionMarker;
    private Timestamp collectionTime;

    @Id
    @Column(name = "collection_id")
    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    @Basic
    @Column(name = "collection_user_id")
    public int getCollectionUserId() {
        return collectionUserId;
    }

    public void setCollectionUserId(int collectionUserId) {
        this.collectionUserId = collectionUserId;
    }

    @Basic
    @Column(name = "collection_article_id")
    public int getCollectionArticleId() {
        return collectionArticleId;
    }

    public void setCollectionArticleId(int collectionArticleId) {
        this.collectionArticleId = collectionArticleId;
    }

    @Basic
    @Column(name = "collection_article_classify")
    public int getCollectionArticleClassify() {
        return collectionArticleClassify;
    }

    public void setCollectionArticleClassify(int collectionArticleClassify) {
        this.collectionArticleClassify = collectionArticleClassify;
    }

    @Basic
    @Column(name = "collection_marker")
    public Integer getCollectionMarker() {
        return collectionMarker;
    }

    public void setCollectionMarker(Integer collectionMarker) {
        this.collectionMarker = collectionMarker;
    }

    @Basic
    @Column(name = "collection_time")
    public Timestamp getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(Timestamp collectionTime) {
        this.collectionTime = collectionTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollectionEntity that = (CollectionEntity) o;

        if (collectionId != that.collectionId) return false;
        if (collectionUserId != that.collectionUserId) return false;
        if (collectionArticleId != that.collectionArticleId) return false;
        if (collectionArticleClassify != that.collectionArticleClassify) return false;
        if (collectionMarker != null ? !collectionMarker.equals(that.collectionMarker) : that.collectionMarker != null)
            return false;
        if (collectionTime != null ? !collectionTime.equals(that.collectionTime) : that.collectionTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = collectionId;
        result = 31 * result + collectionUserId;
        result = 31 * result + collectionArticleId;
        result = 31 * result + collectionArticleClassify;
        result = 31 * result + (collectionMarker != null ? collectionMarker.hashCode() : 0);
        result = 31 * result + (collectionTime != null ? collectionTime.hashCode() : 0);
        return result;
    }
}
