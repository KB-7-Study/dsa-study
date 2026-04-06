import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            Deque<Character> dq = new LinkedList<>();
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (!dq.isEmpty() && dq.peek().equals(chars[j])) {
                    dq.pop();
                } else {
                    dq.addFirst(chars[j]);
                }
            }
            if (dq.isEmpty()) cnt++;
        }

        System.out.println(cnt);
    }
}