import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            long n = Long.parseLong(line);
            long cnt = 1;
            long num = 1;
            while (true) {
                if (num % n == 0) {
                    sb.append(cnt).append('\n');
                    break;
                }
                cnt++;
                num = ((10 * num) % n + 1) % n;
            }

        }
        System.out.print(sb);
    }
}