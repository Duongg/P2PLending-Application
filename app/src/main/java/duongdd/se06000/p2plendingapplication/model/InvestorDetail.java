package duongdd.se06000.p2plendingapplication.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class InvestorDetail implements Serializable {

    @SerializedName("investedMoney")
    private BigDecimal investedMoney;

    @SerializedName("investmentCompanyID")
    private int investmentCompanyID;

    @SerializedName("investorDetailsID")
    private int investorDetailsID;

    @SerializedName("startDate")
    private Date startDate;

    @SerializedName("investmentName")
    private String investmentName;

    @SerializedName("period")
    private int period;

    @SerializedName("interestRateInvestor")
    private float interestRateInvestor;

    @SerializedName("investedDate")
    private Date investedDate;

    @SerializedName("career")
    private String career;

    @SerializedName("disbursementDate")
    private Date disbursementDate;

    @SerializedName("principleMoneyLeft")
    private BigDecimal principleMoneyLeft;

    @SerializedName("interestMoney")
    private BigDecimal interestMoney;

    @SerializedName("disbursementMoney")
    private BigDecimal disbursementMoney;

    @SerializedName("status")
    private String status;

    public InvestorDetail() {
    }

    public InvestorDetail(BigDecimal investedMoney, int investmentCompanyID, int investorDetailsID,
                          Date startDate, String investmentName, int period, float interestRateInvestor,
                          Date investedDate, String career, Date disbursementDate, BigDecimal principleMoneyLeft,
                          BigDecimal interestMoney, BigDecimal disbursementMoney, String status) {
        this.investedMoney = investedMoney;
        this.investmentCompanyID = investmentCompanyID;
        this.investorDetailsID = investorDetailsID;
        this.startDate = startDate;
        this.investmentName = investmentName;
        this.period = period;
        this.interestRateInvestor = interestRateInvestor;
        this.investedDate = investedDate;
        this.career = career;
        this.disbursementDate = disbursementDate;
        this.principleMoneyLeft = principleMoneyLeft;
        this.interestMoney = interestMoney;
        this.disbursementMoney = disbursementMoney;
        this.status = status;
    }

    public int getInvestmentCompanyID() {
        return investmentCompanyID;
    }

    public void setInvestmentCompanyID(int investmentCompanyID) {
        this.investmentCompanyID = investmentCompanyID;
    }

    public int getInvestorDetailsID() {
        return investorDetailsID;
    }

    public void setInvestorDetailsID(int investorDetailsID) {
        this.investorDetailsID = investorDetailsID;
    }

    public BigDecimal getInvestedMoney() {
        return investedMoney;
    }

    public void setInvestedMoney(BigDecimal investedMoney) {
        this.investedMoney = investedMoney;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getInvestmentName() {
        return investmentName;
    }

    public void setInvestmentName(String investmentName) {
        this.investmentName = investmentName;
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

    public Date getInvestedDate() {
        return investedDate;
    }

    public void setInvestedDate(Date investedDate) {
        this.investedDate = investedDate;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public Date getDisbursementDate() {
        return disbursementDate;
    }

    public void setDisbursementDate(Date disbursementDate) {
        this.disbursementDate = disbursementDate;
    }

    public BigDecimal getPrincipleMoneyLeft() {
        return principleMoneyLeft;
    }

    public void setPrincipleMoneyLeft(BigDecimal principleMoneyLeft) {
        this.principleMoneyLeft = principleMoneyLeft;
    }

    public BigDecimal getInterestMoney() {
        return interestMoney;
    }

    public void setInterestMoney(BigDecimal interestMoney) {
        this.interestMoney = interestMoney;
    }

    public BigDecimal getDisbursementMoney() {
        return disbursementMoney;
    }

    public void setDisbursementMoney(BigDecimal disbursementMoney) {
        this.disbursementMoney = disbursementMoney;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
