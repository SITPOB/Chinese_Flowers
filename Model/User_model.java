package Chinese_Flower.Model;

public class User_model {
    private int UserID;
    private int UserAge;
    private String UserAccount;
    private String UserPWD;
    private String NickName;
    private String UserPhone;
    public User_model() {
        UserID = 0;
        UserAge = 0;
        UserAccount = "";
        UserPWD = "";
        NickName = "";
        UserPhone = "";
    }
    public User_model(int UserID, int UserAge, String UserAccount, String UserPWD, String NickName, String UserPhone) {
        this.UserID = UserID;
        this.UserAge = UserAge;
        this.UserAccount = UserAccount;
        this.UserPWD = UserPWD;
        this.NickName = NickName;
        this.UserPhone = UserPhone;
    }
    public void setAll(int UserID, int UserAge, String UserAccount, String UserPWD, String NickName, String UserPhone) {
        this.UserID = UserID;
        this.UserAge = UserAge;
        this.UserAccount = UserAccount;
        this.UserPWD = UserPWD;
        this.NickName = NickName;
        this.UserPhone = UserPhone;
    }
    public int getUserID() {
        return UserID;
    }
    public void setUserID(int userID) {
        UserID = userID;
    }
    public int getUserAge() {
        return UserAge;
    }
    public void setUserAge(int userAge) {
        UserAge = userAge;
    }
    public String getUserAccount() {
        return UserAccount;
    }
    public void setUserAccount(String userAccount) {
        UserAccount = userAccount;
    }
    public String getUserPWD() {
        return UserPWD;
    }
    public void setUserPWD(String userPWD) {
        UserPWD = userPWD;
    }
    public String getNickName() {
        return NickName;
    }
    public void setNickName(String nickName) {
        NickName = nickName;
    }
    public String getUserPhone() {
        return UserPhone;
    }
    public void setUserPhone(String userPhone) {
        UserPhone = userPhone;
    }
    public void setNULL() {
        UserID = 0;
        UserAge = 0;
        UserAccount = "";
        UserPWD = "";
        NickName = "";
        UserPhone = "";
    }
    
}
