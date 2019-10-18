package duongdd.se06000.p2plendingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import duongdd.se06000.p2plendingapplication.model.Account;
import duongdd.se06000.p2plendingapplication.presenters.CreateAccountPresenters;
import duongdd.se06000.p2plendingapplication.view.CreateAccountView;

public class RegisterActivity extends AppCompatActivity implements CreateAccountView {
    CreateAccountPresenters createAccountPresenters;
    EditText edtName, edtNumberPhone, edtEmail, edtPassword, edtConfirmPassword, edtUsername;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        createAccountPresenters = new CreateAccountPresenters(this);
        edtName = findViewById(R.id.edtName);
        edtNumberPhone = findViewById(R.id.edtPhoneNumber);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        edtUsername = findViewById(R.id.edtUsername);
        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmPassword();
            }
        });
    }

    private void confirmPassword(){
        if(!edtPassword.getText().toString().equals(edtConfirmPassword.getText().toString())){
            showAlertDialogCheckPassword();
        }else{
            initData();
        }
    }

    private void initData(){
        Intent intent = getIntent();
        String role = intent.getStringExtra("ROLE");
        Account account = new Account();
        account.setAccountID(0);
        account.setName(edtName.getText().toString());
        account.setEmail(edtEmail.getText().toString());
        account.setPassword(edtPassword.getText().toString());
        account.setPhone(edtNumberPhone.getText().toString());
        account.setUsername(edtUsername.getText().toString());
        account.setRole(role);
        createAccountPresenters.createAccount(account);
    }

    @Override
    public void onSuccess(Account account) {
        showAlertDialogSuccess();

    }

    @Override
    public void onFail(String message) {
        showAlertDialogFail();
    }

    public void showAlertDialogCheckPassword() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Mật khẩu nhập lại không đúng");
        builder.setCancelable(false);
        builder.setPositiveButton("Xác nhận", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                edtPassword.setText("");
                edtConfirmPassword.setText("");
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    public void showAlertDialogSuccess() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Đăng kí thành công !!");
        builder.setCancelable(false);
        builder.setPositiveButton("Xác nhận", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    public void showAlertDialogFail() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Đăng kí thất bại !!");
        builder.setCancelable(false);
        builder.setPositiveButton("Xác nhận", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}
