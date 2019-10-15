package duongdd.se06000.p2plendingapplication.presenters;

import java.util.List;


import duongdd.se06000.p2plendingapplication.model.ListCallingInvestment;
import duongdd.se06000.p2plendingapplication.repository.LendingRepository;
import duongdd.se06000.p2plendingapplication.repository.LendingRepositoryImp;
import duongdd.se06000.p2plendingapplication.util.CallBackData;
import duongdd.se06000.p2plendingapplication.view.ListCallingInvestmentView;

public class ListCallingInvestmentPresenters {
    private ListCallingInvestmentView listCallingInvestmentView;
    private LendingRepository lendingRepository;

    public ListCallingInvestmentPresenters(ListCallingInvestmentView listCallingInvestmentView) {
        this.listCallingInvestmentView = listCallingInvestmentView;
        this.lendingRepository = new LendingRepositoryImp();
    }

    public void getListCallingInvestment(String token){
        lendingRepository.getListCallingInvestment(token, new CallBackData<List<ListCallingInvestment>>() {
            @Override
            public void onSuccess(List<ListCallingInvestment> listCallingInvestments) {
                listCallingInvestmentView.onSuccess(listCallingInvestments);
            }

            @Override
            public void onFail(String message) {
                listCallingInvestmentView.onFail(message);
            }
        });
    }
}
