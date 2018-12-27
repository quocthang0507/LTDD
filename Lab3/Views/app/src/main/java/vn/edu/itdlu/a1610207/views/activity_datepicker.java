package vn.edu.itdlu.a1610207.views;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class activity_datepicker extends AppCompatActivity {
    private static final int DATE_DIALOG_ID = 999;
    private TextView textView;
    private DatePicker datePicker;
    private int year, month, day;
    private Button button;

    private DatePickerDialog.OnDateSetListener datePickerListener = new
            DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                    year = selectedYear;
                    month = selectedMonth;
                    day = selectedDay;
                    textView.setText(new StringBuilder().append(month + 1).append("-").append(day).append("-").append(year)
                            .append(" "));
                    datePicker.init(year, month, day, null);
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datepicker);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setCurrentDateOnView();
        addListenerOnButton_DatePicker();
    }

    void setCurrentDateOnView() {
        textView = findViewById(R.id.tv_Date);
        datePicker = findViewById(R.id.date_result);
        final Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        textView.setText(new StringBuilder().append(month + 1).append("/").append(day).append("/").append(year));
        datePicker.init(year, month, day, null);
    }

    public void addListenerOnButton_DatePicker() {
        button = findViewById(R.id.btn_changeDate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, datePickerListener, year, month, day);
        }
        return null;
    }
}
