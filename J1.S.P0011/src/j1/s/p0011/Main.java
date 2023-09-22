/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0011;

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        while (true) {
            int choice = Manager.Menu();
            switch (choice) {
                case 1:
                    Manager.ConvertFromBinary();
                    break;
                case 2:
                    Manager.ConvertFromDecimal();
                    break;
                case 3:
                    Manager.ConvertFromHexaDecimal();
                    break;
                case 4:
                    return;
            }
        }
    }

}
