package duongdd.se06000.p2plendingapplication.view;


import java.util.List;

import duongdd.se06000.p2plendingapplication.model.InvestorDetail;

public interface InvestorDetailView {
    public void onSuccess(List<InvestorDetail> investorDetail);
    public void onFail(String message);
}
