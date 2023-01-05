package com.workshop.workshop3;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment {
    public DetailFragment() {
        // Required empty public constructor
    }

    //step 1 activity to fragment (send data)
    private int itemId;
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layoutRoot = inflater.inflate(R.layout.fragment_detail,
                container, false);

        return layoutRoot;
    }

    //step 3 fragment to activity (send data)
    private IDetailFragment iDetailFragment;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        iDetailFragment = (IDetailFragment) context;
    }

    //step 4 fragment to activity (send data)
    public void sendDataToActivity(String content) {
        iDetailFragment.itemClicked(content);
    }

    //step 1 fragment to activity (send data)
    public interface IDetailFragment {
        void itemClicked(String content);
    }



    @Override
    public void onStart() {
        super.onStart();

//        Bundle bundle = getArguments();
//        if (bundle != null) {
//            itemId = bundle.getInt("itemId");
//        }


        View view = getView();
        if (view != null) {
            DataItem item = DataService.getItem(itemId);

            //set to fragment textview (after activity to fragment)
            TextView title = view.findViewById(R.id.textTitle);
            title.setText(item.getName());

            //step 5 fragment to activity (when click)
            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView textView = (TextView) v;
                    sendDataToActivity(textView.getText().toString());
                }
            });

            //set to fragment textview (after activity to fragment)
            TextView desc = view.findViewById(R.id.textDescription);
            desc.setText(item.getDescription());

            //step 5 fragment to activity (when click)
            desc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView textView = (TextView) v;
                    sendDataToActivity(textView.getText().toString());
                }
            });
        }
    }
}