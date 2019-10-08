package duongdd.se06000.p2plendingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

import duongdd.se06000.p2plendingapplication.formatter.DateFormat;
import duongdd.se06000.p2plendingapplication.formatter.FormatDecimal;
import duongdd.se06000.p2plendingapplication.model.InvestmentCompanyDetail;
import duongdd.se06000.p2plendingapplication.model.InvestorInvest;
import duongdd.se06000.p2plendingapplication.model.ListInvestmentCompany;
import duongdd.se06000.p2plendingapplication.presenters.InvestmentCompanyDetailPresenters;
import duongdd.se06000.p2plendingapplication.presenters.InvestorInvestPresenters;
import duongdd.se06000.p2plendingapplication.util.ConfigApi;
import duongdd.se06000.p2plendingapplication.view.InvestmentCompanyDetailView;
import duongdd.se06000.p2plendingapplication.view.InvestorInvestView;

public class DetailCompanyActivity extends AppCompatActivity implements InvestmentCompanyDetailView, InvestorInvestView{
    private InvestmentCompanyDetailPresenters investmentCompanyDetailPresenters;
    private InvestorInvestPresenters investorInvestPresenters;
    private TextView txtBorrowerName, txtInvestmentName, txtCareer, txtPeriod, txtProfit,
            txtInvestMoney, txtStartDate, txtInvestorInvestMoney, txtAvailableMoney;
    private Button btnInvest;
    private EditText edtMoney;
    private String token = "";
    private int investorID = 1;
    private ListInvestmentCompany investmentCompany = null;
    private InvestmentCompanyDetail investmentCompanyDetail = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_company);
        investmentCompanyDetailPresenters = new InvestmentCompanyDetailPresenters(this);
        investorInvestPresenters = new InvestorInvestPresenters(this);
        txtBorrowerName = findViewById(R.id.txtBorrowerName);
        txtInvestmentName = findViewById(R.id.txtInvestmentName);
        txtCareer = findViewById(R.id.txtCareer);
        txtPeriod = findViewById(R.id.txtPeriod);
        txtProfit = findViewById(R.id.txtProfit);
        txtInvestMoney = findViewById(R.id.txtInvestMoney);
        txtStartDate = findViewById(R.id.txtStartDate);
        txtInvestorInvestMoney = findViewById(R.id.txtInvestorInvestMoney);
        txtAvailableMoney = findViewById(R.id.txtAvailableMoney);
        btnInvest = findViewById(R.id.btnInvest);
        edtMoney = findViewById(R.id.edtMoney);
        initData();

    }

    private void initData(){
        Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();
        investmentCompany = (ListInvestmentCompany) bundle.getSerializable("investment");
        token = bundle.getString("TOKEN");
        investorID = bundle.getInt("INVESTOR_ID");
//        investmentCompany = (ListInvestmentCompany) intent.getSerializableExtra("investment");
//        token = intent.getStringExtra("TOKEN");
//        investorID = intent.getIntExtra("INVESTOR_ID", 1);
        investmentCompanyDetailPresenters.getInvestmentCompanyDetail(token, investmentCompany.getInvestmentCompanyID());
    }

    @Override
    public void onSuccess(InvestmentCompanyDetail investmentCompanyDetail) {
        investmentCompanyDetail = investmentCompanyDetail;
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
    public void onSuccess(InvestorInvest investorInvest) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("TOKEN", token);
        startActivity(intent);
    }

    @Override
    public void onFail(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void clickToInvest(View view) {
        investorInvestPresenters.investorInvest(token,
                investmentCompany.getAccountID(), investmentCompany.getInvestmentCompanyID(), new BigDecimal(edtMoney.getText().toString().trim()));
        showAlertDialog();
    }

    public void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Đầu tư thành công !!");
        builder.setCancelable(false);
        builder.setPositiveButton("Xác nhận", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("TOKEN", token);
                startActivity(intent);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}
