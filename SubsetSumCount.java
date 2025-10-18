package dp;

/**
 * Given an array arr[] of non-negative integers and a value sum, the task is to
 * check if there is a subset of the given array whose sum is equal to the given
 * sum.
 * 
 * Examples:
 * 
 * Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9 Output: True Explanation: There
 * is a subset (4, 5) with sum 9.
 * 
 * Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 30 Output: False Explanation:
 * There is no subset that add up to 30.
 * 
 **/

public class SubsetSumCount {

	static Integer dp[][];

	public static void main(String args[]) {

		int nums[] = { 3, 34, 4, 12, 5, 2 };
		int sum = 9;
		int n = nums.length;

		dp = new Integer[n + 1][sum + 1];
		
		for (int i = 0; i <= n; i++) {
			dp[0][i] = 0;
		}

		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}

		System.out.println("Subset sum count : " + subsetSumCount(nums, sum, n));
	}

	static int subsetSumCount(int nums[], int sum, int n) {

		if (n <= 0 && sum>0)
			return 0;

		if (sum == 0)
			return 1;

		if (dp[n][sum] != null)
			return dp[n][sum];

		if (nums[n - 1] <= sum)
			return dp[n][sum] = subsetSumCount(nums, sum-nums[n-1], n-1) + subsetSumCount(nums, sum, n-1);

		else
			return dp[n][sum] = subsetSumCount(nums, sum, n-1);

	}

}
