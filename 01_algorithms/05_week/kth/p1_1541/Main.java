package _5_week.p1_1541;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int tmp = 0;
        int pSum = 0;
        int ret = 0;
        boolean isMinus = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '+' && str.charAt(i) != '-') {
                tmp = 10 * tmp + str.charAt(i) - '0';
            } else if (str.charAt(i) == '+') {
                if (isMinus) {
                    pSum += tmp;
                } else {
                    ret += tmp;
                }
                tmp = 0;
            } else if (str.charAt(i) == '-') {
                if (isMinus) {
                    ret -= pSum;
                    ret -= tmp;
                    pSum = 0;
                } else {
                    isMinus = true;
                    ret += tmp;
                }
                tmp = 0;
            }
        }
        pSum += tmp;
        if (isMinus) ret -= pSum;
        else ret += tmp;
        System.out.println(ret);
    }
}