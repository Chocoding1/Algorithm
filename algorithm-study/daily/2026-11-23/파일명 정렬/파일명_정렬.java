import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// 프로그래머스 Lv.2
public class 파일명_정렬 {

    /**
     * 우선 head와 number를 추출해야겠다.
     * 처음 정수형 문자열이 나오는 곳의 위치를 알아낸다음 subsTring으로 head 추출
     * 첫 정수형 문자열 위치부터 마지막 정수형 문자열 위치까지 subString으로 number 추출
     */
    public String[] solution(String[] files) {
        ArrayList<File> fileEntities = new ArrayList<>();
        for (String file : files) {
            fileEntities.add(new File(file));
        }

        Collections.sort(fileEntities);
        return fileEntities.stream()
                .map(File::getFileName)
                .toArray(String[]::new);
    }

    public static void main(String[] args) {
        파일명_정렬 solution = new 파일명_정렬();

        System.out.println(Arrays.toString(solution.solution(
                new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"}
        )));
        System.out.println(Arrays.toString(solution.solution(
                new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"}
        )));
    }


    private static class File implements Comparable<File> {
        private final String fileName;
        private final String head;
        private final int number;

        private File(String fileName) {
            this.fileName = fileName;
            this.head = extractHead(fileName);
            this.number = extractNumber(fileName);
        }

        public String getFileName() {
            return fileName;
        }

        private String extractHead(String fileName) {
            int startIdx = 0;
            for (int i = 0; i < fileName.length(); i++) {
                if (Character.isDigit(fileName.charAt(i))) {
                    startIdx = i;
                    break;
                }
            }
            return fileName.substring(0, startIdx);
        }

        private int extractNumber(String fileName) {
            int startIdx = 0;
            int endIdx = 0;
            for (int i = 0; i < fileName.length(); i++) {
                if (Character.isDigit(fileName.charAt(i))) {
                    if (startIdx == 0) {
                        startIdx = i;
                    }
                    continue;
                }
                if (startIdx != 0 && endIdx == 0) {
                    endIdx = i;
                }
            }
            if (endIdx == 0) {
                endIdx = fileName.length();
            }
            return Integer.parseInt(fileName.substring(startIdx, endIdx));
        }

        @Override
        public int compareTo(File o) {
            int headCompare =
                    head.compareToIgnoreCase(o.head);

            if (headCompare != 0) {
                return headCompare;
            }

            return Integer.compare(number, o.number);
        }
    }
}
