import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int maxSafety = 0;

    // 상하좌우 탐색을 위한 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 벽 3개를 세우는 모든 경우의 수 탐색 시작
        setWall(0);

        System.out.println(maxSafety);
    }

    // 벽 세우기
    static void setWall(int count) {
        // 벽이 3개 세워졌다면 시뮬레이션 돌리기
        if (count == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;      // 벽 세우기
                    setWall(count + 1); // 다음 벽 세우러 가기
                    map[i][j] = 0;      // 다시 허물기 (백트래킹 핵심)
                }
            }
        }
    }

    // 바이러스 퍼트리기
    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        int[][] copyMap = new int[N][M];

        // 원본 지도를 복사하고 바이러스 위치를 큐에 삽입
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j];
                if (copyMap[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        // BFS로 바이러스 전파 시뮬레이션
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (copyMap[nx][ny] == 0) {
                        copyMap[nx][ny] = 2; // 바이러스 전파
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        // 안전 영역(0)의 개수 세기 및 최댓값 갱신
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) count++;
            }
        }
        maxSafety = Math.max(maxSafety, count);
    }
}