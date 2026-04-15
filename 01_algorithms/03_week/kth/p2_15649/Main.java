package three_week.p2_15649;

import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    static public void print(List<Integer> list) {
        for (int el : list) {
            sb.append(el).append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append('\n');
    }

    static public void permutaion(List<Integer> depth) {
        if (depth.size() == M) {
            print(depth);
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (visited[i - 1]) continue;
            visited[i - 1] = true;
            depth.add(i);
            permutaion(depth);
            depth.remove(depth.size() - 1);
            visited[i - 1] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];

        permutaion(new ArrayList<>());
        System.out.print(sb);
    }
}