package duongdd.se06000.p2plendingapplication.view;

import duongdd.se06000.p2plendingapplication.model.DetailInvestmentCalling;

public interface DetailInvestmentCallingView {
    public void onSuccess(DetailInvestmentCalling detailInvestmentCalling);
    public void onFail(String message);
}
