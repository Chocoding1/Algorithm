# 두 큐 합 같게 만들기 재도전

## 문제 정보 - Codex 작성

- 링크: https://school.programmers.co.kr/learn/courses/30/lessons/118667
- 플랫폼 / 난이도: 프로그래머스 / Lv.2
- 풀이 날짜: 2026-10-11
- 핵심 유형: 재도전 완료 후 다시 확인
- 목표 시간: 일요일 실전 세트 전체 120분 — 개별 목표 시간 없음
- 풀이 구분: 동일 문제 재도전
- 연결된 원본 문제: 2026-10-09 `두 큐 합 같게 만들기`
- Java 코드 경로: `algorithm-study/daily/2026-10-11/두 큐 합 같게 만들기/두_큐_합_같게_만들기_재도전.java`

## 실전 운영 - Codex 작성

> 이전 코드와 회고를 보지 않고 처음부터 풉니다. 세 문제 전체에 120분을 사용하며 문제별 제한 시간은 따로 두지 않습니다. 실전 운영 회고는 세트 종료 후 날짜 `README.md`에 한 번만 기록합니다.

## 풀이 전 핵심 기록 - 사용자 작성

- 문제와 제한·목표 복잡도: 두 큐의 최대 길이는 300000으로 O(N) 또는 O(NlogN)만 가능
- 가장 단순한 풀이와 병목: 모든 경우의 수를 따져가며 큐의 원소들을 이동시키는 방법 / 너무 오래 걸리고 너무 많은 경우의 수가 있고, 그 경우의 수를 다 탐색하는 구현 방법이 떠오르지 않음
- 확정한 설계와 처리 흐름: 목표 원소 합을 기준으로 하나의 큐만 본다 해당 큐의 원소 합이 목표보다 작으면 상대 큐에서 가져오고 목표보다 크면 해당 큐에서 보내는 방식으로 진행한다.
- 정답 근거와 핵심 엣지 케이스:매 순간마다 목표 합과 비교하므로 정답을 지나칠 일이 없다고 생각한다.
- 출제 의도 알고리즘 추측: 선택 항목, Codex 피드백 전에 작성

## 풀이 후 결과 - 사용자 작성

- 실제 풀이 시간: 10분
- 풀이 외 제외 시간: 0분
- 결과: 성공
- 제출 결과: 첫 제출 통과
- 설계 확정까지 걸린 시간: 5분
- 구현 실수: 없음
- 막힌 지점·배운 점:

## Codex 분석

- 힌트 수준(Codex 판정): 없음 — 이전 코드·회고와 추가 설명을 확인하지 않고 처음부터 구현
- 복습 등급: B
- 등급 판정 근거: 핵심 진행 규칙을 5분 만에 독립 재현하고 10분에 첫 제출로 통과했지만, 제한에서 필요한 `long` 합산이 실제로는 `int`로 수행되는 안전성 오류가 반복됨
- 독립 재현 여부: 부분 완료 — 합 비교와 이동 규칙은 독립 재현했으나 오버플로 안전성은 재현하지 못함
- 목표 시간 달성: 일요일 세트 전체 120분 종료 후 판정
- 첫 시도 성공: 재도전이므로 대상 아님
- 공식 출제 의도 알고리즘: 공식 의도 명시 없음
- Codex 추천 목표 알고리즘: 한 큐의 합과 두 FIFO를 이용한 단조로운 경계 이동
- 실제 풀이와 이전 풀이 비교: 목표와 한 큐의 합을 비교해 어느 큐의 앞 원소를 옮길지 결정하는 흐름과 반복 상한을 60분에서 10분으로 단축해 독립 재현했다. 다만 이전에 지적된 합계 오버플로가 같은 코드로 반복됐다.
- 코드 개선 포인트: `long sum1 = Arrays.stream(queue1).sum()`은 대입만 `long`이고 합산은 먼저 `int`로 끝난다. `Arrays.stream(queue1).asLongStream().sum()`을 사용해야 한다. 반복문 시작에서 성공을 검사하도록 구성하면 마지막 허용 이동 뒤의 상태도 명확하게 검사할 수 있다. 빅오 개선이 아니라 정확성·안전성 개선이다.
- 클린 코드 예시:

```java
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 두_큐_합_같게_만들기_재도전 {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = Arrays.stream(queue1).asLongStream().sum();
        long sum2 = Arrays.stream(queue2).asLongStream().sum();
        long total = sum1 + sum2;

        if (total % 2 != 0) {
            return -1;
        }

        long target = total / 2;
        Queue<Integer> first = toQueue(queue1);
        Queue<Integer> second = toQueue(queue2);
        int limit = queue1.length * 4;

        for (int count = 0; count <= limit; count++) {
            if (sum1 == target) {
                return count;
            }
            if (count == limit) {
                break;
            }

            if (sum1 < target) {
                int value = second.poll();
                first.offer(value);
                sum1 += value;
            } else {
                int value = first.poll();
                second.offer(value);
                sum1 -= value;
            }
        }

        return -1;
    }

    private Queue<Integer> toQueue(int[] values) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int value : values) {
            queue.offer(value);
        }
        return queue;
    }
}
```

- 풀이 후 새로 배운 점: 결과를 `long` 변수에 받는 것만으로는 중간 계산이 `long`이 되지 않는다. 스트림 원소 자체를 `long`으로 변환한 뒤 합산해야 한다.
- 다음 문제에 적용할 한 문장 규칙: 합의 최댓값이 `int`를 넘으면 저장 변수뿐 아니라 합산 연산이 시작되는 지점부터 `long`인지 확인한다.
- 오류 분류: 구현·자료형 안전성 — 유효한 최대 입력에서 합계 오버플로 가능
- 시간복잡도: `O(N)` — 각 이동에서 한 원소만 처리하며 이동 횟수에 선형 상한을 둠
- 공간복잡도: `O(N)` — 두 큐에 전체 원소를 저장

## 반복 복습

- D+1: 완료(2026-10-12) — `sum()`과 `asLongStream().sum()`의 중간 연산 자료형 차이 확인
- D+3: 대상(2026-10-14) — 이동 규칙·종료 상한·오버플로 안전성을 3분 이내 회상
- D+7: 재도전 성공 시 2026-10-18 신규 변형
- 동일 문제 추가 재도전 예정일: 없음 — 흐름은 독립 재현했고 자료형 수정은 짧은 복습으로 확인
- 재도전 결과: 부분 성공 — 핵심 설계 독립 재현, 오버플로 안전성 미완료
