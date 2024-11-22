package vendingmachine.service;

import java.util.List;
import vendingmachine.domain.Inventory;
import vendingmachine.domain.Money;

public class InventoryService {

    public Money purchase(Money money, Inventory inventory) {
        inventory.setStock();
        if (inventory.getProduct() == null) {
            return null;
        }
        if (money.getMoney() - inventory.getProduct().getPrice() < 0) {
            return null;
        }
        money.setMoney(money.getMoney() - inventory.getProduct().getPrice());
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
