package duongdd.se06000.p2plendingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import duongdd.se06000.p2plendingapplication.formatter.DateFormat;
import duongdd.se06000.p2plendingapplication.formatter.FormatDecimal;
import duongdd.se06000.p2plendingapplication.model.InvestedInformation;
import duongdd.se06000.p2plendingapplication.presenters.InvestedInformationPresenters;
import duongdd.se06000.p2plendingapplication.view.InvestedInformationView;

public class DetailInvestedCompanyActivity extends AppCompatActivity implements InvestedInformationView {
    private InvestedInformationPresenters investedInformationPresenters;
    private TextView txtName, txtInvestmentName, txtCareer, txtPeriod, txtInvestedMoney,
            txtStartDate, txtEndDate, txtLoan, txtLoanReceive, txtProfit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_invested_company);
        investedInformationPresenters = new InvestedInformationPresenters(this);
        txtName = findViewById(R.id.txtName);
        txtInvestmentName = findViewById(R.id.txtInvestmentName);
        txtCareer = findViewById(R.id.txtCareer);
        txtPeriod = findViewById(R.id.txtPeriod);
        txtInvestedMoney = findViewById(R.id.txtInvestedMoney);
        txtStartDate = findViewById(R.id.txtStartDate);
        txtEndDate = findViewById(R.id.txtEndDate);
        txtLoan = findViewById(R.id.txtLoan);
        txtLoanReceive = findViewById(R.id.txtLoanReceive);
        txtProfit = findViewById(R.id.txtProfit);

        initData();
    }

    private void initData(){
        Bundle bundle = getIntent().getExtras();
        String token = bundle.getString("TOKEN");
        int investorDetailsID = bundle.getInt("investorDetailsID");
        investedInformationPresenters.getInvestedInformation(token, investorDetailsID);
    }

    @Override
    public void onSuccess(InvestedInformation investedInformation) {
        txtName.setText(investedInformation.getName());
        txtInvestmentName.setText(investedInformation.getInvestmentName());
        txtCareer.setText(investedInformation.getCareer());
        txtPeriod.setText(String.valueOf(investedInformation.getPeriod()));
        txtProfit.setText(investedInformation.getInterestRateInvestor() + "%");
        txtInvestedMoney.setText(FormatDecimal.formatBigDecimal(investedInformation.getInvestedMoney()));
        txtStartDate.setText(DateFormat.formatDate(investedInformation.getStartDate()));
        txtEndDate.setText(DateFormat.formatDate(investedInformation.getEndDate()));
        txtLoan.setText(FormatDecimal.formatBigDecimal(investedInformation.getProfit()));
        txtLoanReceive.setText(FormatDecimal.formatBigDecimal(investedInformation.getProfitReveive()));
    }

    @Override
    public void onFail(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }
}
