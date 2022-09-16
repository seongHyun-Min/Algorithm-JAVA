import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14501 {

    static int[][] arr;
    static int N;
    static int max;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[N + 1][2]; //인덱스 사용을 위해 N+1;
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        find(1, 0);


        System.out.println(max);
    }

    public static void find(int i, int sum) {
        if (max < sum) //max 값 초기화
            max = sum;

        if(i > N) return; //인덱스 마지막이 N인데 넘어가면 break 탐색 완료

        int tmp = i + arr[i][0]; //탐색시간 index
        if(tmp <=N+1){ //tmp가 <N 이 아닌 tmp <= N+1인 이유는
            //마지막 인덱스가 7일때 i=7 arr[7][0] =1 이면 8으로 누적합을 더해줄수가 있기 때문
            // 그리고 누적합을 더한후 int i는 8이 되므로 return
            find(tmp, sum+arr[i][1]);
        }
        find(i+1, sum); //이렇게 함수를 쪼개서 걸어주면
        //1일차 탐색하고 4일차를 탐색해야되는데 4일차를 탐색한 함수와 5일차를 탐색한 함수로 쪼개서 탐색 해줄수있다.


    }
}






