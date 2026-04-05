package two_week.p5_2636;

import java.io.*;
import java.util.*;

public class Main {
    static public boolean isDone(int[][] arr) {
        for (int[] a : arr) {
            for (int v : a) {
                if (v == 1) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

//       BFS
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) flag = false;
            }
        }
        if (flag) {
            System.out.println(0);
            return;
        }
//      0: 내부 공간
//      1: 치즈
//      2: 외부 공간
//      3: 맞닿는 치즈
//      바깥영역 체킹
//      바깥영역과 맞닿는 부분 확인 후, 표시
//      표시된 부분 지우기
//      존재하지는지 확인
//      시간 증가
//      1번부터 반복
        int t = 0;
        Queue<Node> q = new ArrayDeque<>();
        Queue<Node> cheese = new ArrayDeque<>();
        int[] dy = {-1, 0, 1, 0};

        int[] dx = {0, 1, 0, -1};
        Node init = new Node(0, 0);
        int cnt = 0;
        while (true) {
            if (isDone(arr)) break;
//          외부 공간 표시
            q.add(init);
            arr[0][0] = 2;
            while (!q.isEmpty()) {
                Node cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];
                    if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
//                  맞닿는 치즈일 경우
                    if (arr[ny][nx] == 1) {
                        arr[ny][nx] = 3;
                        cheese.add(new Node(ny, nx));
                    } else if (arr[ny][nx] == 0) {
//                   범위 초과 여부
                        arr[ny][nx] = 2;
                        q.add(new Node(ny, nx));
                    }
                }
            }
//          맞닿는 치즈 제거
            cnt = cheese.size();
            while (!cheese.isEmpty()) {
                Node cur = cheese.poll();
                arr[cur.y][cur.x] = 2;
            }

            q.add(init);
            arr[0][0] = 0;
            while (!q.isEmpty()) {
                Node cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];
                    if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;

                    if (arr[ny][nx] != 2) continue;

                    arr[ny][nx] = 0;
                    q.add(new Node(ny, nx));

                }
            }

            t++;
        }
        System.out.println(t + "\n" + cnt);
    }

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}