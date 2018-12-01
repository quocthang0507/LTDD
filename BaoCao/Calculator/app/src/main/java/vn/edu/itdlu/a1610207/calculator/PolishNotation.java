package vn.edu.itdlu.a1610207.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolishNotation {
    String bieuThuc;
    List<String> input = new ArrayList<String>();
    Stack<String> stack = new Stack<String>();
    List<String> output = new ArrayList<String>();

    public String getBieuThuc(){return bieuThuc;}

    public void setBieuThuc(String bieuThuc){this.bieuThuc=bieuThuc;}

    public List<String> getInput(){return this.input;}

    public void setInput(List<String> input){this.input=input;}

    //Kiểm tra một ký tự c có phải là một toán tử hay không?
    static public boolean La_ToanTu(String c) {
        if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/") || c.equals("%") ||
                c.equals("^") || c.equals("&") || c.equals("|") || c.equals(">>") || c.equals("<<"))
            return true;
        else return false;
    }

    //Tách số tại vị trí i trong chuỗi s
    public String Tach_So(String s, int i) {
        String t = "";
        int len = s.length();
        do {
            t += s.charAt(i);
            i++;
        }
        while (i < len && (La_KySo("" + s.charAt(i)) || s.charAt(i) == '.'));
        return t;
    }

    //Chuyển biểu thức (một chuỗi) thành một danh sách
    public void Chuyen_BieuThuc_DanhSach() {
        int len = bieuThuc.length();
        for (int i = 0; i < len; i++) {
            if (bieuThuc.charAt(i) >= '0' && bieuThuc.charAt(i) <= '9' || bieuThuc.charAt(i) >= 'A' && bieuThuc.charAt(i) <= 'F') { //Nếu nó là số
                String t = Tach_So(bieuThuc, i);
                input.add(t);
                i += t.length() - 1;
            } else if (bieuThuc.charAt(i) == '>') {//Nếu nó là toán tử của phép dịch bit
                input.add(">>");
                i++;
            } else if (bieuThuc.charAt(i) == '<') {
                input.add("<<");
                i++;
            } else input.add(Character.toString(bieuThuc.charAt(i)));
        }
    }

    //Chèn một ký tự vào chuỗi bieuThuc tại vị trí p
    public void Chen_KyTu_Chuoi(int p, char c) {
        StringBuilder s = new StringBuilder(bieuThuc);
        s.insert(p, c);
        bieuThuc = s.toString();
    }

    //Trả về -1 nếu thiếu dấu đóng ngoặc
    //Trả về -2 nếu thiếu dấu mở ngoặc
    //Trả về 1 nếu nhập đúng
    public int KT_BT_Dung() {
        if (La_ToanTu(Character.toString(bieuThuc.charAt(0))))
            Chen_KyTu_Chuoi(0, '0');
        int len = bieuThuc.length();
        int counter = 0;
        for (int i = 0; i < len; i++) {
            if (bieuThuc.charAt(i) == '(')
                counter++;
            else if (bieuThuc.charAt(i) == ')')
                counter--;
        }
        return counter == 0 ? 1 : counter > 0 ? -1 : -2;
    }

    //Độ ưu tiên của toán tử
    public int Do_UuTien(String c) {
        if (c.equals("*") || c.equals("/") || c.equals("%"))
            return 4;
        else if (c.equals("+") || c.equals("-"))
            return 3;
        else if (c.equals("&"))
            return 2;
        else if (c.equals("|") || c.equals("^"))
            return 1;
        return 0;
    }

    //Kiểm tra s có phải là một số hay không?
    public boolean La_KySo(String s) {
        try {
            Long.parseLong(s, 16);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    //Thực hiện việc chuyển đổi biểu thức trung tố sang biểu thức hậu tố
    public void Chuyen_TrungTo_HauTo() {
        Chuyen_BieuThuc_DanhSach();
        String x;
        for (String item : this.input) {
            if (La_KySo(item))
                output.add(item);
            else if (item.equals("("))
                stack.push(item);
            else if (item.equals(")")) {
                x = stack.pop();
                while (!x.equals("(")) {
                    output.add(x);
                    x = stack.pop();
                }
            } else {
                while (!stack.empty() && La_ToanTu(stack.peek()))
                    if (Do_UuTien(stack.peek()) >= Do_UuTien(item)) {
                        x = stack.pop();
                        output.add(x);
                    } else break;
                stack.push(item);
            }
        }
        while (!stack.empty()) {
            x = stack.pop();
            output.add(x);
        }
    }

    //Tính giá trị biểu thức hậu tố, trả về cơ số 10
    public long Tinh_BieuThuc_HauTo(int radix) {
        long x, y;
        Stack<Long> s = new Stack<Long>();
        for (String item : output) {
            if (La_KySo(item)) {
                x = Long.parseLong(item, radix);
                s.push(x);
            } else {
                x = s.pop();
                y = s.pop();
                switch (item) {
                    case "+":
                        s.push(y + x);
                        break;
                    case "-":
                        s.push(y - x);
                        break;
                    case "*":
                        s.push(y * x);
                        break;
                    case "/":
                        if (x == 0)
                            return Long.MAX_VALUE;
                        else s.push(y / x);
                        break;
                    case "%":
                        s.push(y % x);
                        break;
                    case "&":
                        s.push(y & x);
                        break;
                    case "^":
                        s.push(y ^ x);
                        break;
                    case "|":
                        s.push(y | x);
                        break;
                    case ">>":
                        s.push(y >> x);
                        break;
                    case "<<":
                        s.push(y << x);
                        break;
                    default:
                        break;
                }
            }
        }
        return s.peek();
    }

    public void Reset() {
        bieuThuc = "";
        input.clear();
        output.clear();
        stack.clear();
    }
}
