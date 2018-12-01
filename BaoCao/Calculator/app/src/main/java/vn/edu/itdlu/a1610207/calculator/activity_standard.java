package vn.edu.itdlu.a1610207.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_standard extends AppCompatActivity {

    TextView tv_result, tv_exp;
    String pattern = "['+']|['×']|['÷']", exp = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        map();
    }

    void map() {
        tv_result = findViewById(R.id.result);
        tv_exp = findViewById(R.id.formula);
    }

    boolean containDigit(String str) {
        if (str.matches(pattern))
            return false;
        else return true;
    }

    String formatExp(String exp) {
        return exp.replace('×', '*').replace('÷', '/');
    }

    public void btn_number_OnClick(View v) {
        String input = tv_result.getText().toString();
        String expression = tv_exp.getText().toString();
        if (input.equals("0"))
            input = "";
        else if (input.matches(pattern) || input.equals("−")) {
            expression += input;
            input = "";
        }
        input += ((Button) v).getText().toString();
        tv_result.setText(input);
        tv_exp.setText(expression);
    }

    public void btn_neg_OnClick(View v) {
        String input = tv_result.getText().toString();
        if (containDigit(input))
            if (input.charAt(0) == '−') {
                input = input.substring(2, input.length() - 1);
            } else {
                input = "−(" + input + ")";
            }
        tv_result.setText(input);
    }

    public void btn_dot_OnClick(View v) {
        String input = tv_result.getText().toString();
        if (Character.isDigit(input.charAt(input.length() - 1))) {
            input += ".";
        }
        tv_result.setText(input);
    }

    public void btn_equal_OnClick(View v) {
    }

    public void btn_opr_OnClick(View v) {
        String input = tv_result.getText().toString();
        String expression = tv_exp.getText().toString();
        if (containDigit(input) && !input.equals("−"))
            expression += input;
        int id = v.getId();
        if (id == R.id.btn_plus)
            input = "+";
        else if (id == R.id.btn_mul)
            input = "×";
        else if (id == R.id.btn_sub)
            input = "−";
        else input = "÷";
        tv_exp.setText(expression);
        tv_result.setText(input);
    }

    public void btn_deleteAll_OnClick(View v) {

    }

    public void btn_delete_OnClick(View v) {

    }

    public void btn_backspace_OnClick(View v) {

    }

    public void btn_sqrt_OnClick(View v) {

    }

    public void btn_percent_OnClick(View v) {

    }

    public void btn_square_OnClick(View v) {

    }

    public void btn_reverse_OnClick(View v) {

    }
}
