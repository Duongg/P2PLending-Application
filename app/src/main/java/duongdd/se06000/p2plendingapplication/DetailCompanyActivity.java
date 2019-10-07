package duongdd.se06000.p2plendingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import duongdd.se06000.p2plendingapplication.formatter.FormatDecimal;
import duongdd.se06000.p2plendingapplication.model.InvestmentCompanyDetail;
import duongdd.se06000.p2plendingapplication.model.ListInvestmentCompany;
import duongdd.se06000.p2plendingapplication.presenters.InvestmentCompanyDetailPresenters;
import duongdd.se06000.p2plendingapplication.view.InvestmentCompanyDetailView;

public class DetailCompanyActivity extends AppCompatActivity implements InvestmentCompanyDetailView {
    private InvestmentCompanyDetailPresenters investmentCompanyDetailPresenters;
    private TextView txtBorrowerName, txtInvestmentName, txtCareer, txtPeriod, txtProfit,
            txtInvestMoney, txtStartDate, txtInvestorInvestMoney, txtAvailableMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_company);
        investmentCompanyDetailPresenters = new InvestmentCompanyDetailPresenters(this);
        txtBorrowerName = findViewById(R.id.txtBorrowerName);
        txtInvestmentName = findViewById(R.id.txtInvestmentName);
        txtCareer = findViewById(R.id.txtCareer);
        txtPeriod = findViewById(R.id.txtPeriod);
        txtProfit = findViewById(R.id.txtProfit);
        txtInvestMoney = findViewById(R.id.txtInvestMoney);
        txtStartDate = findViewById(R.id.txtStartDate);
        txtInvestorInvestMoney = findViewById(R.id.txtInvestorInvestMoney);
        txtAvailableMoney = findViewById(R.id.txtAvailableMoney);

        initData();

    }

    private void initData(){
        Intent intent = getIntent();
        ListInvestmentCompany investmentCompany = (ListInvestmentCompany) intent.getSerializableExtra("investment");
        String token = intent.getStringExtra("TOKEN");
        investmentCompanyDetailPresenters.getInvestmentCompanyDetail(token, investmentCompany.getAccountID(), investmentCompany.getInvestmentCompanyID());
    }

    @Override
    public void onSuccess(InvestmentCompanyDetail investmentCompanyDetail) {
        txtBorrowerName.setText(investmentCompanyDetail.getName());
        txtInvestmentName.setText(investmentCompanyDetail.getInvestmentName());
        txtCareer.setText(investmentCompanyDetail.getCareer());
        txtPeriod.setText(investmentCompanyDetail.getPeriod() + "");
        txtProfit.setText(investmentCompanyDetail.getInterestRateInvestor() + "%");
        txtInvestMoney.setText(FormatDecimal.formatBigDecimal(investmentCompanyDetail.getInvestMoney()));
        txtStartDate.setText((CharSequence) investmentCompanyDetail.getInvestedDate());
        txtInvestorInvestMoney.setText(FormatDecimal.formatBigDecimal(investmentCompanyDetail.getInvestorInvestMoney()));
        txtAvailableMoney.setText(FormatDecimal.formatBigDecimal(investmentCompanyDetail.getAvailableMoney()));
    }

    @Override
    public void onFail(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
