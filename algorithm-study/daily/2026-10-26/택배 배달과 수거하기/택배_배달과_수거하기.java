// 프로그래머스 Lv.2
public class 택배_배달과_수거하기 {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        // 각 배열에서 아직 처리하지 않은 가장 먼 집을 가리킨다.
        int deliveryIndex = n - 1;
        int pickupIndex = n - 1;

        while (deliveryIndex >= 0 || pickupIndex >= 0) {
            // 배달할 물량이 없는 집을 건너뛴다.
            while (deliveryIndex >= 0
                    && deliveries[deliveryIndex] == 0) {
                deliveryIndex--;
            }

            // 수거할 물량이 없는 집을 건너뛴다.
            while (pickupIndex >= 0
                    && pickups[pickupIndex] == 0) {
                pickupIndex--;
            }

            // 배달과 수거가 모두 끝났다.
            if (deliveryIndex < 0 && pickupIndex < 0) {
                break;
            }

            // 두 배열의 top 중 더 먼 집까지 왕복한다.
            int farthest = Math.max(deliveryIndex, pickupIndex);
            answer += (farthest + 1) * 2L;

            // 이번 왕복에서 배달 가능한 개수
            int deliveryCapacity = cap;

            while (deliveryIndex >= 0 && deliveryCapacity > 0) {
                int delivered = Math.min(
                        deliveries[deliveryIndex],
                        deliveryCapacity
                );

                deliveries[deliveryIndex] -= delivered;
                deliveryCapacity -= delivered;

                // 현재 집의 배달을 모두 처리했다면
                // 스택의 다음 원소로 이동한다.
                if (deliveries[deliveryIndex] == 0) {
                    deliveryIndex--;
                }
            }

            // 이번 왕복에서 수거 가능한 개수
            int pickupCapacity = cap;

            while (pickupIndex >= 0 && pickupCapacity > 0) {
                int pickedUp = Math.min(
                        pickups[pickupIndex],
                        pickupCapacity
                );

                pickups[pickupIndex] -= pickedUp;
                pickupCapacity -= pickedUp;

                // 현재 집의 수거를 모두 처리했다면
                // 스택의 다음 원소로 이동한다.
                if (pickups[pickupIndex] == 0) {
                    pickupIndex--;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        택배_배달과_수거하기 solution = new 택배_배달과_수거하기();

        System.out.println(solution.solution(
                4,
                5,
                new int[]{1, 0, 3, 1, 2},
                new int[]{0, 3, 0, 4, 0}
        )); // 16
        System.out.println(solution.solution(
                2,
                7,
                new int[]{1, 0, 2, 0, 1, 0, 2},
                new int[]{0, 2, 0, 1, 0, 2, 0}
        )); // 30
    }
}

