# 부대복귀

## 문제 정보 - Codex 작성

- 링크: https://school.programmers.co.kr/learn/courses/30/lessons/132266
- 플랫폼 / 난이도: 프로그래머스 Lv.3
- 풀이 날짜: 2026-11-25
- 핵심 유형: 무가중 최단거리·BFS·공통 목적지에서 거리 결과 재사용
- 목표 시간: 50분
- 풀이 구분: 신규·유형 비공개 실전
- 연결된 학습 문제: `2026-11-24 합승 택시 요금 재도전`의 탐색 결과 재사용 문제와 비교
- Java 코드 경로: `daily/2026-11-25/부대복귀/부대복귀.java`

## 풀이 시간 배분 - Codex 작성

| 단계 | 할 일 | 권장 비율 | 이 문제 배분 | 누적 종료 시점 |
|---|---|---:|---:|---:|
| 1 | 문제 이해·제한 확인 | 20% | 10분 | 10분 |
| 2 | 단순 풀이·병목 찾기 | 20% | 10분 | 20분 |
| 3 | 접근 선택·풀이 흐름·정확성 확인 | 20% | 10분 | 30분 |
| 4 | Java 구현 | 25% | 12분 | 42분 |
| 5 | 예제·엣지 케이스 검증 및 제출 | 15% | 8분 | 50분 |

> 실전 공통 규칙에 따라 25분에 구현 가능한 설계가 없으면 다른 문제로 전환합니다. 이 문제에 연속 50분 이상 사용하지 않습니다.

## 풀이 중 시간대별 기록 - 사용자 작성

### 0~20% (0~10분) — 문제와 제한 이해

`roads` 한 행과 `sources`의 각 값은 무엇을 뜻하며 반환 배열의 순서는 무엇을 따라야 하는가?
-

경로가 없는 시작 지역과 목적지 자체가 시작 지역인 경우 반환값은 각각 무엇인가?
-

### 20~40% (10~20분) — 단순 풀이와 병목

각 `source`마다 목적지까지의 경로를 따로 찾으면 최대 입력에서 총 연산량은 어느 정도인가?
-

각 요청을 따로 처리할 때 반복되는 계산은 무엇인가?
-

### 40~60% (20~30분) — 설계 확정

선택한 방법의 전체 연산량이 `n`, `roads`, `sources`의 최댓값에서도 허용되는가?
-

선택한 방법이 더 짧은 경로를 놓치지 않는다고 어떻게 설명할 것인가?
-

### 60% (25~30분) — 전환 판단 지점

25분까지 구현 가능한 설계가 없었다면 다음 문제로 전환합니다. 복귀 시 현재 막힌 지점은?
-

### 60~85% (30~42분) — Java 구현

정점 번호 1부터 `n`까지의 배열 경계와, 연결되지 않은 지역의 초기값을 확인했는가?
-

### 85~100% (42~50분) — 검증과 제출

목적지 자체, 경로가 없는 지역, 여러 최단경로가 있는 지역과 `sources` 출력 순서를 확인했는가?
-

### 선택 기록

출제 의도 알고리즘 추측은? 풀이 후 비교를 원할 때만 작성합니다.
-

## 풀이 후 결과 - 사용자 작성

- 실제 풀이 시간: 24분 (예: `40분`)
- 풀이 외 제외 시간: 0분 (예: `0분` / `5분, 식사`)
- 결과: 성공 (예: `성공` / `실패` / `부분 성공`)
- 제출 결과: 첫 제출 통과 (예: `첫 제출 통과` / `첫 통과 전 오답 2회` / `미제출`)
- 설계 확정까지 걸린 시간: 8분 (예: `22분` / `설계 미확정`)
- 구현 실수: import 안 함 (예: `없음` / `도달 불가 값을 0으로 반환`)
- 막힌 지점·배운 점: 없음 (예: `없음` / `여러 요청의 반복 계산 제거`)

## Codex 분석

- 힌트 수준(Codex 판정): 작은 힌트. 대화에서 `List<Integer>`를 `int[]`로 바꾸는 API를 확인했다. 최단거리 탐색 설계는 코드와 회고에서 독립 구현으로 확인했다.
- 복습 등급: B
- 등급 판정 근거: 8분에 설계를 확정해 24분에 첫 제출로 통과했다. 결과 변환 API에 도움을 받았고, 여러 시작점에서 각각 탐색해 최악 입력에서 같은 정점과 간선을 반복해서 훑을 수 있다.
- 목표 시간 달성: 예 (24분 / 50분)
- 첫 시도 성공: 예 (공식 오답 제출 0회)
- 공식 출제 의도 알고리즘: 문제 본문에 명시되지 않음
- Codex 추천 목표 알고리즘: 양방향 도로와 한 곳으로 고정된 목적지를 이용해 목적지에서 BFS를 한 번 실행하고 각 출발지의 거리를 조회한다.
- 실제 풀이와 의도 알고리즘 비교: 출발지마다 BFS를 수행하는 현재 코드도 정확한 거리를 계산한다. 도로는 양방향이므로 출발지에서 목적지까지의 경로를 뒤집어도 길이가 같고, 목적지에서 한 번 탐색한 거리로 모든 출발지의 결과를 얻을 수 있다.
- 코드 개선 포인트: 탐색을 한 번으로 줄이는 것이 가장 큰 개선이다. 거리 배열의 `-1`이 미방문과 도달 불가를 표현하므로 별도 `visited`와 큐에 넣던 정점별 `int[]`가 각각 필요 없어지고, 반환 배열의 길이가 이미 정해져 있어 `int[] answer`에 바로 쓸 수 있다.

### BFS 큐 선택

현재의 `Queue<int[]> queue = new ArrayDeque<>();` 선언이 적절하다. `Queue`는 호출할 수 있는 연산을 정한 인터페이스이고 `ArrayDeque`가 실제 저장 방식과 FIFO 순서를 제공한다. 이 코드에서 큐에는 가까운 거리의 정점부터 들어가므로 먼저 삽입한 정점을 먼저 꺼내면 된다.

| 선택 | 이 문제에서 삽입·꺼내기 | 적용 |
| --- | --- | --- |
| `Queue` | 구현체에 따라 다름 | `offer`·`poll`을 쓰는 변수의 타입 |
| `ArrayDeque` | `offer`·`poll` 분할 상환 `O(1)` | 단일 스레드의 FIFO BFS에 적합. 내부 배열의 양끝을 이용해 앞 원소를 꺼낼 때 나머지를 이동시키지 않음 |
| `LinkedList` | `offer`·`poll` `O(1)` | FIFO 가능한 구현체. 원소마다 연결 노드를 할당하므로 일반적으로 `ArrayDeque`가 유리 |
| `ArrayList` | 끝에 `add` 분할 상환 `O(1)`, `remove(0)` `O(Q)` | 앞 원소를 제거하면 뒤 원소를 당긴다. `get(head++)`로 직접 FIFO를 만들 수는 있으나 처리한 원소가 리스트에 남는다. 인접 리스트처럼 추가하고 순회하는 용도에는 적합 |
| `PriorityQueue` | `offer`·`poll` `O(log Q)` | 비교 기준으로 꺼낸다. 거리를 비교하면 이 문제에서도 가까운 순서를 얻을 수 있으나 힙 비용이 추가된다. 정점 번호를 비교하면 거리 순서가 깨질 수 있음 |

`Q`는 해당 시점의 큐 크기다. 한 번의 탐색에서 각 정점을 최대 한 번 넣는다는 사실을 활용하면 `int[n]`과 `head`·`tail`로도 FIFO를 구현할 수 있다. 이 방식은 `Integer` 박싱과 큐 내부 확장을 피할 수 있지만, 일반 코테에서는 `Queue<Integer> queue = new ArrayDeque<>();`가 간결하다. 실제 속도 순위는 벤치마크 대신 연산 비용과 할당 구조를 근거로 비교했다. [Java Queue](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Queue.html) · [ArrayDeque](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/ArrayDeque.html) · [LinkedList](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/LinkedList.html) · [ArrayList](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/ArrayList.html) · [PriorityQueue](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/PriorityQueue.html)

### 클린 코드 예시

```java
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);
        distance[destination] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(destination);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : graph.get(current)) {
                if (distance[next] == -1) {
                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                }
            }
        }

        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = distance[sources[i]];
        }
        return answer;
    }
}
```

- 풀이 후 새로 배운 점: 간선 비용이 모두 같으면 FIFO만으로 거리 순서를 유지한다. 양방향 그래프에서 목적지가 고정된 여러 질의는 목적지에서 한 번 탐색해 결과를 공유할 수 있다.
- 다음 문제에 적용할 한 문장 규칙: 최단거리 요청이 여러 개면 간선 비용, 방향, 출발지·도착지 중 고정된 쪽을 확인하고 탐색 횟수를 먼저 계산한다.
- 오류 분류: 효율성·Java API. import 누락은 제출 전 컴파일 단계에서 수정했다.
- 잘한 점: 양방향 인접 리스트, 삽입 시 방문 처리, 도달 불가와 목적지 자체의 반환값을 정확히 구현했다.
- 개선할 점: 큐 연산을 바꾸기 전에 전체 탐색을 몇 번 하는지 확인한다. 이 문제의 최대 입력은 정점 100,000개, 도로 500,000개, 출발지 500개다.
- 검증: 개선안의 공식 예제 2개가 기대값과 일치했다. 무작위 그래프 1,000개에서 기존 코드와 결과가 같았으며, 정점·도로·출발지 수가 각각 상한인 구성에서도 개선안의 결과를 확인했다.
- 시간복잡도: `V`는 정점 수, `E`는 도로 수, `S`는 출발지 수다. 기존 최악 `O(S(V + E))`, 개선안 `O(V + E + S)`.
- 반복 탐색이 커지는 예: `1—2—3—4—5`에서 목적지가 1이고 출발지가 `[5, 4, 3]`이면, 기존 풀이는 `3—2—1` 구간을 세 탐색에서 확인한다. 1에서 한 번만 BFS 하면 거리 `[0, 1, 2, 3, 4]`를 얻으므로 출발지 순서대로 `[4, 3, 2]`를 꺼내면 된다.
- 공간복잡도: 기존과 개선안 모두 인접 리스트, 탐색 상태, 반환값을 포함해 `O(V + E + S)`다. 개선안은 출발지마다 방문 배열을 다시 할당하지 않는다.

## 반복 복습

- D+1: 2026-11-26 회상 후보. 목적지에서 출발해도 같은 거리를 얻는 이유와 FIFO가 충분한 이유 설명
- D+3: 2026-11-30 최종 점검에 통합. 한 번 탐색할 때의 복잡도와 `0`·`-1`의 의미를 최단거리 회상에서 확인
- D+7: 2026-12-02 이후 유형 비공개 변형 후보
- 동일 문제 재도전 예정일: 생략. 새 변형에서 탐색 결과 재사용을 확인
- 재도전·변형 결과: 대상 아님
- D+7 변형 전이 결과: 예정
