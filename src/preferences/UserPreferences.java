package preferences;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserPreferences {
    Scanner scanner = new Scanner(System.in);

    //fields to store what the user wants
    private double minSalary;
    private String titleKeyword;
    private String techStack;

    //the main method that asks the user questions
    public void collectPreferences() {
        this.minSalary = askMinSalary();
        this.titleKeyword = askTitleKeyword();
        this.techStack = askTechStack();
    }

    //helper methods. Each one asks ONE question
    private double askMinSalary() {
        while (true) {
            System.out.print("Enter minimum salary: $");
            try {
                double salary = scanner.nextDouble();
                scanner.nextLine();
                return salary;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Please enter a valid number (e.g. 75000)");
            }
        }
    }

    private String askTitleKeyword() {
        System.out.println("Enter job title: ");
        return scanner.nextLine();
    }

    private String askTechStack() {
        System.out.println("Enter programming language: ");
        return scanner.nextLine();
    }

    //Getters for Main.java

    public double getMinSalary() {
        return minSalary;
    }

    public String getTitleKeyword() {
        return titleKeyword;
    }

    public String getTechStack() {
        return techStack;
    }
}
