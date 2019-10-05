package duongdd.se06000.p2plendingapplication.view;

import java.util.List;


import duongdd.se06000.p2plendingapplication.model.ListInvestmentCompany;

public interface ListInvestmentCompanyView {
    public void onSuccess(List<ListInvestmentCompany> listInvestmentCompany);
    public void onFail(String message);
}
