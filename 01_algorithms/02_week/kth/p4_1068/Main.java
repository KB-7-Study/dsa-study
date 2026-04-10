package two_week.p4_1068;

import java.io.*;
import java.util.*;


public class Main {
    static public int searchLeaf( int[] arr){
        int ret = 0;
        int n = arr.length;
        for (int target = 0; target < n; target++) {
            if(arr[target] == -2) continue;

            boolean isParent = false;
            for (int i = 0; i < n; i++) {
                if(target == arr[i]){
                    isParent = true;
                    break;
                }
            }
            ret += isParent? 0 : 1;
        }
        return ret;

    }
    static public void delete(int target , int[] arr){
        int N = arr.length;
        arr[target] = -2;

        for (int i = 0; i < N; i++) {
            if(arr[i] == target){
                delete(i, arr);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st =new StringTokenizer(br.readLine());
        int[] arr =new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int choice = Integer.parseInt(br.readLine());
        delete(choice, arr);
        int ret = searchLeaf(arr);
        System.out.println(ret);
    }

}

