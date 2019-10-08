package duongdd.se06000.p2plendingapplication.presenters;

import java.util.List;

import duongdd.se06000.p2plendingapplication.model.ListInvestedCompany;
import duongdd.se06000.p2plendingapplication.repository.LendingRepository;
import duongdd.se06000.p2plendingapplication.repository.LendingRepositoryImp;
import duongdd.se06000.p2plendingapplication.util.CallBackData;
import duongdd.se06000.p2plendingapplication.view.ListInvestedView;

public class ListInvestedPresenters {
    private ListInvestedView listInvestedView;
    private LendingRepository lendingRepository;

    public ListInvestedPresenters(ListInvestedView listInvestedView) {
        this.listInvestedView = listInvestedView;
        this.lendingRepository = new LendingRepositoryImp();
    }

    public void getListInvestedCompany(String token, int page){
        lendingRepository.getListInvestedCompany(token, page, new CallBackData<List<ListInvestedCompany>>() {

            @Override
            public void onSuccess(List<ListInvestedCompany> listInvestedCompanies) {
                listInvestedView.onSuccess(listInvestedCompanies);
            }

            @Override
            public void onFail(String message) {
                listInvestedView.onFail(message);
            }
        });
}

}
