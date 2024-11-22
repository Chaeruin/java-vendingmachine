package vendingmachine.enums;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    public static Coin getCoin(int amount) {
        if (amount == 500) {
            return COIN_500;
        } else if (amount == 100) {
            return COIN_100;
        } else if (amount == 50) {
            return COIN_50;
        } else if (amount == 10) {
            return COIN_10;
        }
        return null;
    }
}
