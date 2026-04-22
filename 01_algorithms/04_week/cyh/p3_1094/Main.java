package p3_1094;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        // X를 이진수로 변환했을 때 1의 개수를 구함
        System.out.println(Integer.bitCount(X));
    }
}