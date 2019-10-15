package duongdd.se06000.p2plendingapplication;



import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.sql.SQLOutput;

import duongdd.se06000.p2plendingapplication.formatter.FormatDecimal;
import duongdd.se06000.p2plendingapplication.model.WalletInformation;
import duongdd.se06000.p2plendingapplication.presenters.WalletInformationPresenters;
import duongdd.se06000.p2plendingapplication.view.WalletInformationView;


public class OverViewFragment extends Fragment implements WalletInformationView {
    private TextView txtInvestorID, txtName, txtTotalAsset, txtInvested, txtLoan, txtTotalDept,txtReceiveMoney;
    private WalletInformationPresenters walletInformationPresenters;
    private String token = "";
    private View view;
   // public static OnMoveNextFragment onMoveNextFragment;
    public View onCreateView( LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        walletInformationPresenters = new WalletInformationPresenters(this);
        Intent intent = getActivity().getIntent();
        token = intent.getStringExtra("TOKEN");
        String role = intent.getStringExtra("ROLE");
        System.out.println("Token: 1234: " + token);


        if(role.equals("BORROWER")) {
            walletInformationPresenters.getWalletInformation(token);
             view = inflater.inflate(R.layout.fragment_over_view_borrower, container, false);
            txtInvestorID = view.findViewById(R.id.txtInvestorID);
            txtName = view.findViewById(R.id.txtName);
            txtTotalAsset = view.findViewById(R.id.txtTotalAsset);
            txtTotalDept = view.findViewById(R.id.txtTotalDept);
            txtReceiveMoney = view.findViewById(R.id.txtReceiveMoney);

        }else if(role.equals("INVESTOR")){
            walletInformationPresenters.getWalletInformation(token);
            view = inflater.inflate(R.layout.fragment_over_view, container, false);
            txtInvestorID = view.findViewById(R.id.txtInvestorID);
            txtName = view.findViewById(R.id.txtName);
            txtTotalAsset = view.findViewById(R.id.txtTotalAsset);
            txtInvested = view.findViewById(R.id.txtInvested);
            txtLoan = view.findViewById(R.id.txtLoan);
        }
        return view;
    }
    @Override
    public void loginSuccess(WalletInformation walletInformation) {
// <<<<<<< duongdd/over-view-borrower
        Intent intent = getActivity().getIntent();
        token = intent.getStringExtra("TOKEN");
        String role = intent.getStringExtra("ROLE");
        if(role.equals("BORROWER")){
            txtInvestorID.setText(String.valueOf(walletInformation.getAccountID()));
            txtName.setText(walletInformation.getName());
            txtTotalAsset.setText(FormatDecimal.formatBigDecimalVND(walletInformation.getAsset()));
            txtTotalDept.setText(FormatDecimal.formatBigDecimalVND(walletInformation.getDebt()));//borrow
            txtReceiveMoney.setText(FormatDecimal.formatBigDecimalVND(walletInformation.getInvestMoneyCompany()));//borrow
        }else if(role.equals("INVESTOR")){
            txtInvestorID.setText(String.valueOf(walletInformation.getAccountID()));
            txtName.setText(walletInformation.getName());
            txtTotalAsset.setText(FormatDecimal.formatBigDecimalVND(walletInformation.getAsset()));
            txtInvested.setText(FormatDecimal.formatBigDecimalVND(walletInformation.getInvestedMoney()));//invest
            txtLoan.setText(FormatDecimal.formatBigDecimalVND(walletInformation.getLoan()));//invest
        }


//         //txtTotalMoney.setText(FormatDecimal.formatBigDecimalVND(walletInformation.getAsset()));


// =======
// //         txtInvestorID.setText(String.valueOf(walletInformation.getAccountID()));
// //         txtName.setText(walletInformation.getName());
// //         txtTotalAsset.setText(FormatDecimal.formatBigDecimalVND(walletInformation.getAsset()));
// //         txtInvested.setText(FormatDecimal.formatBigDecimalVND(walletInformation.getInvestedMoney()));
// //         txtLoan.setText(FormatDecimal.formatBigDecimalVND(walletInformation.getLoan()));
// >>>>>>> master
        //onMoveNextFragment.onClick(walletInformation.getAccountID());
         intent = new Intent(getActivity().getBaseContext(), MainActivity.class);
        // String account = String.valueOf(walletInformation.getAccountID());
        Bundle bundle = new Bundle();
        bundle.putString("TOKEN", token);
       // bundle.putInt("INVESTOR_ID", walletInformation.getAccountID());
        //bundle.putInt("BORROWER_ID", walletInformation.getAccountID());
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
