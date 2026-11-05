# 상품 별 오프라인 매출 구하기

## 문제 정보 - Codex 작성

- 링크: https://school.programmers.co.kr/learn/courses/30/lessons/131533
- 플랫폼 / 난이도: 프로그래머스 SQL / Lv.2
- SQL 방언: MySQL
- 풀이 날짜: 2026-11-05
- 학습 단계: SQL 입문 3주차
- 오늘 연습 범주: `INNER JOIN` 강화형·1:N 행 증가·집계·다중 정렬
- 목표 시간: 30분
- 풀이 구분: 신규
- SQL 코드 경로: `algorithm-study/daily/2026-11-05/sql/상품 별 오프라인 매출 구하기/solution.sql`

## 풀이 전 핵심 기록 - 사용자 작성

- 출력해야 할 값: 상품코드 별 매출액(판매가 * 판매량) 합계
- 조회할 테이블과 한 행의 의미: PRODUCT : 의류 쇼핑몰에서 판매중인 상품들의 상품 정보 / OFFLINE_SALE : 오프라인 상품 판매 정보
- 행을 바꾸는 조건과 최종 정렬: 상품코드 별 매출액(판매가 * 판매량) 합계 / 매출액을 기준으로 내림차순 정렬해, 매출액이 같다면 상품코드를 기준으로 오름차순

## 풀이 후 결과 - 사용자 작성

- 실제 풀이 시간: 9분 30초
- 풀이 외 제외 시간: 0분
- 결과: 성공
- 제출 결과: 첫 제출 통과
- 문법·결과 오류: 없음
- 막힌 지점·배운 점:

## Codex 분석

- 힌트 수준(Codex 판정): 없음
- 복습 등급: A
- 등급 판정 근거: 목표 30분 안인 9분 30초에 `INNER JOIN`, 상품 단위 집계, 매출 계산과 두 정렬 기준을 모두 정확히 작성해 문법·결과 오류 없이 첫 제출로 통과했다.
- 목표 시간 달성: 예
- 첫 시도 성공: 예
- 핵심 문법: `INNER JOIN`·`GROUP BY`·`SUM`·계산식·다중 `ORDER BY`
- 결과 한 행의 단위: 오프라인 판매 기록이 존재하는 상품 하나
- 쿼리 데이터 흐름: `PRODUCT`의 상품 한 행과 `OFFLINE_SALE`의 같은 `PRODUCT_ID` 판매 행들을 연결한다. 연결 후 상품 하나가 판매 기록 수만큼 늘어나며, `GROUP BY`로 상품별 판매량을 합산하고 판매가를 곱해 매출액을 만든 뒤 매출액 내림차순·상품코드 오름차순으로 정렬한다.
- 중복·NULL·JOIN 카디널리티 확인: `PRODUCT : OFFLINE_SALE`은 1:N 관계라 JOIN 후 같은 상품이 여러 행이 되며, 이 행 증가는 중복 오류가 아니라 합산해야 할 판매 기록이다. 사용한 컬럼은 모두 `NULL` 불가이고 `INNER JOIN`이므로 판매 기록이 없는 상품은 결과에서 제외된다.
- 코드 개선 포인트: 현재 쿼리는 MySQL에서 정확하다. `PRICE * SUM(SALES_AMOUNT)`는 상품 가격이 상품마다 고정이므로 `SUM(PRICE * SALES_AMOUNT)`와 같은 결과다. 후자는 JOIN으로 만들어진 판매 행마다 매출을 계산해 합산한다는 의미가 더 직접적이다. 또한 `PRODUCT_ID` 기본 키의 함수 종속성을 MySQL이 인정하므로 현재 `GROUP BY P.PRODUCT_ID`가 통과하지만, 선택한 비집계 컬럼도 `GROUP BY`에 명시하면 의도와 이식성이 더 분명해진다.
- 풀이 후 새로 배운 점: JOIN 후 결과 행의 단위를 먼저 확인해야 집계 대상이 보인다. 1:N JOIN에서 N쪽 행 수만큼 상품 행이 늘어나므로 상품 단위 결과를 만들려면 다시 그룹화해야 한다.
- 오류 분류: 없음
- 다음에 적용할 규칙: JOIN 문제에서는 연결 직후 한 행이 무엇인지 확인하고, 최종 한 행의 단위가 다르면 그 단위로 `GROUP BY`한 뒤 필요한 값을 집계한다.

### 클린 쿼리 예시

원본 SQL은 수정하지 않는다.

```sql
SELECT P.PRODUCT_CODE,
       SUM(P.PRICE * OS.SALES_AMOUNT) AS SALES
FROM PRODUCT AS P
JOIN OFFLINE_SALE AS OS
  ON P.PRODUCT_ID = OS.PRODUCT_ID
GROUP BY P.PRODUCT_ID, P.PRODUCT_CODE, P.PRICE
ORDER BY SALES DESC, P.PRODUCT_CODE ASC;
```

## SQL 복습

- 2~3일 뒤 짧은 재작성: 대상(2026-11-08) — JOIN 직후 행 단위, 상품 단위 집계와 두 정렬 기준을 설명하고 5분 이내 재작성
- 동일 문제 재도전: 없음
- 주간 혼합 문제 반영: 대상 — 다음 SQL 주간 혼합에서 1:N JOIN 후 집계를 포함
