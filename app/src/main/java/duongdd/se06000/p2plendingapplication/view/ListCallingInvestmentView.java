package duongdd.se06000.p2plendingapplication.view;

import java.util.List;


import duongdd.se06000.p2plendingapplication.model.ListCallingInvestment;

public interface ListCallingInvestmentView {
    public void onSuccess(List<ListCallingInvestment> callingInvestmentList);
    public void onFail(String message);
}
