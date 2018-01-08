package sfu.cmpt213.as0;

import java.util.ArrayList;

/**
 * Main class which uses Menu and Minion to create a minion tracker application
 */
public class Main {

    public static void main(String[] args) {
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

        ArrayList<Minion> minions = new ArrayList<>();

        ExecuteOption executeOption = new ExecuteOption();
        final int LIST_MINION_OPTION = 1;
        final int ADD_MINION_OPTION = 2;
        final int REMOVE_MINION_OPTION = 3;
        final int ATTRIBUTE_EVIL_DEED_OPTION = 4;
        final int DEBUG_OPTION = 5;
        final int EXIT_OPTION = 6;

        boolean isExit = false;
        while (!isExit) {
            menu.menuOptionsDisplay();
            int userMenuSelection = menu.getSelection();
            switch (userMenuSelection) {
                case LIST_MINION_OPTION:
                    executeOption.listMinion(minions);
                    break;
                case ADD_MINION_OPTION:
                    executeOption.addMinion(minions);
                    break;
                case REMOVE_MINION_OPTION:
                    executeOption.removeMinion(minions);
                    break;
                case ATTRIBUTE_EVIL_DEED_OPTION:
                    executeOption.attributeEvilDeed(minions);
                    break;
                case DEBUG_OPTION:
                    executeOption.dumpObjects(minions);
                    break;
                case EXIT_OPTION:
                    isExit = true;
                    break;
                default:
                    assert false;
            }
        }
    }
}
