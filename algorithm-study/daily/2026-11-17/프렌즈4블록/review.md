# 프렌즈4블록

## 문제 정보 - Codex 작성

- 링크: https://school.programmers.co.kr/learn/courses/30/lessons/17679
- 플랫폼 / 난이도: 프로그래머스 / Lv.2
- 풀이 날짜: 2026-11-17
- 핵심 유형: 격자 시뮬레이션·동시 삭제·중력 구현
- 목표 시간: 40분
- 풀이 구분: 신규
- 연결된 원본 문제: 없음
- Java 코드 경로: `algorithm-study/daily/2026-11-17/프렌즈4블록/프렌즈4블록.java`

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

한 번의 단계에서 지워져야 할 칸들이 서로 겹치면 제거 개수에는 몇 번 포함해야 하는가?
-

한 번 제거한 뒤 남은 블록들의 상대적인 위아래 순서는 어떻게 되어야 하는가?
-

### 20~40% (8~16분) — 단순 풀이와 병목

매 단계마다 전체 보드를 확인해도 `m, n ≤ 30` 제한에서 충분한가?
-

조건을 발견한 즉시 해당 칸을 비우면 같은 단계의 나머지 위치를 확인할 때 어떤 문제가 생길 수 있는가?
-

### 40~60% (16~24분) — 설계 확정

이번 단계에서 지울 칸을 모두 결정한 뒤 실제 제거 개수를 중복 없이 세려면 어떤 순서로 처리할 것인가?
-

빈칸을 채운 뒤 다음 단계를 계속할지 끝낼지는 무엇으로 판단할 것인가?
-

### 60% (24분) — 힌트 판단 지점

현재까지 찾은 병목과 정확히 막힌 지점은? 설계가 확정됐다면 비워 둡니다.
-

### 60~85% (24~34분) — Java 구현

문자열 배열을 수정 가능한 형태로 바꿀 때 행과 열 인덱스가 뒤바뀌지 않았는가?
-

빈칸을 채울 때 기존 블록의 순서를 유지하면서 모든 빈칸을 처리하는가?
-

### 85~100% (34~40분) — 검증과 제출

처음부터 지울 칸이 없는 경우, 여러 영역이 겹치는 경우, 제거 후 새 영역이 생기는 경우를 확인했는가?
-

### 선택 기록

출제 의도 알고리즘 추측은? 풀이 후 비교를 원할 때만 Codex 피드백 전에 작성합니다.
-

## 풀이 후 결과 - 사용자 작성

- 실제 풀이 시간: 1시간 반 이상 (예: `15분`)
- 풀이 외 제외 시간: 0분 (예: `0분` / `5분, 식사`)
- 결과: 실패 (예: `성공` / `실패` / `부분 성공`)
- 제출 결과: 최종 미통과 — 테스트 11개 중 2개 실패 (예: `첫 제출 통과` / `첫 통과 전 오답 2회` / `미제출`)
- 설계 확정까지 걸린 시간: 40분 (예: `8분` / `설계 미확정`)
- 구현 실수: 원본 행과 중력 적용 후 현재 행을 같은 좌표로 사용 (예: `없음` / `배열 인덱스 경계 오류`)
- 막힌 지점·배운 점: 삭제 위치만 누적하고 원본 보드에서 생존 블록을 위로 찾는 방식은 같은 블록을 여러 현재 행에 중복 대응시킬 수 있음 (예: `없음` / `종료 조건을 잘못 설정함`)

## Codex 분석

- 힌트 수준(Codex 판정): 정답 코드 — 좌표 불일치의 핵심 원인, 현재 보드를 직접 갱신하는 3단계 설계와 완성 코드를 확인함
- 복습 등급: C
- 등급 판정 근거: 40분 목표를 크게 넘긴 90분 이상 동안 구현했고 테스트 11개 중 2개가 실패했다. 동시 삭제 표시는 독립적으로 설계했지만 원본 좌표와 중력 적용 후 좌표를 구분하지 못해 상태 설계를 완성하지 못했고, 이후 핵심 해설과 정답 코드를 확인했다.
- 목표 시간 달성: 미달 — 90분 이상 / 40분
- 첫 시도 성공: 아니요 — 최종 미통과
- 시간복잡도: 학습한 표준 구현은 한 턴 `O(mn)`, 성공 턴 최대 `mn / 4`회이므로 최악 `O((mn)²)`
- 공간복잡도: 현재 보드와 삭제 표시 배열에 `O(mn)`
- 풀이 후 새로 배운 점: 시뮬레이션에서는 현재 상태가 자료구조에 직접 드러나게 표현하고, `탐색 → 일괄 삭제 → 중력`을 서로 분리해야 한다. 삭제 여부만으로 중력을 간접 표현하려면 원본 행이 아니라 각 열에서 아래로부터 몇 번째 생존 블록인지 별도로 매핑해야 한다.
- 오류 분류: 상태 표현·좌표계 혼동·중력 구현·시간 관리

## Codex 코드 리뷰

### 잘한 점

- 이번 턴의 삭제 위치 `removed`와 이전 턴까지 삭제된 위치 `removedResult`를 분리해, 같은 턴의 2×2를 모두 기존 상태 기준으로 판정하려고 한 방향은 정확했다.
- 겹치는 2×2의 칸을 `boolean[][]`으로 표시해 중복 집계를 막는 구조도 적절했다.
- 삭제가 없는 턴에서 반복을 종료하는 조건을 구현했다.

### 최종 오답의 원인

`getUpBlockI(currentRow, col)`은 중력 적용 후 `currentRow`에 있는 블록을 반환하지 않는다. 원본 배열의 `currentRow`부터 위쪽으로 검색한 첫 생존 블록을 반환한다. 맨 아래 논리 행을 찾을 때는 우연히 맞을 수 있지만, 다음 논리 행을 검사할 때 방금 아래 행에 대응시킨 같은 원본 블록을 다시 반환할 수 있다.

예를 들어 한 열의 원본 맨 아래 블록이 삭제되면 원본 3행 블록은 현재 4행으로 내려간다. 그런데 `getUpBlockI(4, col)`과 `getUpBlockI(3, col)`이 모두 원본 3행을 반환할 수 있어, 현재 4행과 3행에 같은 블록이 중복 배치된 것처럼 검사된다.

### 다음 구현에서 사용할 구조

한 턴을 다음 세 단계로 고정한다.

1. 현재 `char[][]`를 기준으로 모든 2×2를 검사하고 삭제 위치만 표시한다.
2. 표시된 칸을 한 번에 빈칸으로 바꾸고, 겹친 칸은 한 번만 센다.
3. 각 열을 아래에서 위로 읽으며 생존 블록을 아래쪽부터 다시 채운다.

이 구조에서는 `char[][]` 자체가 항상 중력 적용 후 현재 보드이므로 원본 좌표와 현재 좌표를 변환할 필요가 없다.

### 클린 코드 예시

```java
public class 프렌즈4블록 {

    private static final char EMPTY = ' ';

    public int solution(int m, int n, String[] board) {
        char[][] blocks = new char[m][n];
        for (int row = 0; row < m; row++) {
            blocks[row] = board[row].toCharArray();
        }

        int answer = 0;

        while (true) {
            boolean[][] removed = findBlocksToRemove(blocks, m, n);
            int removedCount = removeBlocks(blocks, removed, m, n);

            if (removedCount == 0) {
                break;
            }

            answer += removedCount;
            applyGravity(blocks, m, n);
        }

        return answer;
    }

    private boolean[][] findBlocksToRemove(char[][] blocks, int m, int n) {
        boolean[][] removed = new boolean[m][n];

        for (int row = 0; row < m - 1; row++) {
            for (int col = 0; col < n - 1; col++) {
                char block = blocks[row][col];

                if (block == EMPTY) {
                    continue;
                }

                if (blocks[row][col + 1] == block
                        && blocks[row + 1][col] == block
                        && blocks[row + 1][col + 1] == block) {
                    removed[row][col] = true;
                    removed[row][col + 1] = true;
                    removed[row + 1][col] = true;
                    removed[row + 1][col + 1] = true;
                }
            }
        }

        return removed;
    }

    private int removeBlocks(
            char[][] blocks,
            boolean[][] removed,
            int m,
            int n
    ) {
        int removedCount = 0;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (removed[row][col]) {
                    blocks[row][col] = EMPTY;
                    removedCount++;
                }
            }
        }

        return removedCount;
    }

    private void applyGravity(char[][] blocks, int m, int n) {
        for (int col = 0; col < n; col++) {
            int writeRow = m - 1;

            for (int row = m - 1; row >= 0; row--) {
                if (blocks[row][col] != EMPTY) {
                    blocks[writeRow--][col] = blocks[row][col];
                }
            }

            while (writeRow >= 0) {
                blocks[writeRow--][col] = EMPTY;
            }
        }
    }
}
```

원본 Java는 당시 사고 과정과 실패 원인을 보존하기 위해 수정하지 않았다.

## 반복 복습

- D+1: 생략 — 정답 코드 확인 문제이므로 동일 문제 재도전으로 대체
- D+3: 2026-11-19 동일 문제 재도전에서 `탐색 → 일괄 삭제 → 중력`과 좌표 불변식을 함께 설명
- D+7: 2026-11-26, 재도전 성공을 전제로 유형 비공개 격자 시뮬레이션 변형
- 동일 문제 재도전 예정일: 2026-11-19, 현재 코드·회고·대화를 보지 않고 처음부터 구현
