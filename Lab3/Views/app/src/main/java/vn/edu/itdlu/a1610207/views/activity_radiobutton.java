package vn.edu.itdlu.a1610207.views;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class activity_radiobutton extends AppCompatActivity {
    RadioGroup rGroup;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiobutton);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        addListenerOnButton_RadioButton();
        }

    void addListenerOnButton_RadioButton() {
        rGroup = findViewById(R.id.rgGender);
        button = findViewById(R.id.btn_Display_2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = rGroup.getCheckedRadioButtonId();
                button = findViewById(selectedId);
                Toast.makeText(getApplicationContext(), button.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
