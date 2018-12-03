package vn.edu.itdlu.a1610207.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.AnalogClock;
import android.widget.DigitalClock;

public class activity_clock extends AppCompatActivity {
    AnalogClock analogClock;
    DigitalClock digitalClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        analogClock = findViewById(R.id.analog);
        digitalClock = findViewById(R.id.digital);
    }
}
