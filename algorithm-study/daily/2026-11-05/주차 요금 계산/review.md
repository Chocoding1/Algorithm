# 주차 요금 계산

## 문제 정보 - Codex 작성

- 링크: https://school.programmers.co.kr/learn/courses/30/lessons/92341
- 플랫폼 / 난이도: 프로그래머스 / Lv.2
- 풀이 날짜: 2026-11-05
- 핵심 유형: 문자열 파싱·차량별 상태 누적·구현
- 목표 시간: 40분
- 풀이 구분: 신규
- 연결된 원본 문제: 풀이 완료 후 Codex 작성
- Java 코드 경로: `algorithm-study/daily/2026-11-05/주차 요금 계산/주차_요금_계산.java`

## 풀이 시간 배분 - Codex 작성

| 단계 | 할 일 | 이 문제 배분 | 누적 종료 시점 |
|---|---|---:|---:|
| 1 | 문제 이해·제한 확인 | 8분 | 8분 |
| 2 | 단순 풀이·병목 찾기 | 8분 | 16분 |
| 3 | 접근 선택·풀이 흐름·정확성 확인 | 8분 | 24분 |
| 4 | Java 구현 | 10분 | 34분 |
| 5 | 검증 및 제출 | 6분 | 40분 |

## 풀이 중 시간대별 기록 - 사용자 작성

### 0~20% (0~8분) — 문제와 제한 이해

`records`의 문자열 한 줄은 어떤 시각에 어떤 차량에서 발생한 무슨 사건을 나타내며, 최종 반환 배열에는 무엇을 어떤 순서로 담아야 하는가?
- 특정 시각에 특정 차량이 입,출차한 사건을 나타냄 / 최종 반환은 각 차량별 주차요금을 오름차순으로 반환

`records`의 최대 개수에서 허용되는 시간복잡도는 무엇이며, 시각 변환·누적 시간·최종 요금의 값 범위는 안전한가?
- 기록의 최대 개수는 1000으로 O(N^2)까지 가능할 것으로 예상 / 각 범위는 안전

### 20~40% (8~16분) — 단순 풀이와 병목

차량마다 전체 `records`를 다시 훑어 입·출차 기록을 찾는다면 처리 흐름과 시간복잡도는 어떻게 되는가?
- 한 번호마다 그 번호가 다시 나올 때까지 records를 훑으면 시간복잡도는 O(N^2)이 될 것으로 예상.

차량마다 `records` 전체를 다시 확인한다면 같은 기록을 최대 몇 번 반복해서 읽게 되며, 입력 제한상 이 반복을 반드시 줄여야 하는가?
- 최대 1000번 / 반드시 줄일 필요는 없어  O(N^2)으로 해도 1억이 안 넘거

### 40~60% (16~24분) — 설계 확정

`records` 한 줄을 처리한 뒤 차량별로 어떤 정보를 남겨야 하며, `IN`과 `OUT`에서 각각 그 정보를 어떻게 바꿀 것인가?
- 차량별로 IN일 경우 시각을 남기고, OUT일 경우 IN 시각을 빼서 주차 시간을 계산해서 분으로 바꿔야 해

모든 기록을 처리한 뒤에도 출차 기록이 없는 차량을 어떻게 처리하며, 각 차량의 최종 요금과 반환 순서를 언제 확정할 것인가?
- OUT 시각을 23:59로 설정해놓고 주차 시간을 계산해야 해. 각 차량의 최종 요금은 records의 모든 차량의 계산이 끝난 뒤에 확정하고 순서도 마지막에 정려하면 될 거 같아

### 60% (24분) — 힌트 판단 지점

현재까지 찾은 병목과 정확히 막힌 지점은? 설계가 확정됐다면 비워 둡니다.
-

### 60~85% (24~34분) — Java 구현

시각 문자열 변환, 미출차 차량 처리, 초과 시간 올림 계산, 차량 번호 순서에서 어떤 경계 조건을 주의해야 하는가?
-

### 85~100% (34~40분) — 검증과 제출

기본 시간 이하, 단위 시간으로 나누어떨어지지 않는 초과 시간, 23:59 미출차, 여러 차량이 섞인 기록을 확인했는가?
- 확인했어

### 선택 기록

출제 의도 알고리즘 추측은? 풀이 후 비교를 원할 때만 Codex 피드백 전에 작성합니다.
-

## 풀이 후 결과 - 사용자 작성

- 실제 풀이 시간: 1시간 10분
- 풀이 외 제외 시간: 0분
- 결과: 성공
- 제출 결과: 첫 제출 통과
- 설계 확정까지 걸린 시간: 25분
- 구현 실수: 올림 처리 계산에서 -1을 안 함
- 막힌 지점·배운 점:
  - 자바의 map을 키로 정렬할 수 있는 treeMap
  - 자릿수가 다르면 왜 숫자로 변환해야 하는지
  - LocalTime끼리 빼는 법, LocalTime.parse
  - Math.ceil을 쓰지 않고 나눗셈을 올림처리하는 법
  -

## Codex 분석

- 힌트 수준(Codex 판정): 작은 힌트 — `TreeMap`, `LocalTime`·`Duration` 사용법은 Java API 설명이며 핵심 설계는 사용자가 독립적으로 확정했다. 정수 올림식에서 빠진 `-1`을 직접 교정받았으므로 구현 단계의 작은 힌트로 기록한다.
- 복습 등급: B
- 등급 판정 근거: 25분에 차량별 입차 시각과 누적 시간을 관리하는 설계를 독립적으로 확정하고 첫 공식 제출에 통과했다. 다만 목표 40분을 30분 초과했고, 요금 단위 수를 올림하는 식에서 `-1`을 누락해 잘못된 금액이 나온 뒤 교정 도움을 받았다.
- 목표 시간 달성: 아니오 — 40분 목표, 실제 70분
- 첫 시도 성공: 예
- 공식 출제 의도 알고리즘: 차량 번호별 입차 시각과 누적 주차 시간을 관리하고, 미출차 차량을 23:59에 출차한 것으로 처리한 뒤 차량 번호 오름차순으로 요금을 계산한다. 공식 해설은 차량 번호를 배열 인덱스로 사용한다.
- Codex 추천 목표 알고리즘: 차량별 입차 시각과 누적 시간을 맵으로 관리하고, 정렬된 차량 번호 순서대로 요금을 계산한다.
- 실제 풀이와 의도 알고리즘 비교: 전체 처리 흐름은 공식 의도와 일치한다. 공식 해설의 고정 크기 배열 대신 `HashMap`과 `TreeMap`을 사용한 유효한 자료구조 대안이며, 네 자리 차량 번호는 문자열 순서와 숫자 순서가 같아 `TreeMap<String, ...>` 정렬도 정확하다.
- 풀이 전 사고와 실제 코드의 차이: 풀이 전 기록의 `주차요금을 오름차순으로 반환`은 요금 자체를 정렬한다는 뜻으로 읽힐 수 있지만, 문제 요구는 차량 번호 오름차순에 맞춰 각 요금을 반환하는 것이다. 실제 코드는 누적 시간 맵을 `TreeMap`으로 만들어 차량 번호 키 순서를 유지했으므로 정확하다. `IN`에서는 입차 시각을 저장하고 `OUT`에서는 제거와 동시에 누적 시간을 갱신한다는 설계도 코드에 그대로 반영됐다.
- 코드 개선 포인트: 현재 코드는 정확하고 제한을 충분히 만족한다. 다만 `HH:MM`을 직접 분으로 변환하면 `LocalTime`·`Duration` 객체 생성을 피할 수 있고, 요금식을 `초과 시간 → 단위 수 → 최종 요금`으로 나누면 올림식 실수를 줄일 수 있다. 결과도 `List<Integer>`와 스트림 대신 크기가 확정된 `int[]`에 바로 담을 수 있다. 빅오는 같고 상수 비용·가독성·안전성이 개선된다.
- 풀이 후 새로 배운 점: `TreeMap`은 키 순서를 유지한다. 길이가 같은 숫자 문자열은 사전순과 숫자순이 같다. 두 `LocalTime` 사이의 분 차이는 `Duration.between(...).toMinutes()`로 계산할 수 있다. 양의 정수 나눗셈 올림은 `(값 + 나누는 수 - 1) / 나누는 수`다.
- 다음 문제에 적용할 한 문장 규칙: 여러 규칙을 구현할 때는 입력을 읽으며 대상별 상태를 갱신하고, 입력 종료 후 남은 상태 처리와 정렬·경계 계산을 별도 단계로 분리한다.
- 복습에 포함할 학습 포인트: 미출차 차량 후처리, 네 자리 차량 번호의 문자열 정렬 근거, 분 단위 시각 변환, 정수 올림식의 `-1` 역할
- 오류 분류: 구현·시간 관리
- 시간복잡도: 차량 수를 `C`, 기록 수를 `N`이라 할 때 평균 `O(N log C)` — `TreeMap` 누적 갱신이 `O(log C)`, 나머지 맵 연산은 평균 `O(1)`이다.
- 공간복잡도: `O(C)`

### 클린 코드 예시

원본 Java는 수정하지 않는다. 다음 예시는 같은 흐름을 유지하면서 시각을 정수 분으로 바꾸고 계산 단계를 분리한 형태다.

```java
public int[] solution(int[] fees, String[] records) {
    Map<String, Integer> enteredAt = new HashMap<>();
    Map<String, Integer> totalMinutes = new TreeMap<>();

    for (String record : records) {
        String[] parts = record.split(" ");
        int time = toMinutes(parts[0]);
        String carNumber = parts[1];

        if (parts[2].equals("IN")) {
            enteredAt.put(carNumber, time);
        } else {
            int parkedMinutes = time - enteredAt.remove(carNumber);
            totalMinutes.merge(carNumber, parkedMinutes, Integer::sum);
        }
    }

    int endOfDay = 23 * 60 + 59;
    for (Map.Entry<String, Integer> entry : enteredAt.entrySet()) {
        int parkedMinutes = endOfDay - entry.getValue();
        totalMinutes.merge(entry.getKey(), parkedMinutes, Integer::sum);
    }

    int[] answer = new int[totalMinutes.size()];
    int index = 0;
    for (int parkedMinutes : totalMinutes.values()) {
        answer[index++] = calculateFee(parkedMinutes, fees);
    }
    return answer;
}

private int toMinutes(String time) {
    return Integer.parseInt(time.substring(0, 2)) * 60
            + Integer.parseInt(time.substring(3, 5));
}

private int calculateFee(int parkedMinutes, int[] fees) {
    int baseTime = fees[0];
    int baseFee = fees[1];
    int unitTime = fees[2];
    int unitFee = fees[3];

    if (parkedMinutes <= baseTime) {
        return baseFee;
    }

    int extraMinutes = parkedMinutes - baseTime;
    int units = (extraMinutes + unitTime - 1) / unitTime;
    return baseFee + units * unitFee;
}
```

## 반복 복습

- D+1: 대상(2026-11-06) — 차량별 입차 시각·누적 시간·미출차 처리 흐름 설명
- D+3: 대상(2026-11-08) — 시각 변환, 정수 올림식, 차량 번호 정렬 근거 회상
- D+7: 대상(2026-11-12) — 유형 비공개 구현 변형
- 동일 문제 재도전 예정일: 없음
- 재도전·변형 결과: 대상 아님
- D+7 변형 전이 결과: 예정
