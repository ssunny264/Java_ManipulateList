/* Programmer:  Sara Sunny
Language:       Java
Purpose:        Application to create and manipulate a student list 
URL:
Assignment:     Homework 8
Date:           12/03/20
Course:         Info-210
*/
package edu.iusb.cs;

/**
 *
 * @author slbru
 */
import java.util.ArrayList;
import java.util.Scanner;

public class HW8_CMS {
    public static void main (String [] args) {
    Scanner input = new Scanner (System.in); //scanner for user input
    
    ArrayList<String> first = new ArrayList<>();
    ArrayList<String> last = new ArrayList<>();
    ArrayList<Integer> id = new ArrayList<>();
   
    int choice; int count = 0;
    String fName; String lName;
    
    System.out.println("Welcome to the Student List");
    System.out.println();
    do {
        System.out.println("Application options. Enter the option number you wish to complete: ");
        System.out.println("Option 1: \t Add student to list");
        System.out.println("Option 2: \t Search for student in list");
        System.out.println("Option 3: \t Print the current list");
        System.out.println("Option 4: \t Exit the program");
        choice = input.nextInt();
        
        switch (choice) {
            case 1:
                count++;
                System.out.println("Enter first name: ");
                fName = input.next();
                first.add(fName);
                System.out.println("Enter last name: ");
                lName = input.next();
                last.add(lName);
                id.add(count);
                break;
            case 2:
                System.out.println("Please select search option number: ");
                System.out.println("Option 1: \t Search by first name ");
                System.out.println("Option 2: \t Search by last name ");
                System.out.println("Option 3: \t Search by student ID ");
                int response = input.nextInt();
                switch (response) {
                    case 1:
                        listFirstSearch(id, first, last);
                        break;
                    case 2:
                        listLastSearch(id, first, last);
                        break;
                    case 3:
                        listIDSearch(id, first, last);
                        break;
                }
                break;
            case 3:
                System.out.println("------------------------------------------------------------------------");
                System.out.println();
                System.out.println("Total number of students: " + count);
                System.out.println("S.ID \t First Name \t Last Name");
                System.out.println("------------------------------------------------------------------------");

                for (count = 0; count < first.size(); count++) {
                    System.out.printf("%d\t%s\t\t%s%n", id.get(count), first.get(count), last.get(count));
                }
                break;
            case 4:
                System.out.println("GoodBye!");
                break;
            default:
                System.out.println("Please enter the option number you wish to complete: ");
                break;
        }
        System.out.println("------------------------------------------------------------------------");
    } while (choice != 4 && count <= 15);
}
public static void listFirstSearch(ArrayList<Integer> id, ArrayList<String> first, ArrayList<String> last) {
    Scanner input = new Scanner (System.in); //scanner for user input
    
    System.out.println("Enter first name to search list for: ");
    String name = input.next();
    
    for (int count = 0; count < first.size(); count++) {
        if (first.get(count).startsWith(name)) {
            System.out.printf("%d\t%s\t%s%n", id.get(count), first.get(count), last.get(count));
        }
    }
}
public static void listLastSearch(ArrayList<Integer> id, ArrayList<String> first, ArrayList<String> last) {
    Scanner input = new Scanner (System.in); //scanner for user input
    
    System.out.println("Enter last name to search list for: ");
    String name = input.next();
    
    for (int count = 0; count < last.size(); count++) {
        if (last.get(count).startsWith(name)) {
            System.out.printf("%d\t%s\t%s%n", id.get(count), first.get(count), last.get(count));
        }
    }
}
public static void listIDSearch(ArrayList<Integer> id, ArrayList<String> first, ArrayList<String> last) {
    Scanner input = new Scanner (System.in); //scanner for user input
    
    System.out.println("Enter Student ID to search list for: ");
    int value = input.nextInt();
    
    for (int count = 0; count <= id.size(); count++) {
        if (value == id.get(count)) {
            System.out.printf("%d\t%s\t%s%n", id.get(count) + first.get(count) + last.get(count));
        }
    }
}
}
