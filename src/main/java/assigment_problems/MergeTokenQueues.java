package assigment_problems;

import java.util.Arrays;

public class MergeTokenQueues {
    public static int[] mergeTokens(int[] counterA, int[] counterB) {
        if (counterA == null) counterA = new int[0];
        if (counterB == null) counterB = new int[0];

        int n = counterA.length;
        int m = counterB.length;
        int[] result = new int[n + m];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n && j < m) {
            if (counterA[i] <= counterB[j]) {
                result[k++] = counterA[i++];
            } else {
                result[k++] = counterB[j++];
            }
        }

        while (i < n) {
            result[k++] = counterA[i++];
        }

        while (j < m) {
            result[k++] = counterB[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a1 = {3, 8, 15, 20};
        int[] b1 = {5, 8, 12};
        System.out.println(Arrays.toString(mergeTokens(a1, b1)));

        int[] a2 = {};
        int[] b2 = {4, 9};
        System.out.println(Arrays.toString(mergeTokens(a2, b2)));
    }
}
