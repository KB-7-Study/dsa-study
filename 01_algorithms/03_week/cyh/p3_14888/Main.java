import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] nums;
    static int[] operators = new int[4]; // +, -, *, / 개수 저장
    static int maxVal = Integer.MIN_VALUE;
    static int minVal = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        // 숫자 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 개수 입력 (+, -, *, / 순서)
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        // 첫 번째 숫자부터 시작하고 index = 1로 설정
        dfs(1, nums[0]);

        System.out.println(maxVal);
        System.out.println(minVal);
    }

    private static void dfs(int idx, int currentSum) {
        // 모든 숫자를 다 연산했다면 최댓값, 최솟값 갱신
        if (idx == N) {
            maxVal = Math.max(maxVal, currentSum);
            minVal = Math.min(minVal, currentSum);
            return;
        }

        // 4가지 연산자를 하나씩 시도
        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) { // 해당 연산자 카드가 남아있을 때만

                operators[i]--; // 1. 연산자 사용 처리

                // 2. 연산 수행 후 다음 재귀로 이동
                if (i == 0) dfs(idx + 1, currentSum + nums[idx]);
                else if (i == 1) dfs(idx + 1, currentSum - nums[idx]);
                else if (i == 2) dfs(idx + 1, currentSum * nums[idx]);
                else if (i == 3) dfs(idx + 1, currentSum / nums[idx]);

                operators[i]++; // 3. 연산자 상태 복구 (Backtracking)
            }
        }
    }
}