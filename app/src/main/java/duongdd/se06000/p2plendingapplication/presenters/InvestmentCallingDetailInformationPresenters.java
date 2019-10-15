package duongdd.se06000.p2plendingapplication.presenters;

import duongdd.se06000.p2plendingapplication.model.InvestmentCallingDetailsInformation;
import duongdd.se06000.p2plendingapplication.repository.LendingRepository;
import duongdd.se06000.p2plendingapplication.repository.LendingRepositoryImp;
import duongdd.se06000.p2plendingapplication.util.CallBackData;
import duongdd.se06000.p2plendingapplication.view.InvestmentCallingDetailInformationView;

public class InvestmentCallingDetailInformationPresenters {
    InvestmentCallingDetailInformationView investmentCallingDetailInformationView;
    LendingRepository lendingRepository;

    public InvestmentCallingDetailInformationPresenters(InvestmentCallingDetailInformationView investmentCallingDetailsInformationView) {
        this.investmentCallingDetailInformationView = investmentCallingDetailsInformationView;
        this.lendingRepository = new LendingRepositoryImp();
    }
    public void getCallingInvestmentDetailsInformation(String token, final int investmentCompanyID){
        lendingRepository.getCallingInvestmentDetailsInformation(token, investmentCompanyID, new CallBackData<InvestmentCallingDetailsInformation>() {
            @Override
            public void onSuccess(InvestmentCallingDetailsInformation investmentCallingDetailsInformation) {
                investmentCallingDetailInformationView.onSuccess(investmentCallingDetailsInformation);
            }

            @Override
            public void onFail(String message) {
                investmentCallingDetailInformationView.onFail(message);
            }
        });
    }
}
