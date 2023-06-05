import java.util.ArrayList;

public class StockBuyAndSell {

    // bruteforce TC -> O(n^2) SC -> O(1)
    public static int maximumProfitBrute(ArrayList<Integer> prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.size(); i++) {
            for (int j = i + 1; j < prices.size(); j++) {
                if (prices.get(i) < prices.get(j)) {
                    int diff = prices.get(i) - prices.get(j);
                    maxProfit = Math.max(maxProfit, diff);
                }
            }
        }
        return maxProfit;
    }

    // Optimal TC -> O(n) SC -> O(1)
    public static int maximumProfitOptimal(ArrayList<Integer> prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.size(); i++) {
            minPrice = Math.min(prices.get(i), minPrice);
            int diff = prices.get(i) - minPrice;
            maxProfit = Math.max(maxProfit, diff);
        }
        return maxProfit;
    }
}
