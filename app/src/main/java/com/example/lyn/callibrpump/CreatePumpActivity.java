package com.example.lyn.callibrpump;

import android.app.ActionBar;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import lyn.librpump.kernel.pump.Pump;

public class CreatePumpActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_pump);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        ActionBar ab = getActionBar();
//        ab.setDisplayHomeAsUpEnabled(true);

//        Intent intent = getIntent();
//        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

    }

    public void createPump(View view){

        EditText t_wai = (EditText) findViewById(R.id.t_wai);
        double Twai = Double.valueOf(t_wai.getText().toString());

        EditText t_wco = (EditText) findViewById(R.id.t_wco);
        double Twco = Double.valueOf(t_wco.getText().toString());

        EditText t_wei = (EditText) findViewById(R.id.t_wei);
        double Twei = Double.valueOf(t_wei.getText().toString());

        EditText t_weo = (EditText) findViewById(R.id.t_weo);
        double Tweo = Double.valueOf(t_weo.getText().toString());

        System.out.println("======================================");

        System.out.println(Twai + " " + Twco + " " + Twei + " " + Tweo + " ");

        System.out.println("======================================");

        Pump pump = new Pump(Twai,Twco,Twei,Tweo);

        Snackbar.make(view, "COP = " + pump.getCOP(), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

    }

    public void clearInput(View view){

        EditText t_wai = (EditText) findViewById(R.id.t_wai);


        EditText t_wco = (EditText) findViewById(R.id.t_wco);


        EditText t_wei = (EditText) findViewById(R.id.t_wei);


        EditText t_weo = (EditText) findViewById(R.id.t_weo);


        t_wai.setText("");
        t_wco.setText("");
        t_wei.setText("");
        t_weo.setText("");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle app bar item clicks here. The app bar
        // automatically handles clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
