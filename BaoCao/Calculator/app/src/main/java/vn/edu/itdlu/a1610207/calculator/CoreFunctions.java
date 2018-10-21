package vn.edu.itdlu.a1610207.calculator;

/**
 * Date calculation
 */

import android.widget.Spinner;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;
import org.joda.time.Weeks;
import org.joda.time.Years;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                    "TOP", "TRY", "TTD", "TWD", "TZS", "UAH", "UGX", "USD", "UYU", "UZS", "VEF",
                    "VND", "VUV", "WST", "XAF", "XCD", "XDR", "XOF", "XPF", "YER", "ZAR", "ZMW"};

    /**
     * Apply decimal format for double value
     */
    DecimalFormat decimalFormat = new DecimalFormat(".######");

    /**
     * Length converter
     * The base unit in the International System of Units (SI) is the metre (or meter)
     */
    String[] Length =
            {"Nanometers", "10^-9", "Microns", "10^-6", "Millimeters", "10^-3",
                    "Centimeters", "10^-2", "Meters", "1", "Kilometers", "10^3",
                    "Inches", "0.0254", "Feet", "0.3048", "Yards", "0.91", "Miles", "1610"};

    /**
     * Volume converter
     * According to the SI System, the base unit for measuring volume is the metre and
     * volumes are thus measured in cubic metres
     */
    String[] Volume =
            {"Milliliters", "10^-6", "Cubic centimeters", "10^-6",
                    "Liters", "10^-3", "Cubic meters", "1", "Cubic inches", "0.000016387064",
                    "Cubic feet", "0.0283168466", "Cubic yards", "0.764554858"};

    /**
     * Mass converter
     * The basic SI unit of mass is the kilogram (kg)
     */
    String[] Weight_Mass =
            {"Carats", "0.0002", "Milligrams", "10^-6", "Centigrams", "10^-5", "Decigrams", "10^-4",
                    "Grams", "10^-3", "Dekagrams", "10^-2", "Hectograms", "10^-1", "Kilograms", "1",
                    "Ounces", "0.0283495231", "Pounds", "0.45359237"};

    /**
     * Temperature converter
     * The basic unit of temperature in the International System of Units (SI) is the kelvin
     */
    String[] Temperature = {"Celsius", "Fahrenheit", "Kelvin"};

    /**
     * Energy converter
     * the SI unit for energy is the same as the unit of work – the joule (J)
     */
    String[] Energy =
            {"Electron volts", "1.60217662×10^-19", "Joules", "1", "Kilojoules", "1000",
                    "Thermal calories", "4184", "Food calories", "4184", "Foot-pounds", "1.35581795"};

    /**
     * Data converter
     * The most commonly used units of data storage capacity are the bit
     */

    String[] Data = {"Bits", "Bytes",
            "Kilobits", "Kibibits", "Kilobytes", "Kibibytes",
            "Megabits", "Mebibits", "Megabytes", "Mebibytes",
            "Gigabits", "Gibibits", "Gigabytes", "Gibibytes",
            "Terabits", "Tebibits", "Terabytes", "Tebibytes",
            "Petabits", "Pebibits", "Petabytes", "Pebibytes",
            "Exabits", "Exbibits", "Exabytes", "Exbibytes",
            "Zetabits", "Zebibits", "Zetabytes", "Zebibytes",
            "Yottabits", "Yotbibits", "Yottabytes", "Yottbibytes"};

    /**
     * Area converter
     * In the International System of Units (SI), the standard unit of area is the square metre
     */
    String[] Area =
            {"Square millimeters", "10^-6", "Square centimeters", "0.0001", "Square meters", "1",
                    "Hectares", "10^4", "Square kilometers", "10^6", "Square inches", "0.00064516",
                    "Square feet", "0.09290304", "Square yards", "0.83612736", "Acres", "4046.85642",
                    "Square miles", "2589988.11"};

    /**
     * Speed converter
     * The SI unit of speed is the metre per second
     */
    String[] Speed =
            {"Centimeters per second", "0.01", "Meters per second", "1",
                    "Kilometers per hour", "0.277777778", "Feet per second", "0.3048",
                    "Miles per hour", "0.44704", "Knots", "0.514444444", "Mach", "340.29"};

    /**
     * Time converter
     * The base unit of time in the International System of Units (SI), and by extension most of the Western world, is the second
     */
    String[] Time =
            {"Microseconds", "10^-6", "Milliseconds", "0.001", "Seconds", "1", "Minutes", "60",
                    "Hours", "3600", "Days", "86400", "Weeks", "604800", "Years", "31556926"};

    /**
     * Power converter
     * In the International System of Units, the unit of power is the joule per second (J/s), known as the watt in honour of James Watt
     */
    String[] Power =
            {"Watts", "1", "Kilowatts", "1000", "Horsepower (US)", "745.699872",
                    "Foot-pounds/minute", "0.0225969658", "BTUs/minute", "17.5842642"};

    /**
     * Pressure converter
     * The unit of pressure in the SI system is the pascal (Pa), defined as a force of one Newton per square meter
     */
    String[] Pressure =
            {"Atmospheres", "101325", "Bars", "10^5", "Kilopascals", "10^3",
                    "Millimeters of mercury", "133.322368", "Pascals", "1",
                    "Pounds per square inch", "6894.75729"};

    /**
     * Angle converter
     * The SI unit of angular measure is the radian
     */
    String[] Angle = {"Degrees", "pi/180", "Radians", "1", "Gradians", "pi/200"};

    /**************************************Calculator**************************************/

    /**
     * Percentage (%)
     */
    static double percentage(double n) {
        return n / 100;
    }

    /**
     * x^y
     * reciprocal 1/x (x^-1)
     * sqr x^2
     * 10^x
     */
    static double pow(double x, double y) {
        return Math.pow(x, y);
    }

    /**
     * Square root of x
     */
    static double sqrt(double x) {
        return Math.sqrt(x);
    }

    /**
     * Negative number
     */
    static double neg(double x) {
        return -x;
    }

    /**
     * Convert degrees to radians
     */
    static double deg2Rad(double x) {
        return Math.toRadians(x);
    }

    /**
     * Convert radians to degrees
     */
    static double rad2Deg(double x) {
        return Math.toDegrees(x);
    }

    /**
     * Common trigonometry
     * Such as: sin, cos, tan
     * isRadians: true if x is radians, false if x is degrees
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

    /**
     * Common hyperbolic
     * Such as: sinh, cosh, tanh
     * isRadians: true if x is radians, false if x is degrees
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

    /**
     * The natural logarithm of x
     */
    static double log(double x) {
        return Math.log(x);
    }

    /**
     * Exponential function
     * The method returns the base of the natural logarithms, e, to the power of the argument
     */
    static double exp(double x) {
        return Math.exp(x);
    }

    /**
     * The mathematical constant π
     */
    static double pi() {
        return Math.PI;
    }

    /**
     * Factorial of x
     */
    static long factorial(int x) {
        if (x > 0)
            return x * factorial(x - 1);
        else return 1;
    }

    /**
     * Convert from base to another base
     */
    static String convertFromBaseToBase(String str, int fromBase, int toBase) {
        return Integer.toString(Integer.parseInt(str, fromBase), toBase);
    }

    /**
     * The Bitwise Operators: And (&), Or (|), Not (~), Xor (^)
     */
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

    /**
     * Difference between 2 dates
     */
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

    /**
     * Date1 add or subtract date2
     */
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

    /**
     * Get HTML source from link
     */
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

    /**************************************Converter**************************************/

    /**
     * Return a string whose value was formatted by decimalFormat
     */
    String format(double value) {
        return decimalFormat.format(value);
    }

    /**
     * Get the exchange rates from website
     */
    double GetExchangeRate(String unit1, String unit2) {
        String url = "https://free.currencyconverterapi.com/api/v6/convert?q=" + unit1 + "_" + unit2 + "&compact=y";
        String content = GetHTMLSource(url);
        Pattern pattern = Pattern.compile("([\\d.]+)");
        Matcher matcher = pattern.matcher(content);
        if (matcher.find())
            return Double.parseDouble(matcher.group());
        else return 0;
    }

    /**
     * Convert string to double, especially if it have power symbol
     */
    double string2Double(String string) {
        if (string.contains("^")) {
            String[] temp = string.split("^");
            double p1 = Double.parseDouble(temp[0]);
            int p2 = Integer.parseInt(temp[1]);
            return pow(p1, p2);
        } else if (string.contains("/")) {
            String[] temp = string.split("/");
            return pi() / Integer.parseInt(temp[1]);
        } else return Double.parseDouble(string);
    }

    /************************Rule of function***********************
     ****** array is the reference unit for converter function******
     ************ id1 is index of the unit of the value*************
     ************ id2 is index of the unit of result****************/

    /**
     * The temperature converter function
     */
    double temperatureConverter(int id1, double value, int id2) {
        if (id1 == id2)
            return value;
        else {
            if (id1 == 0) {
                return id2 == 1 ? 9 / 5 * value + 32 : value + 273;
            } else if (id1 == 1) {
                return id2 == 0 ? 5 / 9 * (value - 32) : 5 / 9 * (value - 32) + 273;
            } else {
                return id2 == 0 ? value - 273 : 9 / 5 * (value - 273) + 32;
            }
        }
    }

    /**
     * Lookup the index in the references unit array
     */
    int getIndexOfArray(String[] array, String unit) {
        int length = array.length;
        for (int i = 0; i < length; i++)
            if (array[i] == unit)
                return i;
        return -1;
    }

    /**
     * Get the index of selected value of spinner
     */
    int getIndexFromSpinner(String[] array, Spinner spinner) {
        return getIndexOfArray(array, spinner.getSelectedItem().toString());
    }

    /**
     * Other unit converter function
     */
    double otherConverter(String[] array, int id1, double value, int id2) {
        if (id1 == id2)
            return value;
        else {
            //1 unit of id1 = ? unit of base
            double base1 = string2Double(array[id1 + 1]);
            //1 unit of id2 = ? unit of base
            double base2 = string2Double(array[id2 + 1]);
            //Get crosshair value
            return base1 / base2;
        }
    }
}
