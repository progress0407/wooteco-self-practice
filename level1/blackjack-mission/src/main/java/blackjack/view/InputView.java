package blackjack.view;

import static java.lang.System.out;

import blackjack.constant.Command;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static List<String> inputNames() {
        out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        return Arrays.stream(SCANNER.nextLine().split(","))
                .map(name -> name.trim())
                .collect(Collectors.toList());
    }

    public static int inputBettingAmount(String name) {
        out.println(name + "의 배팅 금액은?");
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static Command moreCard(String playerName) {
        out.println(playerName + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
        String input = SCANNER.nextLine();
        return Command.of(input);
    }
}
