package com.workshop.workshop3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

//step 2 fragment to activity( implement interface)
public class DetailActivity extends AppCompatActivity implements DetailFragment.IDetailFragment{
    //step 2 fragment to activity (override)
    @Override
    public void itemClicked(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //receive intent from mainactivity
        Intent intent = getIntent();
        int itemId = intent.getIntExtra("itemId", 1);

        //Temporarily hardcode the itemId Value
        //int itemId = 2;

        //step 2 activity to fragment (send data)
        FragmentManager fm = getSupportFragmentManager();
        DetailFragment fragment = (DetailFragment) fm.findFragmentById(R.id.fragment_detail);
        fragment.setItemId(itemId);
    }
}