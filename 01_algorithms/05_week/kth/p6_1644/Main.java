package _5_week.p6_1644;

import java.io.*;
import java.util.*;

public class Main {

    static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (i > 2 && i % 2 == 0) continue;
            if (isPrime(i)) list.add(i);
        }
        int lo = -1;
        int pSum = 0;
        int ret = 0;
        for (int hi = 0; hi < list.size(); hi++) {
            pSum += list.get(hi);
            while (pSum > N && lo <= hi) {
                if (lo > -1) pSum -= list.get(lo);
                lo++;
            }
            if (pSum == N) {
                ret++;
            }
        }
        System.out.println(ret);
    }
}