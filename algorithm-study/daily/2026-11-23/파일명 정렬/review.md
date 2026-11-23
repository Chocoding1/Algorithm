# 파일명 정렬

## 문제 정보 - Codex 작성

- 링크: https://school.programmers.co.kr/learn/courses/30/lessons/17686
- 플랫폼 / 난이도: 프로그래머스 Lv.2
- 풀이 날짜: 2026-11-23
- 핵심 유형: 문자열 파싱·다중 기준 안정 정렬·구현
- 목표 시간: 45분
- 풀이 구분: 신규
- 연결된 원본 문제: 풀이 완료 후 Codex 작성
- Java 코드 경로: `daily/2026-11-23/파일명 정렬/파일명_정렬.java`

## 풀이 시간 배분 - Codex 작성

| 단계 | 할 일 | 권장 비율 | 이 문제 배분 | 누적 종료 시점 |
|---|---|---:|---:|---:|
| 1 | 문제 이해·제한 확인 | 20% | 9분 | 9분 |
| 2 | 단순 풀이·병목 찾기 | 20% | 9분 | 18분 |
| 3 | 접근 선택·풀이 흐름·정확성 확인 | 20% | 9분 | 27분 |
| 4 | Java 구현 | 25% | 11분 | 38분 |
| 5 | 예제·엣지 케이스 검증 및 제출 | 15% | 7분 | 45분 |

> 27분까지 구현 가능한 설계를 확정합니다. 설계가 없다면 작은 힌트를 요청하고, 38분부터는 검증과 제출에 집중합니다.

## 풀이 중 시간대별 기록 - 사용자 작성

> 각 질문 바로 아래에 한두 문장으로 답합니다. 구현 중 특이사항이 없으면 해당 답은 비워도 됩니다.

### 0~20% (0~9분) — 문제와 제한 이해

두 파일의 순서를 결정할 때 첫 번째·두 번째 기준은 무엇이며, 두 기준이 모두 같으면 어떻게 해야 하는가?
-

파일 개수와 파일명 최대 길이를 기준으로 각 파일을 여러 번 확인하는 방식이 허용되는가?
-

### 20~40% (9~18분) — 단순 풀이와 병목

두 파일을 비교할 때마다 파일명 전체를 처음부터 다시 해석한다면 같은 작업이 얼마나 반복되는가?
-

문제의 모든 정렬 조건을 한 번에 확인하지 않으면 어떤 경우에 결과 순서가 달라질 수 있는가?
-

### 40~60% (18~27분) — 설계 확정

각 파일에서 순서를 판단하는 데 필요한 값과 원래 문자열 중 무엇을 보관할 것인가?
-

대소문자 차이, 숫자 앞의 0, 두 기준이 같은 경우를 각각 어떤 비교 결과로 처리할 것인가?
-

### 60% (27분) — 힌트 판단 지점

현재까지 찾은 병목과 정확히 막힌 지점은? 설계가 확정됐다면 비워 둡니다.
-

### 60~85% (27~38분) — Java 구현

숫자 부분이 파일명 끝에서 끝나는 경우와 숫자가 최대 다섯 자리인 경우에도 인덱스가 범위를 벗어나지 않는가?
-

### 85~100% (38~45분) — 검증과 제출

HEAD의 대소문자만 다르거나 NUMBER의 앞자리 0만 다른 파일들이 입력 순서를 유지하는지 확인했는가?
-

### 선택 기록

출제 의도 알고리즘 추측은? 풀이 후 비교를 원할 때만 Codex 피드백 전에 작성합니다.
-

## 풀이 후 결과 - 사용자 작성

- 실제 풀이 시간: 35분 (예: `15분`)
- 풀이 외 제외 시간: 0분 (예: `0분` / `5분, 식사`)
- 결과: 성공 (예: `성공` / `실패` / `부분 성공`)
- 제출 결과: 첫 통과 전 오답 2회 (예: `첫 제출 통과` / `첫 통과 전 오답 2회` / `미제출`)
- 설계 확정까지 걸린 시간: 힌트 참고함 (예: `8분` / `설계 미확정`)
- 구현 실수: File 객체에 Comparator를 구현함, endIdx 초기화를 잘못함 (예: `없음` / `숫자 부분의 끝 인덱스 오류`)
- 막힌 지점·배운 점: Comparable, Comparator, 정수형 문자열을 int로 바꾸면 앞의 0은 사라지는 것, 대소문자 상관없이 정렬하는 법 (예: `없음` / `두 기준이 같은 파일의 기존 순서를 바꿈`)

## Codex 분석

- 힌트 수준(Codex 판정): 핵심 힌트 — `Comparable`·`Comparator` 적용법과 다중 기준 비교 코드를 설명했고, 세 자리 NUMBER와 TAIL 내부 숫자 반례 및 NUMBER가 파일 끝에서 끝날 때의 정확한 종료 인덱스와 수정 코드를 제공함
- 복습 등급: C
- 등급 판정 근거: 목표 45분 안인 35분에 최종 성공하고 HEAD·NUMBER를 객체에 한 번만 파싱하는 큰 설계는 독립적으로 잡았지만 첫 통과 전 오답 2회가 발생했으며, 정렬 API와 NUMBER의 연속 범위·파일 끝 경계를 핵심 힌트로 확인한 뒤 통과함
- 목표 시간 달성: 예
- 첫 시도 성공: 아니오
- 공식 출제 의도 알고리즘: 공식 의도 명시 없음
- Codex 추천 목표 알고리즘: 파일별 HEAD·NUMBER를 한 번 파싱한 뒤 HEAD 대소문자 무시, NUMBER 숫자값 순서로 안정 정렬
- 공식 의도 일치 여부: 공식 의도 명시 없음
- Codex 목표 일치 여부: 일치 — 최종 코드는 파일별 정렬 키를 객체에 저장하고 `Comparable`로 동일한 우선순위를 구현함
- 실제 풀이와 의도 알고리즘 비교: 실제 풀이도 `File` 객체에 원본·HEAD·NUMBER를 저장하고 정렬 후 원본 이름만 반환한다. 초기에는 NUMBER의 끝을 두 번째 숫자 또는 뒤쪽 숫자로 판단했고, 수정 후 첫 숫자부터 첫 숫자 아닌 문자 전까지를 NUMBER로 사용한다.
- 풀이 전 사고와 실제 코드의 차이: 주석에 적은 `HEAD와 NUMBER를 먼저 추출한다`는 방향은 정확했다. 구현 단계에서 `Comparator`와 `Comparable`의 역할을 혼동했고, NUMBER를 `연속된 숫자 구간`이 아니라 숫자 위치들의 범위로 해석해 TAIL의 숫자와 파일 끝 경계를 놓쳤다.
- 정답 검증:
  - `head.compareToIgnoreCase()`가 첫 번째 기준을 구현한다.
  - HEAD가 같을 때 `Integer.compare(number, other.number)`가 앞의 0을 무시한 숫자값 순서를 구현한다.
  - 두 기준이 같으면 `0`을 반환하고 `Collections.sort()`의 안정 정렬이 입력 순서를 유지한다.
  - 원본 `fileName`을 별도로 보관하므로 출력에서는 대소문자·앞자리 0·TAIL이 손실되지 않는다.
- 코드 개선 포인트: 현재 `extractHead()`와 `extractNumber()`가 같은 파일명을 각각 순회하며, NUMBER 끝을 찾은 뒤에도 TAIL 끝까지 계속 확인한다. 첫 숫자 위치를 한 번 찾고 최대 5개의 연속된 숫자만 확인하면 파싱 규칙과 종료 조건이 더 직접적으로 드러난다. `File`은 `java.io.File`과 혼동될 수 있어 `FileInfo`가 명확하다.
- 클린 코드 예시:

```java
import java.util.Arrays;

public class 파일명_정렬 {

    public String[] solution(String[] files) {
        return Arrays.stream(files)
                .map(FileInfo::new)
                .sorted()
                .map(file -> file.original)
                .toArray(String[]::new);
    }

    private static class FileInfo implements Comparable<FileInfo> {
        private final String original;
        private final String head;
        private final int number;

        private FileInfo(String original) {
            this.original = original;

            int numberStart = 0;
            while (!Character.isDigit(original.charAt(numberStart))) {
                numberStart++;
            }

            int numberEnd = numberStart;
            while (numberEnd < original.length()
                    && numberEnd - numberStart < 5
                    && Character.isDigit(original.charAt(numberEnd))) {
                numberEnd++;
            }

            this.head = original.substring(0, numberStart);
            this.number = Integer.parseInt(
                    original.substring(numberStart, numberEnd)
            );
        }

        @Override
        public int compareTo(FileInfo other) {
            int headOrder = head.compareToIgnoreCase(other.head);
            if (headOrder != 0) {
                return headOrder;
            }
            return Integer.compare(number, other.number);
        }
    }
}
```

- 풀이 후 새로 배운 점:
  - `Comparable`은 객체의 기본 순서를 `compareTo()`로 정의하고, `Comparator`는 정렬할 때 외부에서 전달하는 별도 기준이다.
  - NUMBER는 파일명에 존재하는 모든 숫자가 아니라 처음 등장하는 최대 다섯 자리의 연속된 숫자 구간이다.
  - `Integer.parseInt("0012")`는 숫자값 `12`를 만들어 앞자리 0을 자연스럽게 무시한다.
  - NUMBER가 파일 끝에서 끝나면 끝 인덱스는 시작 인덱스가 아니라 `fileName.length()`이다.
- 다음 문제에 적용할 한 문장 규칙: 문자열의 일부를 파싱할 때는 시작 조건뿐 아니라 `어떤 문자에서 끝나는가`와 `입력 끝까지 이어지면 끝 인덱스가 무엇인가`를 함께 정의한다.
- 복습에 포함할 학습 포인트: `Comparable`과 `Comparator` 선택, 다중 기준 비교의 조기 반환, 안정 정렬, 연속 숫자 구간의 끝, 숫자 구간이 문자열 끝에서 종료되는 경우
- 오류 분류: 구현·경계·API 이해
- 잘한 점: Comparator 안에서 매번 파일명을 해석하지 않고 정렬 키를 객체 생성 시 한 번만 추출하는 구조를 선택했고, 원본 파일명을 보존해 정확한 출력으로 복원했다.
- 개선할 점: `endIdx = 0` 같은 의미가 겹치는 센티널보다 `numberStart`에서 앞으로 진행하는 단일 인덱스를 사용하고, 공개 예제 외에 NUMBER 세 자리·파일 끝·TAIL 내부 숫자 반례를 제출 전에 확인한다.
- 유형 인식 신호: 복합 문자열을 여러 기준으로 정렬하고 일부 기준은 원본 표현과 다른 값으로 비교해야 하면, 원본과 정렬 키를 분리해 한 번 파싱한 객체 또는 레코드를 고려한다.
- 다음에 적용할 규칙: 구간 파싱은 `시작 위치 찾기 → 연속 조건이 유지되는 동안 끝 위치 이동 → [start, end) 추출`의 세 단계로 작성한다.
- 시간복잡도: 파일 수를 `F`, 최대 파일명 길이를 `L`이라 하면 파싱 `O(F×L)`, 정렬 비교 `O(F log F×L)`, 전체 `O(F×L + F log F×L)`
- 공간복잡도: 파일별 원본과 정렬 키 객체를 저장해 `O(F×L)`

## 반복 복습

- D+1: 생략 — 시험 직전 일정상 동일 문제 재도전으로 통합
- D+3: 시험 직전 실전 일정을 유지하기 위해 2026-11-30 동일 문제 재도전에서 통합 확인
- D+7: 동일 문제 재도전 성공 후 다음 문자열 정렬 변형에 흡수
- 동일 문제 재도전 예정일: 2026-11-30, 현재 코드·회고 없이 20분 안에 HEAD·NUMBER 파싱과 안정 정렬을 처음부터 구현
- 재도전·변형 결과: 예정
- D+7 변형 전이 결과: 재도전 후 결정
