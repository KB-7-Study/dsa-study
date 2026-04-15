import java.io.*;
import java.util.*;

public class Main {
    static int N, S;
    static int[] nums;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        //크기가 양수인 부분수열
        // S가 0일 때 공집합 하나 뺌
        if (S == 0) {
            System.out.println(count - 1);
        } else {
            System.out.println(count);
        }
    }

    private static void dfs(int idx, int currentSum) {
        if (idx == N) {
            if (currentSum == S) {
                count++;
            }
            return;
        }

        // 현재 원소를 포함하는 경우
        dfs(idx + 1, currentSum + nums[idx]);

        // 현재 원소를 포함하지 않는 경우
        dfs(idx + 1, currentSum);
    }
}