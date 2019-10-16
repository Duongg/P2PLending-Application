package duongdd.se06000.p2plendingapplication.presenters;


import duongdd.se06000.p2plendingapplication.model.CompanyDisbursement;
import duongdd.se06000.p2plendingapplication.repository.LendingRepository;
import duongdd.se06000.p2plendingapplication.repository.LendingRepositoryImp;
import duongdd.se06000.p2plendingapplication.util.CallBackData;
import duongdd.se06000.p2plendingapplication.view.PaymentAllDisbursementView;

public class PaymentAllDisbursementPresenters {
    private PaymentAllDisbursementView paymentAllDisbursementView;
    private LendingRepository lendingRepository;

    public PaymentAllDisbursementPresenters(PaymentAllDisbursementView paymentAllDisbursementView) {
        this.paymentAllDisbursementView = paymentAllDisbursementView;
        this.lendingRepository = new LendingRepositoryImp();
    }

    public void getPaymentAllDisbursement(String token, int investmentCompanyID, int companyDisbursementID){
        lendingRepository.getPaymentAllDisbursement(token, investmentCompanyID, companyDisbursementID, new CallBackData<CompanyDisbursement>() {
            @Override
            public void onSuccess(CompanyDisbursement companyDisbursement) {
                paymentAllDisbursementView.onSuccess(companyDisbursement);
            }

            @Override
            public void onFail(String message) {
                paymentAllDisbursementView.onFail(message);
            }
        });
    }
}
