package duongdd.se06000.p2plendingapplication.view;

import java.util.List;

import duongdd.se06000.p2plendingapplication.model.ListInvestedCompany;

public interface ListInvestedView {
    public void onSuccess(List<ListInvestedCompany> listInvestmentCompany);
    public void onFail(String message);
}
