package duongdd.se06000.p2plendingapplication.presenters;


import duongdd.se06000.p2plendingapplication.model.InvestmentCompanyDetail;
import duongdd.se06000.p2plendingapplication.repository.LendingRepository;
import duongdd.se06000.p2plendingapplication.repository.LendingRepositoryImp;
import duongdd.se06000.p2plendingapplication.util.CallBackData;
import duongdd.se06000.p2plendingapplication.view.InvestmentCompanyDetailView;

public class InvestmentCompanyDetailPresenters {
    InvestmentCompanyDetailView investmentCompanyDetailView;
    LendingRepository lendingRepository;

    public InvestmentCompanyDetailPresenters(InvestmentCompanyDetailView investmentCompanyDetailView) {
        this.investmentCompanyDetailView = investmentCompanyDetailView;
        this.lendingRepository = new LendingRepositoryImp();
    }

    public void getInvestmentCompanyDetail(String token, int investorID, int investmentCompanyID ){
        lendingRepository.getInvestmentCompanyDetail(token, investorID, investmentCompanyID, new CallBackData<InvestmentCompanyDetail>() {
            @Override
            public void onSuccess(InvestmentCompanyDetail investmentCompanyDetail) {
                investmentCompanyDetailView.onSuccess(investmentCompanyDetail);
            }

            @Override
            public void onFail(String message) {
                investmentCompanyDetailView.onFail(message);
            }
        });
    }
}
