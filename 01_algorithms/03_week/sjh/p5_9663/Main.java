package third_week.p5_9663;

import java.util.*;

public class Main {
    static int N;
    static int[] qMap; // 각 열에 퀸이 몇 번째 행에 있는지 저장
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        qMap = new int[N];

        // 0번째 열부터 퀸을 놓기 시작
        backtrack(0);
        
        System.out.println(count);
    }

    static void backtrack(int col) {
        // [탈출 조건] 마지막 열까지 퀸을 다 놓기
        if (col == N) {
            count++;
            return;
        }

        // 현재 열(col)에서 0번 행부터 N-1번 행까지 하나씩
        for (int i = 0; i < N; i++) {
            qMap[col] = i; // 일단 현재 열의 i번째 행에 퀸
            
            // 놔본 자리가 안전한지 체크!
            if (isPossible(col)) {
                backtrack(col + 1); // 안전하면 다음 열로 넘어감
            }
            // 안전하지 않으면 루프를 돌며 다음 행(i+1)을 시도 (백트래킹)
        }
    }

    static boolean isPossible(int col) {
        // 현재 놓은 퀸(col)이 이전 열들에 놓인 퀸들과 충돌하는지 확인
        for (int i = 0; i < col; i++) {
            // 1. 같은 행에 퀸이 있는 경우 (가로 충돌)
            if (qMap[col] == qMap[i]) {
                return false;
            }
            
            // 2. 대각선에 퀸이 있는 경우
            // (열의 차이와 행의 차이가 같으면 대각선에 있음)
            if (Math.abs(col - i) == Math.abs(qMap[col] - qMap[i])) {
                return false;
            }
        }
        return true;
    }
}