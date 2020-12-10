package subway.domain;

public class Station {
    private static final String INVALID_LENGTH = "불가능한 길이입니다.";
    private static final int MIN_LENGTH = 2;


    private String name;

    public Station(String name) {
        if (name.length() < MIN_LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Station paramObj = (Station) obj;
        return this.name.equals(paramObj.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
