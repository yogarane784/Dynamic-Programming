package dp;


/**
 * Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

 

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.

 */
public class EqualSumPartition {
	
	static Boolean dp[][];

	public static void main(String args[]) {

		int nums[] = { 1,5,11,5 };
		int sum = 0;
		int n = nums.length;
		
		for(int i=0;i<n;i++) {
			sum = sum + nums[i];
		}

		dp = new Boolean[n + 1][sum + 1];
		
		for (int i = 0; i <= n; i++) {
			dp[0][i] = false;
		}

		for (int i = 0; i <= n; i++) {
			dp[i][0] = true;
		}

		System.out.println("Equal sum partition present : " + equalSumPartition(nums, sum/2, n));
	}

	static boolean equalSumPartition(int nums[], int sum, int n) {

		if (n <= 0 && sum>0)
			return false;

		if (sum == 0)
			return true;

		if (dp[n][sum] != null)
			return dp[n][sum];

		if (nums[n - 1] <= sum)
			return dp[n][sum] = equalSumPartition(nums, sum-nums[n-1], n-1) || equalSumPartition(nums, sum, n-1);

		else
			return dp[n][sum] = equalSumPartition(nums, sum, n-1);

	}

}
