package duongdd.se06000.p2plendingapplication.presenters;

import java.util.List;


import duongdd.se06000.p2plendingapplication.model.ListInvestmentCompany;
import duongdd.se06000.p2plendingapplication.repository.LendingRepository;
import duongdd.se06000.p2plendingapplication.repository.LendingRepositoryImp;
import duongdd.se06000.p2plendingapplication.util.CallBackData;
import duongdd.se06000.p2plendingapplication.view.ListInvestmentCompanyView;

public class ListInvestmentCompanyPresenters {
    private ListInvestmentCompanyView listInvestmentCompanyView;
    private LendingRepository lendingRepository;

    public ListInvestmentCompanyPresenters(ListInvestmentCompanyView listInvestmentCompanyView) {
        this.listInvestmentCompanyView = listInvestmentCompanyView;
        this.lendingRepository = new LendingRepositoryImp();
    }

    public void getListInvestmentCompany(String token){
        lendingRepository.getListInvestmentCompany(token, new CallBackData<List<ListInvestmentCompany>>() {
            @Override
            public void onSuccess(List<ListInvestmentCompany> listInvestmentCompanies) {
                listInvestmentCompanyView.onSuccess(listInvestmentCompanies);
            }

            @Override
            public void onFail(String message) {
                listInvestmentCompanyView.onFail(message);
            }
        });
    }
}
