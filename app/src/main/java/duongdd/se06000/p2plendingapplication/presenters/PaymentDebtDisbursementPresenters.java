package duongdd.se06000.p2plendingapplication.presenters;


import duongdd.se06000.p2plendingapplication.model.CompanyDisbursement;
import duongdd.se06000.p2plendingapplication.repository.LendingRepository;
import duongdd.se06000.p2plendingapplication.repository.LendingRepositoryImp;
import duongdd.se06000.p2plendingapplication.util.CallBackData;
import duongdd.se06000.p2plendingapplication.view.PaymentDebtDisbursementView;

public class PaymentDebtDisbursementPresenters {
    private PaymentDebtDisbursementView paymentDebtDisbursementView;
    private LendingRepository lendingRepository;

    public PaymentDebtDisbursementPresenters(PaymentDebtDisbursementView paymentDebtDisbursementView) {
        this.paymentDebtDisbursementView = paymentDebtDisbursementView;
        this.lendingRepository = new LendingRepositoryImp();
    }

    public void getPaymentDebtDisbursement(String token, int borrowerID, int investmentCompanyID, int companyDisbursementID){
        lendingRepository.getPaymentDebtDisbursement(token, borrowerID, investmentCompanyID, companyDisbursementID, new CallBackData<CompanyDisbursement>() {
            @Override
            public void onSuccess(CompanyDisbursement companyDisbursement) {
                paymentDebtDisbursementView.onSuccess(companyDisbursement);
            }

            @Override
            public void onFail(String message) {
                paymentDebtDisbursementView.onFail(message);
            }
        });
    }
}
