package _5_week.p7_1202;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] gems = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            gems[i][0] = Integer.parseInt(st.nextToken());
            gems[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] caps = new int[K];
        for (int i = 0; i < K; i++) {
            caps[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(gems, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        Arrays.sort(caps);
        int lo = 0;
        long ret = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });
        for (int i = 0; i < K; i++) {
            while (lo < N && gems[lo][0] <= caps[i]) {
                pq.add(gems[lo]);
                lo++;
            }
            if (!pq.isEmpty()) ret += pq.poll()[1];
        }
        System.out.println(ret);
    }
}