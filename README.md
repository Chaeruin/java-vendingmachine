# 미션 - 자판기

(5시간 제한) <br>
10:50 시작 <br>
-> 15:50 종료 예정 <br>
11:12 기능 요구사항 분석 완료 <br>
11:40 domain 설계 대충 완료 <br>
12:10 utils 설계 및 정규식.. <br>
12:10 ~ 잠시 휴식 (여기까지 1시간 20분) ~ 12:20 재개 <br>
12:55 서비스 설계 완 <br>
13:16 잔돈 컨트롤러 설계 완 <br>
14:36 잔돈 랜덤 배치 제외 설계및 구현 완 <br>
14:50 테케 통과, 구현 완 / 잔돈 랜덤 배치 픽스 완료 (총 휴식 제외 3시간 50분 소요) <br>

- 안한거 : 투입금액 문자예외->이미했었음, 상품명가격수량 인덱스예외(파싱예외)->해결

<br><br>

## 기능 구현

- [X] 입력
    - [X] 자판기가 보유하고 있는 금액 입력
        - [X] 문자/빈문자 예외
        - [X] 10원 미만 예외
    - [X] 상품명과 가격, 수량 입력 [,,];... 포맷 지키기
        - [X] 상품명 빈문자 예외
        - [X] 구분자 오류 예외 -> parser에서 걸러짐
        - [X] 문자열(가격,수량부분)/빈문자 예외
        - [X] 가격이 100원부터 시작, 10원으로 나누어 떨어져야 함 -> 아닌 경우 예외
    - [X] 투입 금액 입력
        - [ ] 문자/빈문자 예외
        - [X] 사용자가 입력하는 투입 금액은 10원 이상 & 10원으로 나누어 떨어져야 함으로 설정하였음
    - [X] 구매 상품명 입력
        - [X] 빈문자 예외
        - [X] 없는 상품 예외 (재고 소모된 상품 예외)
            - [X] 투입 금액 - 상품 금액 -> 구매 상품 입력 반복
            - [X] 남은 투입 금액이 입력한 상품 중 최소 구매 가격보다 작을 때 null 처리
            - [X] 반복 종료
            - [X] 또는 투입 금액이 남아도 모든 상품 재고가 소모된 경우
            - [X] 반복 종료
- [X] 출력
    - [X] 잔돈
        - [X] 남은 투입 금액을 자판기가 가진 동전으로 반환
        - [X] 이때 반환되는 동전 갯수가 최소 갯수가 되도록 함 -> 500원부터 최대 반환하면 최소 갯수됨 설계는 그렇게 했으나 체크해봐야함
        - [X] 잔돈으로 반환할 수 있는 최대 금액 반환하고 나머지는 자판기에 남김

- [X] 기능 구현
    - [X] 자판기 보유 금액 랜덤으로 보유 동전 생성(갯수)
    - [X] 기타 위에 서술

<br><br>

## 🚀 기능 요구사항

반환되는 동전이 최소한이 되는 자판기를 구현한다.

- 자판기가 보유하고 있는 금액으로 동전을 무작위로 생성한다.
    - 투입 금액으로는 동전을 생성하지 않는다.
- 잔돈을 돌려줄 때 *현재 보유한 최소 개수의 동전으로 잔돈을 돌려준*다.
- 지폐를 잔돈으로 반환하는 경우는 없다고 가정한다.
- 상품명, 가격, 수량을 입력하여 상품을 추가할 수 있다.
    - _상품 가격은 100원부터 시작하며, 10원으로 나누어떨어져야 한다._
- 사용자가 투입한 금액으로 상품을 구매할 수 있다.
- _남은 금액이 상품의 최저 가격보다 적거나, 모든 상품이 소진된 경우 바로 잔돈을 돌려준다._
- 잔돈을 반환할 수 없는 경우 **잔돈으로 반환할 수 있는 금액만 반환한다.**
    - _반환되지 않은 금액은 자판기에 남는다._
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 **해당 부분부터 다시 입력을 받는다.**
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