package _5_week.p3_13305;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] paths = new long[N - 1];
        long[] Ws = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            paths[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Ws[i] = Integer.parseInt(st.nextToken());
            if (i > 0) {
                Ws[i] = Math.min(Ws[i], Ws[i - 1]);
            }
        }
        long ret = 0;
        for (int i = 0; i < N - 1; i++) {
            ret += paths[i] * Ws[i];
        }
        System.out.println(ret);
    }
}