import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

// 프로그래머스 Lv.2
public class 주차_요금_계산 {

    public int[] solution(int[] fees, String[] records) {
        Map<String, String> inTimesPerCar = new HashMap<>();
        Map<String, Long> parkingTimePerCar = new TreeMap<>();

        for (String record : records) {
            String[] parsedRecord = record.split(" ");
            String time = parsedRecord[0];
            String carNumber = parsedRecord[1];
            String act = parsedRecord[2];

            if (act.equals("IN")) {
                inTimesPerCar.put(carNumber, time);
            } else {
                String inTime = inTimesPerCar.remove(carNumber);
                LocalTime localInTime = LocalTime.parse(inTime);
                LocalTime localOutTime = LocalTime.parse(time);

                long parkingMinutes = Duration.between(localInTime, localOutTime).toMinutes();
                parkingTimePerCar.put(carNumber, parkingTimePerCar.getOrDefault(carNumber, 0L) + parkingMinutes);
            }
        }

        for (Map.Entry<String, String> remainCars : inTimesPerCar.entrySet()) {
            String carNumber = remainCars.getKey();
            LocalTime inTime = LocalTime.parse(remainCars.getValue());
            LocalTime outTime = LocalTime.of(23, 59);
            long parkingMinutes = Duration.between(inTime, outTime).toMinutes();
            parkingTimePerCar.put(carNumber, parkingTimePerCar.getOrDefault(carNumber, 0L) + parkingMinutes);
        }

        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        List<Integer> parkingFees = new ArrayList<>();
        for (Long parkingTime : parkingTimePerCar.values()) {
                if (parkingTime <= defaultTime) {
                    parkingFees.add(defaultFee);
                    continue;
                }
            parkingFees.add((int) ((parkingTime + unitTime - defaultTime - 1) / unitTime) * unitFee + defaultFee);
        }

        return parkingFees.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        주차_요금_계산 solution = new 주차_요금_계산();

        System.out.println(Arrays.toString(solution.solution(
                new int[]{180, 5000, 10, 600},
                new String[]{
                        "05:34 5961 IN",
                        "06:00 0000 IN",
                        "06:34 0000 OUT",
                        "07:59 5961 OUT",
                        "07:59 0148 IN",
                        "18:59 0000 IN",
                        "19:09 0148 OUT",
                        "22:59 5961 IN",
                        "23:00 5961 OUT"
                }
        ))); // [14600, 34400, 5000]
    }
}
