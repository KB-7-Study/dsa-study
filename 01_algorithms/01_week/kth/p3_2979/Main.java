import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] dp = new int[101];
        for (int i = 0; i < 3; i++) {
            st =new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            for(int j = s+1 ; j <= e ; j++){
                dp[j]++;
            }
        }
        int sum = 0;
        for (int i = 1; i <= 100 ; i++) {
            if(dp[i] == 1){
                sum +=a;
            } else if (dp[i] == 2) {
                sum +=b*2;
            }else if(dp[i] == 3){
                sum += c*3;
            }
        }
        System.out.println(sum);
    }
}