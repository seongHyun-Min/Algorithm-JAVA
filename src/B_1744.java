import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int sum =0; // 수열의합이 int범위를 넘을 수 있다고 생각했지만 문제에서 2^31을 넘지 않는다고 한다
        int zeroBase =1; // zeroBase를 1로 선언한 이유는 음수 큐에서 홀수의 갯수가 남을때 0이 있거나 없거나 zeroBase를 곱해주기 위해서이며
        // 초기화를 0을받지 않은 1로 선언하고 for문을 통해 0이 입력되면 zeroBase를 0으로 초기화 하였다.
        PriorityQueue<Integer> positivePq = new PriorityQueue<>(Collections.reverseOrder()); //우선순위 큐를 내림차순으로 정렬해야 한다. // 양수는 큰 숫자끼리 곱해야 커지니까
        PriorityQueue<Integer> negativePq = new PriorityQueue<>(); // 음수 오름차순 큐 정렬 // 음수는 작은 숫자 끼리 곱해야 커지니까

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp >1){
                positivePq.offer(tmp);
            }
            else if(tmp ==1){
                sum ++;
            }else if(tmp ==0){
                zeroBase =0;
            }else negativePq.offer(tmp);
        }
        //1보다 큰 양수부터 계산
        while(positivePq.size() !=0){
            if(positivePq.size() ==1){
                sum += positivePq.poll();
            }else sum += positivePq.poll() * positivePq.poll();
        }

        //음수 계산
        while(negativePq.size() !=0){
            if(negativePq.size()==1){
                sum += negativePq.poll() * zeroBase;
            }else sum += negativePq.poll() * negativePq.poll();
        }

        System.out.println(sum);
        // 전형적인 양수 음수 우선순위큐 2개선언 하는 그리디 알고리즘


    }
}

