import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        int[][] map = new int[N][M];
        int[][] dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        dist[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (map[nx][ny] == 0) {
                    continue;
                }
                if (dist[nx][ny] != 0) {
                    continue;
                }

                dist[nx][ny] = dist[x][y] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }

        sb.append(dist[N - 1][M - 1]);
        System.out.print(sb);
    }


}
// 시작점과 도착점이 정해져있어 최단거리를 구하는 문제이므로 BFS를 사용한다.
// 상하좌우 4방향 탐색하며 0인 경우, 이미 방문한 경우(dist != 0)는 건너뛴다.
// deque를 사용하여 탐색할 때, 큐에 삽입하기 전에 dist를 갱신한다.
// java 코딩테스트에서는 deque가 queue와 stack을 모두 지원하므로 편리하다.
