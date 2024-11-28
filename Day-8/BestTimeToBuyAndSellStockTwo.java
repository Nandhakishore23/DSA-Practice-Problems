import java.util.Scanner;
class BestTimeToBuyAndSellStockTwo {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of days: ");
        int n = scanner.nextInt();
        int[] prices = new int[n];
        System.out.println("Enter the stock prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        BestTimeToBuyAndSellStockTwo sol = new BestTimeToBuyAndSellStockTwo();
        int result = sol.maxProfit(prices);
        System.out.println("Maximum profit: " + result);
        scanner.close();
    }
}
