package vn.edu.itdlu.a1610207.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_password extends AppCompatActivity {
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        addListenerOnButton_Password();
    }

    void addListenerOnButton_Password() {
        editText = findViewById(R.id.etPassword);
        button = findViewById(R.id.btnClickHere_3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), editText.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
