package p1_1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();

        int result = 0;
        int tmpSum = 0;

        String oneLine = br.readLine();

        try{
            // - 를 기준으로 나누기
            String[] part = oneLine.split("-");
            System.out.println("part0 = " + part[0]);
            System.out.println("part1 = " + part[1]);

            // - 를 기준으로 나뉜 덩어리들
            for(int i = 0; i < part.length; i++){
                // 한 덩어리를 +를 기준으로 나눔
                String[] nums = part[i].split("\\+");

                // 나뉜 숫자들을 모두 더함
                for(int j = 0; j < nums.length; j++){
                    tmpSum += Integer.parseInt(nums[j]);
                }

                if(i == 0) {
                    result = tmpSum;
                } else {
                    result -= tmpSum;
                }
                tmpSum = 0;
            }
        }catch(RuntimeException e){
            String[] front = oneLine.split("\\+");

            for(int i = 0; i < front.length; i++){
                tmpSum += Integer.parseInt(front[i]);
            }

            result = tmpSum;
        }

        System.out.println(result);
    }
}