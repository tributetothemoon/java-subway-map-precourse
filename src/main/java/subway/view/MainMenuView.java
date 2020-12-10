package subway.view;

import java.util.*;

public class MainMenuView {
    private static final String DISPLAY_NAME = "## 메인 화면";
    private static final String STATION_MANAGEMENT = "역 관리";
    private static final String LINE_MANAGEMENT = "노선 관리";
    private static final String SECTION_MANAGEMENT = "구간 관리";
    private static final String SUBWAY_MAP = "지하철 노선도 출력";
    private static final String QUIT_MESSAGE = "Q. 종료";
    private static final String INVALID_SELECTION = "선택할 수 없는 기능입니다.";
    private static final char QUIT = 'Q';

    private static final int MENU_START_RANGE = 1;
    private static final int MENU_END_RANGE = 4;

    private static final List<String> mainMenu = new ArrayList<String>(Arrays.asList(
            STATION_MANAGEMENT, LINE_MANAGEMENT, SECTION_MANAGEMENT, SUBWAY_MAP, QUIT_MESSAGE
    ));

    public static char getMenuSelection() {
        try {
            char menu = InputView.getMenuSelection();
            isValidMenu(menu);
            return menu;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMenuSelection();
        }
    }

    private static boolean isValidMenu(char menu) {
        if (menu == QUIT) {
            return true;
        }
        int numericValue = Character.getNumericValue(menu);
        if (numericValue <= MENU_END_RANGE && MENU_START_RANGE <= numericValue) {
            return true;
        }
        throw new IllegalArgumentException(INVALID_SELECTION);
    }

    public static void showMenu() {
        System.out.println(DISPLAY_NAME);
        Iterator<String> iterator = mainMenu.iterator();
        for (int i = MENU_START_RANGE; i < mainMenu.size(); i++) {
            System.out.println(String.format("%d. %s", i, iterator.next()));
        }
        System.out.println(QUIT_MESSAGE);
    }
}

