import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] adj;
    static BitSet[] killMap;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        killMap = new BitSet[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            killMap[i] = new BitSet(N + 1);
            killMap[i].set(i);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i);
        }

        int maxKills = 0;
        int[] counts = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            counts[i] = killMap[i].cardinality();
            if (counts[i] > maxKills) {
                maxKills = counts[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (counts[i] == maxKills) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }

    static void dfs(int curr) {
        visited[curr] = true;

        for (int next : adj[curr]) {
            if (!visited[next]) {
                dfs(next);
            }
            killMap[curr].or(killMap[next]);
        }
    }


}


