package subway.view.menuView;

import subway.dto.LineDTO;
import subway.dto.StationDTO;
import subway.menuType.MainMenuType;
import subway.view.OutputView;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainView extends MenuView<MainMenuType> {
    private static final String VIEW_NAME = "메인 화면";
    private static final String MENU_STATION_MANAGEMENT = "역 관리";
    private static final String MENU_LINE_MANAGEMENT = "노선 관리";
    private static final String MENU_SECTION_MANAGEMENT = "구간 관리";
    private static final String MENU_SUBWAY_MAP = "지하철 노선도 출력";
    private static final String ESCAPE = "종료";
    private static final String ESCAPE_VALUE = "Q";
    private static final String BORDERLINE = "---";
    private static final String SUBWAY_MAP = "지하철 노선도";

    private static MainView instance;

    private MainView() {
        viewName = VIEW_NAME;

        List<String> descriptions = new ArrayList<>(Arrays.asList(
                MENU_STATION_MANAGEMENT, MENU_LINE_MANAGEMENT, MENU_SECTION_MANAGEMENT, MENU_SUBWAY_MAP, ESCAPE
        ));
        List<String> menuIndexs = new ArrayList<>();
        for (int i = MENU_START_INDEX; i < descriptions.size(); i++) {
            menuIndexs.add(Integer.toString(i));
        }
        menuIndexs.add(ESCAPE_VALUE);

        initializeSelections(menuIndexs, descriptions);
        initializeHashMapToFunctionType(this.selections.toList(), Arrays.asList(MainMenuType.values()));
    }

    public static MainView getInstance() {
        if (instance == null) {
            instance = new MainView();
        }
        return instance;
    }

    public static void showSubwayMap(List<LineDTO> Lines) {
        OutputView.printWithSharpPrefix(SUBWAY_MAP);

        for (LineDTO line : Lines) {
            OutputView.printResponseMessage(line.getName());
            OutputView.printResponseMessage(BORDERLINE);
            line.getStations().stream()
                    .map(StationDTO::getName)
                    .forEach(OutputView::printResponseMessage);
            newLine();
        }
    }

}
