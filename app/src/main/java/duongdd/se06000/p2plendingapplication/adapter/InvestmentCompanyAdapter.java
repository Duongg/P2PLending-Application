package duongdd.se06000.p2plendingapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import duongdd.se06000.p2plendingapplication.R;
import duongdd.se06000.p2plendingapplication.formatter.FormatDecimal;
import duongdd.se06000.p2plendingapplication.model.ListInvestmentCompany;

public class InvestmentCompanyAdapter extends BaseAdapter {
    private List<ListInvestmentCompany> listInvestmentCompany;


    public void setListInvestmentCompany(List<ListInvestmentCompany> listInvestmentCompany) {
        this.listInvestmentCompany = listInvestmentCompany;
    }

    @Override
    public int getCount() {
        return listInvestmentCompany.size();
    }

    @Override
    public Object getItem(int position) {
        return listInvestmentCompany.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listInvestmentCompany.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.item_investment_company, parent, false);
        }
        ListInvestmentCompany company = listInvestmentCompany.get(position);
        TextView txtName = convertView.findViewById(R.id.txtName);
        TextView txtInvestMoney = convertView.findViewById(R.id.txtInvestMoney);
        TextView txtProfit = convertView.findViewById(R.id.txtProfit);
        txtName.setText(company.getInvestmentName());
        txtInvestMoney.setText(FormatDecimal.formatBigDecimal(company.getInvestMoney()));
        txtProfit.setText(company.getInterestRateInvestor() + "%");
        return convertView;
    }
}
