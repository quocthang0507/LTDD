package vn.edu.itdlu.a1610207.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class activity_currency extends AppCompatActivity implements View.OnClickListener {
	
	public static final String ENSURE_INTERNET = "Please ensure that you have a stable internet connection";
	ArrayList<String> listCurrency;
	CoreFunctions functions = new CoreFunctions();
	Spinner spinner1, spinner2;
	EditText editText1, editText2;
	ImageButton button1, button2;
	String str1, str2;
	double value1, value2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_currency);
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayShowTitleEnabled(false);    //Remove activity label
		map();
		loadSpinner();
		addOnClickListener();
	}
	
	void map() {
		spinner1 = findViewById(R.id.spinner_currency_1);
		spinner2 = findViewById(R.id.spinner_currency_2);
		editText1 = findViewById(R.id.et_currency_1);
		editText2 = findViewById(R.id.et_currency_2);
		button1 = findViewById(R.id.btn_down);
		button2 = findViewById(R.id.btn_up);
	}
	
	void loadSpinner() {
		listCurrency = new ArrayList<>(Arrays.asList(functions.Currency));
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_row, listCurrency);
		spinner1.setAdapter(adapter);
		spinner2.setAdapter(adapter);
	}
	
	public void backToMainScreen_OnClick(View v) {
		finish();
	}
	
	void addOnClickListener() {
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View view) {
		double rate, result, from;
		switch (view.getId()) {
			case R.id.btn_down:
				rate = functions.getExchangeRate(str1, str2, getApplicationContext());
				from = Double.parseDouble("" + functions.convertFromString(editText1.getText().toString()));
				editText2.setText("" + from * rate);
				break;
			case R.id.btn_up:
				rate = functions.getExchangeRate(str2, str1, getApplicationContext());
				from = Double.parseDouble("" + functions.convertFromString(editText2.getText().toString()));
				editText1.setText("" + from * rate);
				break;
			default:
				break;
		}
	}
	
	/**
	 * Lấy chữ của 2 spinner cho vào str1, str2
	 */
	void getSpinner() {
		str1 = spinner1.getSelectedItem().toString();
		str2 = spinner2.getSelectedItem().toString();
		if (str1.contains(" ")) str1 = str1.split(" ")[0];
		if (str2.contains(" ")) str2 = str2.split(" ")[0];
	}
}
