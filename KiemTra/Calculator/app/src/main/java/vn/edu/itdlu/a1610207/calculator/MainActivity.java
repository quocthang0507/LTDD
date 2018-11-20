package vn.edu.itdlu.a1610207.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    User user;
    TextView tvResult, tvExp;
    double preValue = Double.NaN;   //The previous value of this calculator
    String operators = "['+']|['*']|['/']"; //Use for regex pattern
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
    }

    public void btDot_OnClick(View v) {
        String current = tvResult.getText().toString();
        if (containDigit(current))
            current += ".";
        tvResult.setText(current);
    }

    public void btEqual_OnClick(View v) {
        String current = tvResult.getText().toString();
        if (containDigit(current)) {
            tvExp.setText(tvExp.getText().toString() + fixType(Double.parseDouble(current)));
            if (preOp != '\0') {
                double t = user.Compute(preOp, preValue, Double.parseDouble(current));
                current = "=" + fixType(t);
            } else
                current = "=" + fixType(Double.parseDouble(current));
            preOp = '\0';
            preValue = Double.NaN;
        }
        tvResult.setText(current);
    }

    public void btUndo_OnClick(View v) {
        String temp = "" + fixType(user.Undo(1));
        tvResult.setText(temp);
        tvExp.setText(temp);
    }

    public void btRedo_OnClick(View v) {
        String temp = "" + fixType(user.Redo(1));
        tvResult.setText(temp);
        tvExp.setText(temp);
    }

    public void btPlusMinus_OnClick(View v) {
        String current = tvResult.getText().toString();
        if (containDigit(current))
            if (Double.parseDouble(current) != 0)
                current = "" + fixType(-Double.parseDouble(current));
        tvResult.setText(current);
    }

    public void btDelete_OnClick(View v) {
        tvResult.setText("0");
        tvExp.setText("");
        preOp = '\0';
        preValue = Double.NaN;
        user.release();
    }

    public void btNumber_OnClick(View v) {
        String str = tvResult.getText().toString();
        if (str.equals("0"))
            str = "";
        if (!str.contains("=")) {
            if (str.matches(operators) || str.contains("-"))
                str = "";
            Button b = (Button) v;
            str += b.getText().toString();
            tvResult.setText(str);
        }
    }

    public void btOperator_OnClick(View v) {
        String current = tvResult.getText().toString();
        char c;
        if (v.getId() == R.id.btn_plus) c = '+';
        else if (v.getId() == R.id.btn_minus) c = '-';
        else if (v.getId() == R.id.btn_mul) c = '*';
        else c = '/';
        if (!current.contains("=")) {   //When the equation isn't complete
            if (!Double.isNaN(preValue) && containDigit(current)) //When user imports number secondly
                if (preOp != c && preOp != '\0')
                    preValue = user.Compute(preOp, preValue, Double.parseDouble(current));
                else preValue = user.Compute(c, preValue, Double.parseDouble(current));
            else if (Double.isNaN(preValue) && containDigit(current)) ////When user imports number firstly
                preValue = Double.parseDouble(current);
        } else {    //When the equation has completed
            preValue = Double.parseDouble(current.substring(1, current.length()));
        }
        tvResult.setText("" + c);
        tvExp.setText("" + fixType(preValue) + c);
        preOp = c;
    }

    /**
     * Check that a string contains at least a digit number
     */
    boolean containDigit(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++)
            if (Character.isDigit(str.charAt(i)))
                return true;
        return false;
    }

    /**
     * Find proper type of value
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
