package com.company;
import static java.lang.System.out;

import java.util.Locale;
import java.util.Scanner;

public class DaysOfTheYear {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            out.print("Which month? ");
            String month = keyboard.nextLine();
// one type of switch case, but it's very tedious:
/*        switch (month) {
            case "January":
                out.println(31);
                break;
            case "February":
                out.println(28);
                break;
            case "March":
                out.println(31);
                break;
            case "April":
                out.println(30);
                break;
            case "May":
                out.println(31);
                break;
            case "June":
                out.println(30);
                break;
            case "July":
                out.println(31);
                break;
            case "August":
                out.println(31);
                break;
            case "September":
                out.println(30);
                break;
            case "October":
                out.println(31);
                break;
            case "November":
                out.println(30);
                break;
            case "December":
                out.println(31);
                break;
        }
 */
            String [] monthsInAYear = {"january", "february", "march", "april", "may",
            "june", "july", "august", "september", "october", "november", "december"};
            int counter = 0;
// another type of switch case that is much cleaner for this situation:
            for (int i = 0; i < monthsInAYear.length; i++) {
                if (!monthsInAYear[i].equals(month)){
                    counter++;
                    if (counter == 12) {
                        out.println("Sorry, please enter a proper month name.");
                    }
                } else {
                    out.print(month + " has ");
                    switch (month.toLowerCase(Locale.ROOT)) {
                        case "january", "march", "may", "july", "august", "october", "december" -> out.print(31);
                        case "april", "june", "september", "november" -> out.print(30);
                        case "february" -> {
                            out.println("Is it a leap year? ");
                            String leapYear = keyboard.nextLine();
                            if (leapYear.toLowerCase(Locale.ROOT).equals("yes")) {
                                out.print(29);
                            } else if (leapYear.toLowerCase(Locale.ROOT).equals("no")) {
                                out.print(28);
                            } else {
                                out.print("Sorry, I didn't understand. Please try again so I can " +
                                        "give you the proper number of");
                            }
                        }
                    }
                    out.println(" days.");
                }
            }
            out.println("Would you like to choose another month? Write 'y' or 'n'");
            String keepGoing = keyboard.nextLine();
            if (keepGoing.toLowerCase(Locale.ROOT).equals("no") || keepGoing.toLowerCase(Locale.ROOT).equals("n")){
                break;
            } else if (!keepGoing.toLowerCase(Locale.ROOT).equals("yes") && !keepGoing.toLowerCase(Locale.ROOT).equals("y")) {
                out.print("I will assume that meant yes! ");
            }
        }
        out.println("Alright, thank you! Goodbye.");
        keyboard.close();
    }
}
