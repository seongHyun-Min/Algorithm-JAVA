import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] arr = new int[9]; //난쟁이 배열 생성
        int sum =0;  // 아홉난쟁이의 합 계산 + 아홉난쟁이 배열 생성
        for(int i=0; i<9; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        // 9c7 을 9c2로 해결해서 문제 풀기
        // 7난쟁이의 합은 항상 100이므로
        // 9난쟁이의 합 - 2난쟁이의 합 == 100이면
        // 그 2난쟁이를 제외한 7난쟁이의 합 100이 성립된다.
        loopout:
        for(int i=0; i<8; i++){
            for(int j=i+1; j<9; j++){
                int tmp = arr[i] + arr[j];
                if(sum -tmp ==100){
                    arr[i] = 0; //찾앗으면 그 난쟁이의 키를 0으로 변환
                    arr[j] = 0;
                    break loopout; //이중 중첩 탈출
                }
            }
        }
        //오름차순 정렬 출력
        Arrays.sort(arr);
        for(int i=2; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
