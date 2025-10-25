package dp;

/**
 * 322. Coin Change Solved Medium Topics premium lock icon Companies You are
 * given an integer array coins representing coins of different denominations
 * and an integer amount representing a total amount of money.
 * 
 * Return the fewest number of coins that you need to make up that amount. If
 * that amount of money cannot be made up by any combination of the coins,
 * return -1.
 * 
 * You may assume that you have an infinite number of each kind of coin.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: coins = [1,2,5], amount = 11 Output: 3 Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * 
 * Input: coins = [2], amount = 3 Output: -1 Example 3:
 * 
 * Input: coins = [1], amount = 0 Output: 0
 */
class CoinChange {

	int min = Integer.MAX_VALUE;

	Integer dp[][];

	public int coinChange(int[] coins, int amount) {

		int n = coins.length;
		dp = new Integer[n + 1][amount + 1];

		int ways = find(coins, amount, n);
		return ways == Integer.MAX_VALUE - 1 ? -1 : ways;
	}

	int find(int[] coins, int amount, int n) {
		if (amount == 0) {
			return 0;
		}

		if (n == 0 && amount > 0)
			return Integer.MAX_VALUE - 1;

		if (dp[n][amount] != null) {
			return dp[n][amount];
		}

		if (coins[n - 1] <= amount) {
			return dp[n][amount] = Math.min(1 + find(coins, amount - coins[n - 1], n), find(coins, amount, n - 1));
		} else {
			return dp[n][amount] = find(coins, amount, n - 1);
		}
	}
}
