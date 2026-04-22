package third_week.p2_15649;

import java.util.*;

public class Main {
    static int N, M;
    static int[] out;       // 숫자를 담을 배열 (정답 저장용)
    static boolean[] visited; // 숫자를 이미 사용했는지 체크하는 배열
    static StringBuilder sb = new StringBuilder(); // 한 번에 출력하려고 쓰는 도구

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // N까지의 자연수 중에서 M개를 고른다.
        N = sc.nextInt(); 
        M = sc.nextInt();
        
        out = new int[M];          // M개 뽑으니 크기는 M
        visited = new boolean[N + 1]; // 1부터 N까지라 크기는 N+1
        
        // 탐색 시작 (현재 0개를 뽑은 상태)
        backtrack(0);
        
        // 쌓아둔 정답 한꺼번에 출력
        System.out.print(sb);
    }

    static void backtrack(int depth) {
        // [탈출 조건] M개를 다 뽑았을 경우
        if (depth == M) {
            // 지금까지 뽑은 숫자들을 슥 훑어서 StringBuilder에 담아
            for (int val : out) {
                sb.append(val).append(" ");
            }
            sb.append("\n"); // 한 줄 끝났으니 줄바꾼다.
            return; // 이전 상태로 리턴.
        }

        // 1부터 N까지 숫자들을 하나씩 넣는다.
        for (int i = 1; i <= N; i++) {
            // 이미 사용한 숫자가 아닐 경우 (중복 방지)
            if (!visited[i]) {
                visited[i] = true;  // 1. 쓴 숫자를 표시하고
                out[depth] = i;    // 2. 결과 배열에 현재 숫자 저장
                
                backtrack(depth + 1); // 3. 다음 칸(depth + 1) 채우러 가서
                
                visited[i] = false; // 4. 다 썼으니까 이제 다른 애가 쓴다. (원상복구)
            }
        }
    }
}