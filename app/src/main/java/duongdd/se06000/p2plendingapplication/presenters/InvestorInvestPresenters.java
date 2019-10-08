package duongdd.se06000.p2plendingapplication.presenters;

import java.math.BigDecimal;

import duongdd.se06000.p2plendingapplication.model.InvestorInvest;
import duongdd.se06000.p2plendingapplication.repository.LendingRepository;
import duongdd.se06000.p2plendingapplication.repository.LendingRepositoryImp;
import duongdd.se06000.p2plendingapplication.util.CallBackData;
import duongdd.se06000.p2plendingapplication.view.InvestorInvestView;

public class InvestorInvestPresenters {
    InvestorInvestView investorInvestView;
    LendingRepository lendingRepository;

    public InvestorInvestPresenters(InvestorInvestView investorInvestView) {
        this.investorInvestView = investorInvestView;
        this.lendingRepository = new LendingRepositoryImp();
    }

    public void investorInvest(String token, int borrowerID, int investmentCompanyID, BigDecimal money){
        lendingRepository.investorInvest(token, borrowerID, investmentCompanyID, money, new CallBackData<InvestorInvest>() {
            @Override
            public void onSuccess(InvestorInvest investorInvest) {
                investorInvestView.onSuccess(investorInvest);
            }

            @Override
            public void onFail(String message) {
                investorInvestView.onFail(message);
            }
        });
    }
}
