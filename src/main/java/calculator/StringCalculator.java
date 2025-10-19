package calculator;

import java.util.*;

public class StringCalculator {

    private static final String DELIMITER = "[,:]";

    public int add(String input) {
        if (input == null || input.isBlank()){
            return 0;
        }
        String experssion = input.trim();
        String delimiter = DELIMITER;

        String[] tokens = experssion.split(delimiter, -1);
        int sum = 0;
        for (String raw : tokens) {
            String s = raw.trim();
            if (s.isEmpty() || !s.matches("\\d+")){
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            int value = Integer.parseInt(s);
            if (value < 0){
                throw new IllegalArgumentException("잘못된 입력입니다/");
            }
            sum += value;
        }
        return sum;
    }
}
