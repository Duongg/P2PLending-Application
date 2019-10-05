package duongdd.se06000.p2plendingapplication.view;

import duongdd.se06000.p2plendingapplication.model.InvestmentCompanyDetail;

public interface InvestmentCompanyDetailView {
    public void onSuccess(InvestmentCompanyDetail investmentCompanyDetail);
    public void onFail(String message);
}
