package sfu.cmpt213.as0;

import java.util.ArrayList;

/**
 * Main class which uses Menu and Minion to create a minion tracker application
 */
public class Main {

    public static void main(String[] args) {

        //TODO maybe put in constants
        String[] menuOptions = {
                "List minions",
                "Add a new minion",
                "Remove a minion",
                "Attribute evil deed to a minion",
                "DEBUG: Dump objects (toString)",
                "Exit"
        };

        Menu menu = new Menu("Main Menu", menuOptions);
        menu.welcomeDisplay();

        boolean isExit = false;
        ArrayList<Minion> minions = new ArrayList<>();

        ExecuteOption executeOption = new ExecuteOption();
        final int LIST_MINION = 1;
        final int ADD_MINION = 2;
        final int REMOVE_MINION = 3;
        final int ATTRIBUTE_EVIL_DEED = 4;
        final int DEBUG = 5;
        final int EXIT = 6;

        while (!isExit) {
            menu.display();
            int userSelection = menu.getSelection();
            switch (userSelection) {
                case LIST_MINION:
                    executeOption.listMinion(minions);
                    break;
                case ADD_MINION:
                    executeOption.addMinion(minions);
                    break;
                case REMOVE_MINION:
                    executeOption.removeMinion(minions);
                    break;
                case ATTRIBUTE_EVIL_DEED:
                    executeOption.attributeEvilDeed(minions);
                    break;
                case DEBUG:
                    executeOption.dumpObjects(minions);
                    break;
                case EXIT:
                    isExit = true;
                    break;
                default:
                    assert false;
            }
        }
    }
}
