package subway.view;

import java.util.*;

public class MainMenuView {
    private static final String MAIN_DISPLAY_NAME = "## 메인 화면";
    private static final String STATION_MANAGEMENT = "역 관리";
    private static final String LINE_MANAGEMENT = "노선 관리";
    private static final String SECTION_MANAGEMENT = "구간 관리";
    private static final int MENU_START_RANGE = 1;

    private static Scanner scanner;

    public static void setScanner(Scanner scanner) {
        MainMenuView.scanner = scanner;
    }

    private static final List<String> mainMenu = new ArrayList<>(Arrays.asList(
            STATION_MANAGEMENT, LINE_MANAGEMENT, SECTION_MANAGEMENT
    ));

    public static int getMenuSelection() {
        showMainMenu();
        return 0;   // 추후 구현
    }

    private static void showMainMenu() {
        Iterator<String> iterator = mainMenu.iterator();
        for(int i = MENU_START_RANGE; i <= mainMenu.size(); i++) {
            System.out.println(String.format("%d. %s", i, iterator.next()));
        }
    }

}
