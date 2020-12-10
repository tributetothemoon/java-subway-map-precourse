package subway.controller;

import subway.domain.StationRepository;
import subway.view.StationManagementView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StationManagement {
    private final StationRepository stationRepository;
    private static final char CREATE = '1';
    private static final char DELETE = '2';
    private static final char SEARCH = '3';
    private static final char BACK = 'B';
    private static final String INVALID_SELECTION = "선택할 수 없는 기능입니다.";
    private static final int MENU_START_RANGE = 1;
    private static final int MENU_END_RANGE = 3;

    private List<Character> menuSelections = new ArrayList<>(Arrays.asList(
        CREATE, DELETE, SEARCH, BACK
    ));

    private char menuType;

    public StationManagement(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public void run() {
        do{
            StationManagementView.showMenu();
            menuType = StationManagementView.getMenuSelection();
        }while(menuType != BACK);
    }

}
