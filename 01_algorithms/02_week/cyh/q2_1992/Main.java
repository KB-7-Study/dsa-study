import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 영상의 크기 N 입력
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        // 2. 영상 데이터 입력 (공백 없이 들어오므로 charAt 사용)
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        // 3. 쿼드 트리 압축 함수 호출 (시작점 0,0 및 크기 N)
        solve(0, 0, N);

        // 4. 최종 결과 출력
        System.out.println(sb.toString());
    }

    // 분할 정복 재귀 함수
    static void solve(int x, int y, int size) {
        // 현재 영역이 모두 같은 숫자인지 확인
        if (isSame(x, y, size)) {
            // 모두 같다면 해당 숫자(0 또는 1)를 추가하고 종료
            sb.append(board[x][y]);
            return;
        }

        // 숫자가 섞여 있다면 4개의 영역으로 나누어야 함
        int newSize = size / 2;

        sb.append("("); // 4분할 시작 시 괄호 열기

        // 문제에서 제시한 순서: 왼쪽 위 -> 오른쪽 위 -> 왼쪽 아래 -> 오른쪽 아래
        solve(x, y, newSize);                         // 1. 왼쪽 위
        solve(x, y + newSize, newSize);               // 2. 오른쪽 위
        solve(x + newSize, y, newSize);               // 3. 왼쪽 아래
        solve(x + newSize, y + newSize, newSize);     // 4. 오른쪽 아래

        sb.append(")"); // 모든 분할 탐색이 끝나면 괄호 닫기
    }

    static boolean isSame(int x, int y, int size) {
        int standard = board[x][y]; // 기준점 숫자

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (board[i][j] != standard) {
                    return false; // 하나라도 다르면 false
                }
            }
        }
        return true; // 모두 같으면 true
    }
}