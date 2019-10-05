package duongdd.se06000.p2plendingapplication.presenters;

import duongdd.se06000.p2plendingapplication.model.WalletInformation;
import duongdd.se06000.p2plendingapplication.repository.LendingRepository;
import duongdd.se06000.p2plendingapplication.repository.LendingRepositoryImp;
import duongdd.se06000.p2plendingapplication.util.CallBackData;
import duongdd.se06000.p2plendingapplication.view.WalletInformationView;

public class WalletInformationPresenters {
    private WalletInformationView walletInformationView;
    private LendingRepository lendingRepository;

    public WalletInformationPresenters(WalletInformationView walletInformationView) {
        this.walletInformationView = walletInformationView;
        lendingRepository = new LendingRepositoryImp();
    }

    public void getWalletInformation(String token){
        lendingRepository.getWalletInfo(token, new CallBackData<WalletInformation>() {
            @Override
            public void onSuccess(WalletInformation walletInformation) {
                walletInformationView.loginSuccess(walletInformation);
            }

            @Override
            public void onFail(String message) {
                walletInformationView.loginFail(message);
            }
        });
    }
}
