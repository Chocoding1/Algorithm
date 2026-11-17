# 순위

## 문제 정보 - Codex 작성

- 링크: https://school.programmers.co.kr/learn/courses/30/lessons/49191
- 플랫폼 / 난이도: 프로그래머스 / Lv.3
- 풀이 날짜: 2026-11-11
- 핵심 유형: 풀이 완료 후 Codex 작성
- 목표 시간: 45분
- 풀이 구분: 신규
- 연결된 원본 문제: 풀이 완료 후 Codex 작성
- Java 코드 경로: `algorithm-study/daily/2026-11-11/순위/순위.java`

## 풀이 시간 배분 - Codex 작성

| 단계 | 할 일 | 이 문제 배분 | 누적 종료 시점 |
|---|---|---:|---:|
| 1 | 문제 이해·제한 확인 | 9분 | 9분 |
| 2 | 단순 풀이·병목 찾기 | 9분 | 18분 |
| 3 | 접근 선택·풀이 흐름·정확성 확인 | 9분 | 27분 |
| 4 | Java 구현 | 11분 | 38분 |
| 5 | 검증 및 제출 | 7분 | 45분 |

## 풀이 중 시간대별 기록 - 사용자 작성

### 0~20% (0~9분) — 문제와 제한 이해

어떤 선수의 정확한 순위를 알 수 있다고 판단하려면, 그 선수와 나머지 선수들의 승패 관계가 어느 정도까지 확인돼야 하는가?
-

`n ≤ 100`, 경기 결과가 최대 4,500개일 때 선수 쌍을 반복해 확인하는 방식은 현실적인가?
-

### 20~40% (9~18분) — 단순 풀이와 병목

입력으로 주어진 경기 결과만 직접 세면 어떤 승패 관계를 놓칠 수 있는가?
-

선수 한 명의 순위를 확인할 때마다 다른 선수들의 결과를 처음부터 다시 추적하면 어떤 계산이 반복되는가?
-

### 40~60% (18~27분) — 설계 확정

주어진 경기 결과와 그로부터 확정할 수 있는 관계를 어떤 형태로 기록하고 갱신할 것인가?
-

선수 한 명의 순위가 확정됐다고 세기 위한 조건을 어떻게 검증할 것인가?
-

### 60% (27분) — 힌트 판단 지점

현재까지 찾은 병목과 정확히 막힌 지점은? 설계가 확정됐다면 비워 둡니다.
-

### 60~85% (27~38분) — Java 구현

1번부터 시작하는 선수 번호와 자기 자신의 결과를 세지 않도록 어떻게 범위를 구분했는가?
-

### 85~100% (38~45분) — 검증과 제출

선수가 1명인 경우, 모든 관계가 확정된 경우, 여러 선수의 관계가 끝까지 확정되지 않는 경우를 확인했는가?
-

### 선택 기록

출제 의도 알고리즘 추측은? 풀이 후 비교를 원할 때만 Codex 피드백 전에 작성합니다.
-

## 풀이 후 결과 - 사용자 작성

- 실제 풀이 시간: 1시간 20분 (예: `15분`)
- 풀이 외 제외 시간: 0분 (예: `0분` / `5분, 식사`)
- 결과: 실패 (예: `성공` / `실패` / `부분 성공`)
- 제출 결과: 미제출 (예: `첫 제출 통과` / `첫 통과 전 오답 2회` / `미제출`)
- 설계 확정까지 걸린 시간: 힌트 참고 (예: `8분` / `설계 미확정`)
- 구현 실수:  (예: `없음` / `배열 인덱스 경계 오류`)
- 막힌 지점·배운 점:  (예: `없음` / `종료 조건을 잘못 설정함`)

## Codex 분석

- 힌트 수준(Codex 판정): 정답 코드 — 간접 승패 관계를 정방향·역방향 DFS로 세는 핵심 상태를 알려준 뒤, 사용자 요청으로 전체 Java 코드를 작성함
- 복습 등급: C
- 등급 판정 근거: 40분 동안 순위 확정 조건과 정방향·역방향 그래프까지는 설계했지만, 도달 관계를 경로 길이와 중복 경로 수로 더하는 오류를 독립적으로 해결하지 못했다. DFS 반환 상태와 정답 코드를 확인했으므로 C등급이다.
- 목표 시간 달성: 독립 풀이 실패 — 45분 목표 중 40분 이상 고민한 뒤 코드 학습으로 전환
- 첫 시도 성공: 실패 — 독립 제출 전에 정답 코드를 확인했으므로 신규 문제 첫 시도 성공으로 집계하지 않음
- 코드 검증: Codex가 작성한 학습 코드는 프로그래머스 공개 예제에서 기대값 `2`를 출력함. 아직 공식 제출은 확인하지 않음.
- 실제 풀이와 의도 알고리즘 비교: 선수를 정점, 승패 결과를 방향 간선으로 보고 직접·간접 관계를 모두 확인하는 방향은 맞았다. 다만 초기 코드는 DFS 깊이 `count`를 도착 정점에 더해, 하나의 승패 관계를 거리만큼 세고 여러 경로로 도달하면 중복 집계했다.
- 핵심 오류: 이 문제에서 필요한 값은 경로의 길이나 개수가 아니라, 각 시작 선수에서 도달할 수 있는 **서로 다른 선수 수**다. `visited`는 한 선수를 여러 경로로 만나도 한 번만 세게 한다.
- 정답 코드 흐름: `winner → loser`를 저장한 그래프와 반대 그래프를 만든다. 선수마다 두 그래프를 각각 DFS해 `win[player]`과 `lose[player]`를 구하고, 합이 `n - 1`인 선수를 세면 된다.
- 클린 코드 개선: 원본과 같은 `O(N(N + E))` 풀이다. `List<Integer>[]`의 unchecked 제네릭 배열 경고를 `List<List<Integer>>`로 없애고, 전체 `win`·`lose` 배열을 저장하지 않고 선수별 도달 수를 바로 판정한다. 빅오 개선이 아니라 가독성·타입 안전성·불필요한 상태 제거다.

### 클린 코드 예시

```java
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int solution(int n, int[][] results) {
        List<List<Integer>> wins = createGraph(n);
        List<List<Integer>> losses = createGraph(n);

        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];

            wins.get(winner).add(loser);
            losses.get(loser).add(winner);
        }

        int answer = 0;

        for (int player = 1; player <= n; player++) {
            int winCount = countReachablePlayers(
                    player,
                    wins,
                    new boolean[n + 1]
            );
            int lossCount = countReachablePlayers(
                    player,
                    losses,
                    new boolean[n + 1]
            );

            if (winCount + lossCount == n - 1) {
                answer++;
            }
        }

        return answer;
    }

    private List<List<Integer>> createGraph(int n) {
        List<List<Integer>> graph = new ArrayList<>(n + 1);

        for (int player = 0; player <= n; player++) {
            graph.add(new ArrayList<>());
        }

        return graph;
    }

    private int countReachablePlayers(
            int current,
            List<List<Integer>> graph,
            boolean[] visited
    ) {
        visited[current] = true;
        int count = 0;

        for (int next : graph.get(current)) {
            if (visited[next]) {
                continue;
            }

            count += 1;
            count += countReachablePlayers(next, graph, visited);
        }

        return count;
    }
}
```

- 시간복잡도: 선수 `N`명에서 정방향·역방향 DFS를 하고 각 DFS가 최대 `N + E`를 확인하므로 `O(N(N + E))`. `N ≤ 100`, `E ≤ 4,500`이므로 충분하다.
- 공간복잡도: 두 인접 리스트 `O(N + E)`, 배열·방문 상태·재귀 스택 `O(N)`으로 전체 `O(N + E)`
- 풀이 후 새로 배운 점: 그래프에서 관계를 세는 문제는 먼저 `거리`, `경로 수`, `도달 가능한 정점 수` 중 무엇을 구하는지 구분해야 한다. 도달 가능성이 필요하면 경로가 여러 개여도 `visited`로 한 번만 세어야 한다.
- 다음 문제에 적용할 한 문장 규칙: 그래프 DFS에 숫자 `count`를 넘기기 전에 그 숫자가 깊이인지, 누적 값인지, 서로 다른 정점 수인지 먼저 한 문장으로 정의한다.
- 복습에 포함할 학습 포인트: 정방향·역방향 도달 수, `visited`가 중복 경로를 제거하는 이유, 순위 확정 조건, `O(N(N+E))` 근거
- 오류 분류: 설계·상태 정의·구현

## 반복 복습

- D+1: 생략 — C등급 동일 문제 재도전으로 대체
- D+3: 생략 — C등급 동일 문제 재도전으로 대체
- D+7: 2026-11-21, 재도전 성공을 전제로 유형 비공개 승패 관계 변형
- 동일 문제 재도전 예정일: 2026-11-13, 실제 학습일인 2026-11-11로부터 이틀 간격을 두고 현재 코드·회고·대화를 보지 않은 채 처음부터 구현
