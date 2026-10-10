package assigment_problems;

public class ClassTopperFinder {
    public static class TopperResult {
        private int rowIndex;
        private int total;

        public TopperResult(int rowIndex, int total) {
            this.rowIndex = rowIndex;
            this.total = total;
        }

        public int getRowIndex() {
            return rowIndex;
        }

        public int getTotal() {
            return total;
        }

        @Override
        public String toString() {
            return "(" + rowIndex + ", " + total + ")";
        }
    }

    public static TopperResult findTopper(int[][] marks) {
        if (marks == null || marks.length == 0) {
            return new TopperResult(-1, 0);
        }

        int bestIndex = 0;
        int maxTotal = -1;

        for (int i = 0; i < marks.length; i++) {
            int currentTotal = 0;
            for (int j = 0; j < marks[i].length; j++) {
                currentTotal += marks[i][j];
            }

            if (currentTotal > maxTotal) {
                maxTotal = currentTotal;
                bestIndex = i;
            }
        }

        return new TopperResult(bestIndex, maxTotal);
    }

    public static void main(String[] args) {
        int[][] marks = {
            {78, 85, 90},
            {88, 92, 79},
            {65, 70, 95}
        };

        System.out.println(findTopper(marks));
    }
}
