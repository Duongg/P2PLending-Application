package duongdd.se06000.p2plendingapplication.view;

import duongdd.se06000.p2plendingapplication.model.WalletInformation;

public interface WalletInformationView {
    public void loginSuccess(WalletInformation walletInformation);
    public void loginFail(String messaage);
}
