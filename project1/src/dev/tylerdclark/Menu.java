package dev.tylerdclark;

import dev.tylerdclark.three_dimensional.*;
import dev.tylerdclark.two_dimensional.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public Menu() {

        Scanner scan = new Scanner(System.in);
        System.out.println("*********Welcome to the Java OO Shapes Program **********");
        System.out.println("Author: Tyler D Clark");

        do {
            System.out.println("Select from the menu below:\n\n1. Construct a Circle\n" + "2. Construct a Rectangle\n3. "
                    + "Construct a Square\n4. Construct a Triangle\n" + "5. Construct a Sphere\n6. Construct a Cube\n7. "
                    + "Construct a Cone\n8. " + "Construct a Cylinder\n9. Construct a Torus\n10. Exit the program\n");

            switch (getNumber(scan)) {
                case 1:
                    System.out.println("You have selected a Circle\nWhat is the radius?");
                    Circle circle = new Circle(getNumber(scan));
                    System.out.format("The area of the Circle is %.1f%n", circle.area());
                    break;
                case 2:
                    System.out.println("You have selected a Rectangle\nWhat is the width");
                    int rectangleWidth = getNumber(scan);
                    System.out.println("and what is the height?");
                    Rectangle rectangle = new Rectangle(rectangleWidth, getNumber(scan));
                    System.out.format("The area of the Rectangle is %.1f%n", rectangle.area());
                    break;
                case 3:
                    System.out.println("You have selected a Square\nWhat length are the sides?");
                    Square square = new Square(getNumber(scan));
                    System.out.format("The area of the Square is %.1f%n", square.area());
                    break;
                case 4:
                    System.out.println("You have selected a Triangle\nWhat is the base?");
                    int triangleBase = getNumber(scan);
                    System.out.println("and what is the height?");
                    Triangle triangle = new Triangle(triangleBase, getNumber(scan));
                    System.out.format("The area of the Triangle is %.1f%n", triangle.area());
                    break;
                case 5:
                    System.out.println("You have selected a Sphere\nWhat is the radius?");
                    Sphere sphere = new Sphere(getNumber(scan));
                    System.out.format("The Volume of the Sphere is %.1f%n", sphere.volume());
                    break;
                case 6:
                    System.out.println("You have selected a Cube\nWhat is the length of the side?");
                    Cube cube = new Cube(getNumber(scan));
                    System.out.format("The Volume of the Cube is %.1f%n", cube.volume());
                    break;
                case 7:
                    System.out.println("You have selected a Cone\nWhat is the radius of the base?");
                    int coneBaseRadius = getNumber(scan);
                    System.out.println("and what is the height?");
                    Cone cone = new Cone(coneBaseRadius, getNumber(scan));
                    System.out.format("The Volume of the Cone is %.1f%n", cone.volume());
                    break;
                case 8:
                    System.out.println("You have selected a Cylinder\nWhat is the radius of the base?");
                    int cylinderRadius = getNumber(scan);
                    System.out.println("and what is the height?");
                    Cylinder cylinder = new Cylinder(cylinderRadius, getNumber(scan));
                    System.out.format("The Volume of the Cylinder is %.1f%n", cylinder.volume());
                    break;
                case 9:
                    System.out.println("You have selected a Torus\nWhat is the inner radius?");
                    int torusInnerRadius = getNumber(scan);
                    System.out.println("and what is the outer radius?");
                    Torus torus = new Torus(torusInnerRadius, getNumber(scan));
                    System.out.format("The Volume of the Torus is %.1f%n", torus.volume());
                    break;
                case 10: // One of two ways to exit loop
                    scan.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Not a possible menu choice!");
                    break;
            }
        } while (goOn(scan)); // Second way to exit loop
        scan.close();
    }

    private static boolean goOn(Scanner scan) {
        System.out.println("Would you like to continue? (Y or N)");
        char choice = scan.next().charAt(0);
        if (choice == 'y') {
            return true;
        }
        if (choice == 'n') {
            return false;
        }
        System.out.println("Sorry I do not understand. Enter Y or N");
        return goOn(scan);
    }

    private static int getNumber(Scanner scan) {
        int choice;
        try {
            choice = scan.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println("Bad choice!");
            scan.next(); // consume bad token
            return getNumber(scan);
        }
        if (choice > 0) { // Let's just avoid the abstract maths...
            return choice;
        } else {
            System.out.println("Bad choice!");
            return getNumber(scan);
        }
    }
}
