package dp;

/**
 * Given a rod of length n inches and an array price[], where price[i] denotes
 * the value of a piece of length i. Your task is to determine the maximum value
 * obtainable by cutting up the rod and selling the pieces.
 * 
 * Note: n = size of price, and price[] is 1-indexed array.
 * 
 * Example:
 * 
 * Input: price[] = [1, 5, 8, 9, 10, 17, 17, 20] Output: 22 Explanation: The
 * maximum obtainable value is 22 by cutting in two pieces of lengths 2 and 6,
 * i.e., 5 + 17 = 22. Input: price[] = [3, 5, 8, 9, 10, 17, 17, 20] Output: 24
 * Explanation: The maximum obtainable value is 24 by cutting the rod into 8
 * pieces of length 1, i.e, 8*price[1] = 8*3 = 24. Input: price[] = [3] Output:
 * 3 Explanation: There is only 1 way to pick a piece of length 1.
 */

public class RodCuttingProblem {

	static Integer dp[][];

	public static void main(String args[]) {

		int val[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
		int wt[] = new int[val.length];
		int W = wt.length;
		int n = wt.length;
		for(int i=0;i<n;i++) {
			wt[i] = i+1;
		}
		
		
		
		dp = new Integer[n + 1][W + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= W; j++) {
				if (i == 0 || j == 0)
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
			return dp[n][W] = Math.max((val[n - 1] + maxProfit(wt, val, n, W - wt[n - 1])),
					maxProfit(wt, val, n - 1, W));

		else
			return dp[n][W] = maxProfit(wt, val, n - 1, W);

	}

}
