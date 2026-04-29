package p13305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int total = 0;

        // 거리
        String[] split = br.readLine().split(" ");
        int[] distance = new int[N-1];
        for(int i = 0; i < split.length; i++){
            distance[i] = Integer.parseInt(split[i]);
        }

        // 기름값
        split = br.readLine().split(" ");
        int[] oil = new int[N];
        for(int i = 0; i < split.length; i++){
            oil[i] = Integer.parseInt(split[i]);
        }

        // 첫 도시는 무조건 다음 도시 거리만큼 사야됨.
        total += distance[0] * oil[0];
        int lowOil = oil[0]; // 제일 싼 가격은 지금임.

        for(int i = 1; i < N-1; i++){
            // 지금까지 가장 싼 도시보다 지금 도시가 더 저렴하다면
            if(lowOil > oil[i]){
                // 제일 싼 기름 갱신
                lowOil = oil[i];
            }
            // 지금이 더 비싸다면 기존 기름 구매

            // 기름 구매
            total += distance[i] * lowOil;
        }

        System.out.println(total);
    }
}
