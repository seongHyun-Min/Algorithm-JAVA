import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_2667 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int arr[][];
    static boolean visitied[][];
    static int N;

    static int count =1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visitied = new boolean[N][N];
        ArrayList<Integer> answer = new ArrayList<>();
        int cnt =0; // 총 단지수
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(str.substring(j, j+1));
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j] !=0  && visitied[i][j]==false){
                    cnt ++; // 인스턴스변수 단지수 카운트
                    count =1; // static count 초기화 안하면 누적돼
                    answer.add(dfs(i,j));
                }
            }
        }
        Collections.sort(answer); //단지 개수 오름차순 정렬
        System.out.println(cnt); //총 단지수 출력
        answer.forEach(System.out::println); // 단지 개수 오름차순 출력



    }
    public static int dfs(int i, int j){
        visitied[i][j] = true;
        for(int k=0; k<4; k++){
            int x = i + dx[k];
            int y = j + dy[k];
            if(x >=0 && y>=0 && x<N && y<N){
                if(arr[x][y] !=0 && visitied[x][y] ==false){
                    count ++;
                    dfs(x,y);
                }
            }
        }
        return count;
    }
}
