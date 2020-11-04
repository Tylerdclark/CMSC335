/*
 * *****************************************************************************
 * FILE: Menu.java
 * NAME: Tyler D Clark
 * PROJECT: Project 1
 * COURSE: CMSC 335
 * DATE: 25 OCT 2020
 * *****************************************************************************
 */

package dev.tylerdclark;

import dev.tylerdclark.three_dimensional.*;
import dev.tylerdclark.two_dimensional.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Driver class of the project.
 */
public class Menu {
    /**
     * Creates a menu instances which continually loops and prompts the user to
     * create shape objects. The loop can be exited using {@link #goOnCheck(Scanner)} and
     * collects number input using {@link #getNumber(Scanner)}.
     */
    public Menu() {

        Scanner scan = new Scanner(System.in);
        System.out.println("*********Welcome to the Java OO Shapes Program **********");

        do {
            System.out.println("Select from the menu below:\n\n1. Construct a Circle\n"
                    + "2. Construct a Rectangle\n3. " + "Construct a Square\n4. Construct a Triangle\n"
                    + "5. Construct a Sphere\n6. Construct a Cube\n7. " + "Construct a Cone\n8. "
                    + "Construct a Cylinder\n9. Construct a Torus\n10. Exit the program");

            switch (getNumber(scan)) {
                case 1:
                    System.out.println("You have selected a Circle\nWhat is the radius?");
                    System.out.println(new Circle(getNumber(scan))); // calling the toString method
                    break;
                case 2:
                    System.out.println("You have selected a Rectangle\nWhat is the width?");
                    int rectangleWidth = getNumber(scan);
                    System.out.println("and what is the height?");
                    System.out.println(new Rectangle(rectangleWidth, getNumber(scan)));
                    break;
                case 3:
                    System.out.println("You have selected a Square\nWhat length are the sides?");
                    System.out.println(new Square(getNumber(scan)));
                    break;
                case 4:
                    System.out.println("You have selected a Triangle\nWhat is the base?");
                    int triangleBase = getNumber(scan);
                    System.out.println("and what is the height?");
                    System.out.println(new Triangle(triangleBase, getNumber(scan)));
                    break;
                case 5:
                    System.out.println("You have selected a Sphere\nWhat is the radius?");
                    System.out.println(new Sphere(getNumber(scan)));
                    break;
                case 6:
                    System.out.println("You have selected a Cube\nWhat is the length of the side?");
                    System.out.println(new Cube(getNumber(scan)));
                    break;
                case 7:
                    System.out.println("You have selected a Cone\nWhat is the radius of the base?");
                    int coneBaseRadius = getNumber(scan);
                    System.out.println("and what is the height?");
                    System.out.println(new Cone(coneBaseRadius, getNumber(scan)));
                    break;
                case 8:
                    System.out.println("You have selected a Cylinder\nWhat is the radius of the base?");
                    int cylinderRadius = getNumber(scan);
                    System.out.println("and what is the height?");
                    System.out.println(new Cylinder(cylinderRadius, getNumber(scan)));
                    break;
                case 9:
                    System.out.println("You have selected a Torus\nWhat is the inner radius?");
                    int torusInnerRadius = getNumber(scan);
                    System.out.println("and what is the outer radius?");
                    System.out.println(new Torus(torusInnerRadius, getNumber(scan)));
                    break;
                case 10: // One of two ways to exit loop
                    endPrompt();
                    scan.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Not a possible menu choice!");
                    break;
            }
        } while (goOnCheck(scan)); // Second way to exit loop
        endPrompt();
        scan.close();
    }

    /**
     * Determines if the user wishes to continue. By accepting a scanner as an
     * argument, the overhead of creating a new one with every method call is
     * avoided and works better with the recursive incorrect input handling of this
     * method.
     *
     * @param scan scanner passed to collect input
     * @return true if the user wishes to continue or false otherwise
     */
    private static boolean goOnCheck(Scanner scan) {
        System.out.println("Would you like to continue? (Y or N)");
        char choice = Character.toLowerCase(scan.next().charAt(0));

        if (choice == 'y') {
            return true;
        }
        if (choice == 'n') {
            return false;
        }
        System.out.println("Sorry I do not understand. Enter Y or N");
        return goOnCheck(scan);
    }

    /**
     * Retrieves a positive integer from user input. By passing the Scanner as
     * parameter, the method can recursively error handle and persistently request a
     * number with the same scanner.
     *
     * @param scan scanner passed to collect input
     * @return a positive integer
     */
    private static int getNumber(Scanner scan) {
        int choice;
        try {
            choice = scan.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println("Bad choice! Please use Integers.");
            scan.next(); // consume bad token
            return getNumber(scan);
        }
        if (choice > 0) { // Let's just avoid the abstract maths...
            return choice;
        } else {
            System.out.println("Bad choice! Please keep values positive.");
            return getNumber(scan);
        }
    }

    /**
     * Thanks the user and prints the date and time.
     */
    private static void endPrompt() { //Nov 11 at 1:40 PM.
        DateFormat dateFormat = new SimpleDateFormat("MMM d 'at' h:mm a");
        Date date = new Date();
        System.out.println("Thank you for using the program. Today is "+ dateFormat.format(date));
    }
}
