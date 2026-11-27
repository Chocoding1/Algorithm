# 대여 횟수가 많은 자동차들의 월별 대여 횟수 구하기

## 문제 정보 - Codex 작성

- 링크: https://school.programmers.co.kr/learn/courses/30/lessons/151139?language=mysql
- 플랫폼 / 난이도: 프로그래머스 SQL Lv.3
- SQL 방언: MySQL
- 풀이 날짜: 2026-11-26
- 학습 단계: 12월 1일 시험 전 정확성 훈련
- 오늘 연습 범주: 기간 필터·조건에 따른 집계
- 목표 시간: 25분
- 풀이 구분: 신규
- SQL 코드 경로: `daily/2026-11-26/sql/대여 횟수가 많은 자동차들의 월별 대여 횟수 구하기/solution.sql`

## 풀이 전 핵심 기록 - 사용자 작성

> 각 질문 아래에 한 문장으로 답합니다.

최종 결과의 한 행은 어떤 차량의 어떤 기간을 나타내?
-

자동차를 포함할지 판단하는 횟수는 어느 기간을 기준으로 세?
-

대여 횟수가 기준 바로 아래인 차량과 정확히 기준에 맞는 차량의 결과는 어떻게 달라야 해?
-

월이 같은 두 행은 어떤 순서로 나와야 해?
-

## 풀이 후 결과 - 사용자 작성

- 실제 풀이 시간: 10분 (예: `15분`)
- 풀이 외 제외 시간: 0분 (예: `0분` / `5분, 식사`)
- 결과: 성공 (예: `성공` / `실패` / `부분 성공`)
- 제출 결과: 첫 제출 통과 (예: `첫 제출 통과` / `첫 통과 전 오답 2회` / `미제출`)
- 문법·결과 오류: 없음 (예: `없음` / `정렬 방향을 반대로 작성`)
- 막힌 지점·배운 점: select절의 별칭은 group by, having, order by에서 쓸 수 있다. (예: `없음` / `JOIN 후 중복 행이 생기는 이유를 놓침`)

## Codex 분석

- 힌트 수준(Codex 판정): 작은 힌트. 채점기의 `Only SELECT statements are allowed` 메시지와 MySQL의 `SELECT` 별칭 사용 범위를 확인했다. 문제의 집계 구조나 정답 쿼리는 풀이 중 제공하지 않았다.
- 복습 등급: B
- 등급 판정 근거: 사용자 기록상 목표 25분 안에 10분으로 첫 제출을 통과했다. 차량별 자격과 월별 집계 단위를 올바르게 나눴으며, 별칭 문법 도움을 받았다. 로컬 저장본은 바깥 집계의 기간 조건이 빠져 있다. 플랫폼 제출본과 저장본이 같은지는 미확인이다.
- 목표 시간 달성: 예 (10분 / 25분, 사용자 기록 기준)
- 첫 시도 성공: 예 (사용자 제출 기록 기준). 대화에서 언급한 실행 제한 메시지는 공식 오답 제출 횟수에 포함하지 않았다.
- 핵심 문법: 기간 범위 `WHERE`, 차량별 `GROUP BY`·`HAVING COUNT(*)`, `JOIN`, 월별 집계, `SELECT` 별칭의 참조 범위
- 결과 한 행의 단위: 자격을 충족한 자동차 한 대의 2022년 특정 월 대여 건수. 대여 이력이 없는 달은 그룹이 생기지 않는다.
- 쿼리 데이터 흐름: 안쪽에서 8~10월 행을 골라 차량당 대여 횟수를 세고 5회 이상인 차량 ID를 뽑는다. 바깥 쿼리는 그 차량의 대여 기록을 읽으므로 바깥에도 같은 날짜 범위를 적용한 후 월·차량별로 센다. [프로그래머스 문제](https://school.programmers.co.kr/learn/courses/30/lessons/151139)
- 중복·NULL·JOIN 카디널리티 확인: 안쪽 결과는 차량당 한 행이므로 원본 대여 기록 한 건이 JOIN 후 여러 건으로 늘어나지 않는다. 스키마에서 `CAR_ID`와 `START_DATE`는 필수 값이며, 집계 대상이 대여 기록 건수이므로 `COUNT(*)`가 맞다.
- 정답 검증: SQLite에서 MySQL의 `MONTH()`를 재현하고 로컬 저장본의 정렬 키에 `C1.`을 붙여 집계 로직을 비교했다. 저장본 로직은 공식 예제에서 1번 차의 7월 기록과 2번 차의 11월 기록까지 출력했다. 아래 개선안은 공식 예제의 다섯 행이 나왔고, 4회와 5회, 7월 31일과 8월 1일, 10월 31일과 11월 1일, 다음 해 같은 달의 경계를 확인했다. 설치된 MySQL 서버는 임시 초기화 중 종료돼 로컬 검증은 SQLite로 수행했다.
- 오류 분류: 집계 대상 기간 누락 (로컬 저장본)
- 다음에 적용할 규칙: 한 쿼리에서 차량 자격과 세부 건수를 따로 구하면 각 단계가 읽을 행을 따로 확인한다. 같은 기간이 두 단계에 적용되는지 제출 전에 기간 밖 기록 하나를 넣어 검사한다.

### 클린 쿼리 예시

```sql
SELECT MONTH(history.START_DATE) AS MONTH,
       history.CAR_ID,
       COUNT(*) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS history
JOIN (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE >= '2022-08-01'
      AND START_DATE <  '2022-11-01'
    GROUP BY CAR_ID
    HAVING COUNT(*) >= 5
) AS eligible ON eligible.CAR_ID = history.CAR_ID
WHERE history.START_DATE >= '2022-08-01'
  AND history.START_DATE <  '2022-11-01'
GROUP BY MONTH(history.START_DATE), history.CAR_ID
ORDER BY MONTH ASC, history.CAR_ID DESC;
```

안쪽 `WHERE`는 차량 선정에 쓸 대여 기록을 제한하고, 바깥 `WHERE`는 결과 건수에 포함할 대여 기록을 제한한다. `MONTH`는 `SELECT`의 별칭이며 MySQL에서 `ORDER BY`에 그대로 쓸 수 있다. [MySQL 별칭 문서](https://dev.mysql.com/doc/refman/8.4/en/problems-with-alias.html)

## SQL 복습

- 2~3일 뒤 짧은 재작성: 2026-11-29 후보, 3분. 두 날짜 범위의 역할을 설명하고, 기간 밖 기록이 집계되는 반례를 확인한다. 모의고사 보완과 겹치면 11월 30일 SQL 점검에 통합한다.
- 동일 문제 재도전: 생략
- 주간 혼합 문제 반영: 자격 판정의 그룹과 최종 출력 그룹이 다를 때, 각 집계의 날짜 범위와 결과 한 행의 단위를 확인한다.
