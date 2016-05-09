package lyn.librpump.activity;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

import lyn.callibrpump.R;

public class PumpDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pump_detail);
        TableLayout table = (TableLayout)findViewById(R.id.table);

    }
}
