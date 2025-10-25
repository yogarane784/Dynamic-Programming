package dp;

/**
 * Given two strings 's1' and 's2', find the length of the longest common
 * substring.
 * 
 * Example:
 * 
 * Input: s1 = "GeeksforGeeks", s2 = "GeeksQuiz" Output : 5 Explanation: The
 * longest common substring is "Geeks" and is of length 5.
 * 
 * Input: s1 = "abcdxyz", s2 = "xyzabcd" Output : 4 Explanation: The longest
 * common substring is "abcd" and is of length 4.
 * 
 * Input: s1 = "abc", s2 = "" Output : 0.
 */
class LongestCommonSubstring {

	static int[][] dp;

	public static int longestCommonSubstring(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();
		dp = new int[m + 1][n + 1];
		return lcs(text1, text2, m, n);
	}

	static int lcs(String x, String y, int m, int n) {
		int maxLen = 0;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
					maxLen = Math.max(maxLen, dp[i][j]);
				} else {
					dp[i][j] = 0;
				}
			}
		}

		return maxLen;
	}

	public static void main(String[] args) {
		String s1 = "geeksforgeeks";
		String s2 = "practicewritegeekscourses";
		System.out.println(longestCommonSubstring(s1, s2)); // Output: 5 ("geeks")
	}
}
