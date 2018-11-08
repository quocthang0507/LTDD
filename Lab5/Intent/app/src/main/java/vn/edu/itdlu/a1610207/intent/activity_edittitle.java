package vn.edu.itdlu.a1610207.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activity_edittitle extends AppCompatActivity {

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittitle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        map();
        addOnClickListener();
        getDataIntent();
    }

    void map() {
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
    }

    void getDataIntent() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String str = bundle.getString("My_Title");
            editText.setText(str);
        }
    }

    void addOnClickListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_intent_explicit.class);
                intent.putExtra("My_Title", editText.getText().toString());
                startActivity(intent);
            }
        });
    }
}
