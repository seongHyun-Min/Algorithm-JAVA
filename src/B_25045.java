import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_25045 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Integer [] product = new Integer [N];
        long [] customer = new long [M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            product[i] = Integer.valueOf(st.nextToken());// long타입으로 받아주자 범위
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            customer[i] = Long.parseLong(st.nextToken());
        }
        // 배열 정렬
        Arrays.sort(product, Collections.reverseOrder());// 그리디 알고리즘을 사용하기 위해 상품 가치는 내림차순으로 정렬한다
        // 그이유는 product : 8 7 6 2 1
        //         custoemr : 1 3 3 3 3 일경우에  8 7 6 에 매칭되는 1 3 3 은 거래해도 되지만 2 1은 -값이 나오므로 거래 하지않는다.
        // 만약 product도 오름차순으로 정렬했을시 1 2 7 8 6
        //                                    1 3 3 3 3   으로 한다면 2는 3보다 작으므로 거래하면 안되지만 거래를 하게 된다
        //                                     만약 조건문으로 걸었다고 하더라도  1 2 7 8 6
        //                                                                   1 3 5 7 9 일경우에 조건문으로 3을 빠저나가도 7에서 5를 빼는것 보다 7에서 3을 빼야지 최대값을 도출해낼수 있다.
        // 그렇게 하기 위해서는 배열의 값을 하나씩 이동 시켜줘야하는데 그렇게 되면 시간 복잡도가 높아질것이라고 예상되기 때문에 사용하지 않는것이 좋다
        // 즉 그리디 알고리즘 최대값을 구하기 위해서는 x - y = max  일경우 x는 내림차순으로 y는 오름차순으로 정렬 해주는것이 최적의 알고리즘이라고 생각한다.
        Arrays.sort(customer);
        long sum =0;
        if(N >= M){
            for(int i=0; i<M; i++){
                if(product[i] > customer[i]){
                    sum += (product[i] - customer[i]);
                }
            }
            System.out.println(sum);
        }
        if(N < M){
            for(int i=0; i<N; i++){
                if(product[i] > customer[i]){
                    sum += (product[i] - customer[i]);
                }
            }
            System.out.println(sum);
        }

    }
}
