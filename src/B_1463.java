import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1463 {
    static int N;
    static int[] D;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        D = new int[N+1];
        for(int i= 2; i<= N; i++) {
            D[i] = D[i -1] +1;
            if(i % 2 ==0) D[i] = Math.min(D[i], D[i/2] +1);
            if(i % 3 ==0) D[i] = Math.min(D[i], D[i/3] +1);

        }
        System.out.println(D[N]);
    }
}
