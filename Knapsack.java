package dp;

/**
 * Given n items where each item has some weight and profit associated with it
 * and also given a bag with capacity W, [i.e., the bag can hold at most W
 * weight in it]. The task is to put the items into the bag such that the sum of
 * profits associated with them is the maximum possible.
 * 
 * Note: The constraint here is we can either put an item completely into the
 * bag or cannot put it at all [It is not possible to put a part of an item into
 * the bag].
 * 
 * Input: W = 4, profit[] = [1, 2, 3], weight[] = [4, 5, 1] Output: 3
 * Explanation: There are two items which have weight less than or equal to 4.
 * If we select the item with weight 4, the possible profit is 1. And if we
 * select the item with weight 1, the possible profit is 3. So the maximum
 * possible profit is 3. Note that we cannot put both the items with weight 4
 * and 1 together as the capacity of the bag is 4.
 * 
 * Input: W = 3, profit[] = [1, 2, 3], weight[] = [4, 5, 6] Output: 0
 * 
 **/

public class Knapsack {

	static Integer dp[][];

	public static void main(String args[]) {

		int wt[] = { 4, 5, 1 };
		int val[] = { 1, 2, 3 };
		int W = 4;
		int n = wt.length;

		dp = new Integer[n + 1][W + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				dp[i][j] = 0;
			}
		}

		System.out.println("Max profit : " + maxProfit(wt, val, n, W));
	}

	static int maxProfit(int wt[], int val[], int n, int W) {

		if (n <= 0)
			return 0;

		if (W <= 0)
			return 0;

		if (dp[n][W] != null)
			return dp[n][W];

		if (wt[n - 1] <= W)
			return dp[n][W] = Math.max((val[n - 1] + maxProfit(wt, val, n - 1, W - wt[n - 1])),
					maxProfit(wt, val, n - 1, W));

		else
			return dp[n][W] = maxProfit(wt, val, n - 1, W);

	}

}
