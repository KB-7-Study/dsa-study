package p5_1322;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        // K를 이진수 문자열로 변환 (K의 비트들을 하나씩 꺼내 쓰기 위함)
        String binaryK = Long.toBinaryString(K);
        int kIndex = binaryK.length() - 1; // K의 가장 낮은 자릿수(오른쪽)부터 탐색

        long Y = 0;
        long bitPosition = 1; // 현재 검사 중인 비트의 가중치 (1, 2, 4, 8...)

        // K의 모든 비트를 Y의 빈 공간(X의 비트가 0인 곳)에 다 채울 때까지 반복
        while (kIndex >= 0) {
            // X의 현재 비트가 0인지 확인
            if ((X & bitPosition) == 0) {
                // X가 0인 자리에 K의 현재 비트가 1이라면 Y에 더해줌
                if (binaryK.charAt(kIndex) == '1') {
                    Y += bitPosition;
                }
                kIndex--; // K의 비트 하나를 사용했으므로 다음 비트로 이동
            }
            // X의 다음 비트 자리를 확인하기 위해 가중치를 2배로
            bitPosition <<= 1;
        }

        System.out.println(Y);
    }
}
