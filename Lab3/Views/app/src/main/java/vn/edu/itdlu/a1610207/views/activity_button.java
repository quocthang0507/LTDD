package vn.edu.itdlu.a1610207.views;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class activity_button extends AppCompatActivity {

    private Button button;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        addListenerOnButton_Button();
    }

    public void addListenerOnButton_Button() {
        button = findViewById(R.id.btnClickHere);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com.vn"));
                startActivity(browserIntent);
            }
        });
    }
}
