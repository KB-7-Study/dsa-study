package p2_2961;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] sour;   // 신맛 S
    static int[] bitter; // 쓴맛 B
    static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력 받기
        N = Integer.parseInt(br.readLine());
        sour = new int[N];
        bitter = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }

        solve(0, 1, 0, 0);

        // 3. 결과 출력
        System.out.println(minDifference);
    }

    static void solve(int index, int currentSour, int currentBitter, int count) {
        if (index == N) {
            // 적어도 하나의 재료는 사용해야 함 (공집합 제외)
            if (count > 0) {
                int diff = Math.abs(currentSour - currentBitter);
                if (diff < minDifference) {
                    minDifference = diff;
                }
            }
            return;
        }

        // 현재 재료를 요리에 포함하는 경우
        solve(index + 1, currentSour * sour[index], currentBitter + bitter[index], count + 1);

        // 현재 재료를 요리에 포함하지 않는 경우
        solve(index + 1, currentSour, currentBitter, count);
    }
}