package three_week.p4_14889;

import java.io.*;
import java.util.*;

public class Main {
    static int min = 98754321, sum = 0, N;
    static boolean[] visited;
    static int[][] twoArr;

    static public void combi(List<Integer> depth, int cur) {
        if (depth.size() == N / 2) {
            int ret = 0;
            for (int i = 0; i < depth.size() - 1; i++) {
                for (int j = i + 1; j < depth.size(); j++) {
                    ret += twoArr[depth.get(i)][depth.get(j)];
                    ret += twoArr[depth.get(j)][depth.get(i)];
                }
            }
            List<Integer> theOther = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (!visited[i]) theOther.add(i);
            }
            for (int i = 0; i < theOther.size() - 1; i++) {
                for (int j = i + 1; j < theOther.size(); j++) {
                    ret -= twoArr[theOther.get(i)][theOther.get(j)];
                    ret -= twoArr[theOther.get(j)][theOther.get(i)];
                }
            }

            min = Math.min(min, Math.abs(ret));
            return;
        }
        for (int i = cur + 1; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            depth.add(i);
            combi(depth, i);
            depth.remove(depth.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        twoArr = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                twoArr[i][j] = Integer.parseInt(st.nextToken());
                sum += twoArr[i][j];
            }
        }
        combi(new ArrayList<>(), -1);
        System.out.println(min);
    }
}