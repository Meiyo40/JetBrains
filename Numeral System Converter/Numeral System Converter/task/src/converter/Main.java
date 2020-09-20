package converter;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result = "";
        int integer = 0;
        String fraction = "";

        String radixInput = "";
        int srcRadix = 0;

        try {
            radixInput = scanner.next();
        } catch (NoSuchElementException e) {
            radixInput = "";
        }

        try {
            srcRadix = Integer.parseInt(radixInput);
        } catch (NumberFormatException e) {
            srcRadix = 0;
        }

        String srcNb = "";
        try {
            srcNb = scanner.next();
        } catch (NoSuchElementException e) {
            srcNb = "";
        }

        String baseInput = "";
        try {
            baseInput = scanner.next();
        } catch (NoSuchElementException e) {
            baseInput = "";
        }
        int base = 0;
        try {
            base = Integer.parseInt(baseInput);
        } catch (NumberFormatException e) {
            base = 0;
        }

        boolean isBaseTen = srcRadix == 10 ? true : false;
        boolean srcNbIsInteger = srcNb.contains(".") ? false : true;
        boolean srcRadixIsValid = srcRadix > 0 && srcRadix < 37? true : false;
        boolean baseIsValid = base > 0 && base < 37? true : false;

        if (srcRadixIsValid && baseIsValid) {
            if (!srcNbIsInteger) {

                String[] arr = srcNb.split("\\.");

                if (srcRadix == 1) {
                    integer = arr[0].split("").length;
                    fraction = String.valueOf(arr[1].split("").length);
                } else {
                    integer = Integer.parseInt(arr[0], srcRadix);
                    fraction = arr[1];
                }

                if (isBaseTen) {

                    result = convertToBase(base, integer, srcRadix) + "." + convertFractionToBase(base, Double.parseDouble("0."+fraction));

                } else {
                    String newInteger = convertToBase(base, integer, srcRadix);
                    double newFraction = decimalToBaseTen(fraction.split(""), srcRadix);
                    String newBaseFraction = convertFractionToBase(base, newFraction);

                    result = newInteger + "." + newBaseFraction;
                }

            } else {

                if (srcRadix == 1) {
                    result = convertToBase(base, Integer.parseInt(srcNb), srcRadix);
                } else {
                    result = convertToBase(base, Integer.parseInt(srcNb, srcRadix), srcRadix);
                }
            }

            System.out.println(result);
        } else {
            System.out.println("error");
        }
    }

    public static String convertFractionToBase(int base, double number) {
        String nb = "";

        for (int i = 0; i < 5; i++) {
            String decimal = String.valueOf(number * base);
            String[] nbDecimal = decimal.split("\\.");
            int val = Integer.parseInt(nbDecimal[0]);
            if (val > 0) {
                nb += getFractionSymbol(val);
                number = Double.parseDouble("0."+nbDecimal[1]);
            } else {
                return nb;
            }
        }

        return nb;
    }

    public static double decimalToBaseTen (String[] fraction, int sourceRadix) {
        double number = 0;
        for (int i = 0; i < fraction.length; i++) {
            fraction[i] = String.valueOf(Integer.parseInt(fraction[i], sourceRadix));
            number += Double.parseDouble(fraction[i]) / Math.pow(sourceRadix, i+1);
        }
        return number;
    }

    public static String convertToBase(int base, int number, int srcRadix) {
        if (srcRadix == 1) {
            number = String.valueOf(number).split("").length;
        }
        if (base > 1) {
            return Integer.toString(number, base);
        } else {
            String msg = "";
            for (int i = 0; i < number; i++) {
                msg += "1";
            }
            return msg;
        }
    }

    public static String getFractionSymbol(int  value) {
        String symbol = "";
        if (value < 10) {
            return String.valueOf(value);
        }
        switch (value) {
            case 10:
                symbol = "a";
                break;
            case 11:
                symbol = "b";
                break;
            case 12:
                symbol = "c";
                break;
            case 13:
                symbol = "d";
                break;
            case 14:
                symbol = "e";
                break;
            case 15:
                symbol = "f";
                break;
            case 16:
                symbol = "g";
                break;
            case 17:
                symbol = "h";
                break;
            case 18:
                symbol = "i";
                break;
            case 19:
                symbol = "j";
                break;
            case 20:
                symbol = "k";
                break;
            case 21:
                symbol = "l";
                break;
            case 22:
                symbol = "m";
                break;
            case 23:
                symbol = "n";
                break;
            case 24:
                symbol = "o";
                break;
            case 25:
                symbol = "p";
                break;
            case 26:
                symbol = "q";
                break;
            case 27:
                symbol = "r";
                break;
            case 28:
                symbol = "s";
                break;
            case 29:
                symbol = "t";
                break;
            case 30:
                symbol = "u";
                break;
            case 31:
                symbol = "v";
                break;
            case 32:
                symbol = "w";
                break;
            case 33:
                symbol = "x";
                break;
            case 34:
                symbol = "y";
                break;
            case 35:
                symbol = "z";
                break;
        }

        return symbol;
    }
}