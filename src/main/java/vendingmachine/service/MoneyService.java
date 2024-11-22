package vendingmachine.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import vendingmachine.domain.Money;
import vendingmachine.enums.Coin;

public class MoneyService {

    public Map<Coin, Integer> randomCoin(Money money) {
        List<Integer> coins = new LinkedList<>(
                Arrays.asList(Coin.COIN_500.getAmount(), Coin.COIN_100.getAmount(), Coin.COIN_50.getAmount(),
                        Coin.COIN_10.getAmount()));
        Map<Coin, Integer> coinAmount = initCoins();
        int amount = money.getMoney();
        while (amount > 0) {
            int randomCoin = Randoms.pickNumberInList(coins);
            if (amount - randomCoin >= 0) {
                amount -= randomCoin;
                coinAmount.replace(Coin.getCoin(randomCoin), coinAmount.get(Coin.getCoin(randomCoin)) + 1);
            }
        }
        return coinAmount;
    }

    public Map<Coin, Integer> initCoins() {
        Map<Coin, Integer> coinAmount = new LinkedHashMap<>();
        for (Coin c : Coin.values()) {
            coinAmount.put(c, 0);
        }
        return coinAmount;
    }

}
