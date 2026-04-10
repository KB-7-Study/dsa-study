import java.io.*;
import java.util.*;

public class Main {
    static class Section{
        int level;
        int result; // 0이면 0, 1이면 1, -1이면 분할
        Section(int level, int result){
            this.level = level;
            this.result = result;
        }
    }
    static int getVideo(int[][] arr, int[] start, int sectionSize){
        int cnt0 = 0;
        int cnt1 = 0;
        for (int i=start[0];i<start[0]+sectionSize;i++){
            for (int j=start[1];j<start[1]+sectionSize;j++){
                if (arr[i][j] == 0) cnt0++;
                else if (arr[i][j] == 1) cnt1++;
            }
        }
        if (cnt0>0 && cnt1>0) return -1;
        else if (cnt0==0 && cnt1>0) return 1;
        else if (cnt0>0 && cnt1==0) return 0;
        else return -2;
    }
    static String answer = "";
    static void dfs(int[][] arr, int[] start, int sectionSize){
        //size가 1이면 종료

        if (getVideo(arr,start, sectionSize)==-1) answer+="(";
        else if (getVideo(arr,start, sectionSize)==0) {
            answer+="0";
            return;
        }
        else if (getVideo(arr,start, sectionSize)==1) {
            answer += "1";
            return;
        }
        if (sectionSize == 1) return;

        // 마지막 타일 끝나면 ")" 붙임
        dfs(arr,start, sectionSize/2);
        dfs(arr,new int[]{start[0],start[1]+sectionSize/2}, sectionSize/2);
        dfs(arr,new int[]{start[0]+sectionSize/2,start[1]}, sectionSize/2);
        dfs(arr,new int[]{start[0]+sectionSize/2,start[1]+sectionSize/2}, sectionSize/2);
        answer+=")";
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        // 첫 섹션은 level 0
        //왼위, 오외, 왼아, 오아 순서로 탐색
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        int[] start = {0,0};

        dfs(arr, start, n);
        System.out.print(answer);

    }
}