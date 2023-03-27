import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B_11651 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] arr = new int[N][2];
        //
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
        }
//        System.out.println(Arrays.deepToString(arr)); 정렬전 테스트 코드
        Arrays.sort(arr, (arr1, arr2) -> {
            if (arr1[1] == arr2[1])
                return arr1[0] - arr2[0]; //y의 좌표가 같다면 x좌표가 큰순서로 정렬
            else {
                return arr1[1] - arr2[1];
            }
        });

        //람다식을 통한 comparator의 compare 오버라이딩
//        System.out.println(Arrays.deepToString(arr)); // 정렬후 테스트 코드

        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}



