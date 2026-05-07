class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int MOD = (int)1e9+7;
        int[][] dp = new int[m+1][n+1];
        boolean[][] checked = new boolean[m+1][n+1];
        for(int[] puddle: puddles){
            checked[puddle[0]][puddle[1]] = true;
        }
        dp[1][1] = 1;
        for(int i = 1 ; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(checked[i][j]) continue;
                if(i > 1) dp[i][j] = (dp[i][j] + dp[i-1][j]) % MOD;
                if(j > 1) dp[i][j] = (dp[i][j] + dp[i][j-1]) % MOD;
            }
        }

        return dp[m][n];
    }
}