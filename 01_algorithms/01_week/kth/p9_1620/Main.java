import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] names = new String[N + 1];
        Map<String, Integer> nums = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            names[i] = name;
            nums.put(name, i);
        }

        for (int i = 0; i < M; i++) {
            String p = br.readLine();
//           숫자
            if (nums.getOrDefault(p, -1) == -1) {
                sb.append(names[Integer.parseInt(p)]).append('\n');
            }
//           문자
            else {
                sb.append(nums.get(p)).append('\n');
            }

        }
        System.out.print(sb);

    }
}