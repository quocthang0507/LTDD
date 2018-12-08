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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class activity_currency extends AppCompatActivity implements TextWatcher, AdapterView.OnItemSelectedListener {

    public static final String ENSURE_INTERNET = "Please ensure that you have a stable internet connection";
    ArrayList<String> listCurrency;
    CoreFunctions functions = new CoreFunctions();
    Spinner spinner1, spinner2;
    EditText editText1, editText2;
    double rate;
    String str1, str2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);    //Remove activity label
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

    public void backToMainScreen_OnClick(View v) {
        finish();
    }

    @Override
    public void afterTextChanged(Editable s) {
        getSpinner();
        switch (this.getCurrentFocus().getId()) {
            case R.id.et_currency_1:
                rate = functions.getExchangeRate(str1, str2);
                if (rate != 0 && getEditText()) {
                    editText2.setText("" + functions.fixType(rate * Double.parseDouble(str1)));
                } else
                    Toast.makeText(getApplicationContext(), ENSURE_INTERNET, Toast.LENGTH_LONG).show();
                break;
            case R.id.et_currency_2:
                rate = functions.getExchangeRate(str2, str1);
                if (rate != 0 && getEditText()) {
                    getEditText();
                    editText1.setText("" + functions.fixType(rate * Double.parseDouble(str2)));
                } else
                    Toast.makeText(getApplicationContext(), ENSURE_INTERNET, Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        getSpinner();
        switch (view.getId()) {
            case R.id.spinner_currency_1:
                rate = functions.getExchangeRate(str1, str2);
                if (rate != 0 && getEditText()) {
                    editText2.setText("" + functions.fixType(rate * Double.parseDouble(str1)));
                } else
                    Toast.makeText(getApplicationContext(), ENSURE_INTERNET, Toast.LENGTH_LONG).show();
                break;
            case R.id.spinner_currency_2:
                rate = functions.getExchangeRate(str2, str1);
                if (rate != 0 && getEditText()) {
                    editText1.setText("" + functions.fixType(rate * Double.parseDouble(str2)));
                } else
                    Toast.makeText(getApplicationContext(), ENSURE_INTERNET, Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    void getSpinner() {
        str1 = spinner1.getSelectedItem().toString();
        str2 = spinner2.getSelectedItem().toString();
        if (str1.contains(" ")) str1 = str1.split(" ")[0];
        if (str2.contains(" ")) str2 = str2.split(" ")[0];
    }

    boolean getEditText() {
        str1 = editText1.getText().toString();
        str2 = editText2.getText().toString();
        return !str1.equals("") || !str2.equals("");
    }
}
