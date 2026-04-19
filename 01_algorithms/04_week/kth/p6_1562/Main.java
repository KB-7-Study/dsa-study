package _4_week.p6_1562;


import java.io.*;
import java.util.Arrays;

public class Main {
    static final int MOD = (int) 1e9;
    static int N, ret;
    static int[][][] dp;

    static int go(int len, int cur, int visited) {
        // 1. 기저 사례: 목표 길이에 도달했을 때
        if (len == N) {
            // 모든 숫자(0~9)를 다 방문했는지 확인
            return visited == (1 << 10) - 1 ? 1 : 0;
        }

        // 2. 메모이제이션
        if (dp[len][cur][visited] != -1) {
            return dp[len][cur][visited];
        }

        long ret = 0;

        // 3. 다음 숫자로 이동 (계단 차이가 1이어야 함)
        // 아래로 이동 (cur - 1)
        if (cur > 0) {
            ret += go(len + 1, cur - 1, visited | (1 << (cur - 1)));
        }
        // 위로 이동 (cur + 1)
        if (cur < 9) {
            ret += go(len + 1, cur + 1, visited | (1 << (cur + 1)));
        }

        // 4. 결과 저장 및 반환
        return dp[len][cur][visited] = (int) (ret % MOD);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N][10][1 << 10];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                Arrays.fill(dp[i][j], -1);
            }

        }
        int ret = 0;
        for (int i = 1; i < 10; i++) {
            ret = (ret + go(1, i, 1 << i)) % MOD;
        }

        System.out.println(ret);
    }
}