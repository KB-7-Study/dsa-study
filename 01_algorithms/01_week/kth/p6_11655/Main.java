import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        final int SHIFT = 13;
        String ret = "";
        for(char ch : str.toCharArray()){
            if(Character.isLowerCase(ch)){
//              0을 기준으로 나머지 연산해야한다
                /**
                 * 만약에 a 기준으로 할 시에 a = 97;
                 * a ~ z : 97 ~ 122
                 *  만약에 y면 y의 shift된 값이 k가 나와야한다
                 *  (121 + 13) % 122 면 12로 108이 아니게 된다
                 *  그래서 shift할 때는 0부터 기준을 맞춰서 실행하자
                 * */
                char encoded = (char)((ch - 'a' + 13)%26 + 'a');
//                System.out.println(encoded);
                ret += encoded;
            }else if(Character.isUpperCase(ch)){
                char encoded = (char)((ch - 'A' + 13)%26 + 'A');
//                System.out.println((int)encoded);
                ret += encoded;
            }
            else{
//                System.out.println(String.format("the other case %c", ch));
                ret += ch;
            }
        }
        System.out.println(ret);

    }
}
