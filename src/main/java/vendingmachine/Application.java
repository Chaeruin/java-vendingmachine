package vendingmachine;

import vendingmachine.controller.ChangeController;
import vendingmachine.controller.VendingMachineController;
import vendingmachine.service.InventoryService;
import vendingmachine.service.MoneyService;
import vendingmachine.service.ProductService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        MoneyService moneyService = new MoneyService();
        ProductService productService = new ProductService();
        InventoryService inventoryService = new InventoryService();
        ChangeController changeController = new ChangeController();

        VendingMachineController vendingMachineController = new VendingMachineController(inputView, outputView,
                moneyService, productService, inventoryService, changeController);

        vendingMachineController.run();
    }
}
