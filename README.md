# 미션 - 자판기

(5시간 제한)

##

## 🚀 기능 요구사항

반환되는 동전이 최소한이 되는 자판기를 구현한다.

- 자판기가 보유하고 있는 금액으로 동전을 무작위로 생성한다.
    - 투입 금액으로는 동전을 생성하지 않는다.
- 잔돈을 돌려줄 때 현재 보유한 최소 개수의 동전으로 잔돈을 돌려준다.
- 지폐를 잔돈으로 반환하는 경우는 없다고 가정한다.
- 상품명, 가격, 수량을 입력하여 상품을 추가할 수 있다.
    - 상품 가격은 100원부터 시작하며, 10원으로 나누어떨어져야 한다.
- 사용자가 투입한 금액으로 상품을 구매할 수 있다.
- 남은 금액이 상품의 최저 가격보다 적거나, 모든 상품이 소진된 경우 바로 잔돈을 돌려준다.
- 잔돈을 반환할 수 없는 경우 잔돈으로 반환할 수 있는 금액만 반환한다.
    - 반환되지 않은 금액은 자판기에 남는다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 해당 부분부터 다시 입력을 받는다.
- 아래의 프로그래밍 실행 결과 예시와 동일하게 입력과 출력이 이루어져야 한다.

### ✍🏻 입출력 요구사항

#### ⌨️ 입력

- 상품명, 가격, 수량은 쉼표로, 개별 상품은 대괄호([])로 묶어 세미콜론(;)으로 구분한다.

```
[콜라,1500,20];[사이다,1000,10]
```

#### 🖥 출력

- 자판기가 보유한 동전

```
500원 - 0개
100원 - 4개
50원 - 1개
10원 - 0개
```

- 잔돈은 반환된 동전만 출력한다.

```
100원 - 4개
50원 - 1개
```

- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 [ERROR]로 시작해야 한다.

```
[ERROR] 금액은 숫자여야 합니다.
```

#### 💻 프로그래밍 실행 결과 예시

```
자판기가 보유하고 있는 금액을 입력해 주세요.
450

자판기가 보유한 동전
500원 - 0개
100원 - 4개
50원 - 1개
10원 - 0개

상품명과 가격, 수량을 입력해 주세요.
[콜라,1500,20];[사이다,1000,10]

투입 금액을 입력해 주세요.
3000

투입 금액: 3000원
구매할 상품명을 입력해 주세요.
콜라

투입 금액: 1500원
구매할 상품명을 입력해 주세요.
사이다

투입 금액: 500원
잔돈
100원 - 4개
50원 - 1개
```

---

### 프로그래밍 요구사항 - Coin

- Coin 클래스를 활용해 구현해야 한다.
- 필드(인스턴스 변수)인 `amount`의 접근 제어자 private을 변경할 수 없다.

```java
public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    // 추가 기능 구현
}
```

### 프로그래밍 요구사항 - Randoms, Console

- JDK에서 기본 제공하는 Random, Scanner API 대신 `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms`, `Console` API를 활용해 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInList()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- 프로그램 구현을 완료했을 때 `src/test/java` 디렉터리의 `ApplicationTest`에 있는 모든 테스트 케이스가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**