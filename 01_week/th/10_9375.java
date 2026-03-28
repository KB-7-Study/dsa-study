import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Map<String, Integer> map = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
//                String wear = br.readLine().split(" ");
                String wear = br.readLine().split(" ")[1];
                map.put(wear, map.getOrDefault(wear, 0) + 1);
            }
            int[] arr = map.values().stream().mapToInt(Integer::intValue).toArray();

            int ret = 1;
            for (int num : arr) {
                ret *= (num + 1);
            }
            ret -= 1;
            sb.append(ret).append('\n');
        }
        System.out.print(sb);
    }
}