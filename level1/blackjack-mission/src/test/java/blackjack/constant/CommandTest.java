package blackjack.constant;

import static blackjack.constant.Command.HIT;
import static blackjack.constant.Command.NOT_FOUND_COMMAND_EXCEPTION_MESSAGE;
import static blackjack.constant.Command.STAY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CommandTest {

    @DisplayName("정상값 입력")
    @ParameterizedTest
    @MethodSource("supplyCommandList")
    void input_normal(String input, Command expectedCommand) {

        Command actualCommand = Command.of(input);
        assertThat(actualCommand).isEqualTo(expectedCommand);
    }


    private static Stream<Arguments> supplyCommandList() {
        return Stream.of(
                Arguments.of("y", HIT),
                Arguments.of("Y", HIT),
                Arguments.of("n", STAY),
                Arguments.of("N", STAY)
        );
    }

    @DisplayName("예외 입력")
    @Test
    void input_exception() {

        assertThatThrownBy(() -> Command.of("x"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_FOUND_COMMAND_EXCEPTION_MESSAGE);
    }

}
