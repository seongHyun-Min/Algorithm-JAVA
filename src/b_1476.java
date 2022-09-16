import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_1476 {
    static int count =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        find(E, S, M);

        System.out.println(count);

    }
    public static void find(int E, int S, int M){
        int e =0;
        int s =0;
        int m =0;
        while(true){
            e++;
            s++;
            m++;
            count++;
            if(e>15) e=1;
            if(s>28) s=1;
            if(m>19) m=1;

            if(E==e && S==s && M==m){
                break;
            }
        }
    }
}
