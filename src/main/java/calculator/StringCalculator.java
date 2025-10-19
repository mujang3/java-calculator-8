package calculator;

import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DELIMITER = "[,:]";
    private static final String ERROR_MESSAGE = "잘못된 입력입니다.";

    public static int add(String input) {
        if (input == null || input.isBlank()){
            return 0;
        }
        String expression = input.trim();
        String delimiter = DELIMITER;

        if (expression.startsWith("//")){
            int nl = expression.indexOf('\n');
            int esc = expression.indexOf("\\n");
            boolean usedExcaped = false;

            if (nl < 0 && esc >= 0){
                nl = esc;
                usedExcaped = true;
            }

            if (nl < 0){
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }

            String custom = expression.substring(2, nl);
            if (custom.length() != 1){
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
            delimiter = Pattern.quote(custom);
            int afterHeader = nl + (usedExcaped ? 2 : 1);
            expression = expression.substring(afterHeader);
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
