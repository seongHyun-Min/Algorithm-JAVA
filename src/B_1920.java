import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1920 {
    public static void main(String[] args) throws IOException {
        //원하는 정수 찾기 n이 30,000개 이하라면 O(n^2)인 중첩 for문을 통해 쉽게 해결할수 있으나
        //n이 100,000개로 O(NlogN) 알고리즘을 사용해야한다 binarySeaarch
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[N]; // 정답 배열 생성
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine()); //배열에 넣을 필요없어
        Arrays.sort(answer); // binarySearch를 하려면 반드시 배열은 정렬된 상태여야 한다.
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            int start = 0; //start와 end는 인덱스 기준으로 선언하기 떄문에 start = 0 end = N-1
            int end = N - 1;
            int count = 0;
            while (start <= end) { // start와 end가 만나면 while 문 종료
                int mid = (start + end) / 2;
                if (answer[mid] == tmp) {
                    count++;
                    break; // 찾으면 while문 탈출
                } else if (answer[mid] > tmp) { //찾을값 보다 mid값이 더크다면 mid보다 더큰 배열은 쓸모가 없어지므로 버린다
                    end = mid - 1; //인덱스 이기 때문에 mid에 -1을 해준것이다. (자세히 설명하자면 mid값이 만약 tmp랑 같다면 위에
                    //if(answer[mid] ==tmp)를 만나서 탈출하게 됨으로 end를 mid까지 설정해준다면 필요없는 배열 하나를 더 탐색하게 되는 것이다.
                } else { //찾을값 보다 mid 값이 더작다면 mid보다 작은 배열은 더이상 쓸모가 없어지므로 버린다.
                    start = mid + 1; //start도 마찬가지로 mid와 start가 같다면 탈출하게 됨으로 start를 mid까지로 선언해준다면 필요없는 배열 하나를 더 탐색하게 되므로
                    // mid값보다 1큰 인덱스부터 탐색하게 된다.
                }
                // 찾을값이 배열에 존재하지 않는다면 while문 자동탈출로 0을 출력해준다
            }
            System.out.println(count);
        }
    }
}