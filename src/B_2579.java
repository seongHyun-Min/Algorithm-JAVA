import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class B_2579 {
    static Integer[] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr =  new int[N+1];
        dp = new Integer[N+1]; //null 값을 활용하기 위하여 Integer타입으로 선언
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = arr[0];
        dp[1] = arr[1]; // 하나면 반드시 1값
        // dp[2] = arr[1] + arr[2]; 일반적으로 이렇게 dp값을 선언하면 N=1일때 오류가 ArrayIndexOutOfBoundsException가 발생한다

        if(N >=2)  dp[2] = arr[1] + arr[2]; //N이 2이상일때만 예외처리를 해줘야 인덱스 오류가 발생하지않는다

        //System.out.println(Arrays.toString(arr));


        System.out.println(find(N));



    }
    public static int find(int N){
        if(dp[N] == null){
            dp[N] = Math.max(find(N-2),find(N-3)+arr[N-1]) +arr[N]; //마지막 자기자신은 항상
        }
        return dp[N];
    }
}
