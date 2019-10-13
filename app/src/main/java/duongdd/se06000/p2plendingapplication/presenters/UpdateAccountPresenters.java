package duongdd.se06000.p2plendingapplication.presenters;

import duongdd.se06000.p2plendingapplication.model.Account;
import duongdd.se06000.p2plendingapplication.repository.LendingRepository;
import duongdd.se06000.p2plendingapplication.repository.LendingRepositoryImp;
import duongdd.se06000.p2plendingapplication.util.CallBackData;
import duongdd.se06000.p2plendingapplication.view.UpdateAccountView;

public class UpdateAccountPresenters {
    private UpdateAccountView updateAccountView;
    private LendingRepository lendingRepository;

    public UpdateAccountPresenters(UpdateAccountView updateAccountView) {
        this.updateAccountView = updateAccountView;
        this.lendingRepository = new LendingRepositoryImp();
    }

    public void updateAccount(String token, Account account){
        lendingRepository.updateAccount(token, account, new CallBackData<Account>() {
            @Override
            public void onSuccess(Account account) {
                updateAccountView.onSuccess(account);
            }

            @Override
            public void onFail(String message) {
                updateAccountView.onFail(message);
            }
        });
    }
}
