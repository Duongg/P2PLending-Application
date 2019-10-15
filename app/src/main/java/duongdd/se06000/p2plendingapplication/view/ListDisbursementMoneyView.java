package duongdd.se06000.p2plendingapplication.view;

import java.util.List;

import duongdd.se06000.p2plendingapplication.model.CompanyDisbursement;

public interface ListDisbursementMoneyView {
    public void onSuccess(List<CompanyDisbursement> companyDisbursementList);
    public void onFail(String message);

}
