# 년, 월, 성별 별 상품 구매 회원 수 구하기

## 문제 정보 - Codex 작성

- 링크: https://school.programmers.co.kr/learn/courses/30/lessons/131532
- 플랫폼 / 난이도: 프로그래머스 SQL Lv.4
- SQL 방언: MySQL
- 풀이 날짜: 2026-11-24
- 학습 단계: 12월 1일 시험 전 복합 SQL
- 오늘 연습 범주: 다중 JOIN·날짜 그룹·1:N 중복·NULL 필터·회원 수 집계
- 목표 시간: 25분
- 풀이 구분: 신규 복합
- SQL 코드 경로: `daily/2026-11-24/sql/년, 월, 성별 별 상품 구매 회원 수 구하기/solution.sql`

## 풀이 전 핵심 기록 - 사용자 작성

> 각 항목은 한 문장이면 충분합니다.

- 출력해야 할 값: 어떤 세 기준별로 구매 회원 수를 출력해야 하는가?
- 조회할 테이블과 한 행의 의미: 판매 기록 하나는 무엇을 나타내며, 회원 정보를 연결한 후 한 회원이 여러 행으로 나타날 수 있는가?
- 행을 바꾸는 조건과 최종 정렬: 결과에서 제외할 회원 정보는 무엇이며, 최종 그룹과 정렬 기준은 어떤 순서인가?

## 풀이 후 결과 - 사용자 작성

- 실제 풀이 시간: 12분 (예: `20분`)
- 풀이 외 제외 시간: 0분 (예: `0분` / `5분, 식사`)
- 결과: 성공 (예: `성공` / `실패` / `부분 성공`)
- 제출 결과: 첫 통과 전 오답 1회 (예: `첫 제출 통과` / `첫 통과 전 오답 2회` / `미제출`)
- 문법·결과 오류: 없음 (예: `없음` / `회원 수를 판매 행 수로 집계`)
- 막힌 지점·배운 점: YEAR, MONTH 배움 / 마지막에 user 수 셀 때 distinct를 안 해서 틀렸음 (예: `없음` / `같은 회원의 월내 복수 구매를 어떻게 세어야 하는지 혼동`)

## Codex 분석

- 힌트 수준(Codex 판정): 작은 힌트 — 풀이 중 `YEAR()`·`MONTH()` 날짜 함수 API를 확인함. `COUNT(DISTINCT UI.USER_ID)` 수정은 Codex의 오답 원인 설명을 읽기 전에 독립적으로 완료했으므로 해당 답변은 힌트로 집계하지 않음
- 복습 등급: B
- 등급 판정 근거: 목표 25분 안인 12분에 JOIN·성별 NULL 제외·년월성별 그룹·정렬을 완성했지만, 첫 제출에서 판매 행 수를 `COUNT(*)`로 세어 한 회원의 월내 복수 구매를 중복 집계했고, 날짜 함수 문법을 작은 힌트로 확인했으므로 B등급
- 목표 시간 달성: 예 — 12분 / 25분
- 첫 시도 성공: 아니오 — 첫 통과 전 오답 1회
- 핵심 문법: `INNER JOIN`·`YEAR()`·`MONTH()`·`IS NOT NULL`·`COUNT(DISTINCT ...)`·`GROUP BY`·다중 `ORDER BY`
- 결과 한 행의 단위: 판매 연도·월·성별 조합 하나와 그 조합에서 구매한 서로 다른 회원 수
- 쿼리 데이터 흐름: `USER_INFO`와 `ONLINE_SALE`을 회원 ID로 연결해 판매 기록별 행을 만든다. 성별이 NULL인 회원의 판매 행을 제외하고, 판매일의 년·월·회원 성별로 묶은 뒤 서로 다른 회원 ID를 세고 같은 순서로 정렬한다.
- 중복·NULL·JOIN 카디널리티 확인: 회원 하나는 `ONLINE_SALE`의 서로 다른 날짜·상품 구매로 같은 달에 여러 행이 될 수 있다. 따라서 `COUNT(*)`는 판매 기록 수이며, 구매 회원 수는 `COUNT(DISTINCT UI.USER_ID)`로 세어야 한다. `WHERE UI.GENDER IS NOT NULL`로 요구된 NULL 제외를 적용함
- 정답 검증: 최종 쿼리는 한 회원의 월내 복수 구매를 한 번만 세고, 성별 NULL 제외·출력 별칭·세 기준 오름차순 정렬을 모두 반영해 공식 제출에 통과함
- 코드 개선 포인트: 현재 쿼리는 정답이며 의미 있는 구조 변경은 필요 없다. `COUNT(...) AS USERS`로 `AS`를 명시하고 `ORDER BY YEAR, MONTH, GENDER`로 출력 별칭을 재사용하면 의도가 더 짧고 잘 드러난다.
- 클린 쿼리 예시:

```sql
SELECT YEAR(OS.SALES_DATE) AS YEAR,
       MONTH(OS.SALES_DATE) AS MONTH,
       UI.GENDER,
       COUNT(DISTINCT UI.USER_ID) AS USERS
FROM USER_INFO AS UI
JOIN ONLINE_SALE AS OS
    ON UI.USER_ID = OS.USER_ID
WHERE UI.GENDER IS NOT NULL
GROUP BY YEAR(OS.SALES_DATE),
         MONTH(OS.SALES_DATE),
         UI.GENDER
ORDER BY YEAR,
         MONTH,
         UI.GENDER;
```

원본 SQL은 사용자의 최종 통과 쿼리로 보존했다.

- 오류 분류: JOIN·중복·집계 단위·문법 탐색
- 다음에 적용할 규칙: 문제가 사람·상품·주문의 `수`를 물으면 JOIN 후 한 대상이 여러 행인지 확인하고, 행 수가 아닌 대상 수라면 식별자에 `DISTINCT`를 적용한다.

## SQL 복습

- 2~3일 뒤 짧은 재작성: 2026-11-27, `COUNT(*)`·`COUNT(column)`·`COUNT(DISTINCT id)`가 각각 세는 대상을 5분 설명
- 동일 문제 재도전: 생략 — 핵심 `DISTINCT`는 독립적으로 수정함
- 주간 혼합 문제 반영: 2026-11-29 유형 비공개 JOIN·중복·집계 혼합
