import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] edges;
    static int[] check;    // 각 컴퓨터당 해킹 가능한 수 저장
    static int[] visited;  // 방문 여부를 체크 (int형으로 최적화)
    static int visitCount; // 현재 탐색 회차 번호

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 1. 인접 리스트 초기화
        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        // 2. 그래프 구성 (B를 해킹하면 A가 해킹되므로 B -> A 방향)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[v].add(u);
        }

        check = new int[N + 1];
        visited = new int[N + 1]; // 초기값 0
        int max = -1;

        // 3. 모든 컴퓨터(1~N)를 시작점으로 탐색
        for (int i = 1; i <= N; i++) {
            visitCount = i; // 매번 배열을 초기화하는 대신 현재 루프 번호를 사용
            check[i] = bfs(i);
            max = Math.max(max, check[i]);
        }

        // 4. 최댓값을 가진 컴퓨터 번호 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (check[i] == max) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }

    // 시간 초과 방지를 위한 BFS 구현
    static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = visitCount; // 현재 회차(i)로 방문 표시
        int count = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            count++;

            for (int next : edges[now]) {
                // 이번 탐색(visitCount)에서 방문하지 않은 노드만 탐색
                if (visited[next] != visitCount) {
                    visited[next] = visitCount;
                    q.add(next);
                }
            }
        }
        return count;
    }
}