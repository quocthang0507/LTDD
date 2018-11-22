package vn.edu.itdlu.a1610207.calculator;

import android.util.Log;

import java.util.ArrayList;

public class User {

    Calculator _calculator;
    ArrayList<Command> _commands = new ArrayList<>(); //Save calculating history
    int _current = 0;   //The status of the equation in _commands list

    public double Redo(int levels) {
        double temp = 0;
        Log.i("Thang_DLU", "Redo " + levels + " levels");
        for (int i = 0; i < levels; i++) {
            if (_current < _commands.size()) {
                Command command = (Command) _commands.get(_current++);
                temp = command.Execute();
            }
        }
        return temp;
    }

    public double Undo(int levels) {
        double temp = 0;
        Log.i("Thang_DLU", "Undo " + levels + " levels");
        for (int i = 0; i < levels; i++) {
            if (_current > 0) {
                Command command = (Command) _commands.get(--_current);
                temp = command.UnExecute();
            }
        }
        return temp;
    }

    /**
     * Create command operation and execute it
     */
    public double Compute(char operator, double preValue, double operand) {
        _calculator = new Calculator(preValue);
        double temp;
        Command command = new CalculatorCommand(_calculator, operator, operand);
        temp = command.Execute();
        //Save current equation to undo
        _commands.add(command);
        _current++;
        return temp;
    }

    void release() {
        _commands = new ArrayList<>();
        _current = 0;
    }
}
