package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_623 {
    static int N;
    static int M;
    static int K;
    static int[] arr;
    static int[] target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        target =  new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            target[i] = Integer.parseInt(st.nextToken());
        }
        boolean isSecret = false;
        for(int i=0; i<=M-N; i++){
            if(target[i] == arr[0]){
                boolean isTrue = true;
                //처음에 시작이 같은경우만 탐색하자
                for(int j=1; j<N; j++){
                    if(target[i+j] != arr[j]){
                        isTrue = false;
                        break;
                    }
                }
                //다 돌았는데 isTrue면
                if(isTrue){
                    isSecret = true;
                    break;
                }
            }
        }
        if(isSecret){
            System.out.println("secret");
        }else{
            System.out.println("normal");

        }

    }
}
