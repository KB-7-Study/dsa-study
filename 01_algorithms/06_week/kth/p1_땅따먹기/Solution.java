class Solution {
    int solution(int[][] land) {
        int N = land.length;
        int[][] dp = new int[4][N+1];
        dp[0][1] = land[0][0];
        dp[1][1] = land[0][1];
        dp[2][1] = land[0][2];
        dp[3][1] = land[0][3];
        
        for(int cur = 2; cur <= N; cur++){
            for(int i = 0 ; i < 4; i++){
                for(int j = 0 ; j < 4; j++){
                    if(i == j) continue;
                    dp[i][cur] = Math.max(dp[i][cur], dp[j][cur-1] + land[cur-1][i]);
                }
            }   
        }
        int answer = 0;
        for(int i = 0; i < 4; i++){
            answer = Math.max(dp[i][N], answer);
        }
        return answer;
    }
}