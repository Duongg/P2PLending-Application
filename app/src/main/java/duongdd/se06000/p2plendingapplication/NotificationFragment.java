package duongdd.se06000.p2plendingapplication;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import duongdd.se06000.p2plendingapplication.adapter.NotificationApdater;
import duongdd.se06000.p2plendingapplication.model.DetailInvestmentCalling;
import duongdd.se06000.p2plendingapplication.model.Notification;
import duongdd.se06000.p2plendingapplication.presenters.NotificationPresenters;
import duongdd.se06000.p2plendingapplication.view.NotificationView;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment implements NotificationView {

private NotificationPresenters notificationPresenters;
private List<Notification> listNotification;
private Notification notification;
private NotificationApdater apdater;
private String token ="";
private TextView txtNotification;
private View view;
private ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        notificationPresenters = new NotificationPresenters(this);
        view = inflater.inflate(R.layout.fragment_notification, container, false);
        listView = view.findViewById(R.id.lvNotification);
        Intent intent = getActivity().getIntent();
        token = intent.getStringExtra("TOKEN");
        String role = intent.getStringExtra("ROLE");



        if(role.equals("BORROWER")){
            notificationPresenters.getNotification(token);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Notification itemNotification1 = (Notification) adapterView.getItemAtPosition(i);
                    Intent intent1 = new Intent(getActivity().getBaseContext(), DetailInvestmentCallingActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("TOKEN", token);
                 //  bundle.putSerializable("investmentID",listNotification.get(i));
                    bundle.putSerializable("investordetailID", itemNotification1);
                    intent1.putExtras(bundle);
                    startActivity(intent1);
                }
            });

        }else if(role.equals("INVESTOR")){
            notificationPresenters.getNotification(token);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Notification itemNotification = (Notification) adapterView.getItemAtPosition(i);
                    Intent intent2 = new Intent(getActivity().getBaseContext(), InvestedDetailsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("TOKEN", token);
                    //bundle.putSerializable("investor",listNotification.get(i));
                    bundle.putSerializable("investordetailID", itemNotification);
                    intent2.putExtras(bundle);
                    startActivity(intent2);
                }
            });
        }
       return view;
    }


    @Override
    public void onSuccess(List<Notification> notificationList) {
        listNotification = notificationList;
        apdater = new NotificationApdater();
        apdater.setNotificationList(notificationList);
        System.out.println("ABCDED");
        listView.setAdapter(apdater);
    }

    @Override
    public void onFail(String message) {
        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
