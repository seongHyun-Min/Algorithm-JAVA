import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1976 {
    //플로이드 와샬로도 구현 가능
    static int[] parent;

    public static void main(String[]args )throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }
        int[][] city = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                int tmp = Integer.parseInt(st.nextToken());

                if(tmp ==1){
                    union(i, j);
                }
            }
        }
        int[] route = new int[M+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=M; i++){
            route[i] = Integer.parseInt(st.nextToken());
        }


        int tmp = find(route[1]);
        for(int i=2; i<route.length; i++){
            if(tmp !=find(route[i])){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    public static void union(int a, int b){
        // union(3,1)이 들어왔을 경우
        // 범위값을 지정해주지 않으면 자동으로 parent[1] = 3; 으로 바뀌게 된다.
        // 그러나 유니온 파인드 알고리즘은 값이 두개 중 더 작은 값을 부모로 선정 해줘야하기 때문에
        // union 메소드에서 범위를 나눠줘야한다
        // 이전 1717번 메소드에서 범위를 나누지 않은 이유는 반드시 A가 B보다 작기 때문이였다.
        int A = find(a);
        int B = find(b);
        if(A !=B) {
            if(A<B){
                parent[b] = a;
            }else{
                parent[A] = b;
            }

        }
    }
    public static int find(int a){
        if(a == parent[a]){
            return a;
        }else return parent[a] = find(parent[a]);
    }

}

