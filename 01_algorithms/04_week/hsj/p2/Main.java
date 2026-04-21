import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] arr1 = new int[10];
    static int[] arr2 = new int[10];
    static int visited = 0;
    static int ans = Integer.MAX_VALUE;

    static void dfs(int cnt, int taste1, int taste2){
        if (cnt == n){
            //taste2가 0인 경우 제외(공집합 제외)
            if (taste2>0){
                ans = Math.min(Math.abs(taste1-taste2), ans);
            }
            return;
        }
        //비트가 켜져있는지 확인할 필요가 있나..?
        //현재 재료 고르는 경우
        dfs(cnt+1, taste1*arr1[cnt], taste2+arr2[cnt]);
        //현재 재료 안고르는 경우
        dfs(cnt+1, taste1, taste2);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr1[i] = Integer.parseInt(st.nextToken());
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 1, 0);
        System.out.println(ans);
    }
}