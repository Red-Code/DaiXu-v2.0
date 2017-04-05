package team.tab.daixu.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by CLY on 2017/4/5.
 */
@Entity
@Table(name = "user", schema = "daixu", catalog = "")
public class UserEntity {
    private long id;
    private String name;
    private Integer join;
    private Integer follow;
    private Integer fans;
    private String img;
    private String brief;
    private Integer surplusExp;
    private int rank;
    private String vip;
    private Integer exp;
    private String account;
    private String password;
    private String sex;
    private Date birthday;
    private String email;
    private String phone;
    private String remindSeek;
    private String setAction;
    private String setFollow;
    private String setFans;
    private String setSee;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
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
    @Column(name = "join")
    public Integer getJoin() {
        return join;
    }

    public void setJoin(Integer join) {
        this.join = join;
    }

    @Basic
    @Column(name = "follow")
    public Integer getFollow() {
        return follow;
    }

    public void setFollow(Integer follow) {
        this.follow = follow;
    }

    @Basic
    @Column(name = "fans")
    public Integer getFans() {
        return fans;
    }

    public void setFans(Integer fans) {
        this.fans = fans;
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
    @Column(name = "brief")
    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    @Basic
    @Column(name = "surplus_exp")
    public Integer getSurplusExp() {
        return surplusExp;
    }

    public void setSurplusExp(Integer surplusExp) {
        this.surplusExp = surplusExp;
    }

    @Basic
    @Column(name = "rank")
    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Basic
    @Column(name = "vip")
    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    @Basic
    @Column(name = "exp")
    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    @Basic
    @Column(name = "account")
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "remind_seek")
    public String getRemindSeek() {
        return remindSeek;
    }

    public void setRemindSeek(String remindSeek) {
        this.remindSeek = remindSeek;
    }

    @Basic
    @Column(name = "set_action")
    public String getSetAction() {
        return setAction;
    }

    public void setSetAction(String setAction) {
        this.setAction = setAction;
    }

    @Basic
    @Column(name = "set_follow")
    public String getSetFollow() {
        return setFollow;
    }

    public void setSetFollow(String setFollow) {
        this.setFollow = setFollow;
    }

    @Basic
    @Column(name = "set_fans")
    public String getSetFans() {
        return setFans;
    }

    public void setSetFans(String setFans) {
        this.setFans = setFans;
    }

    @Basic
    @Column(name = "set_see")
    public String getSetSee() {
        return setSee;
    }

    public void setSetSee(String setSee) {
        this.setSee = setSee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (rank != that.rank) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (join != null ? !join.equals(that.join) : that.join != null) return false;
        if (follow != null ? !follow.equals(that.follow) : that.follow != null) return false;
        if (fans != null ? !fans.equals(that.fans) : that.fans != null) return false;
        if (img != null ? !img.equals(that.img) : that.img != null) return false;
        if (brief != null ? !brief.equals(that.brief) : that.brief != null) return false;
        if (surplusExp != null ? !surplusExp.equals(that.surplusExp) : that.surplusExp != null) return false;
        if (vip != null ? !vip.equals(that.vip) : that.vip != null) return false;
        if (exp != null ? !exp.equals(that.exp) : that.exp != null) return false;
        if (account != null ? !account.equals(that.account) : that.account != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (remindSeek != null ? !remindSeek.equals(that.remindSeek) : that.remindSeek != null) return false;
        if (setAction != null ? !setAction.equals(that.setAction) : that.setAction != null) return false;
        if (setFollow != null ? !setFollow.equals(that.setFollow) : that.setFollow != null) return false;
        if (setFans != null ? !setFans.equals(that.setFans) : that.setFans != null) return false;
        if (setSee != null ? !setSee.equals(that.setSee) : that.setSee != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (join != null ? join.hashCode() : 0);
        result = 31 * result + (follow != null ? follow.hashCode() : 0);
        result = 31 * result + (fans != null ? fans.hashCode() : 0);
        result = 31 * result + (img != null ? img.hashCode() : 0);
        result = 31 * result + (brief != null ? brief.hashCode() : 0);
        result = 31 * result + (surplusExp != null ? surplusExp.hashCode() : 0);
        result = 31 * result + rank;
        result = 31 * result + (vip != null ? vip.hashCode() : 0);
        result = 31 * result + (exp != null ? exp.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (remindSeek != null ? remindSeek.hashCode() : 0);
        result = 31 * result + (setAction != null ? setAction.hashCode() : 0);
        result = 31 * result + (setFollow != null ? setFollow.hashCode() : 0);
        result = 31 * result + (setFans != null ? setFans.hashCode() : 0);
        result = 31 * result + (setSee != null ? setSee.hashCode() : 0);
        return result;
    }
}
