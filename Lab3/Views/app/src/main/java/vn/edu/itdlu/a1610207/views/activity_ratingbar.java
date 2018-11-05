package vn.edu.itdlu.a1610207.views;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class activity_ratingbar extends AppCompatActivity {
    RatingBar ratingBar;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratingbar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        addListenerOnRatingBar();
        addListenerOnButton_RatingBar();
        }

    void addListenerOnRatingBar() {
        ratingBar = findViewById(R.id.ratingBar);
        textView = findViewById(R.id.tv_ratingValue);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                textView.setText(String.valueOf(rating));
            }
        });
    }

    void addListenerOnButton_RatingBar() {
        ratingBar = findViewById(R.id.ratingBar);
        button = findViewById(R.id.btn_Submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), String.valueOf(ratingBar.getRating()), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
