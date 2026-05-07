import java.util.*;
class Solution {
    public int solution(int[] money) {
        int answer = 0;
        
        int N = money.length;
        int[] dp = new int[N];
        int[] dp2 = new int[N];
        dp[0] = money[0];
        dp2[0] = money[1];
        dp[1] = Math.max(dp[0],money[1]);
        dp2[1] = Math.max(dp2[0],money[2]);
        if(N == 3){
            answer = Math.max(money[0], money[1]);
            answer = Math.max(answer, money[2]);
            return answer;
        }
        for(int j = 2 ; j < N; j++){
            dp[j] = Math.max(dp[j-1] , money[j] +dp[j-2]);
            dp2[j] = Math.max(dp2[j-1] , money[(j+1)%N] +dp2[j-2]);

        }
        answer = Math.max(dp[N-2], dp2[N-2]);
        
        return answer;
    }
}