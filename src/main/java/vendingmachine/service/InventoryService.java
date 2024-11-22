package vendingmachine.service;

import java.util.List;
import vendingmachine.domain.Inventory;
import vendingmachine.domain.Money;
import vendingmachine.domain.Product;

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

    public int getLowestPrice(List<Inventory> inventories) {
        int min = Integer.MAX_VALUE;
        for (Inventory inv : inventories) {
            min = Math.min(min, inv.getProduct().getPrice());
        }
        return min;
    }

    public boolean isAllStockNotExist(List<Inventory> inventories) {
        int sum = 0;
        for (Inventory inv : inventories) {
            sum += inv.getStock();
        }
        return sum == 0;
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

    public Inventory getInventory(Inventory inv, Product product) {
        if (inv.getProduct().getName().equals(product.getName())) {
            return inv;
        }
        return null;
    }

}
