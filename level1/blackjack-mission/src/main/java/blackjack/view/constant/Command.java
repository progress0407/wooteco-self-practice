package blackjack.view.constant;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Command {
    HIT("Y"),
    STAY("N");

    private String name;

    Command(String name) {
        this.name = name;
    }

    public static Command of(String inputName) {
        return Arrays.stream(values())
                .filter(command -> command.name.equalsIgnoreCase(inputName))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
