package vn.edu.itdlu.a1610207.views;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class activity_timepicker extends AppCompatActivity {
    static final int TIME_DIALOG_ID = 999;
    int hour, minute;
    TextView textView;
    TimePicker timePicker;
    Button button;
    private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int _minute) {
            hour = hourOfDay;
            minute = _minute;
            textView.setText(new StringBuilder().append(pad(hour)).append(":").append(pad(minute)));
            timePicker.setCurrentHour(hour);
            timePicker.setCurrentMinute(minute);
        }
    };

    private static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else return "0" + String.valueOf(c);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timepicker);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setCurrentTimeOnView();
        addListenerOnButton_TimePicker();
    }

    public void setCurrentTimeOnView() {
        textView = findViewById(R.id.tv_Time);
        timePicker = findViewById(R.id.time_result);
        final Calendar calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        textView.setText(new StringBuilder().append(pad(hour)).append(":").append(pad(minute)));
        timePicker.setCurrentHour(hour);
        timePicker.setCurrentMinute(minute);
    }

    public void addListenerOnButton_TimePicker() {
        button = findViewById(R.id.btn_changeTime);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case TIME_DIALOG_ID:
                return new TimePickerDialog(this, timePickerListener, hour, minute, false);
        }
        return null;
    }
}
