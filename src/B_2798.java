import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  =new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[] =  new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        //완전 탐색 알고리즘
        int max =0;
        for(int i=0; i<N-2; i++){
            for(int j=i+1; j<N-1; j++){
                for(int k=j+1; k<N; k++){
                    int tmp = arr[i] +arr[j] +arr[k];
                    if(tmp <= M){
                        max = Math.max(max, tmp);
                    }else break; // 아무리 완전탐색이라도 오름차순 정렬을 통한
                    // 불필요한 탐색 탈출
                }

            }
        }
        System.out.println(max);

    }
}
