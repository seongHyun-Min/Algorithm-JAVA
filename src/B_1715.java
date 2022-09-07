import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        // 우선순위 큐 선언
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 낮은 숫자가 우선 순위인 int형 우선순위 큐 선언
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        long count =0;
        while(pq.size() !=1){ // 마지막에 큐에 하나가 들어가야 하므로
            int a = pq.poll();
            int b = pq.poll();
            count += a+b;
            pq.offer(a+b);
        }

        System.out.println(count);

    }

}

        // 틀림 이유 (20 30 40 50 ) 일경우에 20+30을한 값이 50이 40보다 크니까 그리디 알고리즘이 적용되지 않는다
        // 즉 더해가면서 비교하는 우선순위 큐를 선언하여 배출해준다.
////        System.out.println(Arrays.toString(arr)); 입력 테스트 코드
//
//// 최소의 비교 값을 구하기 위해서 누적합을 활용한다
//// 만약 N의 갯수가 5라면 10 20 30 40 50 // (10+20) = 30(s[2]) , 30+30 = 60 (s[3]) + 60+40 = 100 (s[4]) , 100+50 = (s[5])
//        //즉 N의 갯수만큼 for문을 돌려서 s[2] 부터 s[N]개 까지의 합을 누계시켜주면 최소의 카드 묶음이 나오게 된다.
//        //단 N의 범위는 1부터 100,000이기 때문에 n이 2이하일떄 예외처리를 해줘야한다
//        // n이 2보다 작다면 그냥 배열에 합을 넣어주면 된다.
//        int[] S = new int[N+1]; // 합배열을 만들기위해 N보다 1큰 배열생성 0번인덱스는 사용 x
//        for(int i=1; i<S.length; i++){
//            S[i] = S[i-1] +arr[i];
//            //합배열 s[0] =0, s[1] = a[1], s[2] = a[1] +a[2] ....
//        }
////        System.out.println(Arrays.toString(S)); //합배열 출력
//        int count =0;
//        if(N>2){
//            for(int i=2; i<S.length; i++){
//                count += S[i];
//            }
//        }
//        else{
//            for(int i=0; i<arr.length; i++){
//                count += arr[i];
//            }
//        }
//        System.out.println(count);
//    }
//}
