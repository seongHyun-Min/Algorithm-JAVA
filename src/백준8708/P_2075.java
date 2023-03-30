package 백준8708;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P_2075 {
    //N^2에서 N번째로 큰수 찾기
    //일반적으로 풀면 O(N^3)이 나온다 이렇게 되면 시간초과
    //우선순위 큐를 이용하면 O(N^2 logN) 만에 풀수 있다.
    static int N;
    static int[][] arr;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pq =new PriorityQueue<>(Collections.reverseOrder());
        //우선순위 큐는 기본적으로 오름차순으로 정렬 되지만
        //N번째로 큰 순서를 찾는것이기 때문에 내림차순 정렬 사용
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                pq.add(arr[i][j]);
            }
        }
        for(int i=0; i<N; i++){
            if(i ==N-1) System.out.println(pq.peek());
            else{
                pq.poll();
            }
        }

    }
}
