package duongdd.se06000.p2plendingapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import java.util.List;

import duongdd.se06000.p2plendingapplication.model.ListInvestedCompany;
import duongdd.se06000.p2plendingapplication.presenters.ListInvestedPresenters;
import duongdd.se06000.p2plendingapplication.view.ListInvestedView;


public class ListInvestedCompanyDetailsFragment extends Fragment implements ListInvestedView {
    ListInvestedPresenters listInvestedPresenters;
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_invested_company_details, container, false);
        listInvestedPresenters = new ListInvestedPresenters(this);
        return view;
    }

    @Override
    public void onSuccess(List<ListInvestedCompany> listInvestmentCompany) {

    }

    @Override
    public void onFail(String message) {

    }
}
