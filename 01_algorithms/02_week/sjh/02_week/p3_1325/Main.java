import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static List<Integer>[] adj;
    static int[] counts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b); // 역으로 저장: a를 해킹하면 b가 영향받음
        }

        counts = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            bfs(i);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) max = Math.max(max, counts[i]);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (counts[i] == max) sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    static void bfs(int start) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : adj[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    counts[next]++; // 도달 가능한 노드 카운트 증가
                    q.add(next);
                }
            }
        }
    }
}