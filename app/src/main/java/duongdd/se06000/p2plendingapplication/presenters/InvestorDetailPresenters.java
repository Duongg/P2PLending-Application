package duongdd.se06000.p2plendingapplication.presenters;

import java.util.List;

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

    public void investorDetailInformation(String token, int investorDetailsID){
        lendingRepository.getInvestorDetail(token, investorDetailsID, new CallBackData<List<InvestorDetail>>() {
            @Override
            public void onSuccess(List<InvestorDetail> investorDetail) {
                investorDetailView.onSuccess(investorDetail);
            }

            @Override
            public void onFail(String message) {
                investorDetailView.onFail(message);
            }
        });
    }
}
