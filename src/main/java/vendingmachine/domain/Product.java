package vendingmachine.domain;

import vendingmachine.enums.ErrorMessage;

public class Product {
    private final String name;
    private final int price;

    public Product(String name, int price) {
        validName(name);
        validPrice(price);
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    void validName(String name) {
        if (name.equals("") || name.equals(" ")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage());
        }
    }

    void validPrice(int price) {
        if (price < 100 || price % 10 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE_MONEY.getErrorMessage());
        }
    }
}
