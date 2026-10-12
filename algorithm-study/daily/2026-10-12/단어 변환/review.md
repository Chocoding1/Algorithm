# 단어 변환

## 문제 정보 - Codex 작성

- 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43163?language=java
- 플랫폼 / 난이도: 프로그래머스 / Lv.3
- 풀이 날짜: 2026-10-12
- 핵심 유형: 풀이 완료 후 Codex 작성
- 목표 시간: 40분
- 풀이 구분: 신규
- 연결된 원본 문제: 풀이 완료 후 필요한 경우 공개
- Java 코드 경로: `algorithm-study/daily/2026-10-12/단어 변환/단어_변환.java`

## 풀이 시간 배분 - Codex 작성

| 단계 | 할 일 | 권장 비율 | 이 문제 배분 | 누적 종료 시점 |
|---|---|---:|---:|---:|
| 1 | 문제 이해·제한 확인 | 20% | 8분 | 8분 |
| 2 | 단순 풀이·병목 찾기 | 20% | 8분 | 16분 |
| 3 | 접근 선택·풀이 흐름·정확성 확인 | 20% | 8분 | 24분 |
| 4 | Java 구현 | 25% | 10분 | 34분 |
| 5 | 예제·엣지 케이스 검증 및 제출 | 15% | 6분 | 40분 |

> 24분까지 제한을 만족하는 설계를 확정하고 구현을 시작합니다.

## 풀이 전 핵심 기록 - 사용자 작성

- 문제와 제한·목표 복잡도: 단어의 길이는 최대 10, words의 길이는 최대 50. 따라서 O(N^2)까지도 가능할 것으로 예상
- 가장 단순한 풀이와 병목: dfs 또는 bfs를 사용하여 각 단어마다 하나의 알파벳만 바뀌는 단어가 존재하면 그 단어로 다시 탐색 진행 / 병목은 없을 것으로 예상
- 확정한 설계와 처리 흐름: 위에서 얘끼한 풀이 그대로 갈 예정
- 정답 근거와 핵심 엣지 케이스: 방문한 단어는 방문 처리를 하여 다시 방문하지 않도록 하면 무한 재귀도 방지할 수 있고, 아무 단어도 매칭되지 않는 경우도 잡을 수 있다고 판단
- 출제 의도 알고리즘 추측: 선택 항목, Codex 피드백 전에 작성

## 풀이 후 결과 - 사용자 작성

- 실제 풀이 시간: 26분
- 풀이 외 제외 시간: 0분
- 결과: 성공
- 제출 결과: 첫 제출 통과
  - 설계 확정까지 걸린 시간: 10분
- 구현 실수: 없음
- 막힌 지점·배운 점:

## Codex 분석

- 힌트 수준(Codex 판정): 없음
- 복습 등급: A
- 등급 판정 근거: 40분 목표 내 26분에 성공했고, 10분 만에 DFS/BFS 탐색 설계를 독립적으로 확정했으며 힌트·구현 실수 없이 첫 제출로 통과함
- 목표 시간 달성: 예 (26분 / 40분)
- 첫 시도 성공: 예
- 공식 출제 의도 알고리즘: DFS/BFS
- Codex 추천 목표 알고리즘: BFS로 최소 변환 횟수 탐색
- 공식 의도 일치 여부: 일치
- Codex 목표 일치 여부: 유효한 대안을 사용함
- 실제 풀이와 의도 알고리즘 비교: 경로별 `visited`를 복구하는 DFS로 가능한 모든 단순 변환 경로를 확인한 뒤 최솟값을 구했다. 정답이지만, 최소 단계를 구하는 문제에서는 첫 도달이 바로 최솟값인 BFS가 더 직접적이고 복잡도도 안정적이다.
- 풀이 전 사고와 실제 코드의 차이: DFS/BFS 후보 중 DFS를 선택해 예정한 흐름대로 구현했다. 다만 풀이 전에 예상한 `O(N²)`은 BFS의 복잡도에 가깝고, 현재 DFS는 방문을 복구하며 모든 단순 경로를 보므로 최악의 경우 팩토리얼 수준으로 커질 수 있다.
- 코드 개선 포인트: 현재 DFS를 유지한다면 목표에 도달한 즉시 `return`, `count >= answer`일 때 탐색 중단, 문자 차이가 2개가 되는 즉시 비교 종료를 적용할 수 있다. 근본적으로는 BFS로 바꾸면 각 단어를 한 번만 방문한다.
- 클린 코드 예시:

```java
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    private record State(int index, int steps) {}

    public int solution(String begin, String target, String[] words) {
        Queue<State> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];

        for (int i = 0; i < words.length; i++) {
            if (differsByOne(begin, words[i])) {
                queue.offer(new State(i, 1));
                visited[i] = true;
            }
        }

        while (!queue.isEmpty()) {
            State current = queue.poll();
            if (words[current.index()].equals(target)) {
                return current.steps();
            }

            for (int next = 0; next < words.length; next++) {
                if (!visited[next] && differsByOne(words[current.index()], words[next])) {
                    visited[next] = true;
                    queue.offer(new State(next, current.steps() + 1));
                }
            }
        }
        return 0;
    }

    private boolean differsByOne(String left, String right) {
        int differences = 0;
        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i) != right.charAt(i) && ++differences > 1) {
                return false;
            }
        }
        return differences == 1;
    }
}
```

- 풀이 후 새로 배운 점: DFS로도 최솟값을 구할 수 있지만, 간선 가중치가 모두 같은 최소 단계 문제는 BFS의 첫 도달을 이용하면 모든 경로를 열거하지 않아도 된다.
- 다음 문제에 적용할 한 문장 규칙: **모든 이동의 비용이 같고 최소 횟수를 구하면 BFS를 우선 검토한다.**
- 복습에 포함할 학습 포인트: DFS 경로별 방문 복구와 BFS 전체 방문의 차이, BFS의 첫 도달이 최솟값인 이유, `O(N²×L)` 근거
- 오류 분류: 없음 (풀이 전 복잡도 예상은 교정 포인트)
- 시간복잡도: 현재 DFS는 최악 팩토리얼 수준인 `O(N × N! × L)`, BFS 대안은 `O(N² × L)` (`N`: words 수, `L`: 단어 길이)
- 공간복잡도: 현재 DFS `O(N)`, BFS 대안 `O(N)`

## 반복 복습

- D+1: 생략
- D+3: 대상 (2026-10-15, DFS·BFS 방문 차이와 BFS 최단거리 근거 회상)
- D+7: 대상 (2026-10-19, `네트워크`와 공유 가능한 유형 비공개 그래프 변형)
- 동일 문제 재도전 예정일:
- 재도전·변형 결과: 재도전 불필요
- D+7 변형 전이 결과: 즉시 전이 성공 (`게임 맵 최단거리`의 상태 전이·탐색 사고를 단어 그래프에 독립 적용)
