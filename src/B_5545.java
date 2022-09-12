import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_5545 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 토핑의 갯수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); //도우의 가격
        int B = Integer.parseInt(st.nextToken()); // 토핑의 가격
        int C = Integer.parseInt(br.readLine()); //도우의 열량
        int max = C/A;
        Integer[] arr = new Integer[N]; //토핑 배열
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(arr, Collections.reverseOrder()); // 배열 역순 정렬 토핑가격은 똑같으니까 토핑열량이 큰거 부터 받자
        int cal = C;
        int price = A;
        for(int i=0; i<arr.length; i++){
            cal += arr[i];
            price += B;
            int tmp = cal/price;
            if(max >tmp){ //토핑열량을 내림차순으로 정렬했기 때문에 처음에 토핑을 넣엇을때
                // 토핑을 더한 열량이 도우의 열량보다 작다면 토핑을 넣을 필요가 없기 때문에 브레이크
                // 또한 3번째 토핑을 넣었는데 2번째 토핑을 넣은 피자보다 열량이 떨어지면
                // 3번쨰 이후에 토핑을 넣는것은 무의미한 행동이기 때문에 break;
                // 근데 신기하게도 max가 tmp랑 같거나 크다고 하면 오류가 나온다 그이유가 뭔지는 모르겠다.
                // 문제에서 토핑을 반드시 하나 넣어야된다는 조건도 없고
                // 열량이 같다면 토핑을 넣어야 한다라는 조건도 없는데 말이다.
                break;
            }else
                max = Math.max(max, tmp);
            }
        System.out.println(max);
    }
}
