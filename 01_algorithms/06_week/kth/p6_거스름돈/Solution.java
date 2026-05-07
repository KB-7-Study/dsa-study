class Solution {
    final int MOD = (int)1e9+7;
    public int solution(int n, int[] money) {
        int[] dp = new int[n+1];
        dp[0]= 1;
        for (int i = 0; i < money.length; i++) {
            int cur = money[i];
            for (int j = cur; j <= n; j++) {
                dp[j] += dp[j - cur];
                dp[j] %= MOD; // 오버플로우 방지
            }
        }
        return dp[n];
    }
}