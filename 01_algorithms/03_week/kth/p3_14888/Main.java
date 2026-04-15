package three_week.p3_14888;

import java.io.*;
import java.util.*;

public class Main {
    static long INF = (long) 1e10 + 1;
    static long max = -INF, min = INF;
    static int N;
    static long[] arr;

    static void permu(List<Integer> depth, int[] visited) {
        if (depth.size() == N - 1) {
            long ret = arr[0];
            for (int i = 0; i < N - 1; i++) {
                switch (depth.get(i)) {
                    case 0:
                        ret += arr[i + 1];
                        break;
                    case 1:
                        ret -= arr[i + 1];
                        break;
                    case 2:
                        ret *= arr[i + 1];
                        break;
                    case 3:
                        ret /= arr[i + 1];
                        break;
                }
            }
            min = Math.min(min, ret);
            max = Math.max(max, ret);

            return;
        }
        for (int i = 0; i < 4; i++) {
            if (visited[i] == 0) continue;
            visited[i]--;
            depth.add(i);
            permu(depth, visited);
            depth.remove(depth.size() - 1);
            visited[i]++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] oprts = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            oprts[i] = Integer.parseInt(st.nextToken());
        }
        if (N == 1) {
            System.out.println(arr[0] + '\n' + arr[0]);
            return;
        }
        permu(new ArrayList<>(), oprts);
        System.out.println(max);
        System.out.println(min);
    }
}