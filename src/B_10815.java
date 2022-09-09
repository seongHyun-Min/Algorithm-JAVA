import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_10815 { //N의 범위가 500,000이므로 중첩문을 통한 배열탐색 불가
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 오름차순 배열정렬 binarySearch
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = N - 1;
            int count = 0;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (arr[mid] == tmp) {
                    count++;
                    break;
                } else if (arr[mid] > tmp) { //찾을값 보다 배열 mid값이 더크다면 큰 배열 버려
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            bw.write(count +" ");
        }
        bw.flush();
        bw.close();
        //한줄에 출력하기 위해서 BufferedWriter생성
    }
}
