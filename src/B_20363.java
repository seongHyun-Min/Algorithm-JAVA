import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_20363 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int count =0;
        if(X > Y){
            count += X; //-를 최소화 하려면 큰거부터 입력 (0이하로는 감소되지 않기 떄문)
            count += Y+(Y / 10); // y를 넣어주고 y의 10분의1을 x로 카운터 해준다
        }else{
            count += Y;
            count += X+(X / 10);
        }
        System.out.println(count);
    }
}
