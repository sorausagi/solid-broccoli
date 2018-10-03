package com.example.hiroki_tsukazawa.lifee_2018;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.nifty.cloud.mb.core.FetchCallback;
import com.nifty.cloud.mb.core.FindCallback;
import com.nifty.cloud.mb.core.NCMBException;
import com.nifty.cloud.mb.core.NCMBObject;
import com.nifty.cloud.mb.core.NCMBQuery;
import com.nifty.cloud.mb.core.NCMBUser;

import java.util.ArrayList;
import java.util.List;

public class lifestyle_result extends AppCompatActivity {

    private static final String NCMB_CLASSNAME_MESSAGES = "messages";

    protected ListView messageView;
    protected List<MessageItem> messages;
    protected MessageItemAdapter messageAdapter;

    protected BarChart chart;

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lifestyle_result);

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
                        int d02 = obj.getInt("edit02");
                        int d03 = obj.getInt("edit03");

                        BarChart barChart;
                        barChart = (BarChart)findViewById(R.id.bar_chart);

                        BarDataSet barDataSet1,barDataSet2;         //BarDataSet１つが１グループの棒グラフのデータ
                        BarData barData;                            //BarDataSetが１つ入る
                        List<BarEntry> entries1 = new ArrayList<BarEntry>();//棒グラフのデータを入力する
                        //BarEntry１個が一つの棒を表す
                        /*entries1.add(new BarEntry(d02,d03));
                        entries1.add(new BarEntry(120, 150));//４個分のデータを適当に入れる*/
                        List<BarEntry> entries2 = new ArrayList<BarEntry>();
                        entries2.add(new BarEntry(140, 80));
                        entries2.add(new BarEntry(150, 100));
                        entries2.add(new BarEntry(160,60));//２組のグループを作成

                        /*barDataSet1 = new BarDataSet(entries1, "体重");
                        barDataSet1.setBarBorderWidth(1);     */        //棒の横幅を設定、単位は横軸の目盛り

                        barDataSet2 = new BarDataSet(entries2, "身長");
                        barDataSet2.setBarBorderWidth(3);
                        barDataSet2.setColor(Color.BLUE);

                        barData = new BarData(/*barDataSet1,*/barDataSet2);         //BarDataにはBarDataSetを複数入れられる
                        barChart.setData(barData);                  //BarChartには一つのBarDataが入る

                        barChart.getAxisRight().setEnabled(false); //右の縦軸の線を表示しない
                        barChart.getAxisLeft().setAxisMinimum(50);  //縦軸を5０から表示する,これをしないとグラフ下部が見切れる
                        barChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);//横軸の数字を下部に表示する

                        barChart.invalidate();

                    }
                }
            });

        }

    }

    public void onClick(View v){
        Intent intent = new Intent(this, lifstylr_result2.class);
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




