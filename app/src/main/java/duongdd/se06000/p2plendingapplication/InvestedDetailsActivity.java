package duongdd.se06000.p2plendingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import duongdd.se06000.p2plendingapplication.R;
import duongdd.se06000.p2plendingapplication.adapter.InformationInvestedAdapter;
import duongdd.se06000.p2plendingapplication.model.InvestorDetail;
import duongdd.se06000.p2plendingapplication.model.ListInvestedCompany;
import duongdd.se06000.p2plendingapplication.model.Notification;
import duongdd.se06000.p2plendingapplication.presenters.InvestorDetailPresenters;
import duongdd.se06000.p2plendingapplication.view.InvestorDetailView;

public class InvestedDetailsActivity extends AppCompatActivity implements InvestorDetailView {
    private InvestorDetailPresenters investorDetailPresenters;
    private String token = "";
    private int investorDetailsID;
    private InformationInvestedAdapter adapter;
    private ListView listView;
    private Notification notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_invested);
        investorDetailPresenters = new InvestorDetailPresenters(this);
        listView = findViewById(R.id.lvListInvested);
        initData();
    }

    private void initData(){
        Bundle bundle = getIntent().getExtras();
        token = bundle.getString("TOKEN");

        ListInvestedCompany listInvestedCompany = (ListInvestedCompany) bundle.getSerializable("invested");
        if(listInvestedCompany == null){
            Notification notification = (Notification) bundle.getSerializable("investordetailID");
            investorDetailPresenters.investorDetailInformation(token, notification.getInvestorDetailsID());
        }else{
            investorDetailPresenters.investorDetailInformation(token, listInvestedCompany.getInvestorDetailsID());
        }


    }

    @Override
    public void onSuccess(List<InvestorDetail> investorDetail) {
        investorDetailsID = investorDetail.get(0).getInvestorDetailsID();
        adapter = new InformationInvestedAdapter();
        adapter.setListInvestorDetails(investorDetail);
        listView.setAdapter(adapter);
    }

    @Override
    public void onFail(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void clickToView(View view) {
        Intent intent = new Intent(getApplicationContext(), DetailInvestedCompanyActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("TOKEN", token);
        bundle.putInt("investorDetailsID", investorDetailsID);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();

    }
}
