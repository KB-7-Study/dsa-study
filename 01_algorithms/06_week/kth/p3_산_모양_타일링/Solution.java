class Solution {
    public int solution(int N, int[] tops) {
        int answer = 0;
        int MOD = 10007;
        int[][] dp = new int[N][2];
        dp[0][0] = 1;
//      색칠하는 부분
        dp[0][1] = 1 + (tops[0] == 1 ? 1: 0);
                    System.out.printf("i: %d 0: %d 1: %d\n", 0, dp[0][0] , dp[0][1]);
        if(N == 1) return dp[0][0]*2 + dp[0][1];
        for(int i = 1 ; i < N ; i++){
            // 밑부분 색칠 가능하면 하기
            dp[i][0] = (dp[i-1][0]*2 + dp[i-1][1])%MOD;
            // 색칠하기
            dp[i][1] = ((dp[i-1][0]+dp[i-1][1])%MOD * ((tops[i] == 1 ? 1: 0) + 1)) %MOD;
            if(tops[i] == 1)dp[i][1] = (dp[i-1][0]+ dp[i][1] ) %MOD;
            
        }
        return ((dp[N-1][0]*2)%MOD + dp[N-1][1])%MOD ;
    }
}