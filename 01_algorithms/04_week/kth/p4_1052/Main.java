package _4_week.p4_1052;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = 0;
        while (Integer.bitCount(N) > M) {
            int leastBit = N & -N;
            N += leastBit;
            cnt += leastBit;
        }
        System.out.println(cnt);
    }
}