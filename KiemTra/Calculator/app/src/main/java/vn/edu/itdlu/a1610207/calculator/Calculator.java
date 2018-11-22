package vn.edu.itdlu.a1610207.calculator;

import android.util.Log;

/**
 * The 'Receiver' class
 */
public class Calculator {

    double _curr = 0;

    public Calculator(double x) {
        _curr = x;
    }

    public double Operation(char operator, double operand) {
        switch (operator) {
            case '+':
                _curr += operand;
                break;
            case '-':
                _curr -= operand;
                break;
            case '*':
                _curr *= operand;
                break;
            case '/':
                if (operand != 0)
                    _curr /= operand;
                else _curr = Double.NaN;
                break;
            default:
                break;
        }
        Log.i("ThangDLU", operand + " " + operator + "= " + _curr);
        return _curr;
    }
}
