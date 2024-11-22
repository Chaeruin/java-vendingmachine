package vendingmachine.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import vendingmachine.domain.Money;
import vendingmachine.enums.Coin;

public class ChangeController {

    // coinAmount : vending machine change
    // input : remaining money
    // inventories : input inventories (after minus stock)
    public Map<Coin, Integer> getChange(Map<Coin, Integer> coinAmount, Money input) {
        int remain = input.getMoney();
        Map<Coin, Integer> change = initMap();
        // while/for 종료 고려!! 역시나 여기가 문제
        setChange(remain, coinAmount, change);
        return change;
    }

    public void setChange(int remain, Map<Coin, Integer> coinAmount, Map<Coin, Integer> change) {
        for (Entry<Coin, Integer> ca : coinAmount.entrySet()) {
            if (remain - ca.getKey().getAmount() >= 0 && ca.getValue() != 0) {
                while (remain > 0 && coinAmount.get(ca.getKey()) != 0) {
                    remain -= ca.getKey().getAmount();
                    change.replace(ca.getKey(), change.get(ca.getKey()) + 1);
                    coinAmount.replace(ca.getKey(), coinAmount.get(ca.getKey()) - 1);
                }
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
