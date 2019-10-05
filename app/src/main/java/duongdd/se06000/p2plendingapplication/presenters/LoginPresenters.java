package duongdd.se06000.p2plendingapplication.presenters;


import duongdd.se06000.p2plendingapplication.repository.LendingRepository;
import duongdd.se06000.p2plendingapplication.repository.LendingRepositoryImp;
import duongdd.se06000.p2plendingapplication.util.CallBackData;
import duongdd.se06000.p2plendingapplication.view.LoginView;

public class LoginPresenters {
    private LoginView loginView;
    private LendingRepository lendingRepository;

    public LoginPresenters(LoginView loginView) {
        this.loginView = loginView;
        lendingRepository = new LendingRepositoryImp();
    }

    public void login(String username, String password) {
        lendingRepository.login(username, password, new CallBackData<String>() {

            @Override
            public void onSuccess(String s) {
                loginView.loginSuccess(s);
            }

            @Override
            public void onFail(String message) {
                loginView.loginFail(message);
            }
        });
    }
}
