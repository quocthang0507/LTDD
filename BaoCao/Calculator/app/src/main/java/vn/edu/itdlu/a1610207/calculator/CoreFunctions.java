package vn.edu.itdlu.a1610207.calculator;

//Date calculation

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;
import org.joda.time.Weeks;
import org.joda.time.Years;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Others


public class CoreFunctions {
    String[] Currency =
            {"AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN", "BAM", "BBD", "BDT",
                    "BGN", "BHD", "BIF", "BND", "BOB", "BRL", "BSD", "BTC", "BTN", "BWP", "BYN",
                    "BYR", "BZD", "CAD", "CDF", "CHF", "CLP", "CNY", "COP", "CRC", "CUP", "CVE",
                    "CZK", "DJF", "DKK", "DOP", "DZD", "EGP", "ERN", "ETB", "EUR", "FJD", "FKP",
                    "GBP", "GEL", "GHS", "GIP", "GMD", "GNF", "GTQ", "GYD", "HKD", "HNL", "HRK",
                    "HTG", "HUF", "IDR", "ILS", "INR", "IQD", "IRR", "ISK", "JMD", "JOD", "JPY",
                    "KES", "KGS", "KHR", "KMF", "KPW", "KRW", "KWD", "KYD", "KZT", "LAK", "LBP",
                    "LKR", "LRD", "LSL", "LVL", "LYD", "MAD", "MDL", "MGA", "MKD", "MMK", "MNT",
                    "MOP", "MRO", "MUR", "MVR", "MWK", "MXN", "MYR", "MZN", "NAD", "NGN", "NIO",
                    "NOK", "NPR", "NZD", "OMR", "PAB", "PEN", "PGK", "PHP", "PKR", "PLN", "PYG",
                    "QAR", "RON", "RSD", "RUB", "RWF", "SAR", "SBD", "SCR", "SDG", "SEK", "SGD",
                    "SHP", "SLL", "SOS", "SRD", "STD", "SYP", "SZL", "THB", "TJS", "TMT", "TND",
                    "TOP", "TRY", "TTD", "TWD", "TZS", "UAH", "UGX", "ele ", "UYU", "UZS", "VEF",
                    "VND", "VUV", "WST", "XAF", "XCD", "XDR", "XOF", "XPF", "YER", "ZAR", "ZMW"};

    String[] Volume = {"Millimeters", "Cubic centimeters", "Liters", "Cubic meters", "Cubic inches", "Cubic feet", "Cubic yards"};

    String[] Length = {"Nanometers", "Microns", "Millimeters", "Centimeters", "Meters", "Kilometers", "Inches", "Feet", "Yards", "Miles"};

    String[] Weight_Mass = {"Carats", "Milligrams", "Centigrams", "Decigrams", "Grams", "Dekagrams", "Hectograms", "Kilograms", "Ounces", "Pounds"};

    String[] Temperature = {"Celsius", "Fahrenheit", "Kelvin"};

    String[] Energy = {"Electron volts", "Joules", "Kilojoules", "Thermal calories", "Food calories", "Foot-pounds"};

    String[] Data = {"Bits", "Bytes",
            "Kilobits", "Kibibits", "Kilobytes", "Kibibytes",
            "Megabits", "Mebibits", "Megabytes", "Mebibytes",
            "Gigabits", "Gibibits", "Gigabytes", "Gibibytes",
            "Terabits", "Tebibits", "Terabytes", "Tebibytes",
            "Petabits", "Pebibits", "Petabytes", "Pebibytes",
            "Exabits", "Exbibits", "Exabytes", "Exbibytes",
            "Zetabits", "Zebibits", "Zetabytes", "Zebibytes",
            "Yottabits", "Yotbibits", "Yottabytes", "Yottbibytes"};

    String[] Area = {"Square millimeters", "Square centimeters", "Square meters", "Hectares", "Square kilometers", "Square inches", "Square feet", "Square yards", "Acres", "Square miles"};

    String[] Speed = {"Centimeters per second", "Meters per second", "Kilometers per hour", "Feet per second", "Miles per hour", "Knots", "Mach"};

    String[] Time = {"Microseconds", "Milliseconds", "Seconds", "Minutes", "Hours", "Days", "Weeks", "Years"};

    String[] Power = {"Watts", "Kilowatts", "Horsepower (US)", "Foot-pounds/minute", "BTUs/minute"};

    String[] Pressure = {"Atmospheres", "Bars", "Kilopascals", "Millimeters of mercury", "Pascals", "Pounds per square inch"};

    String[] Angle = {"Degrees", "Radians", "Gradians"};

    /**************************************Calculator**************************************/

    /* Percentage (%) */
    static double percentage(double n) {
        return n / 100;
    }

    /*
    x^y
    reciprocal 1/x (x^-1)
    sqr x^2
    10^x
    */
    static double pow(double x, double y) {
        return Math.pow(x, y);
    }

    /* Square root of x */
    static double sqrt(double x) {
        return Math.sqrt(x);
    }

    /* Negative number */
    static double neg(double x) {
        return -x;
    }

    /* Convert degrees to radians */
    static double deg2Rad(double x) {
        return Math.toRadians(x);
    }

    /* Convert radians to degrees */
    static double rad2Deg(double x) {
        return Math.toDegrees(x);
    }

    /*
    Common trigonometry
    Such as: sin, cos, tan
    isRadians: true if x is radians, false if x is degrees
    */
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

    /*
    Common hyperbolic
    Such as: sinh, cosh, tanh
    isRadians: true if x is radians, false if x is degrees
    */
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

    /* The natural logarithm of x */
    static double log(double x) {
        return Math.log(x);
    }

    /*
    Exponential function
    The method returns the base of the natural logarithms, e, to the power of the argument
    */
    static double exp(double x) {
        return Math.exp(x);
    }

    /* The mathematical constant π */
    static double pi() {
        return Math.PI;
    }

    /* Factorial of x */
    static long factorial(int x) {
        if (x > 0)
            return x * factorial(x - 1);
        else return 1;
    }

    /* Convert from base to another base */
    static String convertFromBaseToBase(String str, int fromBase, int toBase) {
        return Integer.toString(Integer.parseInt(str, fromBase), toBase);
    }

    /* The Bitwise Operators: And (&), Or (|), Not (~), Xor (^) */
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

    /* Difference between 2 dates */
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

    /* date1 add or subtract date2 */
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

    /**************************************Converter**************************************/

    /* Get HTML source from link */
    static String GetHTMLSource(String link) {
        URL url;
        try {
            url = new URL(link);
            return org.apache.commons.io.IOUtils.toString(url, "utf8");
        } catch (MalformedURLException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    /*Get the excange rates from website*/
    double GetExchangeRate(String unit1, String unit2) {
        String url = "https://free.currencyconverterapi.com/api/v6/convert?q=" + unit1 + "_" + unit2 + "&compact=y";
        String content = GetHTMLSource(url);
        Pattern pattern = Pattern.compile("([\\d.]+)");
        Matcher matcher = pattern.matcher(content);
        if (matcher.find())
            return Double.parseDouble(matcher.group());
        else return 0;
    }

    /*Convert array to list*/
    List<String> ConvertArray2List(String[] array) {
        return Arrays.asList(array);
    }
}
