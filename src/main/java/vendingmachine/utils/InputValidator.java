package vendingmachine.utils;

import vendingmachine.enums.ErrorMessage;

public class InputValidator {

    // 자판기 금액 문/빈 예외
    // 가격, 수량 파싱할 때 해당 부분에 넣으면 됨
    // 투입 금액 문/빈 예외 -> 안함
    public static boolean isParsingErrorOrNone(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage());
        }
        return true;
    }

    // 구매할 때 사용
    public static boolean isNoneProduct(String input) {
        if (input.equals("") || input.equals(" ")) {
            return true;
        }
        return false;
    }
}
