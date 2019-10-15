package duongdd.se06000.p2plendingapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import duongdd.se06000.p2plendingapplication.R;
import duongdd.se06000.p2plendingapplication.formatter.DateFormat;
import duongdd.se06000.p2plendingapplication.formatter.FormatDecimal;
import duongdd.se06000.p2plendingapplication.model.CompanyDisbursement;

public class DisbursementMoneyAdapter extends BaseAdapter {
    private List<CompanyDisbursement> companyDisbursementList;

    public void setCompanyDisbursementList(List<CompanyDisbursement> companyDisbursementList) {
        this.companyDisbursementList = companyDisbursementList;
    }

    @Override
    public int getCount() {
        return companyDisbursementList.size();
    }

    @Override
    public Object getItem(int i) {
        return companyDisbursementList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return companyDisbursementList.indexOf(getItem(i));
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            view = inflater.inflate(R.layout.item_list_disbursement_money, viewGroup, false);
        }
       CompanyDisbursement companyDisbursement = companyDisbursementList.get(i);
        TextView txtMonth = view.findViewById(R.id.txtMonth);
        TextView txtPayMonthly = view.findViewById(R.id.txtPayMonthly);
        TextView txtDeptMonth = view.findViewById(R.id.txtDeptMonth);
        Button btnPayToMonth = view.findViewById(R.id.btnPay);

        txtMonth.setText(DateFormat.formatDate(companyDisbursement.getDisbursementDate()));
        txtPayMonthly.setText(FormatDecimal.formatBigDecimal(companyDisbursement.getDisbursementMoney()));
        txtDeptMonth.setText(FormatDecimal.formatBigDecimal(companyDisbursement.getDebt()));

        return view;
    }
}
