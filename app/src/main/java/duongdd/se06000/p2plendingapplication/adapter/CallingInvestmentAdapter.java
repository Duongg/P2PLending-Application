package duongdd.se06000.p2plendingapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import duongdd.se06000.p2plendingapplication.R;
import duongdd.se06000.p2plendingapplication.model.ListCallingInvestment;

public class CallingInvestmentAdapter extends BaseAdapter {
    private List<ListCallingInvestment> listCallingInvestments;

    public void setListCallingInvestments(List<ListCallingInvestment> listCallingInvestments) {
        this.listCallingInvestments = listCallingInvestments;
    }

    @Override
    public int getCount() {
        return listCallingInvestments.size();
    }

    @Override
    public Object getItem(int i) {
        return listCallingInvestments.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listCallingInvestments.indexOf(getItemId(i));
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
//        if(view == null){
//            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
//            view = inflater.inflate(R.layout.item_calling_investment, viewGroup, false );
//        }
//        ListCallingInvestment callingInvestment = listCallingInvestments.get(i);
//        TextView txtNameInvestment = view.findViewById(R.id.txtNameInvestment);
//        TextView txtCarreer = view.findViewById(R.id.txtCareer);
//        txtNameInvestment.setText(callingInvestment.getInvestmentName());
//        txtCarreer.setText(callingInvestment.getCareer());

        return view;
    }
}
