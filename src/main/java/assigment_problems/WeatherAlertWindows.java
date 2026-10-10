package assigment_problems;

public class WeatherAlertWindows {
    public static int countAlerts(int[] readings, int k, int threshold) {
        if (readings == null || k <= 0 || readings.length < k) {
            return 0;
        }

        long targetSum = (long) k * threshold;
        long currentSum = 0;

        for (int i = 0; i < k; i++) {
            currentSum += readings[i];
        }

        int count = 0;
        if (currentSum >= targetSum) {
            count++;
        }

        for (int i = k; i < readings.length; i++) {
            currentSum += readings[i] - readings[i - k];
            if (currentSum >= targetSum) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] readings = {2, 2, 2, 2, 5, 5, 5, 8};
        int k = 3;
        int threshold = 4;

        System.out.println(countAlerts(readings, k, threshold));
    }
}
