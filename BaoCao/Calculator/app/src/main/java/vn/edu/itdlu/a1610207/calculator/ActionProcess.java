package vn.edu.itdlu.a1610207.calculator;

import android.widget.TextView;

public class ActionProcess {
    public void actionPerformed(TextView textView, String command){
        switch (command){
                //Standard mode
            case "%":   //Percentage
                break;
            case "√":   //Square root
                break;
            case "x²":  //x squared
                break;
            case "⅟":   //Multiplicative inverse
                break;
            case "_C":  //Delete all
                break;
            case "CE":  //Delete current number
                break;
            case "←":   //Backspace
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
                break;
            case "÷":   //Division
            case "×":   //Multiplication
                break;
            case "-":   //Minus
            case "+":   //Plus
                break;
            case "±":   //Negative
                break;
            case ".":   //Decimal
                break;
            case "=":   //Equal
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
            default :   //Calculate
                break;
        }
    }
}
