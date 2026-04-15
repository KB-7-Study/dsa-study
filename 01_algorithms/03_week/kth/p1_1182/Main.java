package three_week.p1_1182;

import java.io.*;
import java.util.*;

public class Main {
    static int ret = 0;
    static int S;
    static boolean[] visited;

    static public void dfs(int sum, int cur, int[] arr) {
        if (cur != -1 && sum == S) ret++;
        for (int i = cur + 1; i < arr.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(sum + arr[i], i, arr);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, -1, arr);
        System.out.println(ret);

    }
}