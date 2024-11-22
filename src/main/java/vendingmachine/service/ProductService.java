package vendingmachine.service;

import vendingmachine.domain.Product;
import vendingmachine.enums.ErrorMessage;
import vendingmachine.utils.InputValidator;

public class ProductService {
    public Product getProduct(Product product, String input) {
        if (InputValidator.isNoneProduct(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_PRODUCT.getErrorMessage());
        }
        if (product.getName().equals(input)) {
            return product;
        }
        return null;
    }
}
