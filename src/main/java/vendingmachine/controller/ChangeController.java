package vendingmachine.controller;

import java.util.HashMap;
import java.util.Map;
import vendingmachine.domain.Money;
import vendingmachine.enums.Coin;

public class ChangeController {

    // coinAmount : vending machine change
    // input : remaining money
    // inventories : input inventories (after minus stock)
    public Map<Coin, Integer> getChange(Map<Coin, Integer> coinAmount, Money input) {
        int remain = input.getMoney();
        Map<Coin, Integer> change = initMap();
        while (remain > 0) {
            // while/for 종료 고려
            setChange(remain, coinAmount, change);
        }
        return change;
    }

    public void setChange(int remain, Map<Coin, Integer> coinAmount, Map<Coin, Integer> change) {
        for (Coin c : Coin.values()) {
            if (coinAmount.get(c) != 0 && (remain - c.getAmount() >= 0)) {
                remain -= c.getAmount();
                change.replace(c, change.get(c) + 1);
                coinAmount.replace(c, coinAmount.get(c) - 1);
            }
        }
    }

    public Map<Coin, Integer> initMap() {
        Map<Coin, Integer> change = new HashMap<>();
        for (Coin c : Coin.values()) {
            change.put(c, 0);
        }
        return change;
    }
}
