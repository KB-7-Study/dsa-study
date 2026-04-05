package two_week.p3_1325;

import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] edges;
    static int N, M;
    static int[] check;
    static boolean[] visited;

//  bfs할때 시간초과난다
//  java 15로 돌릴때는 통과된다.
    static public void dfs(int next , int s){
        for (int v : edges[next]){
            if(visited[v]) continue;
            check[s]++;
            visited[v] = true;
            dfs(v, s);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            edges[v].add(u);
        }

        check = new int[N];
        int max = -1;
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            visited[i] = true;
            dfs(i, i);
            max = Math.max(max, check[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (check[i] == max) {
                sb.append(i+1).append(" ");
            }
        }
        System.out.println(sb.toString().strip());
    }
}