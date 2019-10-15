package duongdd.se06000.p2plendingapplication.view;

import duongdd.se06000.p2plendingapplication.model.Account;

public interface AccountInformationView {
    public void onSuccess(Account account);
    public void onFail(String message);
}
