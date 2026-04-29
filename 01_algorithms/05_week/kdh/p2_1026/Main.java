package p2_1026;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();

        int result = 0;

        // 가장 작은 수랑 가장 큰 수끼리 곱해야 함.
        // A 배열에서 가장 작은 수 뽑기
        // B 배열에서 가장 큰 수 뽑기

        // 원소 개수
        Integer cnt = Integer.parseInt(br.readLine());
        // A 담기
        String[] tmp = br.readLine().split(" ");
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            A.add(Integer.parseInt(tmp[i]));
        }
        // B 담기
        tmp = br.readLine().split(" ");
        List<Integer> B = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            B.add(Integer.parseInt(tmp[i]));
        }

        // A 오름차순 정렬
        Collections.sort(A);
        // B 내림차순 정렬
        Collections.sort(B, Collections.reverseOrder());

        for (int i = 0; i < cnt; i++) {
            result += A.get(i) * B.get(i);
        }

        System.out.println(result);
    }
}