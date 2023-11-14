# 크리스마스 프로모션 기능 요구사항 분석

---

### 기능 개발 목록
- [x] Event Planner
- [x] Event Planner UI
- [x] Order
- [x] Discount
- [x] Badge


<br>
<br>

> discount

Discount 로직 구현 중 문제를 발견.
* 사은품을 할인으로 볼 것인지, 공짜로 제공하는 것으로 볼것인지.
* 본 내용에 대해서는 할인으로 간주해서 처리함.
* 대신 사은품으로 받는 제품에 다시 할인이 적용되지 않도록 order에 할인 가능 여부를 추가함

<br>

> badge

배지의 경우, 배지 인터페이스를 미리 정하고, 값을 불러오는 메서드는 toString만 사용.

<br>

> Formatter

Formatter 를 통해 int를 문제에서 요구하는 문자열로 변환




