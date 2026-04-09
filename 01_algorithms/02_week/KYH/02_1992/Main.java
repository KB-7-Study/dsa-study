import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static char[][] image;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        image = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                image[i][j] = line.charAt(j);
            }
        }

        compress(0, 0, n);
        System.out.print(sb);
    }

    static void compress(int x, int y, int size) {
        if (isSame(x, y, size)) {
            sb.append(image[x][y]);
            return;
        }

        int half = size / 2;
        sb.append('(');
        compress(x, y, half);
        compress(x, y + half, half);
        compress(x + half, y, half);
        compress(x + half, y + half, half);
        sb.append(')');
    }

    static boolean isSame(int x, int y, int size) {
        char first = image[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (image[i][j] != first) {
                    return false;
                }
            }
        }
        return true;
    }
}

// 재귀를 통해서 푸는 문제
// 입력을 받아서 4분할하여 모두 같은 숫자인지 확인하고 같지 않으면 다시 4분할하여 확인한다.
// 모두 같은 숫자이면 그 숫자를 출력한다.
// 모두 같은 숫자가 아니면 괄호를 추가하여 출력한다.
