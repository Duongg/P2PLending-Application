package duongdd.se06000.p2plendingapplication.view;

import duongdd.se06000.p2plendingapplication.model.InvestorInvest;

public interface InvestorInvestView {
    public void onSuccess(InvestorInvest investorInvest);
    public void onFail(String message);
}
