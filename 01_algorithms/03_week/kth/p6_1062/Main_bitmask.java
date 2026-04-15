package three_week.p6_1062;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, baseCase;
    static int[] strs;

    static int count(int visited) {
        int ret = 0;
        for (int str : strs) {
            if (((visited ^ str) & str) == 0) ret++;
        }
        return ret;
    }

    static public int combi(int visited, int s, int cnt) {
        int ret = 0;
        if (cnt == K) {
            return count(visited);
        }
        for (int i = s + 1; i < 26; i++) {
            if ((visited & (1 << i)) != 0) continue;
            ret = Math.max(ret, combi(visited | 1 << i, i, cnt + 1));
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        strs = new int[N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int tmp = 0;
            for (char ch : str.toCharArray()) {
                tmp |= 1 << (cj - 'a');
            }
            strs[i] = tmp;
        }
        if (K < 5) {
            System.out.println(0);
            return;
        }
        baseCase |= 1 << ('a' - 'a');
        baseCase |= 1 << ('n' - 'a');
        baseCase |= 1 << ('t' - 'a');
        baseCase |= 1 << ('i' - 'a');
        baseCase |= 1 << ('c' - 'a');
        System.out.println(combi(baseCase, 0, 5));
    }
}
