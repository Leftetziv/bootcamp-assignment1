/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataentry;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Leyteris
 */
public class ReadFromUserUtilities {

    static Scanner sc = new Scanner(System.in);

    public static int readNumberOrQuit(int start, int end) {
        String answerStr;

        do {
            answerStr = sc.nextLine();

            if ("q".equalsIgnoreCase(answerStr)) {
                return -1;
            }

            try {
                int answerInt = Integer.parseInt(answerStr);

                if (answerInt >= start && answerInt <= end) {
                    return answerInt;
                } else {
                    System.out.println("Input a number from " + start + " to " + end);
                }
            } catch (NumberFormatException e) {
                System.out.println("Input a number from " + start + " to " + end + ", or q to quit");
            }
        } while (true);
    }
    
    public static LocalDate readLocalDateOrQuit() {
        String answerStr;

        do {
            answerStr = sc.nextLine();

            if ("q".equalsIgnoreCase(answerStr)) {
                return LocalDate.parse("0001-01-01");
            }

            try {
                LocalDate date = LocalDate.parse(answerStr);              
                return date;               
            } catch (Exception e) {
                System.out.println("Enter a date in format YYYY-MM-DD, or q to quit");
            }
        } while (true);
    }
}
