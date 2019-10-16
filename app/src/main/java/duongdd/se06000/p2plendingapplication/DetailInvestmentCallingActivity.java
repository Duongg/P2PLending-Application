package duongdd.se06000.p2plendingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.List;

import duongdd.se06000.p2plendingapplication.formatter.DateFormat;
import duongdd.se06000.p2plendingapplication.formatter.FormatDecimal;
import duongdd.se06000.p2plendingapplication.model.DetailInvestmentCalling;
import duongdd.se06000.p2plendingapplication.model.ListCallingInvestment;
import duongdd.se06000.p2plendingapplication.presenters.DetailInvestmentCallingPresenters;
import duongdd.se06000.p2plendingapplication.presenters.ListCallingInvestmentPresenters;
import duongdd.se06000.p2plendingapplication.view.DetailInvestmentCallingView;
import duongdd.se06000.p2plendingapplication.view.ListCallingInvestmentView;

public class DetailInvestmentCallingActivity extends AppCompatActivity implements DetailInvestmentCallingView {
    private ListCallingInvestmentPresenters listCallingInvestmentPresenters;
    private DetailInvestmentCallingPresenters detailInvestmentCallingPresenters;
    private TextView txtInvestmentName, txtPeriod, txtCareer,txtInvestMoney,txtReceivedMoney, txtRate, txtInvestedDate, txtInvestEndDate, txtStatus;
    private String token;
    private int borrowerID;
    private ListCallingInvestment listCallingInvestment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_investment_calling);
        detailInvestmentCallingPresenters = new DetailInvestmentCallingPresenters(this);
        txtInvestmentName = findViewById(R.id.txtInvestmentName);
        txtPeriod = findViewById(R.id.txtPeriod);
        txtCareer = findViewById(R.id.txtCareer);
        txtInvestMoney = findViewById(R.id.txtInvestMoney);
        txtReceivedMoney = findViewById(R.id.txtInvestedMoney);
        txtRate =findViewById(R.id.txtRate);
        txtInvestedDate = findViewById(R.id.txtStartDate);
        txtInvestEndDate = findViewById(R.id.txtEndDate);
        txtStatus = findViewById(R.id.txtStatus);
        initData();
    }
    private void initData(){
        Bundle bundle = getIntent().getExtras();
        //listCallingInvestment = (ListCallingInvestment) bundle.getSerializable("borrower");
        int investmentCompanyID = bundle.getInt("borrower");
        token = bundle.getString("TOKEN");
        System.out.println("Tokennnnn 123 " + token);
        System.out.println("ID 123" + investmentCompanyID);
       // borrowerID = bundle.getInt("BORROWER_ID");
        detailInvestmentCallingPresenters.getDetailInvestmentCalling(token, investmentCompanyID);
     }

    @Override
    public void onSuccess(DetailInvestmentCalling detailInvestmentCalling) {
        txtStatus.setText(detailInvestmentCalling.getStatus());
        txtInvestmentName.setText(detailInvestmentCalling.getInvestmentName());
        txtPeriod.setText(String.valueOf(detailInvestmentCalling.getPeriod()));
        txtCareer.setText(detailInvestmentCalling.getCareer());
        txtInvestMoney.setText(FormatDecimal.formatBigDecimalVND(detailInvestmentCalling.getInvestMoney()));
        txtReceivedMoney.setText(FormatDecimal.formatBigDecimalVND(detailInvestmentCalling.getInvestedMoney()));
        txtRate.setText(String.valueOf(detailInvestmentCalling.getInterestRateInvestor()));
        txtInvestedDate.setText(DateFormat.formatDate(detailInvestmentCalling.getInvestedDate()));
        txtInvestEndDate.setText(DateFormat.formatDate(detailInvestmentCalling.getInvestedEndDate()));
    }

    @Override
    public void onFail(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }
}
