package com.example.hiroki_tsukazawa.lifee_2018;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.SaveCallback;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nifty.cloud.mb.core.DoneCallback;
import com.nifty.cloud.mb.core.NCMBAcl;
import com.nifty.cloud.mb.core.NCMBException;
import com.nifty.cloud.mb.core.NCMBObject;
import com.nifty.cloud.mb.core.NCMBUser;

import java.util.List;

public class medical_result extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medical_result);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        final EditText edit01 = (EditText)findViewById(R.id.me_l1);
        final EditText edit02 = (EditText)findViewById(R.id.me_l2);
        final EditText edit03 = (EditText)findViewById(R.id.me_l3);
        final EditText edit04 = (EditText)findViewById(R.id.me_l4);

        Button btnAdd = (Button)findViewById(R.id.bmi_registration);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NCMBObject obj = new NCMBObject("textClass");
                NCMBUser user = NCMBUser.getCurrentUser();
                try {


                    obj.put("edit01", edit01.getText().toString());
                    obj.put("edit02", edit02.getText().toString());
                    obj.put("edit03", edit03.getText().toString());
                    obj.put("edit04", edit04.getText().toString());
                    obj.put("id",user.getObjectId());
                    obj.put("name",user.getUserName());

                    }catch(NCMBException e){

                    }

                    obj.saveInBackground(new DoneCallback() {

                    @Override
                    public void done(NCMBException e) {
                        if (e == null) {
                            // オブジェクト保村成功！
                            Toast.makeText(getApplication(), "タスク登録成功！", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(medical_result.this,MainActivity.class);
                            startActivity(intent);
                        } else {
                            // Sign up 失敗！
                            Toast.makeText(getApplication(), "失敗！", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }

    /*
    protected void onClick(View v){

        NCMBObject obj = new NCMBObject("SaveObjectTest");
        obj.put("key", );
        obj.saveInBackground(new DoneCallback() {
            @Override
            public void done(NCMBException e) {
                if (e != null) {

                    //エラー発生時の処理
                } else {

                    //成功時の処理
                }
            }
        });

    }
        /*
        final MessageItem tmpItem = item;
        EditText edit01 = (EditText)findViewById(R.id.me_l1);
        EditText edit02 = (EditText)findViewById(R.id.me_l2);
        EditText edit03 = (EditText)findViewById(R.id.me_l3);
        EditText edit04 = (EditText)findViewById(R.id.me_l4);

        String text02 = edit02.getText().toString();

        NCMBObject obj = new NCMBObject("Test");
        obj.put("edit01", );
        obj.put("me02", "12");
        obj.saveInBackground(new DoneCallback() {
            @Override
            public void done(NCMBException e) {
                if(e != null){

                }else{
                    finish();
                }
            }
        });
    }
    */
    /*
    final NCMBObject obj = new NCMBObject("Test");
        obj.put(findViewById(R.id.), "Hello, NCMB!");
        obj.saveInBackground(new DoneCallback() {
        @Override
        public void done(NCMBException e) {
            if (e != null) {
                //保存失敗
                new AlertDialog.Builder(medical_result.this)
                        .setTitle("Notification from Nifty")
                        .setMessage("Error:" + e.getMessage())
                        .setPositiveButton("OK", null)
                        .show();

            } else {
                //保存成功
                new AlertDialog.Builder(medical_result.this)
                        .setTitle("Notification from Nifty")
                        .setMessage("Save successfull! with ID:" + obj.getObjectId())
                        .setPositiveButton("OK", null)
                        .show();

            }
        }
    });
    */

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
}
