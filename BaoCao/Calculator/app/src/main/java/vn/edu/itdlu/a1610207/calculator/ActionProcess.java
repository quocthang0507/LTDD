package vn.edu.itdlu.a1610207.calculator;

import android.widget.TextView;

public class ActionProcess {

    /**
     * Check if the equation is completed
     * true, you can change the last operator
     * false, input string and operator will be joined
     */
    boolean completed;

    /**
     * Perform an action when user press
     */
    public void actionPerformed(TextView expression, TextView input, String command) {
        CoreFunctions fn = new CoreFunctions();
        String in = input.getText().toString();
        String exp = expression.getText().toString();
        switch (command) {

            //Standard mode

            case "%":   //Percentage
                exp += in + "/100";
                completed = true;
                in = "" + (Double.parseDouble(in) / 100);
                break;
            case "√":   //Square root
                exp += "sqrt(" + in + ")";
                completed = true;
                in = "" + fn.sqrt(Double.parseDouble(in));
                break;
            case "x²":  //x squared
                exp += "sqr(" + in + ")";
                completed = true;
                in = "" + fn.pow(Double.parseDouble(in), 2);
                break;
            case "⅟":   //Multiplicative inverse
                if (in == "0" || Double.parseDouble(in) == 0)
                    in = "Cannot divide by zero";
                else {
                    exp += "1/(" + in + ")";
                    in = "" + fn.pow(Double.parseDouble(in), -1);
                }
                completed = true;
                break;
            case "_C":  //Delete all
                exp = "";
                in = "0";
                //Process other variables here ...
                break;
            case "CE":  //Delete current number
                in = "0";
                break;
            case "←":   //Backspace
                if (in == "0" || Double.parseDouble(in) == 0)
                    if (!completed)
                        in = in.substring(0, in.length() - 1);
                break;
            case "0":   //Number
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                if (completed) {
                    actionPerformed(expression, input, "_C");
                }
                completed = false;
                in += command;
                break;
            case "÷":   //Division
            case "×":   //Multiplication
            case "-":   //Minus
            case "+":   //Plus
                if (exp.matches("['+']|['\\-']|['*']|['/']")) {
                    actionPerformed(expression, input, "=");
                    if (exp.substring(exp.length() - 1).matches("['+']|['\\-']|['*']|['/']")) {
                        exp = exp.substring(0, in.length() - 1) + " " + command + " ";
                    } else exp += in + " " + command + " ";
                }
                break;
            case "±":   //Negative
                if (completed) {
                    exp = "negate(" + in + ")";
                }
                in = "" + fn.neg(Double.parseDouble(in));
                break;
            case ".":   //Decimal
                if (exp.substring(exp.length() - 1).matches("['+']|['\\-']|['*']|['/']")) {
                    if (!in.contains(command))
                        in = "0" + command;
                } else in += command;
                break;
            case "=":   //Equal
                //Perform the calculation
                completed = true;
                break;

            //Scientific mode

            case "^":   //x to the power of y
                break;
            case "10^": //Power of 10
                break;
            case "sin": //Trigonometry
            case "cos":
            case "tan":
            case "sinh"://Hyperbolic
            case "cosh":
            case "tanh":
                break;
            case "log": //The natural logarithm of x
            case "exp": //Exponential function
            case "mod": //Modulo
                break;
            case "π":   //The mathematical constant π
                break;
            case "!":   //Factorial of x
                break;
            case "(":   //Open parenthesis
                break;
            case ")":   //CLose parenthesis
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
    }
}
