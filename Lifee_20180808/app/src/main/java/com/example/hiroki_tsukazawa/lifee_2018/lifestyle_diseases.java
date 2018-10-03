package com.example.hiroki_tsukazawa.lifee_2018;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.nifty.cloud.mb.core.DoneCallback;
import com.nifty.cloud.mb.core.FetchCallback;
import com.nifty.cloud.mb.core.FindCallback;
import com.nifty.cloud.mb.core.NCMB;
import com.nifty.cloud.mb.core.NCMBException;
import com.nifty.cloud.mb.core.NCMBObject;
import com.nifty.cloud.mb.core.NCMBObjectService;
import com.nifty.cloud.mb.core.NCMBQuery;
import com.nifty.cloud.mb.core.NCMBUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lifestyle_diseases extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lifestyle_diseases);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        findViewById(R.id.k_01).setOnClickListener(this);

        NCMBUser user = NCMBUser.getCurrentUser();
        if(user != null){

            findViewById(R.id.life).setVisibility(View.VISIBLE);
        }else{
            findViewById(R.id.life).setVisibility(View.INVISIBLE);
        }

    }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();

            boolean result = true;
            switch (id){
                case android.R.id.home:
                    finish();
                    break;
                default:
                    result = super.onOptionsItemSelected(item);
            }
            return result;
        }

    public void onClick(View v){

        if(v != null) {
            switch (v.getId()) {
                case R.id.k_01:
                    startActivity(new Intent(this, lifestyle_result.class));
                    break;

                case R.id.k_02:
                    startActivity(new Intent(this, lifestyle_result.class));
                    break;

            }
        }
    }

}



