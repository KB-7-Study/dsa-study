package _5_week.p5_2170;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Line[] lines = new Line[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            lines[i] = new Line(s, e);
        }
        Arrays.sort(lines);
        int curEnd = lines[0].e;
        int curSt = lines[0].s;
        int len = 0;
        for (int i = 1; i < N; i++) {
            if (lines[i].s > curEnd) {
                len += curEnd - curSt;
                curSt = lines[i].s;
                curEnd = lines[i].e;
            } else {
                curEnd = Math.max(curEnd, lines[i].e);
            }
        }
        len += (curEnd - curSt);
        System.out.println(len);

    }

    static class Line implements Comparable<Line> {
        int s, e;

        public Line(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Line o) {
            return this.s - o.s;
        }
    }
}