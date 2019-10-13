package duongdd.se06000.p2plendingapplication.model;



import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;

public class WalletInformation implements Serializable {

    @SerializedName("accountID")
    private int accountID;

    @SerializedName("name")
    private String name;

    @SerializedName("phone")
    private int phone;

    @SerializedName("email")
    private String email;

    @SerializedName("asset")
    private BigDecimal asset; // tổng tiền đang có

    @SerializedName("investedMoney")
    private BigDecimal investedMoney; // tổng tiền investor đã đầu tư

    @SerializedName("loan")
    private BigDecimal loan; // tổng lợi nhuận investor kiếm được

    @SerializedName("investMoneyCompany")
    private BigDecimal investMoneyCompany; // tổng tiền đã được nhận đầu tư

    @SerializedName("debt")
    private BigDecimal debt; // tổng tiền còn nợ của công ty

    public WalletInformation(int accountID, String name, int phone, String email,
                             BigDecimal asset, BigDecimal investedMoney, BigDecimal loan,
                             BigDecimal investMoneyCompany, BigDecimal debt) {
        this.accountID = accountID;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.asset = asset;
        this.investedMoney = investedMoney;
        this.loan = loan;
        this.investMoneyCompany = investMoneyCompany;
        this.debt = debt;
    }

    public WalletInformation() {
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getAsset() {
        return asset;
    }

    public void setAsset(BigDecimal asset) {
        this.asset = asset;
    }

    public BigDecimal getInvestedMoney() {
        return investedMoney;
    }

    public void setInvestedMoney(BigDecimal investedMoney) {
        this.investedMoney = investedMoney;
    }

    public BigDecimal getLoan() {
        return loan;
    }

    public void setLoan(BigDecimal loan) {
        this.loan = loan;
    }

    public BigDecimal getInvestMoneyCompany() {
        return investMoneyCompany;
    }

    public void setInvestMoneyCompany(BigDecimal investMoneyCompany) {
        this.investMoneyCompany = investMoneyCompany;
    }

    public BigDecimal getDebt() {
        return debt;
    }

    public void setDebt(BigDecimal debt) {
        this.debt = debt;
    }
}
