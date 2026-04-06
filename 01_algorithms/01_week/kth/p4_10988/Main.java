import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str =br.readLine();
        int N = str.length();
//       홀 짝 구분
//       경우 1 : 홀수일 때
        int answer = 1;
        if(N % 2 == 1){
            int pivot = N/2;
            int diff = 1;
            while ((pivot - diff) >= 0){
                int leIdx = pivot - diff;
                int riIdx = pivot + diff;
                char le = str.charAt(leIdx);
                char ri = str.charAt(riIdx);
                if(le != ri) {
                    answer = 0;
                    break;
                }
                diff++;
            }

        }else{
            int lePivot = N/2-1;
            int riPivot = N/2;
            int diff = 0;
            while ((lePivot - diff) >= 0){
                int leIdx = lePivot - diff;
                int riIdx = riPivot + diff;
                char le = str.charAt(leIdx);
                char ri = str.charAt(riIdx);
                if(le != ri) {
                    answer = 0;
                    break;
                }
                diff++;
            }
        }
        System.out.println(answer);

    }
}