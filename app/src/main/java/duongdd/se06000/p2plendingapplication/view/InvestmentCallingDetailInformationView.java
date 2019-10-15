package duongdd.se06000.p2plendingapplication.view;

import java.util.List;

import duongdd.se06000.p2plendingapplication.model.InvestmentCallingDetailsInformation;

public interface InvestmentCallingDetailInformationView {
    public void onSuccess(InvestmentCallingDetailsInformation investmentCallingDetailsInformation);
    public void onFail(String message);
}
