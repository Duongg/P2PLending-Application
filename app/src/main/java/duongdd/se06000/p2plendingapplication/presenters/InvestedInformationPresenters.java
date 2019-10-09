package duongdd.se06000.p2plendingapplication.presenters;

import duongdd.se06000.p2plendingapplication.model.InvestedInformation;
import duongdd.se06000.p2plendingapplication.repository.LendingRepository;
import duongdd.se06000.p2plendingapplication.repository.LendingRepositoryImp;
import duongdd.se06000.p2plendingapplication.util.CallBackData;
import duongdd.se06000.p2plendingapplication.view.InvestedInformationView;

public class InvestedInformationPresenters {
    InvestedInformationView investedInformationView;
    LendingRepository lendingRepository;

    public InvestedInformationPresenters(InvestedInformationView investedInformationView) {
        this.investedInformationView = investedInformationView;
        this.lendingRepository = new LendingRepositoryImp();
    }

    public void getInvestedInformation(String token, int investorID){
        lendingRepository.getInvestedDetailInformation(token, investorID, new CallBackData<InvestedInformation>() {
            @Override
            public void onSuccess(InvestedInformation investedInformation) {
                investedInformationView.onSuccess(investedInformation);
            }

            @Override
            public void onFail(String message) {
                investedInformationView.onFail(message);
            }
        });
    }
}
