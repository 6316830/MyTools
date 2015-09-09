package com.baofeng.hero.myapplication.com.baofeng.view;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.baofeng.hero.myapplication.R;

public class HomeFirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_first);
        ActionBar actionBar=getActionBar();
      //  actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        Button tabBtn1=(Button)findViewById( R.id.tab1);
        Button tabBtn2=(Button)findViewById( R.id.tab2);
        Button tabBtn3=(Button)findViewById( R.id.tab3);
        tabBtn1.setOnClickListener(listener);
        tabBtn2.setOnClickListener(listener);
        tabBtn3.setOnClickListener(listener);
    }
     View.OnClickListener listener=new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             switch (v.getId()) {
                 case R.id.tab1:

                     FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                     PageOneFragment pageOneFragment=PageOneFragment.newInstance("aaa","bbb");
                     fragmentTransaction.replace(R.id.mainView,pageOneFragment);
                     fragmentTransaction.commit();
                      break;
                 case R.id.tab2:
                     fragmentTransaction=getFragmentManager().beginTransaction();
                     PageTwoFragment pageTwoFragment=PageTwoFragment.newInstance("aaa","bbb");
                     fragmentTransaction.replace(R.id.mainView,pageTwoFragment);
                     fragmentTransaction.commit();
                     break;
                 case R.id.tab3:
                     fragmentTransaction=getFragmentManager().beginTransaction();
                     PageThreeFragment pageThreeFragment=PageThreeFragment.newInstance("aaa","bbb");
                     fragmentTransaction.replace(R.id.mainView,pageThreeFragment);
                     fragmentTransaction.commit();
                     break;
                 default:
                     break;
             }
         }
     };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_first, menu);
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

        return super.onOptionsItemSelected(item);
    }
}
