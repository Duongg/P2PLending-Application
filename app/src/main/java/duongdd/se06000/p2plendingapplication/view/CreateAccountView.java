package duongdd.se06000.p2plendingapplication.view;

import duongdd.se06000.p2plendingapplication.model.Account;

public interface CreateAccountView {
    public void onSuccess(Account account);
    public void onFail(String message);
}
