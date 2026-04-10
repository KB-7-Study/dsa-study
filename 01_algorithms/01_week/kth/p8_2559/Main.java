import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] pSum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            pSum[i] = Integer.parseInt(st.nextToken()) + pSum[i - 1];
        }

        int ret = -Integer.MIN_VALUE;
        for (int i = 0; i <= N - len; i++) {
            ret = Math.max(pSum[i + len] - pSum[i], ret);
        }
        System.out.println(ret);

    }
}