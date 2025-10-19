package calculator;

import java.util.*;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DELIMITER = "[,:]";
    private static final String ERROR_MESSAGE = "잘못된 입력입니다.";

    public int add(String input) {
        if (input == null || input.isBlank()){
            return 0;
        }
        String expression = input.trim();
        String delimiter = DELIMITER;

        if (expression.startsWith("//")){
            int newlineIdx = expression.indexOf('\n');
            if (newlineIdx < 0){
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
            String custom = expression.substring(2, newlineIdx);
            if (custom.length() != 1){
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
            delimiter = Pattern.quote(custom);
            expression = expression.substring(newlineIdx + 1);
            if (expression.isEmpty()){
                return 0;
            }
        }

        String[] tokens = expression.split(delimiter, -1);
        int sum = 0;
        for (String raw : tokens) {
            String s = raw.trim();
            if (s.isEmpty() || !s.matches("\\d+")){
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
            int value = Integer.parseInt(s);
            if (value < 0){
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
            sum += value;
        }
        return sum;
    }
}
