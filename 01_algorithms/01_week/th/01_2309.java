import java.io.*;
import java.util.*;

public class Main {
    static int calc(int visited, int[] arr){
        int ret = 0;
        for (int i = 0; i < 9; i++) {
            if((visited & 2 << i) != 0){
                ret += arr[i];
            }
        }
        return ret;
    }
    static int dfs (int cnt ,int visited , int[] arr){
        int ret = 0;
        if(cnt == 7){
//           100이 아닐 경우 0
            int sum = calc(visited, arr);
            if(sum != 100) return 0;
            else return visited;
        }
        for (int i = 0; i < 9; i++) {
//          방문을 할 경우 스킵
            if((visited & (2 << i)) != 0) continue;
//          100을 오버했을 경우 스킵
            ret = Math.max(dfs(cnt+1, visited | (2 << i), arr), ret);
        }
        return ret;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = 9;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int visited = dfs(0, 0, arr);
        int[] answer = new int[7];
        int j = 0;
        for (int i = 0; i < 9; i++) {
            if((visited & 2 << i) != 0){
                answer[j] = arr[i];
                j++;
            }
        }
        for(int val: answer){
            sb.append(val).append('\n');
        }
        System.out.print(sb);

    }
}