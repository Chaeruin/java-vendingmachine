package vendingmachine.domain;

import vendingmachine.enums.ErrorMessage;

public class Money {
    private int money;

    public Money(int money) {
        validInt(money);
        this.money = money;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    void validInt(int money) {
        if (money < 10 || money % 10 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE_MONEY.getErrorMessage());
        }
    }
}
