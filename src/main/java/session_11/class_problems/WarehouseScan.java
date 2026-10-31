public class WarehouseScan {
    public static class SummaryResult {
        public int total;
        public int row;
        public int col;

        public SummaryResult(int total, int row, int col) {
            this.total = total;
            this.row = row;
            this.col = col;
        }
    }

    public static SummaryResult warehouseSummary(int[][] grid) {
        int total = 0;
        int maxVal = -1;
        int maxRow = 0;
        int maxCol = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                int current = grid[r][c];
                total += current;

                if (current > maxVal) {
                    maxVal = current;
                    maxRow = r;
                    maxCol = c;
                }
            }
        }
        return new SummaryResult(total, maxRow, maxCol);
    }
}