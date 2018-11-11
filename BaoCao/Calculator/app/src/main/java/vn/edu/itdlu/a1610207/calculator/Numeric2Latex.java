package vn.edu.itdlu.a1610207.calculator;

public class Numeric2Latex {

    static String percent(String str) {
        return "$$" + str + "\\%$$";
    }

    static String sqrt(String str) {
        return "$$\\sqrt{" + str + "}$$";
    }

    static String pow(String str1, String str2) {
        return "$$" + str1 + "^{" + str2 + "}$$";
    }

    static String inverse(String str) {
        return "$$\\frac{1}{" + str + "}$$";
    }

    static String mul(String str1, String str2) {
        return "$$" + str1 + "\\times" + str2 + "$$";
    }

    static String div(String str1, String str2) {
        return "$$\\frac{" + str1 + "}{" + str2 + "}$$";
    }

    static String sin(String str) {
        return "$$\\sin(" + str + "$$";
    }

    static String cos(String str) {
        return "$$\\cos(" + str + "$$";
    }

    static String tan(String str) {
        return "$$\\tan(" + str + "$$";
    }

    static String arcsin(String str) {
        return "$$\\arcsin(" + str + "$$";
    }

    static String arccos(String str) {
        return "$$\\arccos(" + str + "$$";
    }

    static String arctan(String str) {
        return "$$\\arctan(" + str + "$$";
    }

    static String exp(String str) {
        return "$$\\exp(" + str + "$$";
    }

    static String ln(String str) {
        return "$$\\ln(" + str + "$$";
    }

    static String log(String str) {
        return "$$\\log(" + str + "$$";
    }

    static String pi() {
        return "$$\\pi$$";
    }

}
