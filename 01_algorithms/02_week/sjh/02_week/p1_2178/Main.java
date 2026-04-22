/*최소 칸 수를 구하는 문제이므로 **BFS(너비 우선 탐색)**를 사용하는 것이 정석.
가중치가 없는 그래프에서 최단 거리를 보장.
방문한 칸에 이전 칸의 값 + 1을 저장하며 나아감. */

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;
    // 상, 하, 좌, 우 이동을 위한 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visited = new boolean[N][M];

        // 미로 입력 받기 (붙어서 입력되므로 한 줄씩 읽어 처리)
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        
        // 도착 지점 (N-1, M-1)의 최단 거리 출력
        System.out.println(maze[N - 1][M - 1]);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                // 미로 범위 내에 있고, 벽이 아니며(1), 아직 방문하지 않은 경우
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (maze[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        // 핵심: 이전 칸의 값 + 1을 하여 거리를 기록
                        maze[nx][ny] = maze[curX][curY] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}