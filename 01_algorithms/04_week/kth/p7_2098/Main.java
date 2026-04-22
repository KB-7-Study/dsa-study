package _4_week.p7_2098;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] W = new int[N][];
        for (int i = 0; i < N; i++) {
            W[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        }

        int[][] dp = new int[N][1 << N];
        int INF = 987654321;
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][1 << 0] = 0;
        for (int visited = 0; visited < 1 << N; visited++) {
            for (int cur = 0; cur < N; cur++) {
                if ((1 << cur & visited) == 0) continue;
                for (int next = 0; next < N; next++) {
                    if (W[cur][next] == 0 || ((1 << next) & visited) != 0) continue;
                    int nextVisited = visited | 1 << next;
                    dp[next][nextVisited] = Math.min(dp[next][nextVisited], dp[cur][visited] + W[cur][next]);
                }
            }
        }
        int ret = INF;
        for (int next = 1; next < N; next++) {
            ret = Math.min(ret, dp[next][(1 << N) - 1] + (W[next][0] == 0 ? INF : W[next][0]));
        }
        System.out.println(ret);
    }
}