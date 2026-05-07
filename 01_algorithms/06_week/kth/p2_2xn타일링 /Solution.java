class Solution {
    public int solution(int n) {
        int answer = 0;
        int MOD = (int)1e9 + 7;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3 ; i <= n; i++){
            dp[i] = (dp[i-1] + (dp[i-2])%MOD ) %MOD;
        }
        return dp[n];
    }
}