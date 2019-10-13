package duongdd.se06000.p2plendingapplication.presenters;

import duongdd.se06000.p2plendingapplication.model.Account;
import duongdd.se06000.p2plendingapplication.repository.LendingRepository;
import duongdd.se06000.p2plendingapplication.repository.LendingRepositoryImp;
import duongdd.se06000.p2plendingapplication.util.CallBackData;
import duongdd.se06000.p2plendingapplication.view.CreateAccountView;

public class CreateAccountPresenters {
    private CreateAccountView createAccountView;
    private LendingRepository lendingRepository;

    public CreateAccountPresenters(CreateAccountView createAccountView) {
        this.createAccountView = createAccountView;
        this.lendingRepository = new LendingRepositoryImp();
    }

    public void createAccount(Account account){
        lendingRepository.createAccount(account, new CallBackData<Account>() {
            @Override
            public void onSuccess(Account account) {
                createAccountView.onSuccess(account);
            }

            @Override
            public void onFail(String message) {
                createAccountView.onFail(message);
            }
        });
    }
}
