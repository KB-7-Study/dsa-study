package p4_1052;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int bottlebought = 0;

        // 현재 물병의 상태(2진수 1의 개수)가 K보다 많으면 물병 계속 삼
        while (Integer.bitCount(N) > K) {
            bottlebought++;
            N++;
        }

        System.out.println(bottlebought);
    }
}