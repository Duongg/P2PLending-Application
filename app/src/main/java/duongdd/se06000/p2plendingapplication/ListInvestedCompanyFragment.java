package duongdd.se06000.p2plendingapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.io.Serializable;
import java.util.List;

import duongdd.se06000.p2plendingapplication.adapter.InvestedCompanyAdapter;
import duongdd.se06000.p2plendingapplication.model.ListInvestedCompany;
import duongdd.se06000.p2plendingapplication.presenters.ListInvestedPresenters;
import duongdd.se06000.p2plendingapplication.view.ListInvestedView;


public class ListInvestedCompanyFragment extends Fragment implements ListInvestedView {
    private ListInvestedPresenters listInvestedPresenters;
    private List<ListInvestedCompany> listInvestedCompanies;
    private String token = "";
    private InvestedCompanyAdapter adapter;
    private ListView listView;

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_invested_company, container, false);
        listInvestedPresenters = new ListInvestedPresenters(this);
        listView = view.findViewById(R.id.lvListInvestedCompany);
        initData();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(getActivity().getBaseContext(), InvestedDetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("TOKEN", token);
                bundle.putSerializable("invested", (Serializable) listInvestedCompanies.get(position));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        return view;
    }

    private void initData(){
        Bundle bundle = getActivity().getIntent().getExtras();
        token = bundle.getString("TOKEN");
        listInvestedPresenters.getListInvestedCompany(token);
    }

    @Override
    public void onSuccess(List<ListInvestedCompany> listInvestmentCompany) {
        listInvestedCompanies = listInvestmentCompany;
        adapter = new InvestedCompanyAdapter();
        adapter.setListInvestedCompanies(listInvestmentCompany);
        listView.setAdapter(adapter);
    }

    @Override
    public void onFail(String message) {
        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
