package subway.view;

import java.util.Scanner;

public class InputView {
    private static final String ERROR_NONE_INPUT_VALUE = "입력값이 없습니다.";
    private static final String ERROR_INVALID_INPUT_VALUE = "유효하지 않은 입력입니다.";
    private static final String ERROR_INVALID_LENGTH = "유효하지 않은 길이입니다.";
    private static final String REQUEST_MENU = "## 원하는 기능을 선택하세요.";
    private static final int ZERO = 0;
    private static final int ONE = 1;

    private static Scanner scanner;

    public static void setScanner(Scanner scanner) {
        InputView.scanner = scanner;
    }

    public static String getInputWithoutWhiteSpaces() {
        String rawString = deleteWhiteSpaces(scanner.nextLine());
        isNotEmptyStringOrThrowException(rawString);
        return rawString;
    }

    public static char getMenuSelection() {
        System.out.println(REQUEST_MENU);
        String rawString = getInputWithoutWhiteSpaces();
        if (ONE < rawString.length()) {
            throw new IllegalArgumentException(ERROR_INVALID_LENGTH);
        }
        return rawString.charAt(ZERO);
    }

    private static String deleteWhiteSpaces(String string) {
        return string.replaceAll("\\s+", "");
    }

    private static boolean isNotEmptyStringOrThrowException(String string) {
        if (string.equals("")) {
            throw new IllegalArgumentException(ERROR_NONE_INPUT_VALUE);
        }
        return true;
    }

}
