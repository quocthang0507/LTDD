package vn.edu.itdlu.a1610207.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_intent_explicit extends AppCompatActivity {

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_explicit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        map();
        addOnClickListener();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String str = bundle.getString("My_Title");
            textView.setText(str);
        }
    }

    void map() {
        textView = findViewById(R.id.tv_explicit_1);
        button = findViewById(R.id.btn_Title);
    }

    void addOnClickListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_edittitle.class);
                intent.putExtra("My_Title", textView.getText().toString());
                startActivity(intent);
            }
        });
    }
}
