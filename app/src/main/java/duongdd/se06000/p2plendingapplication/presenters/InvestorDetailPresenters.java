package duongdd.se06000.p2plendingapplication.presenters;

import duongdd.se06000.p2plendingapplication.model.InvestorDetail;
import duongdd.se06000.p2plendingapplication.repository.LendingRepository;
import duongdd.se06000.p2plendingapplication.repository.LendingRepositoryImp;
import duongdd.se06000.p2plendingapplication.util.CallBackData;
import duongdd.se06000.p2plendingapplication.view.InvestorDetailView;

public class InvestorDetailPresenters {

    private InvestorDetailView investorDetailView;
    private LendingRepository lendingRepository;

    public InvestorDetailPresenters(InvestorDetailView investorDetailView) {
        this.investorDetailView = investorDetailView;
        this.lendingRepository = new LendingRepositoryImp();
    }

    public void investorDetailInformation(String token, int investorID){
        lendingRepository.getInvestorDetail(token, investorID, new CallBackData<InvestorDetail>() {
            @Override
            public void onSuccess(InvestorDetail investorDetail) {
                investorDetailView.onSuccess(investorDetail);
            }

            @Override
            public void onFail(String message) {
                investorDetailView.onFail(message);
            }
        });
    }
}
