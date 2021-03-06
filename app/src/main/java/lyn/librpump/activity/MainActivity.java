package lyn.librpump.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;
import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.gc.materialdesign.views.ButtonFloat;

import java.util.ArrayList;
import java.util.List;


import lyn.callibrpump.R;
import lyn.librpump.adapter.TabAdapter;
import lyn.librpump.fragment.CalCOPFragment;
import lyn.librpump.fragment.CalLiBrFragment;
import lyn.librpump.fragment.PumpItemFragment;
import lyn.librpump.fragment.CalH2OFragment;

public class MainActivity extends AppCompatActivity  {

    public final static String EXTRA_MESSAGE = "lyn.callibrpump.MESSAGE";

    private ViewPager mViewPager;
    private TabAdapter mAdapter ;
    private List<Fragment> fragmentList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bootstrap
        TypefaceProvider.registerDefaultIconSets();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButtonFloat fab = (ButtonFloat) findViewById(R.id.fab);
        final Intent  createPumpIntent = new Intent(this, CreatePumpActivity.class);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                startActivity(createPumpIntent);
            }
        });



        initView();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            Intent settingIntent = new Intent(this,SettingsActivity.class);
            startActivity(settingIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    /** Called when the user clicks the Send button */
//    public void sendMessage(View view) {
//        // Do something in response to button
//        Intent intent = new Intent(this, DisplayMessageActivity.class);
//        EditText editText = (EditText) findViewById(R.id.edit_message);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
//    }

    /** Called when the user clicks the Send button */
//    public void sendMessage(View view) {
//        // Do something in response to button
//        Intent intent = new Intent(this,DisplayMessageActivity.class);
//        EditText editText = (EditText) findViewById(R.id.edit_message);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
//    }

    private void initView()
    {
        fragmentList = new ArrayList<Fragment>();
        Fragment calCOPFragment = new CalCOPFragment();
        Fragment calLiBrFragment = new CalLiBrFragment();
        Fragment calH2OFragment = new CalH2OFragment();
        Fragment itemFragment = new PumpItemFragment();

        fragmentList.add(calCOPFragment);
        fragmentList.add(itemFragment);
        fragmentList.add(calLiBrFragment);
        fragmentList.add(calH2OFragment);

        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        mAdapter = new TabAdapter(getSupportFragmentManager(),fragmentList);
        mViewPager.setAdapter(mAdapter);
        tabs.setIndicatorColor(Color.parseColor("#C5CAE9"));
        tabs.setShouldExpand(true);
        tabs.setViewPager(mViewPager);
    }

}

