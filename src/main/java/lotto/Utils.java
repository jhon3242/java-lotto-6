package lotto;

import java.util.Arrays;
import java.util.List;
import lotto.message.ExceptionMessage;

public class Utils {
    public static List<String> splitStringToList(String source, String delimiter) {
        return Arrays.asList(source.split(delimiter));
    }

    public static List<Integer> convertListStringToListInteger(List<String> source) {
        return source.stream()
                .peek(Utils::validateNumber)
                .map(Integer::parseInt)
                .toList();
    }

    // TODO 리팩터링
    public static void validateNumber(String inputValue) {
        try {
            Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_FORMAT);
        }
    }
}
