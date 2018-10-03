package com.example.hiroki_tsukazawa.lifee_2018;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.nifty.cloud.mb.core.FetchCallback;
import com.nifty.cloud.mb.core.NCMBException;
import com.nifty.cloud.mb.core.NCMBObject;
import com.nifty.cloud.mb.core.NCMBUser;

import java.util.List;


public class lifstylr_result2 extends AppCompatActivity {

    private static final String NCMB_CLASSNAME_MESSAGES = "messages";

    protected ListView messageView;
    protected List<MessageItem> messages;
    protected MessageItemAdapter messageAdapter;

    protected BarChart chart;

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lifstyle_result02);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        final NCMBObject obj = new NCMBObject("textClass");
        final NCMBUser user = NCMBUser.getCurrentUser();


        if (user != null) {

            try {
                obj.setObjectId("DMrIcH5rv29CVXTG");
            } catch (NCMBException e) {

            }

            obj.fetchInBackground(new FetchCallback<NCMBObject>() {

                @Override
                public void done(NCMBObject object, NCMBException e) {
                    if (e != null) {
                        //エラー時の処理

                        Toast.makeText(getApplication(), "取得失敗", Toast.LENGTH_SHORT).show();
                    } else {
                        //取得成功時の処理
                        String d01 = obj.getString("edit01");
                        String d02 = obj.getString("edit02");
                        String d03 = obj.getString("edit03");
                        String d04 = obj.getString("edit04");

                        ((TextView) findViewById(R.id.d_01)).setText(d04);
                        ((TextView) findViewById(R.id.d_02)).setText(d02);
                        ((TextView) findViewById(R.id.d_03)).setText(d03);

                    }
                }
            });

        }

    }

    public void onClick(View v){
        Intent intent = new Intent(this, lifestyle_result.class);
        startActivity(intent);
        finish();
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

