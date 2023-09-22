/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0011;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validate {

    public static Scanner sc = new Scanner(System.in);
    public static final String Binary = "^[0-1]+$";
    public static final String decimal = "^[0-9]+$";
    public static final String hexa = "^[0-9a-fA-F]+$";

    public static int checkInt() {
        while (true) {
            try {
                String input = sc.nextLine();
                int number = Integer.parseInt(input);
                return number;
            } catch (NumberFormatException e) {
                System.out.print("Re-input: ");;
            }
        }
    }

    public static int checkLimit(int min, int max) {
        while (true) {
            try {
                int number = Integer.parseInt(sc.nextLine());
                if (number < min || number > max) {
                    throw new NumberFormatException();
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.print("Re-input: ");
            }
        }
    }

    public static String Binary() {
        while (true) {
            System.out.print("Enter binary: ");
            String input = sc.nextLine();
            if (input.matches(Binary)) {
                return input;
            } else {
                System.out.print("Re-input: ");
            }
        }
    }

    public static String Decimal() {
        while (true) {
            System.out.print("Enter Decimal: ");
            String input = sc.nextLine();
            if (input.matches(decimal)) {
                return input;
            } else {
                System.out.print("Re-input: ");
            }
        }
    }

    public static String HexaDecimal() {
        while (true) {
            System.out.print("Enter HexaDecimal: ");
            String input = sc.nextLine();
            if (input.matches(hexa)) {
                return input;
            } else {
                System.out.print("Re-input: ");
            }
        }
    }

}
