package 백준8708;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P_22233 {
    static int N, M;
    static HashSet<String> memo; //해쉬셋 삭제 검색에 O(1)을 갖는다
    //해쉬셋을 사용하지 않고 수정삭제를 할경우 O(MN)시간복잡도를 갖게된다.
    //해쉬셋은 중복되지 않은 요소를 저장하는 클래스 이며 해쉬셋은 요소의 순서를 보장하지않는다.
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        memo = new HashSet<>();
        for(int i=0; i<N; i++){
            memo.add(br.readLine());
        }
        for(int i=0; i<M; i++){
            st =new StringTokenizer(br.readLine(), ",");

            while(st.hasMoreTokens()){
                String tmp = st.nextToken();

                if(memo.contains(tmp)){
                    memo.remove(tmp);
                }
            }
            System.out.println(memo.size());
        }
    }
}
