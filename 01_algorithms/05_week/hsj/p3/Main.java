import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] dist = new long[n-1];
        for (int i=0;i<n-1;i++){
            dist[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        long[] price = new long[n];
        for (int i=0;i<n;i++){
            price[i] = Integer.parseInt(st.nextToken());
        }

        long curPrice = -1;
        for (int i=0;i<n-1;i++){
            if (curPrice == -1){
                answer+=price[i]*dist[i];
                curPrice = price[i];
            }
            else if (curPrice>price[i]){
                answer+=price[i]*dist[i];
                curPrice = price[i];
            }
            else {
                answer+=curPrice*dist[i];
            }
        }

        System.out.println(answer);

    }
}