import java.util.*;
import java.io.*;

public class Main {
    static int X, Y;
    static int[][] maze;
    static boolean[][] visited;
    // 상, 하, 좌, 우 이동을 위한 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        maze = new int[X][Y];
        visited = new boolean[X][Y];

        for (int i = 0; i < X; i++) {
            String line = br.readLine();
            for (int j = 0; j < Y; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    public static int bfs(int x, int y) {
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

                // 미로 범위를 벗어나지 않고, 벽이 아니며(1), 방문하지 않은 곳
                if (nx >= 0 && ny >= 0 && nx < X && ny < Y) {
                    if (maze[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        // 이동 거리를 기록 (이전 칸의 값 + 1)
                        maze[nx][ny] = maze[curX][curY] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        // 도착 지점의 최단 거리 반환
        return maze[X - 1][Y - 1];
    }
}