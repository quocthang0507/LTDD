package vn.edu.itdlu.a1610207.calculator;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ActionProgress_Error {
    List<String> list;
    List<String> oprList;
    List<String>[][] priorityList;
    Stack<String> stack;
    Stack<String> output;
    CoreFunctions functions = new CoreFunctions();

    //Performs action when user pressed the button
    //Textview is screen, command is the button that user pressed
    public void actionPerformed(TextView textView, String command) {
        String string = textView.getText().toString();              //Get the current string displayed on the screen
        int len = string.length();                                  //Length of string
        String last = len > 0 ? string.substring(len - 1) : "";     //Get the last character of string
        //When user pressed a number button
        if (command.matches("[0-9]")) {
            if (len > 0) {
                if (last.matches("[')']|['!']|['π']"))
                    string += "*" + command;
                else string += command;
            } else string = command;
        }
        //When user pressed an action button (or a function button)
        else {
            switch (command) {
                //Standard mode
                case "%":
                    if ((len > 0) && (last.matches("[0-9]|['!']|[')']|['π']")))
                        string += "%";
                    break;
                case "√":
                    if ((len > 0) && (last.matches("[0-9]|['!']|[')']|['π']")))
                        string += "*√(";
                    else string = "√(";
                    break;
                case "x²":
                    if ((len > 0) && (last.matches("[0-9]|['!']|[')']|['π']")))
                        string += "^(2)";
                    break;
                case "x³":
                    if ((len > 0) && (last.matches("[0-9]|['!']|[')']|['π']")))
                        string += "^(3)";
                    break;
                case "xʸ":
                    if ((len > 0) && (last.matches("[0-9]|['!']|[')']|['π']")))
                        string += "^(";
                    break;
                case "1/x":
                    if (last.matches("[')']|['!']|['π']"))
                        string += "*" + "1/(";
                    break;
                case "C":
                    string = "";
                    break;
                case "CE":
                    if (len > 0) {
                        if (!last.matches("[a-z]"))
                            string = string.substring(0, len - 1);
                        else {
                            String str_reverse = new StringBuilder(string).reverse().toString();
                            int index = 0;
                            String sub_reverse = Character.toString(str_reverse.charAt(index));
                            while (sub_reverse.matches("[a-z]")) {
                                sub_reverse = Character.toString(str_reverse.charAt(++index));
                            }
                            str_reverse = str_reverse.substring(index);
                            string = new StringBuilder(str_reverse).reverse().toString();
                        }
                    } else string = "";
                    break;
                case "±":
                    if (string.charAt(0) == '(' && string.charAt(string.length() - 1) == ')')
                        string = "neg" + string;
                    else string = "neg(" + string + ")";
                    break;
                case "(":
                    if (len > 0) {
                        if (last.matches("[')']|['!']|['π']"))
                            string += "*" + command;
                        else string += command;
                    } else string = command;
                    break;
                case ")":
                    if ((len > 0) && (last.matches("[')']|['!']|['π']")))
                        string += command;
                    break;
                case ".":
                    if ((len > 0) && last.matches("[0-9]"))
                        string += command;
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    if ((len > 0) && (last.matches("[0-9]|['!']|[')']|['π']")))
                        string += command;
                    break;
                //Scientific mode
                case "sin":
                case "cos":
                case "tan":
                case "sinh":
                case "cosh":
                case "tanh":
                case "log":
                case "exp":
                    if (len > 0) {
                        if (last.matches("[0-9]|['!']|[')']|['π']"))
                            string += "*" + command;
                        else string += command;
                    } else string = command;
                    break;
                case "mod":
                    if ((len > 0) && (last.matches("[0-9]|['!']|[')']|['π']")))
                        string += command;
                    break;
                case "π":
                    if (len > 0) {
                        if (last.matches("[0-9]|['!']|[')']|['π']"))
                            string += "*π";
                        else string += "π";
                    } else string = "π";
                    break;
                case "!":
                    if ((len > 0) && (last.matches("[0-9]|['!']|[')']|['π']")))
                        string += "!";
                    break;
                //Programmer mode
                case "xor":
                case "or":
                case "and":
                    if ((len > 0) && (last.matches("[0-9]|['!']|[')']|['π']")))
                        string += command;
                    break;
                case "not":
                    break;
                default:
                    if (len > 0) {
                        int counter = 0;
                        for (int i = 0; i < len; i++)
                            if (string.charAt(i) == '(')
                                counter++;
                            else if (string.charAt(i) == ')')
                                counter--;
                        if (counter > 0) {
                            //Dư dấu mở ngoặc
                        } else if (counter < 0) {
                            //Dư dấu dóng ngoặc
                        }
                    } else {
                        //No input!!!
                    }
                    break;
            }
        }
        textView.setText(string);
    }

    private void createTokens(String infix) {
        int x = 0, y = 0, m = 0;
        char[] array = infix.toCharArray();
        String temp = "";
        this.list = new ArrayList<String>();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            String str = "" + array[i];
            if (str.matches("[0-9]|[.]")) {

            }
        }
    }

    private void setPriority() {
    }

    private void evalPostfix() {
    }

    private void toPostfix() {
    }

}
