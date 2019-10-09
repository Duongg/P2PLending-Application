package duongdd.se06000.p2plendingapplication.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ListInvestedCompany implements Serializable {

    @SerializedName("investorID")
    private int investorID;

    @SerializedName("investorDetailsID")
    private int investorDetailsID;

    @SerializedName("investmentCompanyID")
    private int investmentCompanyID;

    @SerializedName("investmentName")
    private String investmentName;

    @SerializedName("borrowerID")
    private int borrowerID;

    @SerializedName("investMoney")
    private BigDecimal investMoney;

    @SerializedName("investedMoney")
    private BigDecimal investedMoney;

    @SerializedName("interestRateInvestor")
    private float interestRateInvestor;

    @SerializedName("name")
    private String name;

    @SerializedName("investedDate")
    private Date investedDate;

    @SerializedName("profit")
    private BigDecimal profit;

    public ListInvestedCompany() {
    }

    public ListInvestedCompany(int investorID, int investmentCompanyID, String investmentName,
                               int borrowerID, BigDecimal investMoney, BigDecimal investedMoney,
                               float interestRateInvestor, String name, Date investedDate, BigDecimal profit) {
        this.investorID = investorID;
        this.investmentCompanyID = investmentCompanyID;
        this.investmentName = investmentName;
        this.borrowerID = borrowerID;
        this.investMoney = investMoney;
        this.investedMoney = investedMoney;
        this.interestRateInvestor = interestRateInvestor;
        this.name = name;
        this.investedDate = investedDate;
        this.profit = profit;
    }


    public int getInvestorID() {
        return investorID;
    }

    public void setInvestorID(int investorID) {
        this.investorID = investorID;
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

    public int getBorrowerID() {
        return borrowerID;
    }

    public void setBorrowerID(int borrowerID) {
        this.borrowerID = borrowerID;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getInvestedDate() {
        return investedDate;
    }

    public void setInvestedDate(Date investedDate) {
        this.investedDate = investedDate;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }
}
