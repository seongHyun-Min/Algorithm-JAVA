import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_24498 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max =Math.max(arr[0],arr[N-1]); // max값 중에서 첫과 끝이 max가 될수 있으니 예외처리
//      int max =0; 으로 선언할시 반례 1000, 1, 2 or 1 , 2, 1000
        int tmp =0;
        for(int i=1; i<arr.length-1; i++){
            tmp = Math.min(arr[i-1],arr[i+1]);
            max = Math.max(max, arr[i]+tmp);
            tmp =0; //tmp초기화
        }
        System.out.println(max);
    }
}