import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static boolean[] visited;
    static int[] arr;
    static void dfs(int cnt){
        if (cnt == m){
            for (int i:arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for (int i=1;i<n+1;i++){
            if (!visited[i]){
                visited[i] = true;
                arr[cnt] = i;
                dfs(cnt+1);
                visited[i] = false;
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        arr = new int[m];

        dfs(0);

    }
}