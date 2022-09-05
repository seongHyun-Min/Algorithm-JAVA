import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_25418 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count =0;
        while(K >= A*2){
            if(!(K %2 ==0)) { //홀수면 -1
                count ++;
                K--;
            }else{ //짝수면 2로 나눠
                count++;
                K /= 2;
            }
        }
        System.out.println(count+(K-A)); //K-A는 최대로 나눈 K값을 1로 빼준 count
    }
}