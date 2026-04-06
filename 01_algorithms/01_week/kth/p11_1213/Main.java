import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final String FAILURE_STR = "I'm Sorry Hansoo";

        char[] chars = br.readLine().toCharArray();
        int oddCnt = 0;
        int evenCnt = 0;
        int N = chars.length;
        int[] digits = new int[26];
        for (char ch : chars) {
            digits[ch - 'A']++;
        }
        char skipCh = '1';
        for (int idx = 0; idx < 26; idx++) {
            int cnt = digits[idx];
            if (cnt > 0) {
                if (cnt % 2 == 0) {
                    evenCnt += 1;
                } else {
                    skipCh = (char) ('A' + idx);
                    oddCnt += 1;
                }
            }
        }
        if (N % 2 != 0) {
            if (oddCnt != 1) {
                System.out.println(FAILURE_STR);
                return;
            }
        } else {
            if (oddCnt != 0) {
                System.out.println(FAILURE_STR);
                return;
            }
        }

        Arrays.sort(chars);
        String ret = "";
        char center = skipCh;
        for (int i = 0; i < N; i += 2) {
            if (skipCh == chars[i]) {
                skipCh = ' ';
                continue;
            }
            ret += chars[i];
            sb.append(chars[i]);
        }
        if (skipCh == ' ') {
            ret += center;
        }
        ret += sb.reverse().toString();
        System.out.println(ret);

    }
}