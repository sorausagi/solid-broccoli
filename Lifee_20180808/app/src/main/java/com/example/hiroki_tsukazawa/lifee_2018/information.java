package com.example.hiroki_tsukazawa.lifee_2018;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

public class information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

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
                case R.id.i_s2:
                    startActivity(new Intent(this, privacy.class));
                    break;

                case R.id.i_s3:
                    startActivity(new Intent(this, service.class));
                    break;

                case R.id.i_s4:
                    startActivity(new Intent(this, licens.class));
                    break;
            }
        }
    }
}
