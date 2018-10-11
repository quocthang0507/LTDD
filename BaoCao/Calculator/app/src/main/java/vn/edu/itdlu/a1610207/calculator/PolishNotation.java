package vn.edu.itdlu.a1610207.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolishNotation {
    String bieuThuc;
    List<String> input = new ArrayList<String>();
    Stack<String> stack = new Stack<String>();
    List<String> output = new ArrayList<String>();

    //Chuyển biểu thức (một chuỗi) thành một danh sách
    private void Chuyen_BieuThuc_DanhSach() {
        int len = bieuThuc.length();
        for (int i = 0; i < len; i++) {
            if (bieuThuc.charAt(i) >= '0' && bieuThuc.charAt(i) <= '9') {
                String t = Tach_So(bieuThuc, i);
                input.add(t);
                i += t.length() - 1;
            } else input.add(Character.toString(bieuThuc.charAt(i)));
        }
    }

    //Đếm số ký tự c có trong chuỗi bieuThuc
    private int Dem_SoKyTu(char c) {
        int len = bieuThuc.length();
        int count = 0;
        for (int i = 0; i <= len; i++) {
            if (bieuThuc.charAt(i) == c)
                count++;
        }
        return count;
    }

    //Chèn một ký tự vào chuỗi bieuThuc tại vị trí p
    void Chen_KyTu_Chuoi(int p, char c) {
        StringBuilder s = new StringBuilder(bieuThuc);
        s.insert(p, c);
        bieuThuc = s.toString();
    }

    //Trả về -1 nếu thiếu dấu đóng ngoặc
    //Trả về -2 nếu thiếu dấu mở ngoặc
    //Trả về 0 nếu sai cú pháp
    //Trả về 1 nếu nhập đúng
    private int KT_BT_Dung() {
        boolean flag = false;
        if (La_ToanTu(Character.toString(bieuThuc.charAt(0))))
            Chen_KyTu_Chuoi(0, '0');
        if (bieuThuc.contains("(") || bieuThuc.contains(")"))
            if (Dem_SoKyTu('(') > Dem_SoKyTu(')'))
                return -1;
            else if (Dem_SoKyTu('(') < Dem_SoKyTu(')'))
                return -2;
        int len = bieuThuc.length();
        for (int i = 0; i < len - 1; i++)
            if (La_ToanTu(Character.toString(bieuThuc.charAt(i))) && La_ToanTu(Character.toString(bieuThuc.charAt(i + 1))))
                return 0;
        return 1;
    }

    //Độ ưu tiên của toán tử
    private int Do_UuTien(String c) {
        if (c == "^" || c == "√")
            return 3;
        else if (c == "*" || c == "/" || c == "%")
            return 2;
        else if (c == "+" || c == "-")
            return 1;
        return 0;
    }

    //Kiểm tra một ký tự c có phải là một toán tử hay không?
    private boolean La_ToanTu(String c) {
        if (c == "+" || c == "-" || c == "*" || c == "/" || c == "%")
            return true;
        else return false;
    }

    //Kiểm tra s có phải là một số hay không?
    private boolean La_KySo(String s) {
        try {
            double x = Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //Tách số tại vị trí i trong chuỗi
    private String Tach_So(String s, int i) {
        String t = "";
        int len = s.length();
        do {
            t += s.charAt(i);
            i++;
        } while (i < len && ((s.charAt(i) >= '0' && s.charAt(i) <= '9') || s.charAt(i) == '.'));
        return t;
    }

    //Thực hiện việc chuyển đổi biểu thức trung tố sang biểu thức hậu tố
    private void Chuyen_TrungTo_HauTo() {
        Chuyen_BieuThuc_DanhSach();
        String x;
        for (String item : this.input) {
            if (La_KySo(item))
                output.add(item);
            else if (item == "(")
                stack.push(item);
            else if (item == ")") {
                x = stack.pop();
                while (x != "(") {
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

    //Tính giá trị biểu thức hậu tố
    private double Tinh_BieuThuc_HauTo() {
        double x, y;
        Stack<Double> s = new Stack<Double>();
        for (String item : output) {
            if (La_KySo(item)) {
                x = Double.parseDouble(item);
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
                            return Double.POSITIVE_INFINITY;
                        else s.push(y / x);
                        break;
                    case "%":
                        s.push(y % x);
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
