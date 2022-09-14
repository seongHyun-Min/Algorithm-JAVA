import java.util.Arrays;
import java.util.Collections;

public class test1 {
    public static long solution(long n) {
        String str = String.valueOf(n);
        String[] strs = str.split(""); //한글자씩 쪼개
        Arrays.sort(strs, Collections.reverseOrder());
//        Arrays.stream(strs).forEach(System.out::print); 테스트 코드
        for (int i = 0; i < strs.length; i++) {

        }
        return 0;
    }



        public static void main(String[] args){

        }
    }

