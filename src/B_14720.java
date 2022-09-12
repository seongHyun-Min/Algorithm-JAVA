import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //배열 완전 탐색하자 N이 1000개니까 완전탐색해도 성공!
        int count =0;
        int start =0; //start는 0이니까 일단 무조건 0부터 찾을꺼야
        for(int i=0; i<arr.length; i++){
            if(arr[i] ==start && start==0){
                count++;
                start =1; //0 -> 1
                continue; //continue해주는 이유는 start 를 1로 바꿧으니까 무조건 다음식이 맞게되서 count가 중복된다.
            }
            if(arr[i] ==start && start==1){
                count ++;
                start = 2; //1 ->2
                continue;
            }if(arr[i] ==start && start==2){
                count ++;
                start =0;
                continue;
            }
        }
        System.out.println(count);
    }
}