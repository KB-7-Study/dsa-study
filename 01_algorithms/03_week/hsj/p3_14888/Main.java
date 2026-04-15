import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] op;
    static int[] arr;
    static int minNum = Integer.MAX_VALUE;
    static int maxNum = Integer.MIN_VALUE;

    //방문 표시 : 연산자 감소, 복구 : 연산자 증가
    static void dfs(int idx, int num) {
        if (idx == arr.length) {
            minNum = Math.min(minNum, num);
            maxNum = Math.max(maxNum, num);
            return;
        }
        for(int i=0;i<op.length;i++){
            if (op[i]>0){
                //연산자 방문
                op[i]--;
                //덧셈
                if (i == 0){
                    dfs(idx+1,num+arr[idx]);
                }
                //뺄셈
                else if (i== 1){
                    dfs(idx+1,num-arr[idx]);
                }
                //곱셈
                else if (i == 2){
                    dfs(idx+1,num*arr[idx]);
                }
                // 나눗셈
                else {
                    dfs(idx+1,num/arr[idx]);
                }
                //연산자 방문 취소
                op[i]++;

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        op = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1,arr[0]);

        System.out.println(maxNum);
        System.out.println(minNum);

    }
}