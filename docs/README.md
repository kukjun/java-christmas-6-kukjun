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

<br>
<br>
<br>

### 리팩토링
- [x] TODO로 적어놓은 버그 픽스
- [x] 상수 Enum으로 모아서 처리
- [x] 구현 Method 분리

<br>
<br>
<br>

### 테스트 코드

> Unit
- [x] order
- [x] badge
- [x] discount

<br>
<br>

> Integation
- [x] DecemberEventPlanner


통합테스트를 진행하는 경우, 입출력 값 지정을 미리 할 수 없어 테스트를 진행하지 못함. 따라서, Application Test 방식을 따라서, 구혀함.

<br>
<br>
<br>

## 추가 사항

1. 사용자 입력을 받되 명확한 에러메시지를 지정하지 않은 경우, 임의로 에러메시지를 생성했음.
