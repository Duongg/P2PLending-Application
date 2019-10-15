package duongdd.se06000.p2plendingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLOutput;
import java.util.List;

import duongdd.se06000.p2plendingapplication.adapter.DisbursementMoneyAdapter;
import duongdd.se06000.p2plendingapplication.formatter.DateFormat;
import duongdd.se06000.p2plendingapplication.formatter.FormatDecimal;
import duongdd.se06000.p2plendingapplication.model.CompanyDisbursement;
import duongdd.se06000.p2plendingapplication.model.InvestmentCallingDetailsInformation;
import duongdd.se06000.p2plendingapplication.model.InvestorDetail;
import duongdd.se06000.p2plendingapplication.model.ListCallingInvestment;
import duongdd.se06000.p2plendingapplication.presenters.InvestmentCallingDetailInformationPresenters;
import duongdd.se06000.p2plendingapplication.presenters.ListDisbursementMoneyPresenters;
import duongdd.se06000.p2plendingapplication.presenters.PaymentAllDisbursementPresenters;
import duongdd.se06000.p2plendingapplication.presenters.PaymentDebtDisbursementPresenters;
import duongdd.se06000.p2plendingapplication.presenters.PaymentDisbursementPresenters;
import duongdd.se06000.p2plendingapplication.view.InvestmentCallingDetailInformationView;
import duongdd.se06000.p2plendingapplication.view.ListDisbursementMoneyView;
import duongdd.se06000.p2plendingapplication.view.PaymentAllDisbursementView;
import duongdd.se06000.p2plendingapplication.view.PaymentDebtDisbursementView;
import duongdd.se06000.p2plendingapplication.view.PaymentDisbursementView;

public class PaymentDetailActivity extends AppCompatActivity implements InvestmentCallingDetailInformationView, ListDisbursementMoneyView {
    private TextView txtInvestmentName, txtMoneyToPay, txtDept, txtTotalMoneyToPay;
    private TextView txtMonth, txtDeptMonth,txtPayMonthly, txtTotalMoney, txtDisbursementDate;
    private InvestmentCallingDetailInformationPresenters investmentCallingDetailInformationPresenters;
    private List<CompanyDisbursement> companyDisbursementsList;
    private DisbursementMoneyAdapter adapter;
    private ListView listView;
    private ListDisbursementMoneyPresenters listDisbursementMoneyPresenters;
    private ListCallingInvestment listCallingInvestment = null;
    private String token;
    private int accountID, investmentCompanyID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_detail);

        investmentCallingDetailInformationPresenters = new InvestmentCallingDetailInformationPresenters(this);
        listDisbursementMoneyPresenters = new ListDisbursementMoneyPresenters(this);
        listView= findViewById(R.id.lvDisbursementMoney);
        initData();
        txtInvestmentName = findViewById(R.id.txtInvestmentName);
        txtMoneyToPay = findViewById(R.id.txtMoneyToPay);
        txtDept = findViewById(R.id.txtDept);
        txtTotalMoneyToPay = findViewById(R.id.txtTotalMoneyToPay);
        txtDisbursementDate = findViewById(R.id.txtDisbursementDate);

        txtMonth = findViewById(R.id.txtMonth);
        txtDeptMonth = findViewById(R.id.txtDeptMonth);
        txtPayMonthly = findViewById(R.id.txtPayMonthly);


    }
    private void initData(){
        Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();
        listCallingInvestment = (ListCallingInvestment) bundle.getSerializable("borrower");
        token = bundle.getString("TOKEN");

        System.out.println("Token 123: " + token);

        accountID = bundle.getInt("BORROWER_ID");

        System.out.println("INVESTMENT COMPANY ID: " + listCallingInvestment.getInvestmentCompanyID());
        investmentCallingDetailInformationPresenters.getCallingInvestmentDetailsInformation(token, listCallingInvestment.getInvestmentCompanyID());
        listDisbursementMoneyPresenters.getListDisbursementMoney(token, listCallingInvestment.getInvestmentCompanyID());
        System.out.println("TOKEN " + token);
        System.out.println("ID " + listCallingInvestment.getInvestmentCompanyID());
    }

    @Override
    public void onSuccess(InvestmentCallingDetailsInformation investmentCallingDetailsInformation) {
        txtInvestmentName.setText(investmentCallingDetailsInformation.getInvestmentName());
        txtMoneyToPay.setText(FormatDecimal.formatBigDecimalVND(investmentCallingDetailsInformation.getInvestmentMoneyMonthly()));
        txtDept.setText(FormatDecimal.formatBigDecimalVND(investmentCallingDetailsInformation.getTotalDebt()));
        txtTotalMoneyToPay.setText(FormatDecimal.formatBigDecimalVND(investmentCallingDetailsInformation.getTotalPayment()));
        txtDisbursementDate.setText(DateFormat.formatDate(investmentCallingDetailsInformation.getDisbursementDate()));
    }


    @Override
    public void onSuccess(List<CompanyDisbursement> companyDisbursementList) {
         companyDisbursementsList = companyDisbursementList;
        System.out.println(companyDisbursementList.size() + " SIZE");
        adapter = new DisbursementMoneyAdapter();
        adapter.setCompanyDisbursementList(companyDisbursementList);
        listView.setAdapter(adapter);
    }

    @Override
    public void onFail(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void clickToDetail(View view) {
        Intent intent = new Intent(getApplicationContext(), DetailInvestmentCallingActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("TOKEN", token);
       //bundle.putSerializable("borrower", listCallingInvestment.getInvestmentCompanyID());
       bundle.putInt("borrower", listCallingInvestment.getInvestmentCompanyID());
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }
}
