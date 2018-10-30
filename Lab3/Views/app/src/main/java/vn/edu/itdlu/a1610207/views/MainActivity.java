package vn.edu.itdlu.a1610207.views;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.DigitalClock;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity extends Activity {

    static final int DATE_DIALOG_ID = 999;
    static final int TIME_DIALOG_ID = 999;
    Button button;
    EditText editText;
    CheckBox chk1, chk2, chk3;
    RadioGroup rGroup;
    RadioButton rb1, rb2;
    ToggleButton tb1, tb2;
    RatingBar ratingBar;
    TextView textView;
    DatePicker datePicker;
    int year, month, day;
    TimePicker timePicker;
    int hour, minute;
    AnalogClock analogClock;
    DigitalClock digitalClock;

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
        switch (10) {
            case 1:
                setContentView(R.layout.button);
                addListenerOnButton_Button();
                break;
            case 2:
                setContentView(R.layout.textbox);
                addKeyListener_TextBox();
                break;
            case 3:
                setContentView(R.layout.password);
                addListenerOnButton_Password();
                break;
            case 4:
                setContentView(R.layout.checkbox);
                addListenerOnCheckbox();
                addListenerOnButton_CheckBox();
                break;
            case 5:
                setContentView(R.layout.radiobutton);
                addListenerOnButton_RadioButton();
                break;
            case 6:
                setContentView(R.layout.togglebutton);
                addListenerOnButton_ToggleButton();
                break;
            case 7:
                setContentView(R.layout.ratingbar);
                addListenerOnRatingBar();
                addListenerOnButton_RatingBar();
                break;
            case 8:
                setContentView(R.layout.datepicker);
                setCurrentDateOnView();
                addListenerOnButton_DatePicker();
                break;
            case 9:
                setContentView(R.layout.timepicker);
                setCurrentTimeOnView();
                addListenerOnButton_TimePicker();
                break;
            case 10:
                setContentView(R.layout.clock);
                analogClock = findViewById(R.id.analog);
                digitalClock = findViewById(R.id.digital);
                break;
        }
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

    private void addKeyListener_TextBox() {
        editText = findViewById(R.id.etTextBox);
        button = findViewById(R.id.btnClickHere_2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), editText.getText(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void addListenerOnButton_Password() {
        editText = findViewById(R.id.etPassword);
        button = findViewById(R.id.btnClickHere_3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), editText.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void addListenerOnCheckbox() {
        chk1 = findViewById(R.id.chk_1);
        chk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    Toast.makeText(getApplicationContext(), "Bro, try Android:)", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void addListenerOnButton_CheckBox() {
        chk1 = findViewById(R.id.chk_1);
        chk2 = findViewById(R.id.chk_2);
        chk3 = findViewById(R.id.chk_3);
        button = findViewById(R.id.btn_Display);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer result = new StringBuffer();
                result.append("iPhone check : ").append(chk1.isChecked());
                result.append("\nAndroid check : ").append(chk2.isChecked());
                result.append("\nWindows Mobile check : ").append(chk3.isChecked());
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void addListenerOnButton_RadioButton() {
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

    public void addListenerOnButton_ToggleButton() {
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

    public void addListenerOnRatingBar() {
        ratingBar = findViewById(R.id.ratingBar);
        textView = findViewById(R.id.tv_ratingValue);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                textView.setText(String.valueOf(rating));
            }
        });
    }

    public void addListenerOnButton_RatingBar() {
        ratingBar = findViewById(R.id.ratingBar);
        button = findViewById(R.id.btn_Submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), String.valueOf(ratingBar.getRating()), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setCurrentDateOnView() {
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

    /*
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, datePickerListener, year, month, day);
        }
        return null;
    }
    */

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
