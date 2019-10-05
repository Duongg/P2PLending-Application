package duongdd.se06000.p2plendingapplication.presenters;

import java.math.BigDecimal;

import duongdd.se06000.p2plendingapplication.model.CompanyDisbursement;
import duongdd.se06000.p2plendingapplication.repository.LendingRepository;
import duongdd.se06000.p2plendingapplication.repository.LendingRepositoryImp;
import duongdd.se06000.p2plendingapplication.util.CallBackData;
import duongdd.se06000.p2plendingapplication.view.PaymentDisbursementView;


public class PaymentDisbursementPresenters {
    private PaymentDisbursementView paymentDisbursementView;
    private LendingRepository lendingRepository;

    public PaymentDisbursementPresenters(PaymentDisbursementView paymentDisbursementView) {
        this.paymentDisbursementView = paymentDisbursementView;
        this.lendingRepository = new LendingRepositoryImp();
    }

    public void getPaymentDisbursement(String token, int borrowerID, int investmentCompanyID, BigDecimal money, int companyDisbursementID){
        lendingRepository.getPaymentDisbursement(token, borrowerID, investmentCompanyID, money, companyDisbursementID, new CallBackData<CompanyDisbursement>() {
            @Override
            public void onSuccess(CompanyDisbursement companyDisbursement) {
                paymentDisbursementView.onSuccess(companyDisbursement);
            }

            @Override
            public void onFail(String message) {
                paymentDisbursementView.onFail(message);
            }
        });
    }
}
