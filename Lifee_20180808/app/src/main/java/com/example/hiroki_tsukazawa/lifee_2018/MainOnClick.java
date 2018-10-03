package com.example.hiroki_tsukazawa.lifee_2018;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainOnClick extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        findViewById(R.id.medical_checkup);
        findViewById(R.id.bmi);
        findViewById(R.id.lifestyle);

    }

    @Override
    public void onClick(View v){
        if(v != null){
            switch (v.getId()){
                case R.id.medical_checkup:
                    Intent intent = new Intent(this, medical_checkup.class);
                    startActivity(intent);
                    break;

                case R.id.bmi:
                    intent = new Intent(this, bmi.class);
                    startActivity(intent);
                    break;

                case R.id.lifestyle:
                    intent = new Intent(this, lifestyle_diseases.class);
                    startActivity(intent);
                    break;

                    default:
                        break;

            }
        }
    }


}
