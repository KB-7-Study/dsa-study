package three_week.p6_1062;

import java.io.*;
import java.util.*;

public class Main {
    static int K, ret = 0;
    static boolean[] digits = new boolean[26];
    static String[] strs;

    static public void count() {
        int tmp = 0;
        for (String str : strs) {
            boolean pass = true;
            for (int i = 0; i < str.length(); i++) {
                if (!digits[str.charAt(i) - 'a']) {
                    pass = false;
                    break;
                }
            }
            if (pass) tmp++;
        }
        ret = Math.max(ret, tmp);
    }

    static public void combi(List<Integer> list, int s) {
        if (list.size() == K - 5) {
            count();
            return;
        }
        for (int i = s + 1; i < 26; i++) {
            if (digits[i]) continue;
            list.add(i);
            digits[i] = true;
            combi(list, i);
            digits[i] = false;
            list.remove(list.size() - 1);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        strs = new String[N];
        for (int i = 0; i < N; i++) {
            strs[i] = br.readLine();
        }
        if (K < 5) {
            System.out.println(0);
            return;
        }

        digits['a' - 'a'] = true;
        digits['n' - 'a'] = true;
        digits['t' - 'a'] = true;
        digits['i' - 'a'] = true;
        digits['c' - 'a'] = true;

        combi(new ArrayList<>(), 0);
        System.out.println(ret);
    }
}