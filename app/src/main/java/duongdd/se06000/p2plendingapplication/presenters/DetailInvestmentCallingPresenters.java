package duongdd.se06000.p2plendingapplication.presenters;

import duongdd.se06000.p2plendingapplication.model.DetailInvestmentCalling;
import duongdd.se06000.p2plendingapplication.repository.LendingRepository;
import duongdd.se06000.p2plendingapplication.repository.LendingRepositoryImp;
import duongdd.se06000.p2plendingapplication.util.CallBackData;
import duongdd.se06000.p2plendingapplication.view.DetailInvestmentCallingView;

public class DetailInvestmentCallingPresenters {
    DetailInvestmentCallingView detailInvestmentCallingView;
    LendingRepository lendingRepository;

    public DetailInvestmentCallingPresenters(DetailInvestmentCallingView detailInvestmentCallingView) {
            this.detailInvestmentCallingView = detailInvestmentCallingView;
        this.lendingRepository = new LendingRepositoryImp();

    }

    public void getDetailInvestmentCalling(String token, int investmentCompanyID){
        lendingRepository.getDetailCallingInvestment(token, investmentCompanyID, new CallBackData<DetailInvestmentCalling>() {
            @Override
            public void onSuccess(DetailInvestmentCalling detailInvestmentCalling) {
                detailInvestmentCallingView.onSuccess(detailInvestmentCalling);
            }

            @Override
            public void onFail(String message) {
                detailInvestmentCallingView.onFail(message);
            }
        });
    }
}
