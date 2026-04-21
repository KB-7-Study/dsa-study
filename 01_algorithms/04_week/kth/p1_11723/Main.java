package _4_week.p1_11723;


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int S = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String oprt = st.nextToken();
            if (oprt.equals("check")) {
                int idx = Integer.parseInt(st.nextToken()) - 1;
                sb.append((S & (1 << idx)) > 0 ? 1 : 0).append('\n');
            } else if (oprt.equals("all")) {
                S = (1 << 20) - 1;

            } else if (oprt.equals("empty")) {
                S = 0;
            } else {
                int idx = Integer.parseInt(st.nextToken()) - 1;
                if (oprt.equals("add")) {
                    S |= (1 << idx);
                } else if (oprt.equals("remove")) {
                    S &= ~(1 << idx);
                } else if (oprt.equals("toggle")) {
                    S ^= (1 << idx);
                }
            }
        }
        System.out.print(sb);
    }
}