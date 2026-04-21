package third_week.p1_1182;

import java.util.*;

public class Main {
    // N: 정수의 개수, S: 목표로 하는 합
    // count: 합이 S가 되는 부분수열의 개수를 저장
    static int N, S, count = 0;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 1. 입력 받기
        N = sc.nextInt(); 
        S = sc.nextInt();
        arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // 2. DFS 탐색 시작 (0번 인덱스부터 시작, 현재까지의 합은 0)
        dfs(0, 0);
        
        // 3. 예외 처리 및 결과 출력
        // 이 알고리즘은 '아무것도 선택하지 않은 경우(공집합)'의 합도 0으로 계산한다.
        // 만약 문제에서 요구하는 목표 합 S가 0이라면, 아무것도 안 더해서 0이 된 '공집합' 케이스 하나가 
        // count에 포함되어 있으므로 1을 빼주어야 한다. (부분수열은 크기가 1 이상이어야 함)
        System.out.println(S == 0 ? count - 1 : count);
    }

    /**
     * @param idx current index (탐색 중인 배열의 위치)
     * @param sum current sum (현재까지 선택된 원소들의 합)
     */
    static void dfs(int idx, int sum) {
        // [종료 조건] 모든 원소를 다 확인했을 때
        if (idx == N) {
            // 현재까지 누적된 합(sum)이 목표치(S)와 같다면 카운트 증가
            if (sum == S) {
                count++;
            }
            return; // 재귀 호출 종료
        }

        // [재귀 호출] 상태를 두 갈래로 나누어 탐색 (상태 공간 트리 확장)
        
        // 1. 현재 인덱스의 숫자(arr[idx])를 부분수열에 포함시키는 경우
        // 다음 인덱스로 넘어가면서 sum에 현재 값을 더해준다.
        dfs(idx + 1, sum + arr[idx]); 

        // 2. 현재 인덱스의 숫자(arr[idx])를 부분수열에 포함시키지 않는 경우
        // 다음 인덱스로 넘어가지만 sum은 그대로 유지한다.
        dfs(idx + 1, sum); 
    }
}