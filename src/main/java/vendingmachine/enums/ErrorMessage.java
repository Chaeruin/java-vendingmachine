package vendingmachine.enums;

public enum ErrorMessage {
    INVALID_RANGE_MONEY("[ERROR] 유효하지 않은 액수입니다"),
    INVALID_INPUT("[ERROR] 유효하지 않은 입력입니다."),
    INVALID_INPUT_PARAM("[ERROR] 구분자 입력이 유효하지 않습니다."),
    INVALID_INPUT_PRODUCT("[ERROR] 유효하지 않은 상품 입력입니다.");

    private final String errorMessage;

    ErrorMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
