package duongdd.se06000.p2plendingapplication.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class InvestmentCallingDetailsInformation implements Serializable {
    @SerializedName("accountID")
    private int borrowerID;

    @SerializedName("investmentCompanyID")
    private int investmentCompanyID;

    @SerializedName("investmentName")
    private String investmentName;

    @SerializedName("investmentMoneyMonthly")
    private BigDecimal investmentMoneyMonthly;

    @SerializedName("totalDebt")
    private BigDecimal totalDebt;

    @SerializedName("totalPayment")
    private BigDecimal totalPayment;

    @SerializedName("status")
    private String status;

    @SerializedName("disbursementDate")
    private Date disbursementDate;

    public InvestmentCallingDetailsInformation() {
    }

    public InvestmentCallingDetailsInformation(int borrowerID, int investmentCompanyID, String investmentName, BigDecimal investmentMoneyMonthly, BigDecimal totalDebt, BigDecimal totalPayment, String status, Date disbursementDate) {
        this.borrowerID = borrowerID;
        this.investmentCompanyID = investmentCompanyID;
        this.investmentName = investmentName;
        this.investmentMoneyMonthly = investmentMoneyMonthly;
        this.totalDebt = totalDebt;
        this.totalPayment = totalPayment;
        this.status = status;
        this.disbursementDate = disbursementDate;
    }

    public int getBorrowerID() {
        return borrowerID;
    }

    public void setBorrowerID(int borrowerID) {
        this.borrowerID = borrowerID;
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

    public BigDecimal getInvestmentMoneyMonthly() {
        return investmentMoneyMonthly;
    }

    public void setInvestmentMoneyMonthly(BigDecimal investmentMoneyMonthly) {
        this.investmentMoneyMonthly = investmentMoneyMonthly;
    }

    public BigDecimal getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(BigDecimal totalDebt) {
        this.totalDebt = totalDebt;
    }

    public BigDecimal getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(BigDecimal totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDisbursementDate() {
        return disbursementDate;
    }

    public void setDisbursementDate(Date disbursementDate) {
        this.disbursementDate = disbursementDate;
    }
}
