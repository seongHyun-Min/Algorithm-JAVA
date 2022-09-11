import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count =99;
        if(N<=99){ //1부터 99까지는 한수
            System.out.println(N);
        }else{
            for(int i=100; i<=N; i++){
                int number = i;// 100~999까지니까 어처피 1000은 한수아니야
                //일의자리 // 십의자리 //백의자리로 카운트
                int a = i %10; //일의자리
                int b = (i/10) %10; // 십의자리
                int c =  i/100; // 백의자리
                if((b - a) == (c - b))
                    count ++; //어처피 1000이들어와도 count안돼 a =0 b=0 c=10이기때문
                }
            System.out.println(count);
        }
    }
}

