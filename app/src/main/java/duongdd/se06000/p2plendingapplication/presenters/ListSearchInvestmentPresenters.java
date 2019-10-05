package duongdd.se06000.p2plendingapplication.presenters;

import java.util.List;


import duongdd.se06000.p2plendingapplication.model.ListSearchInvestment;
import duongdd.se06000.p2plendingapplication.repository.LendingRepository;
import duongdd.se06000.p2plendingapplication.repository.LendingRepositoryImp;
import duongdd.se06000.p2plendingapplication.util.CallBackData;
import duongdd.se06000.p2plendingapplication.view.ListSearchInvestmentView;

public class ListSearchInvestmentPresenters {
    ListSearchInvestmentView listSearchInvestmentView;
    LendingRepository lendingRepository;

    public ListSearchInvestmentPresenters(ListSearchInvestmentView listSearchInvestmentView) {
        this.listSearchInvestmentView = listSearchInvestmentView;
        this.lendingRepository = new LendingRepositoryImp();
    }

    public void getListSearchInvestment(String token, String keyword, String career, int page){
        lendingRepository.getListSearchInvestment(token, keyword, career, page, new CallBackData<List<ListSearchInvestment>>() {
            @Override
            public void onSuccess(List<ListSearchInvestment> listSearchInvestments) {
                listSearchInvestmentView.onSuccess(listSearchInvestments);
            }

            @Override
            public void onFail(String message) {
                listSearchInvestmentView.onFail(message);
            }
        });
    }
}
