import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int day = (K-B) / (A-B);
        int dayoff = (K-B) % (A-B);

        // K-B / A-B 를 해준 이유는 반드시 먼저 올라간다음에 떨어지니까
        // 먼저 올라갔을때 K를 넘긴다면 내려갈 필요가 없다
        // 즉 K / (A-B) 가 아닌
        // 목표치를 K-B 값으로 해주는것이 핵심이다.

        if(dayoff !=0) System.out.println(day+1);
        else if(dayoff ==0) System.out.println(day);





    }
}
