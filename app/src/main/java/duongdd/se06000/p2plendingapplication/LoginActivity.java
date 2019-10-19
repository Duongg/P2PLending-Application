package duongdd.se06000.p2plendingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import duongdd.se06000.p2plendingapplication.model.Login;
import duongdd.se06000.p2plendingapplication.presenters.LoginPresenters;
import duongdd.se06000.p2plendingapplication.presenters.RoleAccountPresenters;
import duongdd.se06000.p2plendingapplication.view.LoginView;
import duongdd.se06000.p2plendingapplication.view.RoleAccountView;

public class LoginActivity extends AppCompatActivity implements LoginView, RoleAccountView {
    private LoginPresenters loginPresenters;
    private String token;
    private RoleAccountPresenters roleAccountPresenters;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginPresenters = new LoginPresenters(this);
        roleAccountPresenters = new RoleAccountPresenters(this);
        username = findViewById(R.id.edtUsername);
        password = findViewById(R.id.edtPassword);
    }

    public void clickToLogin(View view) {
        loginPresenters.login(username.getText().toString(), password.getText().toString());

    }

    @Override
    public void loginSuccess(String s) {
        token = s;
        roleAccountPresenters.getRoleAccount(s);
    }

    @Override
    public void loginFail(String messaage) {
        Toast.makeText(this, messaage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(String role) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("TOKEN", token);
        intent.putExtra("ROLE", role);
        startActivity(intent);
        finish();
    }

    @Override
    public void onFail(String message) {

    }

    public void clickToRegister(View view) {
        showAlertDialog();
    }

    public void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Bạn muốn đăng kí với vài trò..");
        builder.setCancelable(false);
        builder.setPositiveButton("Doanh nghiệp", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                intent.putExtra("ROLE", "BORROWER");
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Nhà đầu tư", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                intent.putExtra("ROLE", "INVESTOR");
                startActivity(intent);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


    public void clickToShow(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Vui lòng liên hệ với P2P Lending support qua số điện thoại 0987654321 để được hỗ trợ.");
        builder.setCancelable(false);
        builder.setPositiveButton("Thoát", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
