package blackjack.constant;

import java.util.Arrays;

public enum Command {
    HIT("Y"),
    STAY("N");

    static final String NOT_FOUND_COMMAND_EXCEPTION_MESSAGE = "[ERROR] 존재하지 않는 명령어입니다.";
    private static final Command[] CACHE = values();

    private final String name;

    Command(String name) {
        this.name = name;
    }

    public static Command of(String input) {
        return Arrays.stream(CACHE)
                .filter(command -> command.name.equalsIgnoreCase(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_COMMAND_EXCEPTION_MESSAGE));
    }
}
