public class StockTrading {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPriceSoFar = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int potentialProfit = prices[i] - minPriceSoFar;
            if (potentialProfit > maxProfit) {
                maxProfit = potentialProfit;
            }
            if (prices[i] < minPriceSoFar) {
                minPriceSoFar = prices[i];
            }
        }
        return maxProfit;
    }
}
