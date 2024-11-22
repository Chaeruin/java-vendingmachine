package vendingmachine.controller;

import java.util.List;
import java.util.Map;
import vendingmachine.domain.Inventory;
import vendingmachine.domain.Money;
import vendingmachine.domain.Product;
import vendingmachine.enums.Coin;
import vendingmachine.service.InventoryService;
import vendingmachine.service.MoneyService;
import vendingmachine.service.ProductService;
import vendingmachine.utils.InputParser;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    final InputView inputView;
    final OutputView outputView;
    final MoneyService moneyService;
    final ProductService productService;
    final InventoryService inventoryService;
    final ChangeController changeController;

    public VendingMachineController(InputView inputView, OutputView outputView, MoneyService moneyService,
                                    ProductService productService, InventoryService inventoryService,
                                    ChangeController changeController) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.moneyService = moneyService;
        this.productService = productService;
        this.inventoryService = inventoryService;
        this.changeController = changeController;
    }

    public void run() {
        Map<Coin, Integer> coinAmount = getCoinAmount();
        List<Inventory> inventories = inputInventoriesHandler();
        Money money = getMoney();
        // 현재 금액이 최저 금액보다 크거나 재고가 있는 경우
        while (money.getMoney() >= inventoryService.getLowestPrice(inventories) && !inventoryService.isAllStockNotExist(
                inventories)) {
            String buyProduct = inputView.getBuyProducts();
            outputView.printEnter();
            money = purchaseProcess(buyProduct, money, inventories);
            outputView.printPutMoney(money);
        }
        outputView.printChange(changeController.getChange(coinAmount, money));
    }

    public Map<Coin, Integer> getCoinAmount() {
        Map<Coin, Integer> coinAmount = moneyService.randomCoin(inputCoinAmountHandler());
        outputView.printEnter();
        outputView.printCoinAmount(coinAmount);
        outputView.printEnter();
        return coinAmount;
    }

    public Money getMoney() {
        Money money = inputMoneyHandler();
        outputView.printEnter();
        outputView.printPutMoney(money);
        return money;
    }

    public Money purchaseProcess(String buyProduct, Money money, List<Inventory> inventories) {
        Inventory inventory = null;
        for (Inventory inv : inventories) {
            Product product = productService.getProduct(inv.getProduct(), buyProduct);
            if (product != null) {
                inventory = inventoryService.getInventory(inv, product);
                break;
            }
        }
        return inventoryService.purchase(money, inventory);
    }

    public Money inputCoinAmountHandler() {
        Money money = null;
        while (money == null) {
            try {
                money = InputParser.parseMoney(inputView.getVendingMachineMoney());
                return money;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return money;
    }

    public List<Inventory> inputInventoriesHandler() {
        List<Inventory> inventories = null;
        while (inventories == null) {
            try {
                inventories = InputParser.parseInventory(inputView.getProductsInventory());
                return inventories;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return inventories;
    }

    public Money inputMoneyHandler() {
        Money money = null;
        while (money == null) {
            try {
                money = InputParser.parseMoney(inputView.getMoney());
                return money;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return money;
    }
}
