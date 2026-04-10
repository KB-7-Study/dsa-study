import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final String SAME_RESULT = "DA";
        final String DIFF_RESULT = "NE";

        int N = Integer.parseInt(br.readLine());
        String pat = br.readLine();
        pat = pat.replace("*", ".*");;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            sb.append(str.matches(pat) ? SAME_RESULT : DIFF_RESULT ).append('\n');
        }
        System.out.print(sb);

    }
}