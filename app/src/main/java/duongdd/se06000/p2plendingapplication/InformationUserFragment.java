package duongdd.se06000.p2plendingapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import duongdd.se06000.p2plendingapplication.model.WalletInformation;
import duongdd.se06000.p2plendingapplication.presenters.WalletInformationPresenters;
import duongdd.se06000.p2plendingapplication.view.WalletInformationView;


public class InformationUserFragment extends Fragment implements WalletInformationView {
    private WalletInformationPresenters walletInformationPresenters;
    private TextView txtInvestorCode,txtInvestorName, txtInvestorPhone,txtInvestorEmail;
    private String token = "";
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_information_user, container, false);
        walletInformationPresenters = new WalletInformationPresenters(this);
        txtInvestorCode = view.findViewById(R.id.investorCode);
        txtInvestorName = view.findViewById(R.id.investorName);
        txtInvestorPhone = view.findViewById(R.id.investorPhone);
        txtInvestorEmail = view.findViewById(R.id.investorEmail);
        initData();
        return view;
    }
    private void initData(){
        Intent intent = getActivity().getIntent();
        token = intent.getStringExtra("TOKEN");
        walletInformationPresenters.getWalletInformation(token);
    }

    @Override
    public void loginSuccess(WalletInformation walletInformation) {
        txtInvestorCode.setText(String.valueOf(walletInformation.getAccountID()));
        txtInvestorName.setText(walletInformation.getName());
        txtInvestorPhone.setText(String.valueOf(walletInformation.getPhone()));
        txtInvestorEmail.setText(walletInformation.getEmail());
        Intent intent = new Intent(getActivity().getBaseContext(), MainActivity.class);
        intent.putExtra("TOKEN", token);
        intent.putExtra("accountID", walletInformation.getAccountID());
        //startActivity(intent);
    }

    @Override
    public void loginFail(String messaage) {
        Toast.makeText(getActivity().getApplicationContext(), messaage, Toast.LENGTH_SHORT).show();
    }
}
