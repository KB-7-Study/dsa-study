package _4_week.p5_1322;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(st.nextToken());
        long possible = ~X;
        long visited = 0;
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 64; i++) {
            if (t == 0) break;
            if ((possible & 1L << i) == 0) continue;
            if ((t & 1) == 1) {
                visited |= (1L << i);
                possible ^= (1L << i);
            }
            t >>= 1;
        }
        System.out.println(visited);
    }
}