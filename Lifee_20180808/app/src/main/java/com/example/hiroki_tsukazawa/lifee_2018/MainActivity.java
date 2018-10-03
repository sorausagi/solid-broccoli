package com.example.hiroki_tsukazawa.lifee_2018;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nifty.cloud.mb.core.DoneCallback;
import com.nifty.cloud.mb.core.LoginCallback;
import com.nifty.cloud.mb.core.NCMB;
import com.nifty.cloud.mb.core.NCMBException;
import com.nifty.cloud.mb.core.NCMBUser;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        NCMBUser user = NCMBUser.getCurrentUser();
        if(user != null){
            ((TextView)findViewById(R.id.name)).setText(user.getUserName());
        }else{
            ((TextView)findViewById(R.id.name)).setText("ログインしてください");
        }

    }

    public void onClick(View v){


        if(v != null){
            switch (v.getId()){
                case R.id.login:
                    startActivity(new Intent(this, login.class));
                    break;

                case R.id.medical_checkup:
                    startActivity(new Intent(this, medical_checkup.class));
                    break;

                case R.id.bmi:
                    startActivity(new Intent(this, bmi.class));
                    break;

                case R.id.lifestyle:
                    startActivity(new Intent(this, lifestyle_diseases.class));
                    break;

                case R.id.cancer:
                    startActivity(new Intent(this, cancer_related.class));
                    break;

                case R.id.infection:
                    startActivity(new Intent(this, infection_test.class));
                    break;

                case R.id.biochemical:
                    startActivity(new Intent(this, biochemical_examination.class));
                    break;

                default:
                    break;

            }
        }
    }





    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_notice) {
            startActivity(new Intent(this, notice.class));

        } else if (id == R.id.nav_tutorial) {
            startActivity(new Intent(this, tutorial.class));

        } else if (id == R.id.nav_mail) {
            startActivity(new Intent(this, mail.class));

        } else if (id == R.id.nav_pass) {
            startActivity(new Intent(this, pass.class));

        } else if (id == R.id.nav_information) {
            startActivity(new Intent(this, information.class));

        } else if (id == R.id.nav_help) {
            startActivity(new Intent(this, help.class));

        } else if (id == R.id.nav_logout) try {
            NCMBUser.logout();
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        }catch (NCMBException e){

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
