package duongdd.se06000.p2plendingapplication.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.Date;

public class CompanyDisbursement {

    @SerializedName("companyDisbursementID")
    private int companyDisbursementID;

    @SerializedName("investmentCompanyID")
    private int investmentCompanyID;

    @SerializedName("disbursementDate")
    private Date disbursementDate;

    @SerializedName("disbursementMoney")
    private BigDecimal disbursementMoney;

    @SerializedName("monthlyInterestMoney")
    private BigDecimal monthlyInterestMoney;

    @SerializedName("payment")
    private BigDecimal payment;

    @SerializedName("debt")
    private BigDecimal debt;

    @SerializedName("status")
    private String status;

    public CompanyDisbursement() {
    }

    public CompanyDisbursement(int companyDisbursementID, int investmentCompanyID, Date disbursementDate,
                               BigDecimal disbursementMoney, BigDecimal monthlyInterestMoney,
                               BigDecimal payment, BigDecimal debt, String status) {
        this.companyDisbursementID = companyDisbursementID;
        this.investmentCompanyID = investmentCompanyID;
        this.disbursementDate = disbursementDate;
        this.disbursementMoney = disbursementMoney;
        this.monthlyInterestMoney = monthlyInterestMoney;
        this.payment = payment;
        this.debt = debt;
        this.status = status;
    }

    public int getCompanyDisbursementID() {
        return companyDisbursementID;
    }

    public void setCompanyDisbursementID(int companyDisbursementID) {
        this.companyDisbursementID = companyDisbursementID;
    }

    public int getInvestmentCompanyID() {
        return investmentCompanyID;
    }

    public void setInvestmentCompanyID(int investmentCompanyID) {
        this.investmentCompanyID = investmentCompanyID;
    }

    public Date getDisbursementDate() {
        return disbursementDate;
    }

    public void setDisbursementDate(Date disbursementDate) {
        this.disbursementDate = disbursementDate;
    }

    public BigDecimal getDisbursementMoney() {
        return disbursementMoney;
    }

    public void setDisbursementMoney(BigDecimal disbursementMoney) {
        this.disbursementMoney = disbursementMoney;
    }

    public BigDecimal getMonthlyInterestMoney() {
        return monthlyInterestMoney;
    }

    public void setMonthlyInterestMoney(BigDecimal monthlyInterestMoney) {
        this.monthlyInterestMoney = monthlyInterestMoney;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public BigDecimal getDebt() {
        return debt;
    }

    public void setDebt(BigDecimal debt) {
        this.debt = debt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
