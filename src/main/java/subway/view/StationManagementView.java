package subway.view;

import java.util.*;

public class StationManagementView {
    private static final String DISPLAY_NAME = "## 역 관리 화면";
    private static final String CREATE = "역 등록";
    private static final String DELETE = "역 삭제";
    private static final String SEARCH = "역 조회";
    private static final String BACK_MESSAGE = "B. 뒤로가기";
    private static final String INVALID_SELECTION = "선택할 수 없는 기능입니다.";
    private static final char BACK = 'B';
    private static final int MENU_START_RANGE = 1;
    private static final int MENU_END_RANGE = 3;

    private static final List<String> menu = new ArrayList<>(Arrays.asList(
            CREATE, DELETE, SEARCH
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
        if (menu == BACK) {
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
        Iterator<String> iterator = menu.iterator();
        for(int i = MENU_START_RANGE; i <= menu.size(); i++) {
            System.out.println(String.format("%d. %s", i, iterator.next()));
        }
        System.out.println(BACK_MESSAGE);
    }
}
