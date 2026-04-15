import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];
        visited = new boolean[N + 1];

        // 깊이 0부터 시작
        dfs(0);

        // 결과 한꺼번에 출력
        System.out.print(sb);
    }

    private static void dfs(int depth) {
        // 1. 기저 조건: 길이가 M인 수열을 완성했을 때
        if (depth == M) {
            for (int val : result) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 2. 1부터 N까지 숫자를 하나씩 확인
        for (int i = 1; i <= N; i++) {
            // 아직 사용하지 않은 숫자라면
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;  // 현재 깊이의 위치에 숫자 저장

                dfs(depth + 1);

                visited[i] = false;
            }
        }
    }
}


