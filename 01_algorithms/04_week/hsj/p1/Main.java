import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        int S = 0;

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String c = st.nextToken();

            switch (c) {
                case "add":
                    int n1 = Integer.parseInt(st.nextToken());
                    S |= (1 << n1);
                    break;

                case "remove":
                    int n2 = Integer.parseInt(st.nextToken());
                    S &= ~(1 << n2);
                    break;

                case "check":
                    int n3 = Integer.parseInt(st.nextToken());
                    if ((S & (1 << n3)) > 0) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                    break;

                case "toggle":
                    int n4 = Integer.parseInt(st.nextToken());
                    S ^= (1 << n4);
                    break;

                case "all":
                    S = (1 << 21) - 2;
                    break;

                case "empty":
                    S = 0;
                    break;
            }
        }

        System.out.print(sb);
    }
}