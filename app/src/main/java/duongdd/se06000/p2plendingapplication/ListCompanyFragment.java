package duongdd.se06000.p2plendingapplication;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import duongdd.se06000.p2plendingapplication.adapter.InvestmentCompanyAdapter;
import duongdd.se06000.p2plendingapplication.model.ListInvestmentCompany;
import duongdd.se06000.p2plendingapplication.presenters.ListInvestmentCompanyPresenters;
import duongdd.se06000.p2plendingapplication.view.ListInvestmentCompanyView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListCompanyFragment extends Fragment implements ListInvestmentCompanyView {
    private final int REQUEST_CODE = 1000;
    private ListInvestmentCompanyPresenters listInvestmentCompanyPresenters;
    private TextView txtName, txtInvestMoney, txtProfit;
    private List<ListInvestmentCompany> listInvestmentCompanies;
    private String token = "";
    int accountID;
    private InvestmentCompanyAdapter adapter;
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_company, container, false);
        listInvestmentCompanyPresenters = new ListInvestmentCompanyPresenters(this);
        listView = view.findViewById(R.id.lvListCompany);
        initData();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(getActivity().getBaseContext(), DetailCompanyActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("TOKEN", token);
                bundle.putInt("INVESTOR_ID", accountID);
                bundle.putSerializable("investment", (Serializable) listInvestmentCompanies.get(position));
//                intent.putExtra("investment", (Serializable) listInvestmentCompanies.get(position));
//                intent.putExtra("INVESTOR_ID", accountID);
//                intent.putExtra("TOKEN", token);
                intent.putExtras(bundle);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
        return view;
    }
    private void initData(){
        //Intent intent = getActivity().getIntent();
        Bundle bundle = getActivity().getIntent().getExtras();
        token = bundle.getString("TOKEN");
        accountID = bundle.getInt("INVESTOR_ID");
//        token = intent.getStringExtra("TOKEN");
//        accountID = intent.getIntExtra("INVESTOR_ID", 3);
        listInvestmentCompanyPresenters.getListInvestmentCompany(token);
    }

    @Override
    public void onSuccess(List<ListInvestmentCompany> listInvestmentCompany) {
        listInvestmentCompanies = listInvestmentCompany;
        adapter = new InvestmentCompanyAdapter();
        adapter.setListInvestmentCompany(listInvestmentCompany);
        listView.setAdapter(adapter);
    }

    @Override
    public void onFail(String message) {
        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && resultCode == getActivity().RESULT_OK){
            listInvestmentCompanyPresenters.getListInvestmentCompany(token);
        }
    }
}
