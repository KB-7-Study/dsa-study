package _4_week.p2_2961;

import java.io.*;
import java.util.*;

public class Main {

    static int ret = Integer.MAX_VALUE, N;
    static int[][] twoArr;

    public static void combi(List<Integer> list, int s) {
        if (list.size() > 0) {
            int multiplyS = list.stream()
                    .map(i -> twoArr[i][0])
                    .reduce(1, (a, b) -> a * b);
            int sumB = list.stream()
                    .map(i -> twoArr[i][1])
                    .reduce(0, (a, b) -> a + b);
            ret = Math.min(ret, Math.abs(multiplyS - sumB));
        }
        for (int next = s + 1; next < N; next++) {
            list.add(next);
            combi(list, next);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

//       신맛: S = X
//       쓴맛: B = +
//       최솟
        N = Integer.parseInt(br.readLine());
        twoArr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            twoArr[i][0] = Integer.parseInt(st.nextToken());
            twoArr[i][1] = Integer.parseInt(st.nextToken());
        }

        combi(new ArrayList<>(), -1);
        System.out.println(ret);
    }
}