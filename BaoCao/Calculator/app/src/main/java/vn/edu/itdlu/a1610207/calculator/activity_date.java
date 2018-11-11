package vn.edu.itdlu.a1610207.calculator;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class activity_date extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    ConstraintLayout constraintLayout1, constraintLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        map();
        loadSpinner();
    }

    void map() {
        spinner = findViewById(R.id.spinner_datemode);
        constraintLayout1 = findViewById(R.id.diff_mode);
        constraintLayout2 = findViewById(R.id.addsubtract_mode);
    }

    void loadSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.dateMode, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        if (pos == 0) {
            constraintLayout1.setVisibility(View.VISIBLE);
            constraintLayout2.setVisibility(View.GONE);
        } else {
            constraintLayout1.setVisibility(View.GONE);
            constraintLayout2.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
