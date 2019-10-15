package duongdd.se06000.p2plendingapplication.presenters;

import java.util.List;

import duongdd.se06000.p2plendingapplication.model.CompanyDisbursement;
import duongdd.se06000.p2plendingapplication.model.InvestmentCallingDetailsInformation;
import duongdd.se06000.p2plendingapplication.repository.LendingRepository;
import duongdd.se06000.p2plendingapplication.repository.LendingRepositoryImp;
import duongdd.se06000.p2plendingapplication.util.CallBackData;
import duongdd.se06000.p2plendingapplication.view.InvestmentCallingDetailInformationView;
import duongdd.se06000.p2plendingapplication.view.ListDisbursementMoneyView;

public class ListDisbursementMoneyPresenters {
    ListDisbursementMoneyView listDisbursementMoneyView;
    LendingRepository lendingRepository;

    public ListDisbursementMoneyPresenters(ListDisbursementMoneyView listDisbursementMoneyView) {
        this.listDisbursementMoneyView = listDisbursementMoneyView;
        this.lendingRepository = new LendingRepositoryImp();
    }

    public void getListDisbursementMoney(String token, final int investmentCompanyID){
        lendingRepository.getListDisbursementMoney(token, investmentCompanyID, new CallBackData<List<CompanyDisbursement>>() {

            @Override
            public void onSuccess(List<CompanyDisbursement> companyDisbursements) {
                listDisbursementMoneyView.onSuccess(companyDisbursements);
            }

            @Override
            public void onFail(String message) {
                listDisbursementMoneyView.onFail(message);
            }
        });
    }
}
