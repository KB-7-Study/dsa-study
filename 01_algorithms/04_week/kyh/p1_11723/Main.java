package kyh.p1_11723;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        int set = 0; // 비트마스크

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("all")) {
                set = (1 << 21) - 2; // 1~20 비트를 1로
            } else if (cmd.equals("empty")) {
                set = 0;
            } else {
                int x = Integer.parseInt(st.nextToken());

                switch (cmd) {
                    case "add":
                        set |= (1 << x);
                        break;
                    case "remove":
                        set &= ~(1 << x);
                        break;
                    case "check":
                        sb.append((set & (1 << x)) != 0 ? 1 : 0).append('\n');
                        break;
                    case "toggle":
                        set ^= (1 << x);
                        break;
                }
            }
        }

        System.out.print(sb);
    }
}