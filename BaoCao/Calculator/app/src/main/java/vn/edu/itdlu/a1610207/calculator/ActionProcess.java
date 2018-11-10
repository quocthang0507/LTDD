package vn.edu.itdlu.a1610207.calculator;

import android.widget.TextView;

import io.github.kexanie.library.MathView;

public class ActionProcess {

    /**
     * Check if the equation is completed
     * true, you can change the last operator
     * false, input string and operator will be joined
     */
    boolean completed = false;

    public ActionProcess() {
    }

    /**
     * Perform an action when user press
     */
    public void actionPerformed(MathView formula, TextView expression, TextView input, String command) {
        CoreFunctions fn = new CoreFunctions();
        String in = input.getText().toString();
        String exp = expression.getText().toString();
        String fo = formula.getText() == null ? "" : formula.getText();
        String pattern = "['+']|['-']|['*']|['/']";
        String temp;
        if (exp.matches(pattern)) {
            if (exp.substring(exp.length() - 1).matches(pattern))
                temp = "";
            else
                for (int i = exp.length() - 1; i >= 0; i--)
                    if (Character.toString(exp.charAt(i)).matches(pattern)) {
                        temp = exp.substring(i + 1, exp.length() - 1);
                    }
        } else temp = "";
        switch (command) {

            //Standard mode

            case "btn_percent":   //Percentage
                exp += in + "/100";
                fo += "$$" + in + "\\%$$";
                completed = true;
                in = "" + (Double.parseDouble(in) / 100);
                break;
            case "btn_sqrt":   //Square root
                exp += "sqrt(" + in + ")";
                fo += "$$\\sqrt{" + in + "}$$";
                completed = true;
                in = "" + fn.sqrt(Double.parseDouble(in));
                break;
            case "btn_square":  //x squared
                exp += "sqr(" + in + ")";
                fo += in + "^{2}";
                completed = true;
                in = "" + fn.pow(Double.parseDouble(in), 2);
                break;
            case "btn_inverse":   //Multiplicative inverse
                if (in.equals("0"))
                    in = "Cannot divide by zero";
                else {
                    exp += "1/(" + in + ")";
                    fo += "$$\\frac{1}{" + in + "}$$";
                    in = "" + fn.pow(Double.parseDouble(in), -1);
                }
                completed = true;
                break;
            case "btn_C":  //Delete all
                exp = "";
                in = "0";
                fo = "";
                //Process other variables here ...
                break;
            case "btn_CE":  //Delete current number
                in = "0";
                break;
            case "btn_back":   //Backspace
                if (!in.equals("0"))
                    if (!completed)
                        in = in.substring(0, in.length() - 1);
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
                    actionPerformed(formula, expression, input, "CE");
                }
                completed = false;
                if (in.equals("0")) in = command.split("_")[1];
                else in += command.split("_")[1];
                break;
            case "btn_div":   //Division
            case "btn_mul":   //Multiplication
            case "btn_minus":   //Minus
            case "btn_plus":   //Plus
                if (exp.matches("['+']|['-']|['*']|['/']|['^']")) {
                    actionPerformed(formula, expression, input, "=");
                    if (exp.substring(exp.length() - 1).matches("['+']|['-']|['*']|['/']|['^']")) {
                        exp = exp.substring(0, in.length() - 1) + " " + command + " ";
                    }
                } else {
                    if (command.equals("btn_div")) {
                        exp += in + " / ";
                        fo += in + " \\div ";
                    } else if (command.equals("btn_mul")) {
                        exp += in + " * ";
                        fo += in + "\\times";
                    } else if (command.equals("btn_minus")) {
                        exp += in + " - ";
                        fo += in + " - ";
                    } else if (command.equals("btn_plus")) {
                        exp += in + " + ";
                        fo += in + " + ";
                    }
                }
                break;
            case "btn_neg":   //Negative
                if (completed) {
                    exp = "negate(" + in + ")";
                    fo = "-(" + in + ")";
                }
                in = "" + fn.neg(Double.parseDouble(in));
                break;
            case "btn_dot":   //Decimal
                if (exp.substring(exp.length() - 1).matches("['+']|['-']|['*']|['/']")) {
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
                if (exp.matches("['+']|['-']|['*']|['/']|['^']")) {
                    actionPerformed(formula, expression, input, "=");
                    if (exp.substring(exp.length() - 1).matches("['+']|['-']|['*']|['/']|['^']")) {
                        exp = exp.substring(0, in.length() - 1) + " ^ ";
                    }
                } else exp += in + " ^ ";
                break;
            case "nroot":
                exp += "" + in + "rt(";
                break;
            case "btn_10x": //Power of 10
                break;
            case "btn_ex":
                break;
            case "btn_sin": //Trigonometry
            case "btn_cos":
            case "btn_tan":
            case "btn_sinh"://Hyperbolic
            case "btn_cosh":
            case "btn_tanh":
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
        formula.setText(fo);
    }
}
