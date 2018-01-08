package sfu.cmpt213.as0;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Menu class creates a menu by storing its title and options
 */
public class Menu {
    private static final int EXTRA_STAR_CHARACTERS = 4;
    private static final int START_MENU_AT_ONE = 1;

    private String title;
    private String[] options;


    public Menu(String title, String[] options) {
        this.title = title;
        this.options = options;
    }

    public void menuOptionsDisplay() {
        System.out.println();
        displayStarLine(this.title);
        System.out.println("* " + this.title + " *");
        displayStarLine(this.title);

        for (int i = 0; i < options.length; i++) {
            System.out.println(i + START_MENU_AT_ONE + ". " + options[i]);
        }

    }

    private void displayStarLine(String title) {
        for (int i = 0; i < title.length() + EXTRA_STAR_CHARACTERS; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public int getSelection() {
        return getNumberBetween(1, options.length);
    }

    public static int getNumberBetween(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int userSelection = 0;

        boolean isInvalidInput = true;

        do {
            try {
                System.out.print("> ");
                userSelection = scanner.nextInt();
                if (userSelection >= min && userSelection <= max) {
                    isInvalidInput = false;
                } else {
                    System.out.println("Error: Please enter a selection between " + min + " and " + max);
                }
            } catch (InputMismatchException exception) {
                System.out.println("Error: Please enter integers only");
                scanner.next();
            }
        } while (isInvalidInput);

        return userSelection;
    }

    public void welcomeDisplay() {
        System.out.println("***************************************");
        System.out.println("Welcome to the Evil Minion Tracker (tm)");
        System.out.println("by Rishi Dholliwar.");
        System.out.println("***************************************");
    }

}
