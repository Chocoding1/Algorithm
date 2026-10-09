// 프로그래머스 Lv.1
public class 최소직사각형_재도전 {
    public int solution(int[][] sizes) {
        for (int i = 0; i < sizes.length; i++) {
            for (int j = 0; j < sizes[i].length; j++) {
                if (sizes[i][0] < sizes[i][1]) {
                    int left = sizes[i][0];
                    sizes[i][0] = sizes[i][1];
                    sizes[i][1] = left;
                }
            }
        }

        int leftMax = 0;
        int rightMax = 0;
        for (int[] size : sizes) {
            leftMax = Math.max(leftMax, size[0]);
            rightMax = Math.max(rightMax, size[1]);
        }
        return leftMax * rightMax;
    }

    public static void main(String[] args) {
        최소직사각형_재도전 solution = new 최소직사각형_재도전();

        System.out.println(solution.solution(new int[][]{
                {60, 50}, {30, 70}, {60, 30}, {80, 40}
        }));
        System.out.println(solution.solution(new int[][]{
                {10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}
        }));
        System.out.println(solution.solution(new int[][]{
                {14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}
        }));
    }
}
