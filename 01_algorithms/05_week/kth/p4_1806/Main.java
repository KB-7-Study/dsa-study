package _5_week.p4_1806;


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        int lo = -1;
        int pSum = 0;
        final int MAX = (int) 1e8 + 1;
        int ret = MAX;

        for (int hi = 0; hi < N; hi++) {
            pSum += arr[hi];

            while (pSum >= S && lo <= hi) {
                ret = Math.min(ret, hi - lo + 1);
                if (lo > -1) pSum -= arr[lo];
                lo++;
            }
        }
        System.out.println(ret == MAX ? 0 : ret);
    }
}