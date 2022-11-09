import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_2193 {
    static int N;
    static long[][] D;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        D = new long[N+1][2];
        D[1][0] = 0; // 한자리수 이친수는 존재하지 않음 0
        D[1][1] = 1; // 한자리수 이친수는 1로 존재
        for(int i=2; i<=N; i++){
            D[i][0] = D[i-1][0] + D[i-1][1]; //0으로 끝나는 이친수는 1로 끝나는 이친수와 0으로 끝나는 이친수 모두를 합할수 있음
            D[i][1] = D[i-1][0]; //1로 끝나는 이친수는 반드시 0으로 끝나는 이친수에만 붙힐수 있음 11이 되면 이친수가 아니기 떄문
        }

        System.out.println(D[N][0] + D[N][1]);

        //System.out.println(Arrays.deepToString(D));

    }
}
