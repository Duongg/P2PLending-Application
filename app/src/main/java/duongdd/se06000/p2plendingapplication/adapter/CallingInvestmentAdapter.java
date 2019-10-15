package duongdd.se06000.p2plendingapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import duongdd.se06000.p2plendingapplication.R;
import duongdd.se06000.p2plendingapplication.formatter.FormatDecimal;
import duongdd.se06000.p2plendingapplication.model.ListCallingInvestment;

public class CallingInvestmentAdapter extends BaseAdapter {
    private List<ListCallingInvestment> listCallingInvestment;

    public void setListCallingInvestment(List<ListCallingInvestment> listCallingInvestment) {
        this.listCallingInvestment = listCallingInvestment;
    }

    @Override
    public int getCount() {
        return listCallingInvestment.size();
    }

    @Override
    public Object getItem(int i) {
        return listCallingInvestment.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listCallingInvestment.indexOf(getItem(i));
    }

    @Override

    public View getView(int i, View converView, ViewGroup viewGroup) {
        if(converView == null){
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            converView = inflater.inflate(R.layout.item_calling_investment, viewGroup, false);
        }
        ListCallingInvestment callingInvestment = listCallingInvestment.get(i);
        TextView txtNameInvestment = converView.findViewById(R.id.txtNameInvestment);
        TextView txtInvestedMoney = converView.findViewById(R.id.txtInvestedMoney);
        TextView txtStartDate = converView.findViewById(R.id.txtStartDate);
        txtNameInvestment.setText(callingInvestment.getInvestmentName());
        txtInvestedMoney.setText(FormatDecimal.formatBigDecimal(callingInvestment.getInvestedMoney()));
        txtStartDate.setText((CharSequence) callingInvestment.getInvestedDate());
        return converView;
    }
}