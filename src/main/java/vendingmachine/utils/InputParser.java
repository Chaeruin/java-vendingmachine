package vendingmachine.utils;

import java.util.LinkedList;
import java.util.List;
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

    public static List<Inventory> parseInventory(String input) {
        String regex = "[\\[\\]]";
        String[] inputSplit = input.replaceAll(regex, "")
                .replaceAll(";", ",").split(",");
        List<Inventory> inventories = new LinkedList<>();
        for (int i = 0; i < inputSplit.length; i += 3) {
            if (InputValidator.isParsingErrorOrNone(inputSplit[i + 1]) && InputValidator.isParsingErrorOrNone(
                    inputSplit[i + 2])) {
                inventories.add(new Inventory(new Product(inputSplit[i], Integer.parseInt(inputSplit[i + 1])),
                        Integer.parseInt(inputSplit[i + 2])));
            }
        }
        return inventories;
    }

}
