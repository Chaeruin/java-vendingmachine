package vendingmachine.service;

import java.util.List;
import vendingmachine.domain.Inventory;
import vendingmachine.domain.Money;
import vendingmachine.domain.Product;

public class InventoryService {

    public Money purchase(Money money, Product product) {
        if (product == null) {
            return null;
        }
        if (money.getMoney() - product.getPrice() < 0) {
            return null;
        }
        money.setMoney(money.getMoney() - product.getPrice());
        return money;
    }

    public boolean isAllStockValid(List<Inventory> inventories) {
        for (Inventory inv : inventories) {
            if (!isStockValid(inv)) {
                return false;
            }
        }
        return true;
    }

    public boolean isStockValid(Inventory inventory) {
        return inventory.getStock() != 0;
    }

}
