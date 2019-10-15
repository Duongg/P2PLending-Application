package duongdd.se06000.p2plendingapplication.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DetailInvestmentCalling implements Serializable {

    @SerializedName("investmentCompanyID")
    private int investmentCompanyID;

    @SerializedName("accountID")
    private int accountID;

    @SerializedName("investmentName")
    private String investmentName;

    @SerializedName("career")
    private String career;

    @SerializedName("period")
    private int period;

    @SerializedName("interestRateInvestor")
    private float interestRateInvestor;

    @SerializedName("investMoney")
    private BigDecimal investMoney;

    @SerializedName("investedMoney")
    private BigDecimal investedMoney;

    @SerializedName("investorInvestMoney")
    private BigDecimal investorInvestMoney;

    @SerializedName("investedDate")
    private Date investedDate;

    @SerializedName("investedEndDate")
    private Date investedEndDate;

    @SerializedName("status")
    private String status;

    public DetailInvestmentCalling() {
    }

    public DetailInvestmentCalling(int investmentCompanyID, int accountID, String investmentName, String career, int period, float interestRateInvestor, BigDecimal investMoney, BigDecimal investedMoney, BigDecimal investorInvestMoney, Date investedDate, Date investedEndDate, String status) {
        this.investmentCompanyID = investmentCompanyID;
        this.accountID = accountID;
        this.investmentName = investmentName;
        this.career = career;
        this.period = period;
        this.interestRateInvestor = interestRateInvestor;
        this.investMoney = investMoney;
        this.investedMoney = investedMoney;
        this.investorInvestMoney = investorInvestMoney;
        this.investedDate = investedDate;
        this.investedEndDate = investedEndDate;
        this.status = status;
    }

    public int getInvestmentCompanyID() {
        return investmentCompanyID;
    }

    public void setInvestmentCompanyID(int investmentCompanyID) {
        this.investmentCompanyID = investmentCompanyID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getInvestmentName() {
        return investmentName;
    }

    public void setInvestmentName(String investmentName) {
        this.investmentName = investmentName;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public float getInterestRateInvestor() {
        return interestRateInvestor;
    }

    public void setInterestRateInvestor(float interestRateInvestor) {
        this.interestRateInvestor = interestRateInvestor;
    }

    public BigDecimal getInvestMoney() {
        return investMoney;
    }

    public void setInvestMoney(BigDecimal investMoney) {
        this.investMoney = investMoney;
    }

    public BigDecimal getInvestedMoney() {
        return investedMoney;
    }

    public void setInvestedMoney(BigDecimal investedMoney) {
        this.investedMoney = investedMoney;
    }

    public BigDecimal getInvestorInvestMoney() {
        return investorInvestMoney;
    }

    public void setInvestorInvestMoney(BigDecimal investorInvestMoney) {
        this.investorInvestMoney = investorInvestMoney;
    }

    public Date getInvestedDate() {
        return investedDate;
    }

    public void setInvestedDate(Date investedDate) {
        this.investedDate = investedDate;
    }

    public Date getInvestedEndDate() {
        return investedEndDate;
    }

    public void setInvestedEndDate(Date investedEndDate) {
        this.investedEndDate = investedEndDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
