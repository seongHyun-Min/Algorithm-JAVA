import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num = 666;
        int count =1;
        while(count != N){ //만약 N이 1이라면 count는 1이므로 루프를 돌지않고 바로 num출력
            num ++;
            if(String.valueOf(num).contains("666")){
                count++;
            }
        }
        System.out.println(num);

    }
}

