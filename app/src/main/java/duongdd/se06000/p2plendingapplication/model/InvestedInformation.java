package duongdd.se06000.p2plendingapplication.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.sql.Date;

public class InvestedInformation{

    @SerializedName("name")
    private String name;

    @SerializedName("accountID")
    private int accountID;

    @SerializedName("investorDetailsID")
    private int investorDetailsID;

    @SerializedName("asset")
    private BigDecimal asset;

    @SerializedName("investmentName")
    private String investmentName;

    @SerializedName("career")
    private String career;

    @SerializedName("investedMoney")
    private BigDecimal investedMoney;

    @SerializedName("interestRateInvestor")
    private float interestRateInvestor;

    @SerializedName("startDate")
    private Date startDate;

    @SerializedName("endDate")
    private Date endDate;

    @SerializedName("period")
    private int period;

    @SerializedName("profit")
    private BigDecimal profit;

    @SerializedName("profitReveive")
    private BigDecimal profitReveive;

    public InvestedInformation() {
    }

    public InvestedInformation(String name, int accountID, int investorDetailsID, BigDecimal asset,
                               String investmentName, String career, BigDecimal investedMoney,
                               float interestRateInvestor, Date startDate, Date endDate, int period,
                               BigDecimal profit, BigDecimal profitReveive) {
        this.name = name;
        this.accountID = accountID;
        this.investorDetailsID = investorDetailsID;
        this.asset = asset;
        this.investmentName = investmentName;
        this.career = career;
        this.investedMoney = investedMoney;
        this.interestRateInvestor = interestRateInvestor;
        this.startDate = startDate;
        this.endDate = endDate;
        this.period = period;
        this.profit = profit;
        this.profitReveive = profitReveive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getProfitReveive() {
        return profitReveive;
    }

    public void setProfitReveive(BigDecimal profitReveive) {
        this.profitReveive = profitReveive;
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

    public void setInvestorDetailsID(int investorDetails) {
        this.investorDetailsID = investorDetails;
    }

    public BigDecimal getAsset() {
        return asset;
    }

    public void setAsset(BigDecimal asset) {
        this.asset = asset;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }
}
