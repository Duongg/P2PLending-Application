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

import duongdd.se06000.p2plendingapplication.model.Account;
import duongdd.se06000.p2plendingapplication.model.WalletInformation;
import duongdd.se06000.p2plendingapplication.presenters.UpdateAccountPresenters;
import duongdd.se06000.p2plendingapplication.view.UpdateAccountView;

public class UpdateInformationUserActivity extends AppCompatActivity implements UpdateAccountView {
    private EditText edtInvestorName, edtInvestorPhone, edtInvestorEmail,edtPassword, edtConfirmPassword;
    private TextView txtInvestorCode;
    private Button btnUpdate;
    private Account accountAfterUpdate;
    private Account accountDTO;
    private String token;
    private UpdateAccountPresenters updateAccountPresenters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_information_user);
        updateAccountPresenters = new UpdateAccountPresenters(this);
        edtInvestorName = findViewById(R.id.investorName);
        edtInvestorPhone = findViewById(R.id.investorPhone);
        edtInvestorEmail = findViewById(R.id.investorEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        txtInvestorCode = findViewById(R.id.investorCode);
        btnUpdate = findViewById(R.id.btnUpdate);

        Bundle bundle = getIntent().getExtras();
        Account account = (Account) bundle.getSerializable("accountDTO");
        token = bundle.getString("TOKEN");
        accountDTO = account;
        txtInvestorCode.setText(String.valueOf(account.getAccountID()));
        edtInvestorName.setText(account.getName().toString());
        edtInvestorEmail.setText(account.getEmail().toString());
        edtInvestorPhone.setText(String.valueOf(account.getPhone()));
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmPassword();

            }
        });
    }

    private void confirmPassword(){
        if(!edtPassword.getText().toString().trim().equals(edtConfirmPassword.getText().toString().trim())){
            showAlertDialogCheckPassword();

        }else if(edtPassword.getText().toString().trim().equals("aaaaa")){
            initDataNotChangePassword();
        }else if(edtPassword.getText().toString().trim().length() < 6){
            showAlertDialogWeakPassword();
        }else{
            initDataChangePassword();
        }

    }


    private void initDataChangePassword(){
        Account account = new Account();
        account.setAccountID(accountDTO.getAccountID());
        account.setRole(accountDTO.getRole());
        account.setUsername(accountDTO.getUsername());
        account.setPhone(edtInvestorPhone.getText().toString());
        account.setPassword(edtPassword.getText().toString());
        account.setEmail(edtInvestorEmail.getText().toString());
        account.setName(edtInvestorName.getText().toString());
        updateAccountPresenters.updateAccount(token,account);

    }

    private void initDataNotChangePassword(){
        Account account = new Account();
        account.setAccountID(accountDTO.getAccountID());
        account.setRole(accountDTO.getRole());
        account.setUsername(accountDTO.getUsername());
        account.setPhone(edtInvestorPhone.getText().toString());
        account.setPassword(accountDTO.getPassword());
        account.setEmail(edtInvestorEmail.getText().toString());
        account.setName(edtInvestorName.getText().toString());
        updateAccountPresenters.updateAccount(token,account);

    }
    public void showAlertDialogCheckPassword() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Mật khẩu nhập lại không đúng");
        builder.setCancelable(false);
        builder.setPositiveButton("Xác nhận", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                edtPassword.setText("aaaaa");
                edtConfirmPassword.setText("aaaaa");
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


    public void showAlertDialogWeakPassword() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Mật khẩu yếu, vui lòng chọn mật khẩu khác");
        builder.setCancelable(false);
        builder.setPositiveButton("Xác nhận", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                edtPassword.setText("aaaaa");
                edtConfirmPassword.setText("aaaaa");
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public void finish() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("accountDTO", accountAfterUpdate);
        bundle.putSerializable("TOKEN", token);
        intent.putExtras(bundle);
        this.setResult(RESULT_OK, intent);
        super.finish();
    }

    public void showAlertDialogSuccess() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Cập Nhập Thành Công!!");
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

    public void showAlertDialogFail() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Cập nhật không thành công");
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

    @Override
    public void onSuccess(Account account) {
        accountAfterUpdate = account;
        showAlertDialogSuccess();
    }

    @Override
    public void onFail(String message) {
        showAlertDialogFail();
    }
}
