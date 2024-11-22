package vendingmachine.utils;

import vendingmachine.domain.Inventory;
import vendingmachine.domain.Money;
import vendingmachine.domain.Product;

public class InputParser {
    public static Money parseMoney(String input) {
        if (InputValidator.isParsingErrorOrNone(input)) {
            return new Money(Integer.parseInt(input));
        }
        return null;
    }

    public static Inventory parseInventory(String input) {
        String regex = "[\\[\\]]";
        String[] inputSplit = input.replaceAll(regex, "")
                .replaceAll(";", ",").split(",");
        for (int i = 0; i < inputSplit.length; i += 3) {
            if (InputValidator.isParsingErrorOrNone(inputSplit[i + 1]) && InputValidator.isParsingErrorOrNone(
                    inputSplit[i + 2])) {
                return new Inventory(new Product(inputSplit[i], Integer.parseInt(inputSplit[i + 1])),
                        Integer.parseInt(inputSplit[i + 2]));
            }
        }
        return null;
    }

}
