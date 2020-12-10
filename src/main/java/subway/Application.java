package subway;

import subway.controller.StationManagement;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.MainMenuView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static final char STATION_MANAGEMENT = '1';
    private static final char LINE_MANAGEMENT = '2';
    private static final char SECTION_MANAGEMENT = '3';
    private static final char SUBWAY_MANAGEMENT = '4';
    private static final char QUIT = 'Q';
    private static final String INVALID_SELECTION = "선택할 수 없는 기능입니다.";

    private static char menuType;
    private static final StationManagement stationManagement = new StationManagement();

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        setScanner(scanner);

        do{
            MainMenuView.showMenu();
            menuType = MainMenuView.getMenuSelection();

            if( menuType == STATION_MANAGEMENT) {
                stationManagement.run();
            }
            
        }while(menuType != QUIT);
    }

    private static void setScanner(Scanner scanner) {
        InputView.setScanner(scanner);
    }
}

