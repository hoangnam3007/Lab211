/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0011;

import java.util.Stack;

/**
 *
 * @author Admin
 */
public class Manager {

    public static final char[] hexa_Pattern = {'0', '1', '2', '3',
        '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static int Menu() {
        System.out.println("=============== Change Base Number ==================");
        System.out.println("1. Binary");
        System.out.println("2. Decimal");
        System.out.println("3. HexaDecimal");
        System.out.print("Your choice: ");
        int choice = Validate.checkInt();
        return choice;
    }

    public static int displayMenu(String from, String case1, String case2, String case3) {
        System.out.println("1. From " + from + " to " + case1);
        System.out.println("2. From" + from + " to " + case2);
        System.out.println("3. From" + from + " to" + case3);
        System.out.print("Enter your choice: ");
        int choice = Validate.checkLimit(1, 3);
        return choice;
    }

    public static void ConvertFromBinary() {
        int choice = displayMenu("Binary", "Binary", "Decimal", "HexaDecimal");
        String binary = Validate.Binary();
        switch (choice) {
            case 1:
                System.out.println("Binary + (BIN)=" + binary + "(BIN)");
                break;
            case 2:
                System.out.println("Binary (BIN)= " + convertBinaryToDecimal(binary) + "(DCM)");
                break;
            case 3:
                System.out.println("Binary(BIN) ="
                        + convertDecimalToHexa(convertBinaryToDecimal(binary)) + "(HEX)");
                break;
        }
    }

    // From Binary to Decimal:
    public static int convertBinaryToDecimal(String binary) {
        int bin = Integer.parseInt(binary);
        int tmp = 0;
        int digit;
        int decimal = 0;
        while (bin != 0) {
            digit = bin % 10;
            bin = bin / 10;
            decimal = (int) (decimal + (digit * Math.pow(2, tmp)));
            tmp++;
        }
        return decimal;
    }

    public static String convertDecimalToHexa(int decimal) {
        String hexa = "";
        while (decimal != 0) {
            hexa = hexa_Pattern[decimal % 16] + hexa;
            decimal /= 16;
        }
        return hexa;
    }

    public static void ConvertFromDecimal() {
        int choice = displayMenu("Decimal", "Decimal", "Binary", "HexaDecimal");
        String decimal = Validate.Decimal();
        switch (choice) {
            case 1:
                System.out.println("Decimal(DEC) =" + decimal + "DEC");
                break;
            case 2:
                System.out.println("Decimal(DEC) = " + convertDecimalToBinary(Integer.parseInt(decimal)) + "(BIN)");
                break;
            case 3:
                System.out.println("Decimal (DEC): " + convertDecimalToHexa(Integer.parseInt(decimal)) + "(HEX)");
                break;
        }
    }

    // From Decimal to Binary
    public static String convertDecimalToBinary(int decimal) {
        Stack stk = new Stack();
        int deci = decimal;
        while (deci != 0) {
            int digit = deci % 2;
            stk.push(digit);
            deci = deci / 2;
        }
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        return sb.toString() ;
    }

    public static void ConvertFromHexaDecimal() {
        int choice = displayMenu("HexaDecimal", "HexaDecimal", "Bianry", "Decimal");
        String hexaDecimal = Validate.HexaDecimal();
        switch (choice) {
            case 1:
                System.out.println("HexaDecimal(HEX) = " + hexaDecimal + "(HEX)");
                break;
            case 2:
                System.out.println("HexaDecimal (HEX) ="
                        + convertDecimalToBinary(convertHexaDecimalToDecimal(hexaDecimal)) + "(BIN)");
                break;
            case 3:
                System.out.println("HexaDecimal (HEX) =" + convertHexaDecimalToDecimal(hexaDecimal) + "(DEC)");
                break;
        }
    }

    public static int convertHexaDecimalToDecimal(String hexaDecimal) {
        int decimal = 0;
        String hexa = "0123456789ABCDEF";
        hexaDecimal = hexaDecimal.toUpperCase();
        for (int i = 0; i < hexaDecimal.length(); i++) {
            char c = hexaDecimal.charAt(i);
            int digit = hexa.indexOf(c);
            decimal = decimal * 16 + digit;
        }
        return decimal;
    }

}
