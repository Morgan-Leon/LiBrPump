package lyn.librpump.activity;

import android.content.ContentValues;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import lyn.callibrpump.R;

import lyn.librpump.kernel.pump.Pump;
import lyn.librpump.model.LiBrPumpDBHelper;
import lyn.librpump.model.librpump.LiBrPumpContract;
import lyn.librpump.model.librpumpConfig.LiBrPumpConfigContract.*;


public class CreatePumpActivity extends AppCompatActivity {

    LiBrPumpDBHelper dbHelper;
    EditText t_wai, t_wco, t_wei, t_weo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_pump);

        dbHelper = new LiBrPumpDBHelper(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        ActionBar ab = getActionBar();
//        ab.setDisplayHomeAsUpEnabled(true);

//        Intent intent = getIntent();
//        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

    }

    public void createPump(View view){

        //读取数据
        t_wai = (EditText) findViewById(R.id.t_wai);
        double Twai = Double.valueOf(t_wai.getText().toString());

        t_wco = (EditText) findViewById(R.id.t_wco);
        double Twco = Double.valueOf(t_wco.getText().toString());

        t_wei = (EditText) findViewById(R.id.t_wei);
        double Twei = Double.valueOf(t_wei.getText().toString());

        t_weo = (EditText) findViewById(R.id.t_weo);
        double Tweo = Double.valueOf(t_weo.getText().toString());

//        System.out.println("======================================");
//
//        System.out.println(Twai + " " + Twco + " " + Twei + " " + Tweo + " ");
//
//        System.out.println("======================================");

        //生成热泵并进行计算
        Pump pump = new Pump(Twai,Twco,Twei,Tweo);

        Snackbar.make(view, "COP = " + pump.getCOP(), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

        ContentValues pumpConfigValues ,pumpValues;

        pumpConfigValues = LiBrPumpConfigEntry.generateValues(pump);
        pumpValues = LiBrPumpContract.LiBrPumpEntry.generateValues(pump);

        dbHelper.insert(pumpConfigValues,pumpValues);
    }

    public void clearInput(View view){

        t_wai = (EditText) findViewById(R.id.t_wai);


        t_wco = (EditText) findViewById(R.id.t_wco);


        t_wei = (EditText) findViewById(R.id.t_wei);


        t_weo = (EditText) findViewById(R.id.t_weo);


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
