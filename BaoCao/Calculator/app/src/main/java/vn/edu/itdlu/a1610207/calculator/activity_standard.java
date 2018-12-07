package vn.edu.itdlu.a1610207.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class activity_standard extends AppCompatActivity {

    TextView tv_result, tv_exp;
    String operators = "['+']|['×']|['÷']", special = "['%']|['²']|['⁻¹']|[')']";
    PolishNotation notation = new PolishNotation();
    CoreFunctions functions = new CoreFunctions();

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

    String replaceString(String str) {
        str = str.replace("%", "/100");
        str = str.replace("²", "^^2");
        str = str.replace("⁻¹", "^^-1");
        str = str.replace('×', '*');
        str = str.replace('÷', '/');
        return str;
    }

    String replaceSqrt(String str) {
        str = str.substring(1, str.length());
        str += "^^(1/2)";
        return str;
    }

    String replaceAllSqrt(String str) {
        int length = str.length();
        int count = 0;
        int i, j = 0;
        for (i = 0; i < length; i++) {
            if (str.charAt(i) == '√') {
                boolean flag = false;
                for (j = i + 1; !flag || count != 0; j++)
                    if (str.charAt(j) == '(') {
                        count++;
                        flag = true;
                    } else if (str.charAt(j) == ')')
                        count--;
                str = str.replace(str.substring(i, j), replaceSqrt(str.substring(i, j)));
                length += 6;
            }
        }
        return str;
    }

    String replaceAllNegative(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == '-' && str.charAt(i + 1) == '(') {
                if (i == 0) { //-(x)
                    str = "0" + str; //0-(x)
                    length++;
                } else if (i > 0 && str.charAt(i - 1) == '(') { //(-(x))^2
                    str = str.substring(0, i) + "0" + str.substring(i); //(0-(x))^2
                    length++;
                }
            } else if (str.charAt(i) == '-' && i > 0 && str.charAt(i - 1) == '^') { //x^-1
                str = str.substring(0, i) + "(0-1)" + str.substring(i + 2); //x^(0-1)
                length += 3;
            }
        }
        return str;
    }

    boolean containDigit(String str) {
        if (str.matches(operators))
            return false;
        else return true;
    }

    boolean endWithSpecial(String str) {
        String last = str.substring(str.length() - 1);
        if (last.matches(special))
            return true;
        else return false;
    }

    public void btn_number_OnClick(View v) {
        String input = tv_result.getText().toString();
        String expression = tv_exp.getText().toString();
        if (input.equals("0"))
            input = "";
        else if (input.matches(operators) || input.equals("-")) {
            expression += input;
            input = "";
        }
        input += ((Button) v).getText().toString();
        tv_result.setText(input);
        tv_exp.setText(expression);
    }

    public void btn_neg_OnClick(View v) {
        String input = tv_result.getText().toString();
        if (containDigit(input)) {
            if (input.charAt(0) == '-') {
                input = input.substring(2, input.length() - 1);
            } else {
                input = "-(" + input + ")";
            }
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
        String exp = tv_exp.getText().toString();
        String input = tv_result.getText().toString();
        if (containDigit(input))
            exp += input;
        String newStr = replaceAllNegative(replaceAllSqrt(replaceString(exp)));
        notation.setBieuThuc(newStr);
        int flag = notation.KT_BT_Dung();
        if (flag == -1)
            Toast.makeText(getApplicationContext(), "Missing \")\"", Toast.LENGTH_LONG).show();
        else if (flag == -2)
            Toast.makeText(getApplicationContext(), "Missing \"(\"", Toast.LENGTH_LONG).show();
        else {
            notation.Chuyen_TrungTo_HauTo();
            String result = notation.Tinh_BieuThuc_HauTo(10).toString();
            input = functions.fixType(Double.parseDouble(result)).toString();
            tv_result.setText(input);
            tv_exp.setText(exp);
        }
    }

    public void btn_opr_OnClick(View v) {
        String input = tv_result.getText().toString();
        String expression = tv_exp.getText().toString();
        if (containDigit(input) && !input.equals("-") && !input.equals("0") ||
                expression.equals("") && input.equals("0"))
            expression += input;
        int id = v.getId();
        if (id == R.id.btn_plus)
            input = "+";
        else if (id == R.id.btn_mul)
            input = "×";
        else if (id == R.id.btn_sub)
            input = "-";
        else input = "÷";
        tv_exp.setText(expression);
        tv_result.setText(input);
    }

    public void btn_deleteAll_OnClick(View v) {
        tv_exp.setText("");
        tv_result.setText("0");
        notation.Reset();
    }

    public void btn_delete_OnClick(View v) {
        tv_result.setText("0");
    }

    public void btn_backspace_OnClick(View v) {
        String input = tv_result.getText().toString();
        input = input.substring(0, input.length() - 1);
        if (input.equals(""))
            input = "0";
        tv_result.setText(input);
    }

    public void btn_sqrt_OnClick(View v) {
        String input = tv_result.getText().toString();
        if (containDigit(input)) {
            input = "√(" + input + ")";
            tv_result.setText(input);
        }
    }

    public void btn_percent_OnClick(View v) {
        String input = tv_result.getText().toString();
        if (endWithSpecial(input)) {
            input = "(" + input + ")%";
        } else if (containDigit(input)) {
            input += "%";
        }
        tv_result.setText(input);
    }

    public void btn_square_OnClick(View v) {
        String input = tv_result.getText().toString();
        if (endWithSpecial(input)) {
            input = "(" + input + ")²";
        } else if (containDigit(input)) {
            input += "²";
        }
        tv_result.setText(input);
    }

    public void btn_reverse_OnClick(View v) {
        String input = tv_result.getText().toString();
        if (endWithSpecial(input)) {
            input = "(" + input + ")⁻¹";
        } else if (containDigit(input)) {
            input += "⁻¹";
        }
        tv_result.setText(input);
    }
}
