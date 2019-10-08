package duongdd.se06000.p2plendingapplication;



import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import duongdd.se06000.p2plendingapplication.formatter.FormatDecimal;
import duongdd.se06000.p2plendingapplication.model.ListInvestmentCompany;
import duongdd.se06000.p2plendingapplication.model.WalletInformation;
import duongdd.se06000.p2plendingapplication.presenters.WalletInformationPresenters;
import duongdd.se06000.p2plendingapplication.view.WalletInformationView;


public class OverViewFragment extends Fragment implements WalletInformationView {
    private TextView txtInvestorID, txtName, txtTotalAsset, txtInvested, txtLoan;
    private WalletInformationPresenters walletInformationPresenters;
    private String token = "";
   // public static OnMoveNextFragment onMoveNextFragment;
    public View onCreateView( LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_over_view, container, false);
        txtInvestorID = view.findViewById(R.id.txtInvestorID);
        txtName = view.findViewById(R.id.txtName);
        txtTotalAsset = view.findViewById(R.id.txtTotalAsset);
        txtInvested = view.findViewById(R.id.txtInvested);
        txtLoan = view.findViewById(R.id.txtLoan);
        walletInformationPresenters = new WalletInformationPresenters(this);
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
        txtInvestorID.setText(String.valueOf(walletInformation.getAccountID()));
        txtName.setText(walletInformation.getName());
        txtTotalAsset.setText(FormatDecimal.formatBigDecimal(walletInformation.getAsset()));
        txtInvested.setText(FormatDecimal.formatBigDecimal(walletInformation.getInvestedMoney()));
        txtLoan.setText(FormatDecimal.formatBigDecimal(walletInformation.getLoan()));
        //onMoveNextFragment.onClick(walletInformation.getAccountID());
        Intent intent = new Intent(getActivity().getBaseContext(), MainActivity.class);
       // String account = String.valueOf(walletInformation.getAccountID());
        Bundle bundle = new Bundle();
        bundle.putString("TOKEN", token);
        bundle.putInt("INVESTOR_ID", walletInformation.getAccountID());
        intent.putExtras(bundle);
        //getActivity().startActivity(intent);
    }

    @Override
    public void loginFail(String messaage) {
        Toast.makeText(getActivity().getApplicationContext(), messaage, Toast.LENGTH_SHORT).show();
    }

//    public interface OnMoveNextFragment{
//        void onClick(int accountId);
//    }
}
