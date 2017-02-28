package team.tab.daixu.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by CLY on 2017/2/28.
 */
@Entity
@Table(name = "user", schema = "daixu", catalog = "")
public class UserEntity {
    private int userId;
    private String userName;
    private Integer userJoin;
    private Integer userFollow;
    private Integer userFans;
    private String userImg;
    private String userBrief;
    private Integer userSurplusExp;
    private int userRank;
    private String userVip;
    private Integer userExp;
    private String userAccount;
    private String userPassword;
    private String userSex;
    private Date userBirthday;
    private String userEmail;
    private String userPhone;
    private String userRemindSeek;
    private String userSetAction;
    private String userSetFollow;
    private String userSetFans;
    private String userSetSee;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_join")
    public Integer getUserJoin() {
        return userJoin;
    }

    public void setUserJoin(Integer userJoin) {
        this.userJoin = userJoin;
    }

    @Basic
    @Column(name = "user_follow")
    public Integer getUserFollow() {
        return userFollow;
    }

    public void setUserFollow(Integer userFollow) {
        this.userFollow = userFollow;
    }

    @Basic
    @Column(name = "user_fans")
    public Integer getUserFans() {
        return userFans;
    }

    public void setUserFans(Integer userFans) {
        this.userFans = userFans;
    }

    @Basic
    @Column(name = "user_img")
    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    @Basic
    @Column(name = "user_brief")
    public String getUserBrief() {
        return userBrief;
    }

    public void setUserBrief(String userBrief) {
        this.userBrief = userBrief;
    }

    @Basic
    @Column(name = "user_surplus_exp")
    public Integer getUserSurplusExp() {
        return userSurplusExp;
    }

    public void setUserSurplusExp(Integer userSurplusExp) {
        this.userSurplusExp = userSurplusExp;
    }

    @Basic
    @Column(name = "user_rank")
    public int getUserRank() {
        return userRank;
    }

    public void setUserRank(int userRank) {
        this.userRank = userRank;
    }

    @Basic
    @Column(name = "user_vip")
    public String getUserVip() {
        return userVip;
    }

    public void setUserVip(String userVip) {
        this.userVip = userVip;
    }

    @Basic
    @Column(name = "user_exp")
    public Integer getUserExp() {
        return userExp;
    }

    public void setUserExp(Integer userExp) {
        this.userExp = userExp;
    }

    @Basic
    @Column(name = "user_account")
    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    @Basic
    @Column(name = "user_password")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_sex")
    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    @Basic
    @Column(name = "user_birthday")
    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    @Basic
    @Column(name = "user_email")
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "user_phone")
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Basic
    @Column(name = "user_remind_seek")
    public String getUserRemindSeek() {
        return userRemindSeek;
    }

    public void setUserRemindSeek(String userRemindSeek) {
        this.userRemindSeek = userRemindSeek;
    }

    @Basic
    @Column(name = "user_set_action")
    public String getUserSetAction() {
        return userSetAction;
    }

    public void setUserSetAction(String userSetAction) {
        this.userSetAction = userSetAction;
    }

    @Basic
    @Column(name = "user_set_follow")
    public String getUserSetFollow() {
        return userSetFollow;
    }

    public void setUserSetFollow(String userSetFollow) {
        this.userSetFollow = userSetFollow;
    }

    @Basic
    @Column(name = "user_set_fans")
    public String getUserSetFans() {
        return userSetFans;
    }

    public void setUserSetFans(String userSetFans) {
        this.userSetFans = userSetFans;
    }

    @Basic
    @Column(name = "user_set_see")
    public String getUserSetSee() {
        return userSetSee;
    }

    public void setUserSetSee(String userSetSee) {
        this.userSetSee = userSetSee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userId != that.userId) return false;
        if (userRank != that.userRank) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (userJoin != null ? !userJoin.equals(that.userJoin) : that.userJoin != null) return false;
        if (userFollow != null ? !userFollow.equals(that.userFollow) : that.userFollow != null) return false;
        if (userFans != null ? !userFans.equals(that.userFans) : that.userFans != null) return false;
        if (userImg != null ? !userImg.equals(that.userImg) : that.userImg != null) return false;
        if (userBrief != null ? !userBrief.equals(that.userBrief) : that.userBrief != null) return false;
        if (userSurplusExp != null ? !userSurplusExp.equals(that.userSurplusExp) : that.userSurplusExp != null)
            return false;
        if (userVip != null ? !userVip.equals(that.userVip) : that.userVip != null) return false;
        if (userExp != null ? !userExp.equals(that.userExp) : that.userExp != null) return false;
        if (userAccount != null ? !userAccount.equals(that.userAccount) : that.userAccount != null) return false;
        if (userPassword != null ? !userPassword.equals(that.userPassword) : that.userPassword != null) return false;
        if (userSex != null ? !userSex.equals(that.userSex) : that.userSex != null) return false;
        if (userBirthday != null ? !userBirthday.equals(that.userBirthday) : that.userBirthday != null) return false;
        if (userEmail != null ? !userEmail.equals(that.userEmail) : that.userEmail != null) return false;
        if (userPhone != null ? !userPhone.equals(that.userPhone) : that.userPhone != null) return false;
        if (userRemindSeek != null ? !userRemindSeek.equals(that.userRemindSeek) : that.userRemindSeek != null)
            return false;
        if (userSetAction != null ? !userSetAction.equals(that.userSetAction) : that.userSetAction != null)
            return false;
        if (userSetFollow != null ? !userSetFollow.equals(that.userSetFollow) : that.userSetFollow != null)
            return false;
        if (userSetFans != null ? !userSetFans.equals(that.userSetFans) : that.userSetFans != null) return false;
        if (userSetSee != null ? !userSetSee.equals(that.userSetSee) : that.userSetSee != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userJoin != null ? userJoin.hashCode() : 0);
        result = 31 * result + (userFollow != null ? userFollow.hashCode() : 0);
        result = 31 * result + (userFans != null ? userFans.hashCode() : 0);
        result = 31 * result + (userImg != null ? userImg.hashCode() : 0);
        result = 31 * result + (userBrief != null ? userBrief.hashCode() : 0);
        result = 31 * result + (userSurplusExp != null ? userSurplusExp.hashCode() : 0);
        result = 31 * result + userRank;
        result = 31 * result + (userVip != null ? userVip.hashCode() : 0);
        result = 31 * result + (userExp != null ? userExp.hashCode() : 0);
        result = 31 * result + (userAccount != null ? userAccount.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userSex != null ? userSex.hashCode() : 0);
        result = 31 * result + (userBirthday != null ? userBirthday.hashCode() : 0);
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (userPhone != null ? userPhone.hashCode() : 0);
        result = 31 * result + (userRemindSeek != null ? userRemindSeek.hashCode() : 0);
        result = 31 * result + (userSetAction != null ? userSetAction.hashCode() : 0);
        result = 31 * result + (userSetFollow != null ? userSetFollow.hashCode() : 0);
        result = 31 * result + (userSetFans != null ? userSetFans.hashCode() : 0);
        result = 31 * result + (userSetSee != null ? userSetSee.hashCode() : 0);
        return result;
    }
}
