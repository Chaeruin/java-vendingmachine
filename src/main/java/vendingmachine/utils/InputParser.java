package vendingmachine.utils;

import java.util.LinkedList;
import java.util.List;
import vendingmachine.domain.Inventory;
import vendingmachine.domain.Money;
import vendingmachine.domain.Product;
import vendingmachine.enums.ErrorMessage;

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

        return isValidIndexInvetories(inputSplit);
    }

    static boolean isParsingOK(String inputOne, String inputTwo) {
        return InputValidator.isParsingErrorOrNone(inputOne) && InputValidator.isParsingErrorOrNone(inputTwo);
    }

    static List<Inventory> isValidIndexInvetories(String[] inputSplit) {
        List<Inventory> inventories = new LinkedList<>();
        try {
            for (int i = 0; i < inputSplit.length; i += 3) {
                addInventory(inventories, inputSplit[i], inputSplit[i + 1], inputSplit[i + 2]);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage());
        }
        return inventories;
    }

    static void addInventory(List<Inventory> inventories, String one, String two, String three) {
        if (isParsingOK(two, three)) {
            inventories.add(new Inventory(new Product(one, Integer.parseInt(two)), Integer.parseInt(three)));
        }
    }
}
