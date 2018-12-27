package vn.edu.itdlu.a1610207.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class activity_checkbox extends AppCompatActivity {
    private CheckBox chk1, chk2, chk3;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        addListenerOnCheckbox();
        addListenerOnButton_CheckBox();
    }

    void addListenerOnCheckbox() {
        chk1 = findViewById(R.id.chk_1);
        chk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    Toast.makeText(getApplicationContext(), "Bro, try Android:)", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    void addListenerOnButton_CheckBox() {
        chk1 = findViewById(R.id.chk_1);
        chk2 = findViewById(R.id.chk_2);
        chk3 = findViewById(R.id.chk_3);
        button = findViewById(R.id.btn_Display);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer result = new StringBuffer();
                result.append("iPhone check : ").append(chk1.isChecked());
                result.append("\nAndroid check : ").append(chk2.isChecked());
                result.append("\nWindows Mobile check : ").append(chk3.isChecked());
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
