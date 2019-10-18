package duongdd.se06000.p2plendingapplication.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class Notification implements Serializable {
    @SerializedName("accountID")
    private int  accountID;

    @SerializedName("investorDetailsID")
    private int investorDetailsID;

    @SerializedName("investmentCompanyID")
    private int investmentCompanyID;

    @SerializedName("notificationID")
    private int notificationID;

    @SerializedName("content")
    private String content;

    @SerializedName("date")
    private Date date;

    public Notification() {
    }

    public Notification(int accountID, int investorDetailsID, int investmentCompanyID, int notificationID, String content, Date date) {
        this.accountID = accountID;
        this.investorDetailsID = investorDetailsID;
        this.investmentCompanyID = investmentCompanyID;
        this.notificationID = notificationID;
        this.content = content;
        this.date = date;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getInvestorDetailsID() {
        return investorDetailsID;
    }

    public void setInvestorDetailsID(int investorDetailsID) {
        this.investorDetailsID = investorDetailsID;
    }

    public int getInvestmentCompanyID() {
        return investmentCompanyID;
    }

    public void setInvestmentCompanyID(int investmentCompanyID) {
        this.investmentCompanyID = investmentCompanyID;
    }

    public int getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(int notificationID) {
        this.notificationID = notificationID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
