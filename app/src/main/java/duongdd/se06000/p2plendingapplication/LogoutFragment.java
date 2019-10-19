package duongdd.se06000.p2plendingapplication;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.BlockedNumberContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class LogoutFragment extends Fragment {


    public LogoutFragment() {

    }

//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_logout, container, false);
//    }

    @Override
    public void onStart() {
        super.onStart();
        // Required empty public constructor
        Intent intent = new Intent(getActivity().getBaseContext(), LoginActivity.class);
        Bundle bundle = new Bundle();
        bundle.clear();
        startActivity(intent);
    }

}
