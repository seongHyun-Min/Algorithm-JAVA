import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Integer[] arr = new Integer[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(arr, Collections.reverseOrder());
        int count =0;
        for(int i=0; i<arr.length; i++){
            if(K/arr[i] >=1){
                count += K/arr[i]; //목 만큼 카운트
                K = K % arr[i]; // 나머지만큼 N값 초기화
            }
            if(N==0) break;
        }
        // 배열에는 1이 들어가므로 항상 N을 0으로 만듣어 줄수 있기 때문에 0이 아니라면 예외처리 x
        System.out.println(count);

    }
}
