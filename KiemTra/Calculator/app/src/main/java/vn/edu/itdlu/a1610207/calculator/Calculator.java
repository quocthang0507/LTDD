package vn.edu.itdlu.a1610207.calculator;

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
        }
        return _curr;
    }
}
