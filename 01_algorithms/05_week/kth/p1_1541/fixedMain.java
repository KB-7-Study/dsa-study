package 05_week.p1_1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class fixedMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] strs = br.readLine().split("-");
        int sum = 0;
        StringTokenizer st = new StringTokenizer(strs[0], "+");
        while (st.hasMoreTokens()) {
            sum += Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < strs.length; i++) {
            st = new StringTokenizer(strs[i], "+");
            int tmp = 0;
            while (st.hasMoreTokens()) {
                tmp += Integer.parseInt(st.nextToken());
            }
            sum -= tmp;
        }
        System.out.println(sum);
    }
}