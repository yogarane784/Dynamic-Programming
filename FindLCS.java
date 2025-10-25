package dp;

/**
 * You are given two strings ‘s1’ and ‘s2’.
 * 
 * 
 * 
 * Return the longest common subsequence of these strings.
 * 
 * 
 * 
 * If there’s no such string, return an empty string. If there are multiple
 * possible answers, return any such string.
 * 
 * 
 * 
 * Note: Longest common subsequence of string ‘s1’ and ‘s2’ is the longest
 * subsequence of ‘s1’ that is also a subsequence of ‘s2’. A ‘subsequence’ of
 * ‘s1’ is a string that can be formed by deleting one or more (possibly zero)
 * characters from ‘s1’.
 * 
 * 
 * Example: Input: ‘s1’ = “abcab”, ‘s2’ = “cbab”
 * 
 * Output: “bab”
 * 
 * Explanation: “bab” is one valid longest subsequence present in both strings
 * ‘s1’ , ‘s2’.
 */

public class FindLCS {
	public static String findLCS(int m, int n, String s1, String s2) {

		dp = new int[m + 1][n + 1];
		return lcs(s1, s2, s1.length(), s2.length());
	}

	static int dp[][];

	static String lcs(String x, String y, int m, int n) {

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		StringBuilder sb = new StringBuilder("");
		int i = m, j = n;

		while (i > 0 && j > 0) {
			if (x.charAt(i - 1) == y.charAt(j - 1)) {
				sb.append(x.charAt(i - 1));
				i--;
				j--;
			} else if (dp[i][j - 1] > dp[i - 1][j]) {
				j--;
			} else {
				i--;
			}
		}

		return sb.reverse().toString();
	}
}
