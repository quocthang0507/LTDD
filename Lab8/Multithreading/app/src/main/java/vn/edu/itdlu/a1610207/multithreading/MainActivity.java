package vn.edu.itdlu.a1610207.multithreading;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView_xuoi, textView_nguoc;
    Button button;
    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map();
        addButtonOnClickListener();
    }

    void map() {
        editText = findViewById(R.id.editText_number);
        textView_xuoi = findViewById(R.id.textView_Xuoi);
        textView_nguoc = findViewById(R.id.textView_Nguoc);
        button = findViewById(R.id.button_start);
    }

    void DemXuoi() {
        for (int i = 1; i <= value; i++) {
            textView_xuoi.setText("" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void DemNguoc() {
        for (int i = value; i >= 1; i--) {
            textView_nguoc.setText("" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void addButtonOnClickListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText.getText().toString();
                try {
                    value = Integer.parseInt(input);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập số", Toast.LENGTH_LONG).show();
                    return;
                }
                Thread thread=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        DemNguoc();
                    }
                });
		thread.Start();
            }
        });
    }
}
