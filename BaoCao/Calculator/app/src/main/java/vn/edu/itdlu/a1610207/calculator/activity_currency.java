package vn.edu.itdlu.a1610207.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class activity_currency extends AppCompatActivity implements TextWatcher, AdapterView.OnItemSelectedListener {

    ArrayList<String> listCurrency;
    CoreFunctions functions = new CoreFunctions();
    Spinner spinner1, spinner2;
    EditText editText1, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        map();
        loadSpinner();
        addTextChangeListener();
        addItemSelectedListener();
    }

    void map() {
        spinner1 = findViewById(R.id.spinner_currency_1);
        spinner2 = findViewById(R.id.spinner_currency_2);
        editText1 = findViewById(R.id.et_currency_1);
        editText2 = findViewById(R.id.et_currency_2);
    }

    void loadSpinner() {
        listCurrency = new ArrayList<>(Arrays.asList(functions.Currency));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_row, listCurrency);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
    }

    void addTextChangeListener() {
        editText1.addTextChangedListener(this);
        editText2.addTextChangedListener(this);
    }

    void addItemSelectedListener() {
        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
