import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_2012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Integer> arr = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr.add(Integer.valueOf(st.nextToken()));
        }
        Collections.sort(arr); // Array.sort()를 사용하지 않고 Collection.sort()를 사용한 이유는
        //Array.sort()는 정렬방식이 dualpviotquicksort 이므로 평균 O(nlog(N)이지만 worst case의 경우 O(N^2)가 나올수 있기 떄문에
        //n의 범위가 500,000 이기 떄문에 O(N^2)이 되면 문제를 해결할 수 없으므로
        //Collection.sort() 정렬방식이 TimeSort(삽입정렬과 합병정렬을 결합한 정렬)으로 worst case의 경우에도 O(N(log(N)알고리즘을 사용했다.

        long count =0;
        for(int i=0; i<arr.size(); i++){

            count += Math.abs(arr.get(i) -(i+1));
        }
        System.out.println(count);
    }
}
