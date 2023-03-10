package com.workshop.workshop3;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ListFragment extends Fragment {

    Button mDetailBtn1;
    Button mDetailBtn2;
    Button mDetailBtn3;

    public ListFragment() {
        // Required empty public constructor
    }

    //create fragment class
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //button click from fragmentlayout
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        mDetailBtn1 = view.findViewById(R.id.detail1Btn);
        mDetailBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewDetail(1);
            }
        });

        mDetailBtn2 = view.findViewById(R.id.detail2Btn);
        mDetailBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewDetail(2);
            }
        });

        mDetailBtn3 = view.findViewById(R.id.detail3Btn);
        mDetailBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewDetail(3);
            }
        });

        return view;
    }







    //step 3 fragment to activity(send data)
    private IListFragment iListFragment;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        iListFragment = (IListFragment) context;
    }

    //step 4 fragment to activity(send data)
    void viewDetail(int itemId) {
        iListFragment.viewDetail(itemId);
    }


    //step 1 fragment to activity(send data)
    public interface IListFragment {
        void viewDetail(int itemId);
    }
}
