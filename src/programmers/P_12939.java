package programmers;

import java.io.IOException;

public class P_12939 {
        public static String solution(String s) {
            String str[] = s.split("\\s");
            Integer max =Integer.MIN_VALUE;
            Integer min =Integer.MAX_VALUE;
            for(int i=0; i<str.length; i++){
                int tmp = Integer.parseInt(str[i]);
                max = Math.max(max, tmp);
                min = Math.min(min, tmp);
            }

            String answer = String.valueOf(min)+" "+String.valueOf(max);
            return answer;

        }

    public static void main(String[] args) throws IOException { //테스트 코드
        System.out.println((long)Math.sqrt(25));


    }
}
