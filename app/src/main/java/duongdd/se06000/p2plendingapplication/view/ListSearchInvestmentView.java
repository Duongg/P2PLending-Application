package duongdd.se06000.p2plendingapplication.view;

import java.util.List;


import duongdd.se06000.p2plendingapplication.model.ListSearchInvestment;

public interface ListSearchInvestmentView {
    public void onSuccess(List<ListSearchInvestment> listSearchInvestments);
    public void onFail(String message);
}
