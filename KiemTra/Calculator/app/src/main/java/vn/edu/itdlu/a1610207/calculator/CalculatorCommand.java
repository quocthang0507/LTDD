package vn.edu.itdlu.a1610207.calculator;

//CalculatorCommand class inherits from Command class
public class CalculatorCommand extends Command {

    char _operator;
    double _operand;
    Calculator _calculator;

    public CalculatorCommand(Calculator calculator, char operator, double operand) {
        this._calculator = calculator;
        this._operator = operator;
        this._operand = operand;
    }

    public void setOperator(char operator) {
        this._operator = operator;
    }

    public void setOperand(int operand) {
        this._operand = operand;
    }

    @Override
    public double Execute() { return _calculator.Operation(_operator, _operand); }

    @Override
    public double UnExecute() {
        return _calculator.Operation(Undo(_operator), _operand);
    }

    /**
     * Return opposite operator for given operator
     */
    char Undo(char operator) {
        switch (operator) {
            case '+':
                return '-';
            case '-':
                return '+';
            case '*':
                return '/';
            case '/':
                return '*';
            default:
                throw new IllegalArgumentException();
        }
    }
}
