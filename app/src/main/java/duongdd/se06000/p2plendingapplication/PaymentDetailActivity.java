package duongdd.se06000.p2plendingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
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

public class PaymentDetailActivity extends AppCompatActivity implements InvestmentCallingDetailInformationView,
                                                                        ListDisbursementMoneyView,
                                                                        PaymentDisbursementView,
                                                                        PaymentAllDisbursementView,
                                                                        PaymentDebtDisbursementView {
    private TextView txtInvestmentName, txtMoneyToPay, txtDept, txtTotalMoneyToPay;
    private TextView txtMonth, txtDeptMonth, txtPayMonthly, txtDisbursementDate, txtCompanyDisbursementID;
    private EditText edtMoney;
    private RadioButton rbPaybyMonth, rbPayAll;
    private Button btnPay, btnPayDept;
    private InvestmentCallingDetailInformationPresenters investmentCallingDetailInformationPresenters;
    private PaymentAllDisbursementPresenters paymentAllDisbursementPresenters;
    private PaymentDebtDisbursementPresenters paymentDebtDisbursementPresenters;
    private PaymentDisbursementPresenters paymentDisbursementPresenters;
    private CompanyDisbursement companyDisbursement;
    private List<CompanyDisbursement> companyDisbursementsList;
    private DisbursementMoneyAdapter adapter;
    private ListView listView;
    private ListDisbursementMoneyPresenters listDisbursementMoneyPresenters;
    private ListCallingInvestment listCallingInvestment = null;
    private String token, status;
    private int position;
    private int accountID, companyDisbursementID, disbursementIDforDebt;

    private InvestmentCallingDetailsInformation investmentCallingDetailsInformationAA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_detail);

        investmentCallingDetailInformationPresenters = new InvestmentCallingDetailInformationPresenters(this);
        listDisbursementMoneyPresenters = new ListDisbursementMoneyPresenters(this);
        paymentDisbursementPresenters = new PaymentDisbursementPresenters(this);
        paymentAllDisbursementPresenters = new PaymentAllDisbursementPresenters(this);
        paymentDebtDisbursementPresenters = new PaymentDebtDisbursementPresenters(this);

        listView = findViewById(R.id.lvDisbursementMoney);
        initData();
        // ------------------PAY DEPT DISBURSEMENT---
        btnPayDept = findViewById(R.id.btnPayDept);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                System.out.println("123456789");
//                companyDisbursement = (CompanyDisbursement) adapterView.getItemAtPosition(i);
//                disbursementIDforDebt = companyDisbursement.getCompanyDisbursementID();
//                System.out.println("ID DISBURSEMENT " +disbursementIDforDebt);
//            }
//        });


        txtInvestmentName = findViewById(R.id.txtInvestmentName);
        txtMoneyToPay = findViewById(R.id.txtMoneyToPay);
        txtDept = findViewById(R.id.txtDept);
        txtTotalMoneyToPay = findViewById(R.id.txtTotalMoneyToPay);
        txtDisbursementDate = findViewById(R.id.txtDisbursementDate);

        txtMonth = findViewById(R.id.txtMonth);
        txtDeptMonth = findViewById(R.id.txtDeptMonth);
        txtPayMonthly = findViewById(R.id.txtPayMonthly);
        // txtCompanyDisbursementID =findViewById(R.id.txtDisbursementID);

        rbPaybyMonth = findViewById(R.id.rbPaybymonth);
        rbPayAll = findViewById(R.id.rbPayAll);
        edtMoney = findViewById(R.id.edtMoney);
        btnPay = findViewById(R.id.btnPay);


        paymentDetail();



    }

    private void initData() {
        Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();
        listCallingInvestment = (ListCallingInvestment) bundle.getSerializable("borrower");
        token = bundle.getString("TOKEN");
        accountID = bundle.getInt("BORROWER_ID");
        investmentCallingDetailInformationPresenters.getCallingInvestmentDetailsInformation(token, listCallingInvestment.getInvestmentCompanyID());
        listDisbursementMoneyPresenters.getListDisbursementMoney(token, listCallingInvestment.getInvestmentCompanyID());
    }

    @Override
    public void onSuccess(InvestmentCallingDetailsInformation investmentCallingDetailsInformation) {
        txtInvestmentName.setText(investmentCallingDetailsInformation.getInvestmentName());
        txtMoneyToPay.setText(FormatDecimal.formatBigDecimal(investmentCallingDetailsInformation.getInvestmentMoneyMonthly()));
        txtDept.setText(FormatDecimal.formatBigDecimal(investmentCallingDetailsInformation.getTotalDebt()));
        txtTotalMoneyToPay.setText(FormatDecimal.formatBigDecimal(investmentCallingDetailsInformation.getTotalPayment()));
        txtDisbursementDate.setText(DateFormat.formatDate(investmentCallingDetailsInformation.getDisbursementDate()));
        companyDisbursementID = investmentCallingDetailsInformation.getDisbursementCompanyID();
    }


    @Override
    public void onSuccess(List<CompanyDisbursement> companyDisbursementList) {
        companyDisbursementsList = companyDisbursementList;
        adapter = new DisbursementMoneyAdapter();
        adapter.setCompanyDisbursementList(companyDisbursementList);
        listView.setAdapter(adapter);
    }

    @Override
    public void onSuccess(CompanyDisbursement companyDisbursement) {
        showAlertDialog();
    }

    @Override
    public void onFail(String message) {
        showAlertDialogInvalidMoney(message);
    }

    public void clickToDetail(View view) {
        Intent intent = new Intent(getApplicationContext(), DetailInvestmentCallingActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("TOKEN", token);
        //bundle.putSerializable("borrower", listCallingInvestment.getInvestmentCompanyID());
        bundle.putInt("borrower", listCallingInvestment.getInvestmentCompanyID());
        intent.putExtras(bundle);
        startActivity(intent);
    }

    //--------------PAY ALL AND DISBURSEMENT ------------------
    private void paymentDetail() {

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (rbPaybyMonth.isChecked()) {
                    // do pay by month
                    if(edtMoney.getText().toString().trim().isEmpty()){
                        showAlertDialogNotNullMoney();
                    }else {
                        paymentDisbursementPresenters.getPaymentDisbursement(
                                token,
                                listCallingInvestment.getInvestmentCompanyID(),
                                new BigDecimal(edtMoney.getText().toString().trim()),
                                companyDisbursementID);
                    }
                } else if (rbPayAll.isChecked()) {
                    //do pay all
                    edtMoney.setFocusable(false);
                    paymentAllDisbursementPresenters.getPaymentAllDisbursement(
                            token,
                            listCallingInvestment.getInvestmentCompanyID(),
                            companyDisbursementID);
                }


            }
        });
    }
//    private void paydebt(){
//        btnPayDept.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                paymentDebtDisbursementPresenters.getPaymentDebtDisbursement(
//                        token,
//                        listCallingInvestment.getInvestmentCompanyID(),
//                        disbursementIDforDebt);
//                System.out.println("abc");
//                Toast.makeText(PaymentDetailActivity.this,"Pay Debt Successfully", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    public void clickToPayDebt(View view) {
//        System.out.println("Duong oi");
//        position = (int) view.getTag();
//        paymentDebtDisbursementPresenters.getPaymentDebtDisbursement(
//                token,
//                listCallingInvestment.getInvestmentCompanyID(),
//                disbursementIDforDebt);
//        System.out.println("DEPT " + disbursementIDforDebt);
//        Toast.makeText(PaymentDetailActivity.this, "Pay Debt Successfully", Toast.LENGTH_SHORT).show();
    }
    private void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Trả tiền thành công !!");
        builder.setCancelable(false);
        builder.setPositiveButton("Xác nhận", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    private void showAlertDialogInvalidMoney(String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("Xác nhận", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    private void showAlertDialogNotNullMoney(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Vui lòng điền số tiền vào ô nhập tiền !!");
        builder.setCancelable(false);
        builder.setPositiveButton("Xác nhận", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }



}
