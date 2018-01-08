package sfu.cmpt213.as0;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Executes the menu options
 */
public class ExecuteOption {
    private static final int START_MENU_AT_ONE = 1;
    private static final int INITIAL_EVIL_DEED = 0;

    public void listMinion(ArrayList<Minion> minions) {
        System.out.println();
        System.out.println("List of Minions:");
        System.out.println("****************");

        if (minions.isEmpty()) {
            System.out.println("No minions found.");
            return;
        }

        for (int i = 0; i < minions.size(); i++) {
            Minion currMinion = minions.get(i);
            System.out.println(i + START_MENU_AT_ONE + ". " + currMinion.getName() + ", "
                    + currMinion.getHeightInM() + "m, "
                    + currMinion.getNumEvilDeeds() + " evil deed(s)");

        }

    }

    public void addMinion(ArrayList<Minion> minions) {
        String minionName = getMinionNameInput();
        double minionHeight = getValidMinionHeightInput();
        minions.add(new Minion(minionName, minionHeight, INITIAL_EVIL_DEED));
    }

    public void removeMinion(ArrayList<Minion> minions) {
        int userSelection = getValidMinion(minions);
        if (userSelection > 0) {
            minions.remove(userSelection - START_MENU_AT_ONE);
        }
    }

    public void attributeEvilDeed(ArrayList<Minion> minions) {
        int userSelection = getValidMinion(minions);
        if (userSelection > 0) {
            Minion minion = minions.get(userSelection - START_MENU_AT_ONE);
            minion.incrementEvilDeed();
            System.out.println(minion.getName() + " has now done " + minion.getNumEvilDeeds() + " evil deed(s)!");
        }
    }

    public void dumpObjects(ArrayList<Minion> minions) {
        System.out.println("All minion objects:");
        for (int i = 0; i < minions.size(); i++) {
            System.out.println(i+START_MENU_AT_ONE + ". " + minions.get(i).toString());
        }
    }

    private String getMinionNameInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter minion's name: ");
        String minionName = scanner.nextLine();
        return minionName;
    }

    private double getValidMinionHeightInput() {
        Scanner scanner = new Scanner(System.in);


        double minionHeight = 0;
        boolean isInvalidInput = true;

        do {
            try {
                System.out.print("Enter minion's height: ");
                minionHeight = scanner.nextDouble();
                if (minionHeight > 0) {
                    isInvalidInput = false;
                } else {
                    System.out.println("Error: Please enter a minion height greater than 0");
                }
            } catch (InputMismatchException exception) {
                System.out.println("Error: Please enter numbers only");
                scanner.next();
            }
        } while (isInvalidInput);

        return minionHeight;
    }

    private int getValidMinion(ArrayList<Minion> minions) {
        listMinion(minions);
        System.out.println("(Enter 0 to cancel)");
        Scanner scanner = new Scanner(System.in);
        int userSelection = 0;
        boolean isInvalidInput = true;

        do {
            try {
                System.out.print("> ");
                userSelection = scanner.nextInt();
                if (userSelection >= 0 && userSelection <= minions.size()) {
                    isInvalidInput = false;
                } else {
                    System.out.println("Error: Please enter a selection between 0 and " + minions.size());
                }
            } catch (InputMismatchException exception) {
                System.out.println("Error: Please enter integers only");
                scanner.next();
            }
        } while (isInvalidInput);

        return userSelection;

    }

}
