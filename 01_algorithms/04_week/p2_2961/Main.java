package p2_2961;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] S = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken()); // 신맛
            B[i] = Integer.parseInt(st.nextToken()); // 쓴맛
        }

        int answer = Integer.MAX_VALUE;

        for (int mask = 1; mask < (1 << N); mask++) {
            int sour = 1;
            int bitter = 0;

            for (int j = 0; j < N; j++) {
                if ((mask & (1 << j)) != 0) {
                    sour *= S[j];
                    bitter += B[j];
                }
            }

            answer = Math.min(answer, Math.abs(sour - bitter));
        }

        System.out.println(answer);
    }
}