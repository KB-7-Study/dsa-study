import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] visited;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divideTeam(0, 0);

        System.out.println(minDiff);
    }

    // count: 현재까지 스타트 팀으로 뽑힌 인원 수
    static void divideTeam(int idx, int count) {
        // N/2명을 다 뽑았을 때
        if (count == N / 2) {
            calculateDiff();
            return;
        }

        // 2. 조합 탐색
        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;      // 스타트 팀으로 선택
                divideTeam(i + 1, count + 1);
                visited[i] = false;     // 백트래킹 (원상복구)
            }
        }
    }

    // 두 팀의 능력치 차이를 계산
    static void calculateDiff() {
        int startTeamScore = 0;
        int linkTeamScore = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                // i번과 j번이 모두 스타트 팀(visited[i,j] == true)인 경우
                if (visited[i] && visited[j]) {
                    startTeamScore += S[i][j] + S[j][i];
                }
                // i번과 j번이 모두 링크 팀(visited[i,j] == false)인 경우
                else if (!visited[i] && !visited[j]) {
                    linkTeamScore += S[i][j] + S[j][i];
                }
            }
        }

        int diff = Math.abs(startTeamScore - linkTeamScore);

        // 차이가 0이면 최솟값이므로 즉시 출력하고 종료 가능 (최적화)
        if (diff == 0) {
            System.out.println(0);
            System.exit(0);
        }

        minDiff = Math.min(minDiff, diff);
    }
}