package duongdd.se06000.p2plendingapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import duongdd.se06000.p2plendingapplication.model.ListInvestedCompany;
import duongdd.se06000.p2plendingapplication.R;
import duongdd.se06000.p2plendingapplication.formatter.FormatDecimal;

public class InvestedCompanyAdapter extends BaseAdapter {
    private List<ListInvestedCompany> listInvestedCompanies;


    public void setListInvestedCompanies(List<ListInvestedCompany> listInvestedCompanies) {
        this.listInvestedCompanies = listInvestedCompanies;
    }

    @Override
    public int getCount() {
        return listInvestedCompanies.size();
    }

    @Override
    public Object getItem(int position) {
        return listInvestedCompanies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listInvestedCompanies.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.item_invested_company, parent, false);
        }
        ListInvestedCompany company = listInvestedCompanies.get(position);
        TextView txtInvestmentName = convertView.findViewById(R.id.txtInvestmentName);
        TextView txtInvestedMoney = convertView.findViewById(R.id.txtInvestedMoney);
        TextView txtDate = convertView.findViewById(R.id.txtDate);
        txtInvestmentName.setText(company.getInvestmentName());
        txtInvestedMoney.setText(FormatDecimal.formatBigDecimalVND(company.getInvestedMoney()));
        txtDate.setText((CharSequence) company.getInvestedDate());
        return convertView;
    }
}
