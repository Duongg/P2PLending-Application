package duongdd.se06000.p2plendingapplication.view;


import duongdd.se06000.p2plendingapplication.model.CompanyDisbursement;

public interface PaymentDisbursementView {
    public void onSuccess(CompanyDisbursement companyDisbursement);
    public void onFail(String message);
}
