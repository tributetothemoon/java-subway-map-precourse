package subway.view;

import subway.domain.Station;

import java.util.List;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String INFO_PREFIX = "[INFO] ";

    public static void showErrorMessage(Exception e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }

    public static void showStations(List<Station> stations) {
        stations.forEach(i -> System.out.println(INFO_PREFIX + i.getName()));
    }

}
