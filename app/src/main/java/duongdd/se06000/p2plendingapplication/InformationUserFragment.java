package duongdd.se06000.p2plendingapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.Serializable;

import duongdd.se06000.p2plendingapplication.model.Account;
import duongdd.se06000.p2plendingapplication.model.WalletInformation;
import duongdd.se06000.p2plendingapplication.presenters.AccountInformationPresenters;
import duongdd.se06000.p2plendingapplication.presenters.WalletInformationPresenters;
import duongdd.se06000.p2plendingapplication.view.AccountInformationView;
import duongdd.se06000.p2plendingapplication.view.WalletInformationView;


public class InformationUserFragment extends Fragment implements AccountInformationView {
    private AccountInformationPresenters accountInformationPresenters;
    private EditText edtInvestorName, edtInvestorPhone, edtInvestorEmail;
    private TextView txtInvestorCode, txtInvestorName, txtInvestorPhone, txtInvestorEmail;
    private String token = "";
    private Button btnUpdate;
    private Account accountDTO;
    private final int REQUEST_CODE = 9999;

    public View onCreateView(final LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_information_user, container, false);
        accountInformationPresenters = new AccountInformationPresenters(this);
        txtInvestorCode = view.findViewById(R.id.investorCode);
        txtInvestorName = view.findViewById(R.id.investorName);
        txtInvestorPhone = view.findViewById(R.id.investorPhone);
        txtInvestorEmail = view.findViewById(R.id.investorEmail);
        btnUpdate = view.findViewById(R.id.btnUpdateProfile);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getBaseContext(), UpdateInformationUserActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("accountDTO", (Serializable) accountDTO);
                bundle.putString("TOKEN", token);
                intent.putExtras(bundle);
                startActivityForResult(intent, REQUEST_CODE);

            }
        });
        initData();
        return view;
    }
    private void initData(){
        Intent intent = getActivity().getIntent();
        token = intent.getStringExtra("TOKEN");
        accountInformationPresenters.getAccountInformation(token);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
            accountDTO = (Account) data.getSerializableExtra("accountDTO");
            txtInvestorCode.setText(String.valueOf(accountDTO.getAccountID()));
            txtInvestorName.setText(accountDTO.getName());
            txtInvestorPhone.setText(String.valueOf(accountDTO.getPhone()));
            txtInvestorEmail.setText(accountDTO.getEmail());
        }
    }

    @Override
    public void onSuccess(Account account) {
        txtInvestorCode.setText(String.valueOf(account.getAccountID()));
        txtInvestorName.setText(account.getName());
        txtInvestorPhone.setText(String.valueOf(account.getPhone()));
        txtInvestorEmail.setText(account.getEmail());
        accountDTO = account;
        Intent intent = new Intent(getActivity().getBaseContext(), MainActivity.class);
        intent.putExtra("TOKEN", token);
        intent.putExtra("accountID", account.getAccountID());
    }

    @Override
    public void onFail(String message) {
        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
