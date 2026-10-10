package class_problems;

public class WarehouseGridSummary {
    public static class SummaryResult {
        private int totalItems;
        private int maxRow;
        private int maxCol;

        public SummaryResult(int totalItems, int maxRow, int maxCol) {
            this.totalItems = totalItems;
            this.maxRow = maxRow;
            this.maxCol = maxCol;
        }

        public int getTotalItems() {
            return totalItems;
        }

        public int getMaxRow() {
            return maxRow;
        }

        public int getMaxCol() {
            return maxCol;
        }

        @Override
        public String toString() {
            return "(" + totalItems + ", (" + maxRow + ", " + maxCol + "))";
        }
    }

    public static SummaryResult warehouseSummary(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return new SummaryResult(0, -1, -1);
        }

        int total = 0;
        int maxVal = -1;
        int maxR = 0;
        int maxC = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                int val = grid[r][c];
                total += val;
                if (val > maxVal) {
                    maxVal = val;
                    maxR = r;
                    maxC = c;
                }
            }
        }

        return new SummaryResult(total, maxR, maxC);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };

        System.out.println(warehouseSummary(grid));
    }
}
