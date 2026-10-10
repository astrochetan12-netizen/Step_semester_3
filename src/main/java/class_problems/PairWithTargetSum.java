package class_problems;

import java.util.HashSet;
import java.util.Set;

public class PairWithTargetSum {
    public static boolean hasPairWithSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return true;
            }
            seen.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        boolean result1 = hasPairWithSum(nums1, target1);
        System.out.println(result1 ? "true (because 2 + 7 = 9)" : "false");

        int[] nums2 = {3, 4, 6};
        int target2 = 20;
        boolean result2 = hasPairWithSum(nums2, target2);
        System.out.println(result2 ? "true" : "false");
    }
}
