package third_week.p3_14888;

import java.util.*;

public class Main {
    static int N;
    static int[] numbers;
    static int[] operators = new int[4]; // +, -, *, / 순서
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        // 연산자 개수 입력 (덧셈, 뺄셈, 곱셈, 나눗셈)
        for (int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt();
        }

        // 첫 번째 숫자를 시작 합계로 넣고, 두 번째 숫자(인덱스 1)부터 연산 시작
        backtrack(numbers[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    static void backtrack(int currentSum, int idx) {
        // [탈출 조건] 모든 숫자를 다 사용했을 때
        if (idx == N) {
            max = Math.max(max, currentSum);
            min = Math.min(min, currentSum);
            return;
        }

        // 4종류의 연산자
        for (int i = 0; i < 4; i++) {
            // 남은 연산자 개수가 0보다 클 때만 사용 가능
            if (operators[i] > 0) {
                
                // 1. 연산자 사용 표시 (개수 하나 줄이기)
                operators[i]--;

                // 2. 현재 연산자로 계산한 값을 들고 다음 숫자로 이동
                if (i == 0) backtrack(currentSum + numbers[idx], idx + 1);
                else if (i == 1) backtrack(currentSum - numbers[idx], idx + 1);
                else if (i == 2) backtrack(currentSum * numbers[idx], idx + 1);
                else if (i == 3) backtrack(currentSum / numbers[idx], idx + 1);

                // 3. 재귀 끝나고 돌아오면 다시 연산자 개수 복구
                operators[i]++;
            }
        }
    }
}