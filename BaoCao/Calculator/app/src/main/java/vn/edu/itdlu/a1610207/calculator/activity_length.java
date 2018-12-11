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

public class activity_length extends AppCompatActivity implements View.OnClickListener {

    Spinner spinner1, spinner2;
    EditText editText1, editText2;
    ImageButton button1, button2;
    ArrayList<String> listLength;
    CoreFunctions functions = new CoreFunctions();
    String str1, str2;
    int id1, id2;
    Object value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);    //Remove activity label
        map();
        loadSpinner();
        addOnClickListener();
    }
    
    public void backToMainScreen_OnClick(View v) {
        finish();
    }
    
    void map() {
        spinner1 = findViewById(R.id.spinner_length_1);
        spinner2 = findViewById(R.id.spinner_length_2);
        editText1 = findViewById(R.id.et_length_1);
        editText2 = findViewById(R.id.et_length_2);
        button1 = findViewById(R.id.btn_down);
        button2 = findViewById(R.id.btn_up);
    }

    void addOnClickListener() {
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        getID();
        switch (view.getId()) {
            case R.id.btn_down:
                value = functions.convertFromString(editText1.getText().toString());
                editText2.setText("" + functions.otherConverter(functions.Length, id1, value, id2));
                break;
            case R.id.btn_up:
                value = functions.convertFromString(editText2.getText().toString());
                editText1.setText("" + functions.otherConverter(functions.Length, id2, value, id1));
                break;
            default:
                break;
        }
    }

    void array2List() {
        String[] temp = functions.Length;
        listLength = new ArrayList<>();
        for (int i = 0; i < temp.length; i++) {
            if (i % 2 == 0)
                listLength.add(temp[i]);
        }
    }

    void loadSpinner() {
        array2List();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_row, listLength);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
    }

    void getSpinner() {
        str1 = spinner1.getSelectedItem().toString();
        str2 = spinner2.getSelectedItem().toString();
    }

    void getID() {
        getSpinner();
        id1 = functions.findIndexInArray(functions.Length, str1);
        id2 = functions.findIndexInArray(functions.Length, str2);
    }
}
