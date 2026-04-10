import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dp = new int[10000001];
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
            dp[n] = 1;
        }
        for (int i = 0; i < N; i++) {
            if (M - arr[i] >= 0 && dp[M - arr[i]] == 1) {
                dp[M]++;
            }
        }
        System.out.println(dp[M] / 2);
    }
}