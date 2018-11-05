package vn.edu.itdlu.a1610207.views;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class activity_toggle extends AppCompatActivity {
    ToggleButton tb1, tb2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        addListenerOnButton_ToggleButton();
        }

    void addListenerOnButton_ToggleButton() {
        tb1 = findViewById(R.id.toggle_1);
        tb2 = findViewById(R.id.toggle_2);
        button = findViewById(R.id.btn_Display_3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer result = new StringBuffer();
                result.append("toggle_1 : ").append(tb1.getText());
                result.append("\ntoggle_2 : ").append(tb2.getText());
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
