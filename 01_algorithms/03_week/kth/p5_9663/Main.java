package three_week.p5_9663;


import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int N, ret;

    static void dfs(int[][] arr, int y, int x) {
        if (y == N) {
            ret++;
            return;
        }
        for (int j = 0; j < N; j++) {
            if (arr[y][j] == 1) {
                continue;
            }
            if ((1 << j & x) != 0) {
                continue;
            }
            int u = y - 1;
            int v = j - 1;
            boolean a = false;
            while (true) {
                if (u < 0 || v < 0) break;
                if (arr[u][v] == 1) {
                    a = true;
                    break;
                }
                u--;
                v--;
            }
            if (a) {
                continue;
            }
            u = y - 1;
            v = j + 1;
            a = false;
            while (true) {
                if (u < 0 || v >= N) break;
                if (arr[u][v] == 1) {
                    a = true;
                    break;
                }
                u--;
                v++;
            }
            if (a) {
                continue;
            }

            arr[y][j] = 1;
            dfs(arr, y + 1, x | 1 << j);
            arr[y][j] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        dfs(arr, 0, 0);


        System.out.println(ret);


    }
}