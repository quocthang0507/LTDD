package vn.edu.itdlu.a1610207.calculator;

import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;
import org.joda.time.Weeks;
import org.joda.time.Years;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CoreFunctions {
    //Percentage (%)
    static double percentage(double n) {
        return n / 100;
    }

    //x^y
    //reciprocal 1/x (x^-1)
    //sqr x^2
    //10^x
    static double pow(double x, double y) {
        return Math.pow(x, y);
    }

    //Square root of x
    static double sqrt(double x) {
        return Math.sqrt(x);
    }

    //Negating number
    static double neg(double x) {
        return -x;
    }

    //i = 0: The C button will clear all input to the calculator.
    //i = 1: The CE button clears the most recent entry
    //i = 2: Backspace
    static void del(int i) {
        //Do something here
    }

    //Convert degrees to radians
    static double deg2Rad(double x) {
        return Math.toRadians(x);
    }

    //Convert radians to degrees
    static double rad2Deg(double x) {
        return Math.toDegrees(x);
    }

    //Common trigonometry
    //sin, cos, tan
    //isRadians: true if x is radians, false if x is degrees
    static double trigonometry(String t, double x, boolean isRadians) {
        double value = 0;
        if (!isRadians)
            x = deg2Rad(x);
        switch (t) {
            case "sin":
                value = Math.sin(x);
                break;
            case "cos":
                value = Math.cos(x);
                break;
            case "tan":
                value = Math.tan(x);
                break;
        }
        return value;
    }

    //Common hyperbolic
    //sinh, cosh, tanh
    //isRadians: true if x is radians, false if x is degrees
    static double hyperbolic(String t, double x, boolean isRadians) {
        double value = 0;
        if (!isRadians)
            x = deg2Rad(x);
        switch (t) {
            case "sinh":
                value = Math.sinh(x);
                break;
            case "cosh":
                value = Math.cosh(x);
                break;
            case "tanh":
                value = Math.tanh(x);
                break;
        }
        return value;
    }

    //The natural logarithm of x
    static double log(double x) {
        return Math.log(x);
    }

    //Exponential function
    //The method returns the base of the natural logarithms, e, to the power of the argument.
    static double exp(double x) {
        return Math.exp(x);
    }

    //The mathematical constant π
    static double pi() {
        return Math.PI;
    }

    //Factorial of x
    static long factorial(int x) {
        if (x > 0)
            return x * factorial(x - 1);
        else return 1;
    }

    //Convert from base to another base
    static String convertFromBaseToBase(String str, int fromBase, int toBase) {
        return Integer.toString(Integer.parseInt(str, fromBase), toBase);
    }

    //The Bitwise Operators: And (&), Or (|), Not (~), Xor (^)
    static int not(int n) {
        return ~n;
    }

    static long bitwise(long a, long b, String t) {
        long value = 0;
        switch (t) {
            case "and":
                value = a & b;
                break;
            case "or":
                value = a | b;
                break;
            case "xor":
                value = a ^ b;
                break;
        }
        return value;
    }

    //Difference between 2 dates
    static String difference(String start, String stop) {
        String value = "";
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        Date d1 = null, d2 = null;
        try {
            d1 = format.parse(start);
            d2 = format.parse(stop);
            DateTime dt1 = new DateTime(d1);
            DateTime dt2 = new DateTime(d2);
            if (Years.yearsBetween(dt1, dt2).getYears() > 0)
                value += Years.yearsBetween(dt1, dt2).getYears() + " years, ";
            if (Months.monthsBetween(dt1, dt2).getMonths() > 0)
                value += Months.monthsBetween(dt1, dt2).getMonths() + " months, ";
            if (Weeks.weeksBetween(dt1, dt2).getWeeks() > 0)
                value += Weeks.weeksBetween(dt1, dt2).getWeeks() + " weeks, ";
            if (Days.daysBetween(dt1, dt2).getDays() > 0)
                value += Days.daysBetween(dt1, dt2).getDays() + " days";
            if (dt1 == dt2)
                value = "Same day";
        } catch (Exception e) {
            return null;
        }
        return value;
    }

    //date1 add or subtract date2
    static String ChangeDay(String date1, String date2, char c) {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        Date d1 = null, d2 = null;
        String value;
        try {
            d1 = format.parse(date1);
            d2 = format.parse(date2);
            DateTime dt1 = new DateTime(d1);
            DateTime dt2 = new DateTime(d2);
            switch (c) {
                case '+':
                    dt1.plusDays(dt2.getDayOfMonth());
                    dt1.plusMonths(dt2.getMonthOfYear());
                    dt1.plusYears(dt2.getYear());
                    break;
                case '-':
                    dt1.minusDays(dt2.getDayOfMonth());
                    dt1.minusMonths(dt2.getMonthOfYear());
                    dt1.minusYears(dt2.getYear());
                    break;
            }
            value = dt1.toString();
        } catch (Exception e) {
            return null;
        }
        return value;
    }
}
