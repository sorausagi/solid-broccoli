package com.example.hiroki_tsukazawa.lifee_2018;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class medical_checkup extends AppCompatActivity implements View.OnClickListener{
        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.medical_checkup);

            findViewById(R.id.medical_result).setOnClickListener(this);

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
            Intent intent = new Intent(this, medical_result.class);
            startActivity(intent);
        }


}
