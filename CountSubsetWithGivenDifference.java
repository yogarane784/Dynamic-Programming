package dp;

/**
 * Given an array arr[] of size N and a given difference diff, the task is to
 * count the number of partitions that we can perform such that the difference
 * between the sum of the two subsets is equal to the given difference.
 * 
 * Note: A partition in the array means dividing an array into two parts say S1
 * and S2 such that the union of S1 and S2 is equal to the original array and
 * each element is present in only of the subsets.
 * 
 * Examples:
 * 
 * Input: N = 4, arr[] = [5, 2, 6, 4], diff = 3 Output: 1 Explanation: We can
 * only have a single partition which is shown below: {5, 2} and {6, 4} such
 * that S1 = 7 and S2 = 10 and thus the difference is 3
 * 
 * Input: N = 5, arr[] = [1, 2, 3, 1, 2], diff = 1 Output: 5 Explanation: We can
 * have five partitions which is shown below {1, 3, 1} and {2, 2} - S1 = 5, S2 =
 * 4 {1, 2, 2} and {1, 3} - S1 = 5, S2 = 4 {3, 2} and {1, 1, 2} - S1 = 5, S2 = 4
 * {1, 2, 2} and {1, 3} - S1 = 5, S2 = 4 {3, 2} and {1, 1, 2} - S1 = 5, S2 = 4
 */

//sum = s1+s2
//s2 = sum - s1
//s1 - sum + s1 = diff
//2s1-sum = diff
//s1 = (diff+sum)/2

public class CountSubsetWithGivenDifference {

	static Integer dp[][];

	public static void main(String[] args) {

		int nums[] = { 1, 2, 3, 1, 2 };

		int n = nums.length;

		int diff = 1;
		int sum = 0;

		for (int i = 0; i < n; i++) {
			sum = sum + nums[i];
		}

		int targetSum = (diff + sum) / 2;
		dp = new Integer[n + 1][targetSum + 1];

		System.out.println(countSubsetWithGivenDifference(nums, n, targetSum));
	}

	static int countSubsetWithGivenDifference(int nums[], int n, int sum) {

		if (n == 0 && sum > 0)
			return 0;

		if (sum == 0)
			return 1;

		if (dp[n][sum] != null)
			return dp[n][sum];

		if (nums[n - 1] <= sum) {
			return dp[n][sum] = countSubsetWithGivenDifference(nums, n - 1, sum - nums[n - 1])
					+ countSubsetWithGivenDifference(nums, n - 1, sum);
		} else {
			return dp[n][sum] = countSubsetWithGivenDifference(nums, n - 1, sum);
		}
	}

}
