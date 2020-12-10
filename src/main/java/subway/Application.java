package subway;

import subway.view.MainMenuView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현

        int menuType = getMainMenuSelection();
    }

    private static void setScanner(Scanner scanner) {
        MainMenuView.setScanner(scanner);
    }

    private static int getMainMenuSelection() {
        try {
            return MainMenuView.getMenuSelection();
        } catch (IllegalArgumentException e) {
            return getMainMenuSelection();
        }
    }
}

