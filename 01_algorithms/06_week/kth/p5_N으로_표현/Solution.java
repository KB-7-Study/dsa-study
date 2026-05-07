import java.util.*;
class Solution {
    public int solution(int N, int number) {
        if(N == number) return 1;
        List<Set<Integer>> dp = new ArrayList<>();
        for(int i = 0 ; i < 9; i++){
            dp.add(new HashSet<>());
        }
        int s = N;
        for(int i = 1 ; i<= 8;i++){
            dp.get(i).add(s);
            s = s*10 + N;
        }
        for(int cnt = 2 ; cnt <= 8; cnt++){
            for(int i = 1;  i < cnt; i++){
                int j = cnt - i ;
                for(int a : dp.get(i)){
                    for(int b : dp.get(j)){
                        dp.get(cnt).add(a + b);
                        dp.get(cnt).add(a - b);
                        dp.get(cnt).add(a * b);
                        if(b != 0){
                            dp.get(cnt).add( a / b);
                        }

                        if(dp.get(cnt).contains(number))
                            return cnt;
                    }
                }
            }
        }
        return -1;
    }
}