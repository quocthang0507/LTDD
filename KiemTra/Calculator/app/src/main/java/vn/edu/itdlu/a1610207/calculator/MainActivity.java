package vn.edu.itdlu.a1610207.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    User user;
    ArrayList<View> allButtons; //List contains all buttons in app
    TextView tvResult, tvExp;
    double prevalue = Double.NaN;   //The previous value of this calculator
    String operators = "['+']|['*']|['/']"; //For regex pattern
    char preOp = '\0';   //The previous operator of this calculator
    String pattern = ".#########";  //Decimal format for double value
    Locale locale = Locale.US;      //Locale for formatting double value

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = new User();
        tvResult = findViewById(R.id.result);
        tvExp = findViewById(R.id.expression);
        findAllButtons();
        addOnClickListener();
    }

    /**
     * Find all buttons in app
     */
    void findAllButtons() {
        allButtons = new ArrayList<>();
        allButtons = ((LinearLayout) findViewById(R.id.main_layout)).getTouchables();
    }

    /**
     * Add OnClickListener for all buttons
     */
    void addOnClickListener() {
        Button button;
        ImageButton imageButton;
        for (View view : allButtons)
            if (view instanceof Button) {
                button = (Button) view;
                button.setOnClickListener(this);
            } else if (view instanceof ImageButton) {
                imageButton = (ImageButton) view;
                imageButton.setOnClickListener(this);
            }
    }

    @Override
    public void onClick(View v) {
        //Get name of the button
        String input = v.getResources().getResourceName(v.getId()).split("/")[1];
        //Get current string of textView
        String current = tvResult.getText().toString();
        //Get current expression string of textView
        String exp = tvExp.getText().toString();
        //Switch function button
        switch (input) {
            case "btn_plus":
                //If the equation is not completed
                if (!current.contains("=")) {
                    if (!Double.isNaN(prevalue) && !current.matches(operators)) //When user imports number secondly
                        if (preOp != '+' && preOp != '\0')
                            prevalue = user.Compute(preOp, prevalue, Double.parseDouble(current));
                        else prevalue = user.Compute('+', prevalue, Double.parseDouble(current));
                    else if (Double.isNaN(prevalue) && !current.matches(operators)) ////When user imports number firstly
                        prevalue = Double.parseDouble(current);
                } else {
                    prevalue = Double.parseDouble(current.substring(1, current.length()));
                }
                current = "+";
                preOp = '+';
                exp = "" + fixType(prevalue) + "+";
                break;
            case "btn_minus":
                if (!current.contains("=")) {
                    if (!Double.isNaN(prevalue) && !current.matches(operators))
                        if (preOp != '-' && preOp != '\0')
                            prevalue = user.Compute(preOp, prevalue, Double.parseDouble(current));
                        else prevalue = user.Compute('-', prevalue, Double.parseDouble(current));
                    else if (Double.isNaN(prevalue) && !current.matches(operators))
                        prevalue = Double.parseDouble(current);
                } else {
                    prevalue = Double.parseDouble(current.substring(1, current.length()));
                }
                current = "-";
                preOp = '-';
                exp = "" + fixType(prevalue) + "-";
                break;
            case "btn_mul":
                if (!current.contains("=")) {
                    if (!Double.isNaN(prevalue) && !current.matches(operators))
                        if (preOp != '*' && preOp != '\0')
                            prevalue = user.Compute(preOp, prevalue, Double.parseDouble(current));
                        else prevalue = user.Compute('*', prevalue, Double.parseDouble(current));
                    else if (Double.isNaN(prevalue) && !current.matches(operators))
                        prevalue = Double.parseDouble(current);
                } else {
                    prevalue = Double.parseDouble(current.substring(1, current.length()));
                }
                current = "*";
                preOp = '*';
                exp = "" + fixType(prevalue) + "*";
                break;
            case "btn_div":
                if (!current.contains("=")) {
                    if (!Double.isNaN(prevalue) && !current.matches(operators))
                        if (preOp != '/' && preOp != '\0')
                            prevalue = user.Compute(preOp, prevalue, Double.parseDouble(current));
                        else prevalue = user.Compute('/', prevalue, Double.parseDouble(current));
                    else if (Double.isNaN(prevalue) && !current.matches(operators))
                        prevalue = Double.parseDouble(current);
                } else {
                    prevalue = Double.parseDouble(current.substring(1, current.length()));
                }
                current = "/";
                preOp = '/';
                exp = "" + fixType(prevalue) + "/";
                break;
            case "btn_0":
            case "btn_1":
            case "btn_2":
            case "btn_3":
            case "btn_4":
            case "btn_5":
            case "btn_6":
            case "btn_7":
            case "btn_8":
            case "btn_9":
                if (!current.contains("=")) {
                    String temp = input.split("_")[1];
                    if (!current.matches(operators) && !current.contains("-"))
                        if (!current.equals("0"))
                            current += temp;
                        else current = temp;
                    else current = temp;
                }
                break;
            case "btn_dot":
                if (!current.matches(operators) && !current.contains("-"))
                    current += ".";
                break;
            case "btn_equal":
                if (!current.matches(operators)) {
                    exp += "" + fixType(Double.parseDouble(current));
                    if (preOp != '\0') {
                        double t = user.Compute(preOp, prevalue, Double.parseDouble(current));
                        current = "=" + fixType(t);
                    } else
                        current = "=" + fixType(Double.parseDouble(current));
                    preOp = '\0';
                    prevalue = Double.NaN;
                }
                break;
            case "btn_delete":
                current = "0";
                preOp = '\0';
                prevalue = Double.NaN;
                exp = "";
                user.release();
                break;
            case "btn_redo":
                current = "" + fixType(user.Redo(1));
                exp = current;
                break;
            case "btn_undo":
                current = "" + fixType(user.Undo(1));
                exp = current;
                break;
            case "btn_plus_minus":
                if (!current.matches(operators) && !current.contains("="))
                    if (Double.parseDouble(current) != 0)
                        current = "" + fixType(-Double.parseDouble(current));
                break;
            default:
                break;
        }
        tvResult.setText(current);
        tvExp.setText(exp);
    }

    /**
     * Fix type of value
     */
    Object fixType(double value) {
        double decimal = value - (long) value;
        if (decimal == 0f)
            return (long) value;
        else return format(value);
    }

    /**
     * Format double value to fixed decimal
     */
    double format(double value) {
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
        decimalFormat.applyPattern(pattern);
        String temp = decimalFormat.format(value);
        return Double.parseDouble(temp);
    }
}
