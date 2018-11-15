package vn.edu.itdlu.a1610207.calculator;

import android.widget.TextView;

import io.github.kexanie.library.MathView;

public class ActionProcess {

    public ActionProcess() {
    }

    /**
     * Perform an action when user press
     */
    public void actionPerformed(MathView formula, TextView expression, TextView input, String command, boolean completed) {
        CoreFunctions fn = new CoreFunctions();
        String in = input.getText().toString();
        String exp = expression.getText().toString();
        //Khong the phan biet duoc dau tru "-"
        String pattern = "['+']|['-']|['*']|['/']|['^']";
        String temp = "";
        if (exp.matches(pattern)) {
            if (!exp.substring(exp.length() - 1).matches(pattern)) {
                for (int i = exp.length() - 1; i >= 0; i--)
                    if (Character.toString(exp.charAt(i)).matches(pattern)) {
                        temp = exp.substring(i + 1, exp.length() - 1);
                        exp = exp.substring(0, i - 1);
                        break;
                    }
            } else temp = in;
        }
        switch (command) {

            //Standard mode

            case "btn_percent":   //Percentage
                if (temp.equals("")) {
                    exp = in + "/100";
                    in = "" + (Double.parseDouble(in) / 100);
                } else {
                    exp += temp + "/100";
                    actionPerformed(formula, expression, input, "btn_equal", false);
                }
                break;
            case "btn_sqrt":   //Square root
                if (temp.equals("")) {
                    exp = "sqrt(" + in + ")";
                    in = "" + fn.sqrt(Double.parseDouble(in));
                } else {
                    exp += "sqrt(" + temp + ")";
                    actionPerformed(formula, expression, input, "btn_equal", false);
                }
                break;
            case "btn_square":  //x squared
                if (temp.equals("")) {
                    exp = "sqr(" + in + ")";
                    in = "" + fn.pow(Double.parseDouble(in), 2);
                } else {
                    exp += "sqr(" + temp + ")";
                    actionPerformed(formula, expression, input, "btn_equal", false);
                }
                completed = true;
                break;
            case "btn_inverse":   //Multiplicative inverse
                if (in.equals("0"))
                    in = "Cannot divide by zero";
                else {
                    if (temp.equals("")) {
                        exp = "1/(" + in + ")";
                        in = "" + fn.pow(Double.parseDouble(in), -1);
                    } else {
                        exp += "1/(" + temp + ")";
                        actionPerformed(formula, expression, input, "btn_equal", false);
                    }
                }
                completed = true;
                break;
            case "btn_C":  //Delete all
                exp = "";
                in = "0";
                //Process other variables here ...
                break;
            case "btn_CE":  //Delete current number
                in = "0";
                break;
            case "btn_back":   //Backspace
                if (!in.equals("0"))
                    if (!completed)
                        in = in.substring(0, in.length() - 1);
                    else in = "0";
                if (in.equals(""))
                    in = "0";
                break;
            case "btn_0":   //Number
            case "btn_1":
            case "btn_2":
            case "btn_3":
            case "btn_4":
            case "btn_5":
            case "btn_6":
            case "btn_7":
            case "btn_8":
            case "btn_9":
                if (completed) {
                    actionPerformed(formula, expression, input, "btn_C", false);
                }
                if (temp.equals("0")) in = command.split("_")[1];
                else if(!temp.equals("")) in += command.split("_")[1];
                break;
            case "btn_div":   //Division
            case "btn_mul":   //Multiplication
            case "btn_minus":   //Minus
            case "btn_plus":   //Plus
                if (!temp.equals("")) {
                    actionPerformed(formula, expression, input, "=", true);
                    if (temp.equals("0")) {
                        exp = exp.substring(0, in.length() - 1) + " " + command + " ";
                    }
                } else {
                    if (command.equals("btn_div")) {
                        exp += in + " / ";
                    } else if (command.equals("btn_mul")) {
                        exp += in + " * ";
                    } else if (command.equals("btn_minus")) {
                        exp += in + " - ";
                    } else if (command.equals("btn_plus")) {
                        exp += in + " + ";
                    }
                }
                break;
            case "btn_neg":   //Negative
                if (temp.equals("")) {
                    exp = "negate(" + in + ")";
                    in = "" + fn.neg(Double.parseDouble(in));
                } else {
                    exp += "negate(" + temp + ")";
                    actionPerformed(formula, expression, input, "btn_equal", false);
                }
                break;
            case "btn_dot":   //Decimal
                if (exp.substring(exp.length() - 1).matches(pattern)) {
                    if (!in.contains("."))
                        in = "0.";
                } else in += ".";
                break;
            case "btn_equal":   //Equal
                //Perform the calculation
                completed = true;
                break;

            //Scientific mode

            case "btn_pow":   //x to the power of y
                //Xu ly giong phep cong tru nhan chia
                break;
            case "nroot":
                break;
            case "btn_10x": //Power of 10
                break;
            case "btn_ex":
                break;
            case "btn_sin": //Trigonometry
            case "btn_cos":
            case "btn_tan":
            case "btn_asin"://Hyperbolic
            case "btn_acos":
            case "btn_atan":
                break;
            case "btn_log": //The natural logarithm of x
            case "btn_exp": //Exponential function
            case "btn_ln":  //The natural logarithm
            case "btn_dms": //Degrees Decimal to Degrees Minutes Seconds
            case "btn_deg": //Degrees Minutes Seconds to Degrees Decimal
                break;
            case "btn_mod": //Modulo
                break;
            case "btn_pi":   //The mathematical constant π
                break;
            case "btn_factorial":   //Factorial of x
                break;
            case "btn_open":   //Open parenthesis
                break;
            case "btn_close":   //CLose parenthesis
                break;

            //Programmer mode

            case "xor": //The Bitwise Operators: And (&), Or (|), Not (~), Xor (^)
            case "or":
            case "and":
                break;
            case "not":
                break;
            case "A":   //Hexadecimal
            case "B":
            case "C":
            case "D":
            case "E":
            case "F":
                break;
            default:   //Calculate
                break;
        }
        expression.setText(exp);
        input.setText(in);
        //Convert numeric to Latex
    }
}
