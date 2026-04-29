import java.io.*;
import java.util.*;

public class Main {

    static int n,s;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n+1];
        for (int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        int sum = arr[0];
        int start = 0;
        int end = 1;
        while(end<=n){
            if (sum>=s){
                answer = Math.min(answer, end - start);
                sum-=arr[start];
                start++;
            }
            else {
                sum+=arr[end];
                end++;
            }
        }

        if (answer == Integer.MAX_VALUE) answer = 0;

        System.out.println(answer);

    }
}