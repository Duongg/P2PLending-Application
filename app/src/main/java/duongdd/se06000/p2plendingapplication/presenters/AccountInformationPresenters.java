package duongdd.se06000.p2plendingapplication.presenters;

import duongdd.se06000.p2plendingapplication.model.Account;
import duongdd.se06000.p2plendingapplication.repository.LendingRepository;
import duongdd.se06000.p2plendingapplication.repository.LendingRepositoryImp;
import duongdd.se06000.p2plendingapplication.util.CallBackData;
import duongdd.se06000.p2plendingapplication.view.AccountInformationView;

public class AccountInformationPresenters {
    private AccountInformationView accountInformationView;
    private LendingRepository lendingRepository;

    public AccountInformationPresenters(AccountInformationView accountInformationView) {
        this.accountInformationView = accountInformationView;
        this.lendingRepository = new LendingRepositoryImp();
    }
    public void getAccountInformation(String token){
        lendingRepository.getAccountInformation(token, new CallBackData<Account>() {
            @Override
            public void onSuccess(Account account) {
                accountInformationView.onSuccess(account);
            }

            @Override
            public void onFail(String message) {
                accountInformationView.onFail(message);
            }
        });
    }
}
