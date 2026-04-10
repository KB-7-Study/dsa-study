import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final String ABSTENTION = "PREDAJA";
        int N = Integer.parseInt(br.readLine());
        int[] digits = new int[26];
        for (int i = 0; i < N; i++) {
            char ch = br.readLine().charAt(0);
            digits[ch - 'a']++;
        }
        String ret = "";
        for (int i = 0; i < 26; i++) {
            if(digits[i] >=5){
                ret += (char)('a' + i);
            }
        }
        System.out.println(ret.isBlank() ? ABSTENTION : ret );

    }
}