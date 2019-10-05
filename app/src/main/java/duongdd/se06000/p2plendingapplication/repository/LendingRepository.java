package duongdd.se06000.p2plendingapplication.repository;

import java.math.BigDecimal;
import java.util.List;

import duongdd.se06000.p2plendingapplication.model.CompanyDisbursement;
import duongdd.se06000.p2plendingapplication.model.InvestmentCompanyDetail;
import duongdd.se06000.p2plendingapplication.model.InvestorDetail;
import duongdd.se06000.p2plendingapplication.model.ListCallingInvestment;
import duongdd.se06000.p2plendingapplication.model.ListInvestmentCompany;
import duongdd.se06000.p2plendingapplication.model.ListSearchInvestment;
import duongdd.se06000.p2plendingapplication.model.WalletInformation;
import duongdd.se06000.p2plendingapplication.util.CallBackData;

public interface LendingRepository {

    void login(String username, String password, CallBackData<String> callBackData);

   // void login(String username, String password, CallBackData<Login> callBackData);

    void getWalletInfo(String token, CallBackData<WalletInformation> callBackData);

    void getListInvestmentCompany(String token, int page, CallBackData<List<ListInvestmentCompany>> callBackData);

    void getInvestorDetail(String token, int investorID, CallBackData<InvestorDetail> callBackData);

    void getInvestmentCompanyDetail(String token, int investorID, int investmentCompanyID, CallBackData<InvestmentCompanyDetail> callBackData);

    void getListCallingInvestment(String token, int id, int page, CallBackData<List<ListCallingInvestment>> callBackData);

    void getListSearchInvestment(String token, String keyword, String career, int page, CallBackData<List<ListSearchInvestment>> callBackData);

    void getPaymentAllDisbursement(String token, int borrowerID, int investmentCompanyID, int companyDisbursementID, CallBackData<CompanyDisbursement> callBackData);

    void getPaymentDebtDisbursement(String token, int borrowerID, int investmentCompanyID, int companyDisbursementID, CallBackData<CompanyDisbursement> callBackData);

    void getPaymentDisbursement(String token, int borrowerID, int investmentCompanyID, BigDecimal money, int companyDisbursementID, CallBackData<CompanyDisbursement> callBackData);
}
