package two_week.p2_1992;

import java.io.*;

public class Main {
    static int[][] twoArr;
    public static String compress(int y1, int x1, int y2, int x2){
        boolean isAllSame = true;
        String ret = "";
        for (int i = y1; i < y2; i++) {
            if(!isAllSame) break;
            for (int j = x1; j < x2; j++) {
                if(twoArr[y1][x1] != twoArr[i][j]){
                    isAllSame = false;
                    break;
                }
            }
        }
        if(isAllSame) return ""+twoArr[y1][x1];
        else{
            int my = (y1+y2)/2;
            int mx = (x1+x2)/2;
            ret += compress(y1,x1,my,mx);
            ret += compress(y1,mx,my,x2);
            ret += compress(my,x1,y2,mx);
            ret += compress(my,mx,y2,x2);
        }

        return  String.format("(%s)", ret);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        twoArr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                twoArr[i][j] = str.charAt(j) -'0';
            }
        }
        System.out.println(compress(0,0,N,N));


    }
}