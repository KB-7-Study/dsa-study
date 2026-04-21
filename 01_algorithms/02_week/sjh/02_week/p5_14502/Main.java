import java.util.*;

public class Main {
    static int N, M, maxSafe = 0;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt();
        map = new int[N][M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) map[i][j] = sc.nextInt();

        setWall(0);
        System.out.println(maxSafe);
    }

    // 벽 3개를 세우는 조합 (백트래킹)
    static void setWall(int count) {
        if (count == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    setWall(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        int[][] copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            copyMap[i] = map[i].clone();
            for (int j = 0; j < M; j++) if (copyMap[i][j] == 2) q.add(new int[]{i, j});
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i], ny = cur[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && copyMap[nx][ny] == 0) {
                    copyMap[nx][ny] = 2;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        
        int safe = 0;
        for (int[] row : copyMap) for (int v : row) if (v == 0) safe++;
        maxSafe = Math.max(maxSafe, safe);
    }
}