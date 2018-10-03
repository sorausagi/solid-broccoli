package com.example.hiroki_tsukazawa.lifee_2018;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nifty.cloud.mb.core.DoneCallback;
import com.nifty.cloud.mb.core.LoginCallback;
import com.nifty.cloud.mb.core.NCMB;
import com.nifty.cloud.mb.core.NCMBException;
import com.nifty.cloud.mb.core.NCMBUser;

public class login extends AppCompatActivity {

    private EditText mUserName;
    private EditText mEmail;
    private EditText mPassword;

    private EditText mLoginUserName;
    private EditText mLoginPassword;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        /*
        mUserName = (EditText) findViewById(R.id.UserName);
        mEmail = (EditText) findViewById(R.id.MailAddress);
        mPassword = (EditText) findViewById(R.id.Password);
        */

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        NCMB.initialize(getApplication(), "c9882e68f3f3a0b19c248ac199ca0ec8404a6770f624d6757fb27a34fd48bb11", "28886a303e0b87743f2a1c9f484bf10782303715477d53edafed5ab12873e646");

        /*
        Button btn = (Button) findViewById(R.id.Button);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // ここに Sign up 処理

                NCMBUser user = new NCMBUser();
                user.setUserName(mUserName.getText().toString());
                user.setMailAddress(mEmail.getText().toString());
                user.setPassword(mPassword.getText().toString());

                // 既定値以外のフィールドに値を設定
                // user.put("phone", "123-456-7890");

                user.signUpInBackground(new DoneCallback() {
                    @Override
                    public void done(NCMBException e) {

                        if (e == null) {
                            // Sign up 成功！
                            Toast.makeText(getApplication(), "成功！", Toast.LENGTH_SHORT).show();
                            finish();

                        } else {
                            // Sign up 失敗！
                            Toast.makeText(getApplication(), "失敗！", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        */



        mLoginUserName = (EditText) findViewById(R.id.login_UserName);
        mLoginPassword = (EditText) findViewById(R.id.login_Password);

        Button loginBtn = (Button) findViewById(R.id.login_Button);
        loginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // ここに Login 処理

                String userName = mLoginUserName.getText().toString();
                String userPassword = mLoginPassword.getText().toString();

                // ログイン
                try {
                    NCMBUser.loginInBackground(userName, userPassword, new LoginCallback() {
                        @Override
                        public void done(NCMBUser user, NCMBException e) {
                            if (e == null) {
                                if (user.getBoolean("mailAddressConfirm")){
                                    Toast.makeText(getApplication(), "ログイン成功", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplication(), MainActivity.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(getApplication(), "メール認証エラー", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(getApplication(), "ログイン失敗", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } catch (NCMBException e) {
                    e.printStackTrace();
                }
            }

        });

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
}
