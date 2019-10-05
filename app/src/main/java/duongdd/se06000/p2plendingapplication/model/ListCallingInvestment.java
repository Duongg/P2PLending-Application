package duongdd.se06000.p2plendingapplication.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.Date;

public class ListCallingInvestment {

    @SerializedName("investmentCompanyID")
    private int investmentCompanyID;

    @SerializedName("investmentName")
    private String investmentName;

    @SerializedName("accountID")
    private int accountID;

    @SerializedName("investMoney")
    private BigDecimal investMoney;

    @SerializedName("investedMoney")
    private BigDecimal investedMoney;

    @SerializedName("interestRateInvestor")
    private float interestRateInvestor;

    @SerializedName("interestRatePlatform")
    private float interestRatePlatform;

    @SerializedName("period")
    private int period;

    @SerializedName("investedDate")
    private Date investedDate;

    @SerializedName("investedEndDate")
    private Date investedEndDate;

    @SerializedName("status")
    private String status;

    @SerializedName("career")
    private String career;

    public ListCallingInvestment(int investmentCompanyID, String investmentName,
                                 int accountID, BigDecimal investMoney, BigDecimal investedMoney,
                                 float interestRateInvestor, float interestRatePlatform, int period,
                                 Date investedDate, Date investedEndDate, String status, String career) {
        this.investmentCompanyID = investmentCompanyID;
        this.investmentName = investmentName;
        this.accountID = accountID;
        this.investMoney = investMoney;
        this.investedMoney = investedMoney;
        this.interestRateInvestor = interestRateInvestor;
        this.interestRatePlatform = interestRatePlatform;
        this.period = period;
        this.investedDate = investedDate;
        this.investedEndDate = investedEndDate;
        this.status = status;
        this.career = career;
    }

    public ListCallingInvestment() {
    }

    public int getInvestmentCompanyID() {
        return investmentCompanyID;
    }

    public void setInvestmentCompanyID(int investmentCompanyID) {
        this.investmentCompanyID = investmentCompanyID;
    }

    public String getInvestmentName() {
        return investmentName;
    }

    public void setInvestmentName(String investmentName) {
        this.investmentName = investmentName;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
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

    public float getInterestRateInvestor() {
        return interestRateInvestor;
    }

    public void setInterestRateInvestor(float interestRateInvestor) {
        this.interestRateInvestor = interestRateInvestor;
    }

    public float getInterestRatePlatform() {
        return interestRatePlatform;
    }

    public void setInterestRatePlatform(float interestRatePlatform) {
        this.interestRatePlatform = interestRatePlatform;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
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

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }
}
