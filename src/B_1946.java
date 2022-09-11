import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1946 {

    // 내부 클래스 생성
    static class employee { // static 클래스 생성 메인에서 실행하려고
        int document = 0;
        int interview = 0;

        employee(int document, int interview) {
            this.document = document;
            this.interview = interview;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 코드 갯수 받기
        StringTokenizer st;
        PriorityQueue<Integer> pq;
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            employee[] arr = new employee[N];
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                arr[j] = new employee(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            Arrays.sort(arr, new Comparator<employee>() {
                @Override //comparator 인터페이스 람다식으로 받아 compare 함수 오버라이딩
                public int compare(employee o1, employee o2) {
                    return o1.document - o2.document;
                }
            });
            pq = new PriorityQueue<>(); // 우선순위 큐 선언후 초기화
            pq.offer(arr[0].interview);
            for(int k=1; k<N; k++){
                if(arr[k].interview <pq.peek()){
                    pq.offer(arr[k].interview);
                }
            }
            System.out.println(pq.size());
        }

    }
}
