package team.tab.daixu.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by CLY on 2017/3/25.
 */
@Entity
@Table(name = "article", schema = "daixu", catalog = "")
public class ArticleEntity {
    private int id;
    private String name;
    private int author;
    private String rule;
    private Integer jurisdiction;
    private String content;
    private Timestamp update;
    private Timestamp publish;
    private int praise;
    private int total;
    private String surface;
    private String fine;
    private String end;
    private String endName;
    private String endBrief;
    private String endSurface;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "rule")
    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    @Basic
    @Column(name = "jurisdiction")
    public Integer getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(Integer jurisdiction) {
        this.jurisdiction = jurisdiction;
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
    @Column(name = "update")
    public Timestamp getUpdate() {
        return update;
    }

    public void setUpdate(Timestamp update) {
        this.update = update;
    }

    @Basic
    @Column(name = "publish")
    public Timestamp getPublish() {
        return publish;
    }

    public void setPublish(Timestamp publish) {
        this.publish = publish;
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
    @Column(name = "total")
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Basic
    @Column(name = "surface")
    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    @Basic
    @Column(name = "fine")
    public String getFine() {
        return fine;
    }

    public void setFine(String fine) {
        this.fine = fine;
    }

    @Basic
    @Column(name = "end")
    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Basic
    @Column(name = "end_name")
    public String getEndName() {
        return endName;
    }

    public void setEndName(String endName) {
        this.endName = endName;
    }

    @Basic
    @Column(name = "end_brief")
    public String getEndBrief() {
        return endBrief;
    }

    public void setEndBrief(String endBrief) {
        this.endBrief = endBrief;
    }

    @Basic
    @Column(name = "end_surface")
    public String getEndSurface() {
        return endSurface;
    }

    public void setEndSurface(String endSurface) {
        this.endSurface = endSurface;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleEntity that = (ArticleEntity) o;

        if (id != that.id) return false;
        if (author != that.author) return false;
        if (praise != that.praise) return false;
        if (total != that.total) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (rule != null ? !rule.equals(that.rule) : that.rule != null) return false;
        if (jurisdiction != null ? !jurisdiction.equals(that.jurisdiction) : that.jurisdiction != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (update != null ? !update.equals(that.update) : that.update != null) return false;
        if (publish != null ? !publish.equals(that.publish) : that.publish != null) return false;
        if (surface != null ? !surface.equals(that.surface) : that.surface != null) return false;
        if (fine != null ? !fine.equals(that.fine) : that.fine != null) return false;
        if (end != null ? !end.equals(that.end) : that.end != null) return false;
        if (endName != null ? !endName.equals(that.endName) : that.endName != null) return false;
        if (endBrief != null ? !endBrief.equals(that.endBrief) : that.endBrief != null) return false;
        if (endSurface != null ? !endSurface.equals(that.endSurface) : that.endSurface != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + author;
        result = 31 * result + (rule != null ? rule.hashCode() : 0);
        result = 31 * result + (jurisdiction != null ? jurisdiction.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (update != null ? update.hashCode() : 0);
        result = 31 * result + (publish != null ? publish.hashCode() : 0);
        result = 31 * result + praise;
        result = 31 * result + total;
        result = 31 * result + (surface != null ? surface.hashCode() : 0);
        result = 31 * result + (fine != null ? fine.hashCode() : 0);
        result = 31 * result + (end != null ? end.hashCode() : 0);
        result = 31 * result + (endName != null ? endName.hashCode() : 0);
        result = 31 * result + (endBrief != null ? endBrief.hashCode() : 0);
        result = 31 * result + (endSurface != null ? endSurface.hashCode() : 0);
        return result;
    }
}
