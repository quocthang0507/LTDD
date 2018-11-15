package vn.edu.itdlu.a1610207.calculator;

import android.util.Log;

import java.util.ArrayList;

public class User {

    Calculator _calculator;
    ArrayList<Command> _commands = new ArrayList<>();
    int _current = 0;

    public double Redo(int levels) {
        double temp = 0;
        Log.i("Thang_DLU", "Redo " + levels + " levels");
        for (int i = 0; i < levels; i++) {
            if (_current < _commands.size()) {
                Command command = (Command)_commands.get(_current++);
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

    public double Compute(char operator, double prevalue, double operand) {
        _calculator = new Calculator(prevalue);
        double temp;
        Command command = new CalculatorCommand(_calculator, operator, operand);
        temp = command.Execute();
        _commands.add(command);
        _current++;
        return temp;
    }

    void release() {
        _commands = new ArrayList<>();
        _current = 0;
    }
}
