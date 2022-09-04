import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B_20937 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> arr  = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr.add(Integer.valueOf(st.nextToken())); // valueOf Integer 타입
        }
        Collections.sort(arr, Collections.reverseOrder());

        int count = 0; //떡국값 카운터
        int max =0;
        //중복갓 찾기
        for(int i=0; i<arr.size()-1; i++){
            if(arr.get(i).equals(arr.get(i+1))){
                count ++; //
                max = Math.max(max, count); //ex 6이 5개라면 max에 5가 저장되고 count는 초기화

            }else
                count =0; //빈도수중 최대값을 찾아야하기 때문에 ex)6의 빈도수 찾고 초기화
        }
        System.out.println(max +1); //1을 해주는 이유는 중복이 안되는 배열에서 처음부터 끝가지 담은 count



    }
}
