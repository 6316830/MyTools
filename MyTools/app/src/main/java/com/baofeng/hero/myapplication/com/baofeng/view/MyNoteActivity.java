package com.baofeng.hero.myapplication.com.baofeng.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.baofeng.hero.myapplication.MainActivity;
import com.baofeng.hero.myapplication.R;
import com.baofeng.hero.myapplication.com.baofeng.dbHelper.DBManager;

import java.util.List;
import java.util.Map;

public class MyNoteActivity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_note);
        listView=(ListView)findViewById(R.id.listView);
//        TextView textView=(TextView)findViewById(R.id.text1);
        DBManager dbManager=new DBManager(MyNoteActivity.this);
//        dbManager.insertDay("2088-8-8","three");
      List<Map<String,String>> lists= dbManager.selectAll();
        for (int a=0;a<lists.size();a++){
              Map<String,String> temp=lists.get(a);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_note, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_add) {
            Intent intent=new Intent(this,NewDayItemActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
