import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_14501_DP { //DP로 풀기
    // 1차원 배열로 생각
    static int[] T; //시간

    static int[] P; //금액
    static int N;
    static int[] D;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        T = new int[N+1];
        P = new int[N+1];
        D = new int[N+2]; //점화식 사용을 위해 +1 큰 배열을 생성
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        // System.out.println(Arrays.toString(T));
        // System.out.println(Arrays.toString(P));
        // 뒤에서 부터 i일로부터 퇴사일 까지 최대 금액을 구한다
        for(int i=N; i >=1; i--){
            //조건 그날에 일을 할수 있는경우
            if(i+T[i] <=N+1){
                //그날에 일을 하는게 유리한지, 안하는게 유리한지 max로 판단
                D[i] = Math.max(D[i+T[i]] +P[i], D[i+1]);
                // D[i+T[1]] + P[i]  == P[i]는 그날 일을한 값 + D[X], X는 일을 하고 난 후의 최대값
                // D[i+1] 그날 일을한 값보다 안하는게 유리한 경우 D[i+1]로 변경

            }else D[i] = D[i+1]; //퇴사일까지 일을 끝낼수 없는경우 이전에 구한 max값이 최대값

        }
        System.out.println(D[1]); //첫번째 날부터 시작한 최대금액
        //System.out.println(Arrays.toString(D));
    }
}
