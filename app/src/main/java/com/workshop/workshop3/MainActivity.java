package com.workshop.workshop3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

//step 2 implement interface
public class MainActivity extends AppCompatActivity implements
        ListFragment.IListFragment {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //step 2 fragement to activity(send data)
    @Override
    public void viewDetail(int itemId) {

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("itemId", itemId);
        startActivity(intent);
    }

}