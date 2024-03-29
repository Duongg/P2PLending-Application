package duongdd.se06000.p2plendingapplication.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import duongdd.se06000.p2plendingapplication.R;
import duongdd.se06000.p2plendingapplication.formatter.DateFormat;
import duongdd.se06000.p2plendingapplication.formatter.FormatDecimal;
import duongdd.se06000.p2plendingapplication.model.InvestorDetail;

public class InformationInvestedAdapter extends BaseAdapter {
    private List<InvestorDetail> listInvestorDetails;

    public void setListInvestorDetails(List<InvestorDetail> listInvestorDetails) {
        this.listInvestorDetails = listInvestorDetails;
    }

    @Override
    public int getCount() {
        return listInvestorDetails.size();
    }

    @Override
    public Object getItem(int position) {
        return listInvestorDetails.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listInvestorDetails.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.item_investor_details, parent, false);
        }
        InvestorDetail company = listInvestorDetails.get(position);
        if(company.getStatus().equals("PENDING")){
            TextView txtDateReceive = convertView.findViewById(R.id.txtDateReceive);
            txtDateReceive.setTextColor(Color.rgb(255,255,255));
            TextView txtPrincipleMoney = convertView.findViewById(R.id.txtPrincipleMoney);
            txtPrincipleMoney.setTextColor(Color.rgb(255,255,255));
            TextView txtLoan = convertView.findViewById(R.id.txtLoan);
            txtLoan.setTextColor(Color.rgb(255,255,255));
            TextView txtReceiveMoney = convertView.findViewById(R.id.txtReceiveMoney);
            txtReceiveMoney.setTextColor(Color.rgb(255,255,255));
            txtDateReceive.setText(DateFormat.formatDate(company.getDisbursementDate()));
            txtPrincipleMoney.setText(FormatDecimal.formatBigDecimal(company.getPrincipleMoneyLeft()));
            txtLoan.setText(FormatDecimal.formatBigDecimal(company.getInterestMoney()));
            txtReceiveMoney.setText(FormatDecimal.formatBigDecimal(company.getDisbursementMoney()));
        }else if(company.getStatus().equals("COMPLETE")){
            TextView txtDateReceive = convertView.findViewById(R.id.txtDateReceive);
            txtDateReceive.setTextColor(Color.rgb(22, 209, 219));
            TextView txtPrincipleMoney = convertView.findViewById(R.id.txtPrincipleMoney);
            txtPrincipleMoney.setTextColor(Color.rgb(22, 209, 219));
            TextView txtLoan = convertView.findViewById(R.id.txtLoan);
            txtLoan.setTextColor(Color.rgb(22, 209, 219));
            TextView txtReceiveMoney = convertView.findViewById(R.id.txtReceiveMoney);
            txtReceiveMoney.setTextColor(Color.rgb(22, 209, 219));
            txtDateReceive.setText(DateFormat.formatDate(company.getDisbursementDate()));
            txtPrincipleMoney.setText(FormatDecimal.formatBigDecimal(company.getPrincipleMoneyLeft()));
            txtLoan.setText(FormatDecimal.formatBigDecimal(company.getInterestMoney()));
            txtReceiveMoney.setText(FormatDecimal.formatBigDecimal(company.getDisbursementMoney()));
        }

        return convertView;
    }
}
