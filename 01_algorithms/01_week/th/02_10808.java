import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] letters = new int[26];

        String input = br.readLine();

        for(char ch : input.toCharArray()){
            letters[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            sb.append(letters[i]).append(i < 25 ? ' ' : '\n');
        }
        System.out.print(sb);


    }
}