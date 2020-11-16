/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataentry;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
                    System.out.println("Wrong input, input a number from " + start + " to " + end);
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong input, input a number from " + start + " to " + end + ", or q to quit");
            }
        } while (true);
    }

    public static LocalDate readDateOrQuit() {
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
                System.out.println("Wrong input, enter a date in format YYYY-MM-DD, or q to quit");
            }
        } while (true);
    }

    public static String readString() {
        String answerStr;

        do {
            answerStr = sc.nextLine();

            if (answerStr == null || answerStr.isEmpty()) {
                System.out.println("Input can not be empty");
                continue;
            }
            return answerStr;

        } while (true);
    }

    public static LocalDate readDate() {
        String answerStr;

        do {
            answerStr = sc.nextLine();

            try {
                return LocalDate.parse(answerStr);
            } catch (Exception e) {
                System.out.println("Wrong input, enter a date in format YYYY-MM-DD");
            }
        } while (true);
    }

    public static LocalDateTime readDateTime() {
        String answerStr;

        do {
            answerStr = sc.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            try {
                return LocalDateTime.parse(answerStr, formatter);
            } catch (Exception e) {
                System.out.println("Wrong input, enter a date in format YYYY-MM-DD HH-MM");
            }
        } while (true);
    }

    public static int readInt() {
        String answerStr;
        int tuitionFees;

        do {
            answerStr = sc.nextLine();

            try {
                tuitionFees = Integer.parseInt(answerStr);
                if (tuitionFees < 0) {
                    System.out.println("Tuition cant be a negative number");
                }
                return tuitionFees;
            } catch (NumberFormatException e) {
                System.out.println("Must input a number");
            }
        } while (true);
    }

    public static boolean readYesOrNo() {
        String answerStr;

        do {
            answerStr = sc.nextLine();

            if ("yes".equalsIgnoreCase(answerStr)) {
                return true;
            } else if ("no".equalsIgnoreCase(answerStr)) {
                return false;
            } else {
                System.out.println("Must input yes or no");
            }
        } while (true);

    }
}
