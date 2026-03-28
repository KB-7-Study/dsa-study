import java.io.*;
import java.util.*;

public class Main {
    //    메모제이션은 메모리 초과 유발
    static long divide(int a, int b, int c) {
        if (b == 0) return 1 % c;
        if (b == 1) return a % c;
        long half = divide(a, b / 2, c);
        if (b % 2 == 0) {
            return (half * half) % c;
        } else {
            return ((half * half) % c * a) % c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        System.out.println(divide(a, b, c));
    }
}
