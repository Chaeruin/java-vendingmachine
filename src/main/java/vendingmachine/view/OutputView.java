package vendingmachine.view;

import java.util.Map;
import java.util.Map.Entry;
import vendingmachine.domain.Money;
import vendingmachine.enums.Coin;

public class OutputView {

    public void printEnter() {
        System.out.println();
    }

    public void printCoinAmount(Map<Coin, Integer> coinAmount) {
        System.out.println("자판기가 보유한 동전");
        for (Entry<Coin, Integer> coinA : coinAmount.entrySet()) {
            System.out.println(coinA.getKey().getAmount() + "원 - " + coinA.getValue() + "개");
        }
    }

    public void printPutMoney(Money money) {
        System.out.println("투입 금액: " + money.getMoney() + "원");
    }

    // 여기까지 반복

    public void printChange(Map<Coin, Integer> change) {
        System.out.println("잔돈");
        for (Entry<Coin, Integer> ch : change.entrySet()) {
            if (ch.getValue() == 0) {
                continue;
            }
            System.out.println(ch.getKey().getAmount() + "원 - " + ch.getValue() + "개");
        }
    }

}
