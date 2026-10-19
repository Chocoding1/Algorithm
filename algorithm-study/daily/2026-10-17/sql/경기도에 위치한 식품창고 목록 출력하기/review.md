# 경기도에 위치한 식품창고 목록 출력하기

## 문제 정보 - Codex 작성

- 링크: https://school.programmers.co.kr/learn/courses/30/lessons/131114
- 플랫폼 / 난이도: 프로그래머스 SQL / Lv.1
- SQL 방언: MySQL
- 풀이 날짜: 2026-10-17
- 실제 완료일: 2026-10-18
- 학습 단계: SQL 입문 2주차 4일차
- 오늘 연습 범주: `NULL` 판별과 대체값 출력
- 목표 시간: 20분
- 풀이 구분: 신규
- SQL 코드 경로: `algorithm-study/daily/2026-10-17/sql/경기도에 위치한 식품창고 목록 출력하기/solution.sql`

## 풀이 전 핵심 기록 - 사용자 작성

- 출력해야 할 값: 경기도에 위치한 창고의 ID, 이름, 주소, 냉동시설 여부
- 조회할 테이블과 한 행의 의미: FOOD_WAREHOUSE / 식품창고의 정보
- 행을 바꾸는 조건과 최종 정렬: 경기도에 위치한 창고 / 창고 ID를 기준으로 오름차순

## 풀이 후 결과 - 사용자 작성

- 실제 풀이 시간: 5분
- 풀이 외 제외 시간: 0분
- 결과: 정답
- 제출 결과: 첫 제출 통과
- 문법·결과 오류: 특정 컬럼 값이 null인 경우 COALESCE를 사용했어야 했는데, default를 사용함
- 막힌 지점·배운 점: COALESCE

## Codex 분석

- 힌트 수준(Codex 판정): 작은 힌트 — 사용자가 `NULL`인 컬럼을 특정 값으로 출력하는 방법을 질문해 `COALESCE`·`IFNULL` 문법과 현재 문제의 `FREEZER_YN` 적용 예를 확인했지만, 출력 컬럼·지역 필터·정렬을 포함한 전체 쿼리는 독립적으로 작성함
- 복습 등급: B
- 등급 판정 근거: 목표 20분 안인 5분에 최종 쿼리를 완성해 첫 제출로 통과했지만, 저장 시 기본값을 정하는 `DEFAULT`와 조회 시 `NULL`을 대체하는 `COALESCE`를 혼동해 핵심 문법에 작은 힌트를 사용함
- 목표 시간 달성: 예 (5분 / 20분)
- 첫 시도 성공: 예
- 핵심 문법: `LIKE`, `COALESCE`, `ORDER BY`
- 결과 한 행의 단위: 주소가 `경기도`로 시작하는 식품창고 한 곳
- 쿼리 데이터 흐름: `FROM FOOD_WAREHOUSE`에서 창고별 행을 읽고, `WHERE ADDRESS LIKE '경기도%'`로 경기도 창고만 남긴 뒤 `FREEZER_YN`의 `NULL`을 출력 시 `'N'`으로 바꾸고 창고 ID 오름차순으로 정렬함
- 중복·NULL·JOIN 카디널리티 확인: JOIN과 그룹화가 없어 원본 창고 한 행이 결과 한 행으로 유지된다. `COALESCE`는 행을 제거하거나 저장값을 변경하지 않고 결과에 표시되는 `NULL`만 `'N'`으로 대체한다. 주소가 `NULL`인 행은 `LIKE` 결과도 `NULL`이어서 `WHERE`를 통과하지 않는다.
- 정답 검증: 프로그래머스 첫 제출 통과
- 코드 개선 포인트: **출력 의미 명시** — 현재 쿼리는 정답이다. `COALESCE(FREEZER_YN, 'N') AS FREEZER_YN`처럼 별칭을 붙이면 계산식의 결과 컬럼명이 요구사항과 일치한다는 의도가 더 명확하다. 성능 개선은 아니다.
- 클린 쿼리 예시:

```sql
SELECT WAREHOUSE_ID,
       WAREHOUSE_NAME,
       ADDRESS,
       COALESCE(FREEZER_YN, 'N') AS FREEZER_YN
FROM FOOD_WAREHOUSE
WHERE ADDRESS LIKE '경기도%'
ORDER BY WAREHOUSE_ID;
```

- 풀이 후 새로 배운 점: `DEFAULT`는 `INSERT`에서 값을 생략했을 때 저장할 기본값이고, `COALESCE`는 조회 결과에서 첫 번째 `NULL`이 아닌 값을 선택한다. 따라서 이미 저장된 `NULL`을 화면에 다른 값으로 보여줄 때는 `COALESCE` 또는 MySQL의 `IFNULL`을 사용한다.
- 오류 분류: 문법 선택 — 저장 시 기본값과 조회 시 `NULL` 대체 역할 혼동
- 다음에 적용할 규칙: **기존 행의 `NULL`을 다른 값으로 보여줄 때는 `COALESCE`, 새 행에서 값을 생략했을 때 저장할 기본값은 `DEFAULT`를 사용한다.**

## SQL 복습

- 2~3일 뒤 짧은 재작성: 대상(2026-10-21) — `DEFAULT`와 `COALESCE`의 차이를 설명하고 별칭까지 포함한 쿼리를 5분 이내 재작성
- 동일 문제 재도전: 없음 — 전체 쿼리는 첫 제출로 통과했고 작은 문법 힌트만 사용함
- 주간 혼합 문제 반영: `NULL` 판별·대체값 출력 문제에서 독립 적용 여부 확인 예정
