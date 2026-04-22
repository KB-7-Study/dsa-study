/*영역 내의 숫자가 모두 같지 않으면 4등분하여 재귀적으로 탐색합니다.

왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래 순서로 탐색하며 괄호 ()를 적절히 배치해야 합니다. */

import java.util.*;
import java.io.*;

public class Main {
    static int[][] tree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) tree[i][j] = s.charAt(j) - '0';
        }
        divide(0, 0, N);
        System.out.println(sb);
    }

    static void divide(int r, int c, int size) {
        if (isSame(r, c, size)) {
            sb.append(tree[r][c]);
            return;
        }
        sb.append("(");
        int nSize = size / 2;
        divide(r, nSize, nSize); // 1사분면 느낌이지만 위치상 좌상단
        divide(r, c + nSize, nSize);
        divide(r + nSize, c, nSize);
        divide(r + nSize, c + nSize, nSize);
        sb.append(")");
    }

    static boolean isSame(int r, int c, int size) {
        int val = tree[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (tree[i][j] != val) return false;
            }
        }
        return true;
    }
}