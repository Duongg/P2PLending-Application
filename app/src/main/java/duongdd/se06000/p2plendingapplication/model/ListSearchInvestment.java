package duongdd.se06000.p2plendingapplication.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class ListSearchInvestment {

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

    @SerializedName("name")
    private String name;

    public ListSearchInvestment() {
    }

    public ListSearchInvestment(int investmentCompanyID, String investmentName, int accountID,
                                BigDecimal investMoney, BigDecimal investedMoney,
                                float interestRateInvestor, String name) {
        this.investmentCompanyID = investmentCompanyID;
        this.investmentName = investmentName;
        this.accountID = accountID;
        this.investMoney = investMoney;
        this.investedMoney = investedMoney;
        this.interestRateInvestor = interestRateInvestor;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
