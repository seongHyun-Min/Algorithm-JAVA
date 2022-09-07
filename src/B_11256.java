import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_11256 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 T개 받고 T번 반복 시키자

        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int J = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int count =0;
            Integer [] arr  = new Integer[N];
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                arr[j] = (Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()));
            }

            Arrays.sort(arr, Collections.reverseOrder());
         //  System.out.println(Arrays.toString(arr)); // 입력 테스트 코드 정렬
            for(int k=0; k<N; k++) {
                if (J > 0) {
                    J -= arr[k];
                    count++;

                } else break;
            }
            System.out.println(count);

        }

    }
}