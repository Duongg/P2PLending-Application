package duongdd.se06000.p2plendingapplication;

import androidx.appcompat.app.AppCompatActivity;

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
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        intent.putExtra("TOKEN", token);
        intent.putExtra("ROLE", role);
        startActivity(intent);
        finish();
    }

    @Override
    public void onFail(String message) {

    }
}
