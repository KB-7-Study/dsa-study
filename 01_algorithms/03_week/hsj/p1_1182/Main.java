import java.io.*;
import java.util.*;

public class Main {
    //현재 원소 고르는 경우
    //현재 원소 안고르는 경우
    static int res = 0;
    static void dfs(int[] arr, int s, int sum, int cnt){
        if (cnt==arr.length) {
            if (sum == s) res++;
            return;
        }

        //현재 원소 고르는 경우
        dfs(arr, s,sum+arr[cnt], cnt+1);
        //현재 원소 안고르는 경우
        dfs(arr, s,sum, cnt+1);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr, s, 0, 0);

        //다 안고르는 경우 제거
        if (s == 0) res--;

        System.out.println(res);

    }
}