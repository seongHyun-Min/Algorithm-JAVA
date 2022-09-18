import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1182 {
    static int[] arr;
    static int count = 0;

    static int N;

    static int S; //목표 숫자

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        find(0, 0);

        if(S==0){
            System.out.println(count-1);
        }else System.out.println(count);
        // s=0인 경우 공집합도 포함되므로 -1해준다
        // 원래 부분집합에는 공집합도 포함되는데 이문제에서는 공집합을 포함시키지 않았다.



    }

    public static void find(int x, int sum) {
        if (x == N) { //총 순환 시키기
            if (sum == S) {
                count++;
            }
            return;
        }

        find(x + 1, sum + arr[x]); //지금 index를 포함시키는지
        find(x + 1, sum); //지금 index는 포함 안시키고 건너 뛰던지

    }

}
