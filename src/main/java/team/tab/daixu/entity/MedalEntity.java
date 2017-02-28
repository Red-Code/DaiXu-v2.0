package team.tab.daixu.entity;

import javax.persistence.*;

/**
 * Created by CLY on 2017/2/28.
 */
@Entity
@Table(name = "medal", schema = "daixu", catalog = "")
public class MedalEntity {
    private int medalId;
    private String medalImg;
    private String medalName;
    private String medalContent;

    @Id
    @Column(name = "medal_id")
    public int getMedalId() {
        return medalId;
    }

    public void setMedalId(int medalId) {
        this.medalId = medalId;
    }

    @Basic
    @Column(name = "medal_img")
    public String getMedalImg() {
        return medalImg;
    }

    public void setMedalImg(String medalImg) {
        this.medalImg = medalImg;
    }

    @Basic
    @Column(name = "medal_name")
    public String getMedalName() {
        return medalName;
    }

    public void setMedalName(String medalName) {
        this.medalName = medalName;
    }

    @Basic
    @Column(name = "medal_content")
    public String getMedalContent() {
        return medalContent;
    }

    public void setMedalContent(String medalContent) {
        this.medalContent = medalContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MedalEntity that = (MedalEntity) o;

        if (medalId != that.medalId) return false;
        if (medalImg != null ? !medalImg.equals(that.medalImg) : that.medalImg != null) return false;
        if (medalName != null ? !medalName.equals(that.medalName) : that.medalName != null) return false;
        if (medalContent != null ? !medalContent.equals(that.medalContent) : that.medalContent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = medalId;
        result = 31 * result + (medalImg != null ? medalImg.hashCode() : 0);
        result = 31 * result + (medalName != null ? medalName.hashCode() : 0);
        result = 31 * result + (medalContent != null ? medalContent.hashCode() : 0);
        return result;
    }
}
