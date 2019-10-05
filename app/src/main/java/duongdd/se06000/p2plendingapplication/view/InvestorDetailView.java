package duongdd.se06000.p2plendingapplication.view;


import duongdd.se06000.p2plendingapplication.model.InvestorDetail;

public interface InvestorDetailView {
    public void onSuccess(InvestorDetail investorDetail);
    public void onFail(String message);
}
