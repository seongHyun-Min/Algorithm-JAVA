import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();
        String arr[] = expression.split("-"); // -기호로 잃단 잘라서 배열에 담자

        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            //숫자형 변환 함수 선언
            int temp = mySum(arr[i]);
            if (i == 0) { //첫번째 배열에는 항상 + 가 담긴다 (문제 조건_)
                answer +=temp;
            }else answer -= temp; //나눈 배열부터는 - 기준으로 끊기 떄문에 항상 -를 해준다

        }
        System.out.println(answer);
    }

    static int mySum(String a) {
        int sum = 0;
        String tmp[] = a.split("\\+"); // split의 경우 (regex) 정규식을 받기 떄문에 "+"를 하면
        // regex.PatternSyntaxException이 발생한다  그 이유는 + 문자가 메타문자이기 떄문이다.
        // 여기에서 메타 문자란 특수 문자 기호로 정규표현식 내 특별한 의미를 갖는 문자 기호로
        // 선택 `|`, 문자 클래스 `[]`, 서브 패턴 `()`, 수량자 `* + ? {}`, 앵커 `^ $ ＼ 등`,
        // 점 `.`, 수정자 `g i m s` 등
        // 메타문자를 정규식에 사용하기 위해서는 이스케이프 처리로 백슬레시 \\+를 해야 원하는 + 문자 그대로 분리할 수 있다.
        // 이스케이프 탈출
        for (int i = 0; i < tmp.length; i++) {
            sum += Integer.parseInt(tmp[i]);
        }
        return sum; // -부터 다음 -까지의 배열에 모든 합 리턴메서드 생성
    }
}








