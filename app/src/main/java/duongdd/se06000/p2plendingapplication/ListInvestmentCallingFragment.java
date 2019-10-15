package duongdd.se06000.p2plendingapplication;




import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import duongdd.se06000.p2plendingapplication.adapter.CallingInvestmentAdapter;
import duongdd.se06000.p2plendingapplication.model.DetailInvestmentCalling;
import duongdd.se06000.p2plendingapplication.model.ListCallingInvestment;
import duongdd.se06000.p2plendingapplication.model.ListInvestmentCompany;
import duongdd.se06000.p2plendingapplication.presenters.ListCallingInvestmentPresenters;
import duongdd.se06000.p2plendingapplication.view.ListCallingInvestmentView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListInvestmentCallingFragment extends Fragment implements ListCallingInvestmentView {
    private ListCallingInvestmentPresenters listCallingInvestmentPresenters;
    private List<ListCallingInvestment> listCallingInvestments;
    private String token ="";
    private ListView listView;
    private CallingInvestmentAdapter adapter;
    private int accountID;
    public ListInvestmentCallingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_investment_calling, container, false);
        listCallingInvestmentPresenters = new ListCallingInvestmentPresenters(this);
        listView = view.findViewById(R.id.lvListInvestmentCalling);
        initData();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity().getBaseContext(), PaymentDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("TOKEN", token);
                bundle.putSerializable("borrower",listCallingInvestments.get(i));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        return view;
    }
    private void initData(){
        Bundle bundle = getActivity().getIntent().getExtras();
        token = bundle.getString("TOKEN");
        //accountID = bundle.getInt("BORROWER_ID");
        listCallingInvestmentPresenters.getListCallingInvestment(token);
    }
    @Override
    public void onSuccess(List<ListCallingInvestment> callingInvestmentList) {
        listCallingInvestments  = callingInvestmentList;
        adapter = new CallingInvestmentAdapter();
        adapter.setListCallingInvestment(listCallingInvestments);
        listView.setAdapter(adapter);

    }

    @Override
    public void onFail(String message) {
        Toast.makeText(getActivity().getApplicationContext(), message,Toast.LENGTH_SHORT).show();
    }
}

