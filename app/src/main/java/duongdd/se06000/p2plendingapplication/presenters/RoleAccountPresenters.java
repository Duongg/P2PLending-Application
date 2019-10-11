package duongdd.se06000.p2plendingapplication.presenters;

import duongdd.se06000.p2plendingapplication.repository.LendingRepository;
import duongdd.se06000.p2plendingapplication.repository.LendingRepositoryImp;
import duongdd.se06000.p2plendingapplication.util.CallBackData;
import duongdd.se06000.p2plendingapplication.view.RoleAccountView;

public class RoleAccountPresenters {
    private RoleAccountView roleAccountView;
    private LendingRepository lendingRepository;

    public RoleAccountPresenters(RoleAccountView roleAccountView) {
        this.roleAccountView = roleAccountView;
        this.lendingRepository = new LendingRepositoryImp();
    }

    public void getRoleAccount(String token){
        lendingRepository.getRoleAccount(token, new CallBackData<String>() {
            @Override
            public void onSuccess(String s) {
                roleAccountView.onSuccess(s);
            }

            @Override
            public void onFail(String message) {
                roleAccountView.onFail(message);

            }
        });
    }
}
