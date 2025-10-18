package dp;


/**
 * Given a knapsack weight, say capacity and a set of n items with certain value vali and weight wti, The task is to fill the knapsack in such a way that we can get the maximum profit. This is different from the classical Knapsack problem, here we are allowed to use an unlimited number of instances of an item.

Examples: 

Input: capacity = 100, val[]  = [1, 30], wt[] = [1, 50]
Output: 100 
Explanation: There are many ways to fill knapsack. 
1) 2 instances of 50 unit weight item. 
2) 100 instances of 1 unit weight item. 
3) 1 instance of 50 unit weight item and 50 instances of 1 unit weight items. 
We get maximum value with option 2.  

Input: capacity = 8, val[] = [10, 40, 50, 70], wt[]  = [1, 3, 4, 5]        
Output : 110
Explanation: We get maximum value with one unit of weight 5 and one unit of weight 3.
 */
public class UnboundedKnapsack {
	
	static Integer dp[][];

	public static void main(String args[]) {

		int wt[] = { 1, 50 };
		int val[] = { 1, 30 };
		int W = 100;
		int n = wt.length;

		dp = new Integer[n + 1][W + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= W; j++) {
				if(i==0 || j==0)
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
			return dp[n][W] = Math.max((val[n - 1] + maxProfit(wt, val, n , W - wt[n - 1])),
					maxProfit(wt, val, n-1, W));

		else
			return dp[n][W] = maxProfit(wt, val, n - 1, W);

	}

}
