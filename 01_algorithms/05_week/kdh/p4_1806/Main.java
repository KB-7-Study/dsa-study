package p4_1806;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 모든 합이 S 미만이라면 return 0

        String oneLine = br.readLine();
        String[] part = oneLine.split(" "); // N과 S 분리
        int N = Integer.parseInt(part[0]);
        int S = Integer.parseInt(part[1]);

        int sum = 0;
        int left = 0;
        int tmp = Integer.MAX_VALUE; // 최솟값 구하는 문제이니 MAX로.

        oneLine = br.readLine(); // 다음 줄
        String[] stringNums = oneLine.split(" "); // 공백 기준으로 수열 자르기

        List<Integer> nums = new ArrayList<>();
        // 수열을 nums에 쓸어담기
        for (int i =0; i< stringNums.length; i++){
            nums.add(Integer.parseInt(stringNums[i]));
        }

        // right를 오른쪽으로 이동
        for(int right = 0; right < N; right++){
            sum += nums.get(right);

            while (sum >= S && left <= right){
                // S 이상이면서 left 보다 이상이면 길이 측정
                // left 옮기기 전에 측정해야 조건 만족한 친구의 길이를 구할 수 있음.
                if(tmp > (right - left + 1)){
                    tmp = right - left + 1;
                }
                // left를 오른쪽으로 이동하면서 S에서 빼보기.
                sum -= nums.get(left);
                left++;
            }
        }

        // 합 못 만들었으면 0 출력
        if(tmp == Integer.MAX_VALUE){
            System.out.println(0);
        }else{
            System.out.println(tmp);
        }

    }
}