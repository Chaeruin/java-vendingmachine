package vendingmachine.dto;

import vendingmachine.domain.Inventory;
import vendingmachine.domain.Product;

public record InventoryStatus(
        Product product,
        int stock
) {
    public static InventoryStatus of(final Inventory inventory) {
        return new InventoryStatus(
                inventory.getProduct(),
                inventory.getStock()
        );
    }
}
