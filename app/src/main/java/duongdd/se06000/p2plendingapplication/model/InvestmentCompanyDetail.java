package duongdd.se06000.p2plendingapplication.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class InvestmentCompanyDetail implements Serializable {

    @SerializedName("investmentCompanyID")
    private int investmentCompanyID;

    @SerializedName("accountID")
    private int accountID;

    @SerializedName("name")
    private String name;

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
    private BigDecimal investorInvestMoney; // số tiền còn lại có thể đầu tư

    @SerializedName("availableMoney")
    private BigDecimal availableMoney; // số dư khả dụng có thể đầu tư

    @SerializedName("investedDate")
    private Date investedDate;

    @SerializedName("investmentName")
    private String investmentName;

    @SerializedName("investorID")
    private int investorID;

    public InvestmentCompanyDetail(int investmentCompanyID, int accountID, String name,
                                   String career, int period, float interestRateInvestor,
                                   BigDecimal investMoney, BigDecimal investedMoney,
                                   BigDecimal investorInvestMoney, BigDecimal availableMoney,
                                   Date investedDate, String investmentName, int investorID) {
        this.investmentCompanyID = investmentCompanyID;
        this.accountID = accountID;
        this.name = name;
        this.career = career;
        this.period = period;
        this.interestRateInvestor = interestRateInvestor;
        this.investMoney = investMoney;
        this.investedMoney = investedMoney;
        this.investorInvestMoney = investorInvestMoney;
        this.availableMoney = availableMoney;
        this.investedDate = investedDate;
        this.investmentName = investmentName;
        this.investorID = investorID;
    }

    public InvestmentCompanyDetail() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public BigDecimal getAvailableMoney() {
        return availableMoney;
    }

    public void setAvailableMoney(BigDecimal availableMoney) {
        this.availableMoney = availableMoney;
    }

    public Date getInvestedDate() {
        return investedDate;
    }

    public void setInvestedDate(Date investedDate) {
        this.investedDate = investedDate;
    }

    public String getInvestmentName() {
        return investmentName;
    }

    public void setInvestmentName(String investmentName) {
        this.investmentName = investmentName;
    }

    public int getInvestorID() {
        return investorID;
    }

    public void setInvestorID(int investorID) {
        this.investorID = investorID;
    }
}
