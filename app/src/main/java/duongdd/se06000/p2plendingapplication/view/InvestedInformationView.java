package duongdd.se06000.p2plendingapplication.view;

import duongdd.se06000.p2plendingapplication.model.InvestedInformation;

public interface InvestedInformationView {
    public void onSuccess(InvestedInformation investedInformation);
    public void onFail(String message);
}
