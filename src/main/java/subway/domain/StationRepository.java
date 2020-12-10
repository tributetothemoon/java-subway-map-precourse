package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final String ALREADY_IS = "이미 등록된 역입니다.";
    private static final List<Station> stations = new ArrayList<>();

    public StationRepository() {
    }

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException(ALREADY_IS);
        }
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static boolean contains(Station station) {
        return stations.contains(station);
    }
}
